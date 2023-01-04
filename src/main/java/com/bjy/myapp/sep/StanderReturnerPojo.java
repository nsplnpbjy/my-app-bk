package com.bjy.myapp.sep;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjy.myapp.exexception.AppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StanderReturnerPojo {
    private Integer statueCode;
    private String msg;
    private List<StanderDataBasePojo> cards;
    private Boolean isOk;

    public StanderReturnerPojo(Boolean aBoolean){
        isOk = aBoolean;
    }
    public StanderReturnerPojo(AppException e){
        statueCode = e.getCode();
        msg = e.getMsg();
    }

    public StanderReturnerPojo(IPage<StanderDataBasePojo> inPage){
        cards = inPage.getRecords();
    }
}
