package com.bjy.myapp.controllers;

import com.bjy.myapp.exexception.AppException;
import com.bjy.myapp.sep.StanderExchangePojo;
import com.bjy.myapp.sep.StanderReturnerPojo;
import com.bjy.myapp.service.MainService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@Validated
public class MainController {

    @Resource
    MainService mainService;
    @PostMapping("/search")
    public StanderReturnerPojo search(HttpServletResponse httpServletResponse, @RequestBody StanderExchangePojo standerExchangePojo) throws AppException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return mainService.doSearch(standerExchangePojo);
    }

    @PostMapping("/post")
    public StanderReturnerPojo post(HttpServletResponse httpServletResponse,@RequestBody StanderExchangePojo standerExchangePojo) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return mainService.doInsert(standerExchangePojo);

    }

    @PostMapping("/update")
    public StanderReturnerPojo update(HttpServletResponse httpServletResponse,@RequestBody StanderExchangePojo standerExchangePojo) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return mainService.doUpdate(standerExchangePojo);
    }

    @PostMapping("/delete")
    public StanderReturnerPojo delete(HttpServletResponse httpServletResponse,@RequestBody StanderExchangePojo standerExchangePojo) throws AppException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return mainService.doDelete(standerExchangePojo);
    }

}
