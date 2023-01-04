package com.bjy.myapp.controllers;

import com.bjy.myapp.exexception.AppException;
import com.bjy.myapp.sep.StanderExchangePojo;
import com.bjy.myapp.sep.StanderReturnerPojo;
import com.bjy.myapp.service.MainService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin("*")
@RestController
@Validated
public class MainController {

    @Resource
    MainService mainService;
    @PostMapping("/search")
    public StanderReturnerPojo search(@RequestBody StanderExchangePojo standerExchangePojo) throws AppException {
        return mainService.doSearch(standerExchangePojo);
    }

    @PostMapping("/post")
    public StanderReturnerPojo post(@RequestBody StanderExchangePojo standerExchangePojo) throws Exception {
        return mainService.doInsert(standerExchangePojo);

    }

    @PostMapping("/update")
    public StanderReturnerPojo update(@RequestBody StanderExchangePojo standerExchangePojo) throws Exception {
        return mainService.doUpdate(standerExchangePojo);
    }

    @PostMapping("/delete")
    public StanderReturnerPojo delete(@RequestBody StanderExchangePojo standerExchangePojo) throws AppException {
        return mainService.doDelete(standerExchangePojo);
    }

}
