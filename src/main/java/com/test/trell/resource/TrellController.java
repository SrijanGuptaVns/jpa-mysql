package com.test.trell.resource;

import com.test.trell.model.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TrellController {
   @Autowired
   private TrellService trellService;

    @RequestMapping(method = RequestMethod.POST, value = "/trell")
    public void add(@RequestBody Input input)
    {
        trellService.createMapping(input);
    }

}
