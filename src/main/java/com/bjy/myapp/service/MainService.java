package com.bjy.myapp.service;

import com.bjy.myapp.exexception.AppException;
import com.bjy.myapp.sep.StanderExchangePojo;
import com.bjy.myapp.sep.StanderReturnerPojo;
import org.springframework.stereotype.Service;

public interface MainService {
    public StanderReturnerPojo doSearch(StanderExchangePojo standerExchangePojo) throws AppException;
    public StanderReturnerPojo doInsert(StanderExchangePojo standerExchangePojo) throws Exception;
    public StanderReturnerPojo doDelete(StanderExchangePojo standerExchangePojo) throws AppException;
    public StanderReturnerPojo doUpdate(StanderExchangePojo standerExchangePojo) throws Exception;
}
