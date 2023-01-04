package com.bjy.myapp.sep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Data
public class StanderExchangePojo {
    private LocalDateTime datetimeLocalSend;
    private String headLineSend;
    private String mainTextSend;
    private String searchTextSend;
    private String id;
}
