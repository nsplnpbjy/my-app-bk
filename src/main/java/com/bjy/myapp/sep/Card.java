package com.bjy.myapp.sep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Card {
    private String headLine;
    private String MainText;
    private Date dateTime;
    private String id;
}
