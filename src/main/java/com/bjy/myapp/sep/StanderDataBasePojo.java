package com.bjy.myapp.sep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class StanderDataBasePojo {
    @Column
    private LocalDateTime dateTime;
    @Column
    private String headLine;
    @Column
    private String mainText;
    @Id
    private String id;

    public StanderDataBasePojo() {

    }

    public StanderDataBasePojo(StanderExchangePojo standerExchangePojo){
        id = idGenerator();
        headLine = standerExchangePojo.getHeadLineSend();
        mainText = standerExchangePojo.getMainTextSend();
        dateTime = standerExchangePojo.getDatetimeLocalSend();
    }

    static public String idGenerator(){
            return UUID.randomUUID().toString();
    }
}
