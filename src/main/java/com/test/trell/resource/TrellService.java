package com.test.trell.resource;

import com.test.trell.model.AppPackageTest;
import com.test.trell.model.Input;
import com.test.trell.model.UserAppPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrellService {

    @Autowired
    private UserAppRepo userAppRepo;
    @Autowired
    private AppPackageRepo appPackageRepo;

    public TrellService(UserAppRepo userAppRepo, AppPackageRepo appPackageRepo) {
        this.userAppRepo = userAppRepo;
        this.appPackageRepo = appPackageRepo;
    }


    public void createMapping(Input input) {
        List<String> packageList = new ArrayList<>(Arrays.asList(input.getPackeges().split(",")));

        List<String> userAppPackageList = new ArrayList<>();
        //userAppRepo.findAll().forEach(n->userAppPackageList.add(n.getPackages()));
        for(UserAppPackage i :  userAppRepo.findAll() )
        {
            if(i.getUser_id()==input.getUserId())
            {
                userAppPackageList.add(i.getPackages());
            }
        }

        List<String> appPackageList = new ArrayList<>();
        appPackageRepo.findAll().forEach(n->appPackageList.add(n.getPackages()));

        packageList.removeAll(userAppPackageList);
        if(!packageList.isEmpty()) {// find difference post package list and UAP
            List<String> difference = new ArrayList<>();
            difference.addAll(packageList);   // store package list in difference

            packageList.removeAll(appPackageList);  // not present in the APT

            difference.removeAll(packageList);          // need to update list of userAppPackages

            for(String i: packageList)
            {
                AppPackageTest temp = new AppPackageTest();

                UserAppPackage tempUserApp = new UserAppPackage();
                tempUserApp.setPackages(i);
                tempUserApp.setUser_id(input.getUserId());

                temp.setPackages(i);
                temp.setUserAppPackages(new ArrayList<>(Arrays.asList(tempUserApp)));

                appPackageRepo.save(temp);
            }
            for (String i : difference )
            {
                AppPackageTest temp = appPackageRepo.findByPackages(i);
                //appPackageRepo.deleteById(temp.getId());

                UserAppPackage tempUserApp = new UserAppPackage();
                tempUserApp.setPackages(i);
                tempUserApp.setUser_id(input.getUserId());

                temp.getUserAppPackages().add(tempUserApp);

                appPackageRepo.save(temp);

            }
        }
        else return;





    }
}

