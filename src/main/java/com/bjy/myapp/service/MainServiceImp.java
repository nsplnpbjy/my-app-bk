package com.bjy.myapp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjy.myapp.dao.StanderDataBaseDao;
import com.bjy.myapp.exexception.AppException;
import com.bjy.myapp.sep.StanderDataBasePojo;
import com.bjy.myapp.sep.StanderExchangePojo;
import com.bjy.myapp.sep.StanderReturnerPojo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class MainServiceImp implements MainService{

    @Resource
    StanderDataBaseDao standerDataBaseDao;
    @Override
    public StanderReturnerPojo doSearch(StanderExchangePojo standerExchangePojo) throws AppException {
        if (Objects.isNull(standerExchangePojo.getSearchTextSend())||standerExchangePojo.getSearchTextSend().isBlank()){
            throw  new AppException("搜索体不存在",401);
        }
        String keyWord = standerExchangePojo.getSearchTextSend();
        IPage<StanderDataBasePojo> page = new Page<StanderDataBasePojo>();
        if (standerExchangePojo.getSearchTextSend().equals("allShow")){
            page.setRecords(standerDataBaseDao.mainPageLoad());
            return new StanderReturnerPojo(page);
        }
        standerDataBaseDao.selectPage(page,new QueryWrapper<StanderDataBasePojo>().like("head_line",keyWord).or().like("main_text",keyWord));
        return new StanderReturnerPojo(page);
    }

    @Override
    public StanderReturnerPojo doInsert(StanderExchangePojo standerExchangePojo) throws Exception {
        StanderDataBasePojo standerDataBasePojo = new StanderDataBasePojo(standerExchangePojo);
        if(standerDataBaseDao.insert(standerDataBasePojo)!=1){
            throw new AppException(standerDataBasePojo.getHeadLine()+"插入失败",402);
        }
        return new StanderReturnerPojo(true);
    }

    @Override
    public StanderReturnerPojo doDelete(StanderExchangePojo standerExchangePojo) throws AppException {
        if(standerDataBaseDao.deleteById(standerExchangePojo.getId())!=1){
            throw new AppException(standerExchangePojo.getId()+"删除失败",402);
        }
        return new StanderReturnerPojo(true);
    }

    @Override
    public StanderReturnerPojo doUpdate(StanderExchangePojo standerExchangePojo) throws Exception {
        if (standerDataBaseDao.update(new StanderDataBasePojo(standerExchangePojo),new QueryWrapper<StanderDataBasePojo>().eq("id",standerExchangePojo.getId()))!=1){
            throw new AppException(standerExchangePojo.getId()+"更新失败",402);
        }
        return new StanderReturnerPojo(true);
    }

}
