package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

/**
 * 热卖车型
 */
@Data
@ToString
public class Car_brand {

    public Integer id;
    public String name;
    public String img;
    public String firstletter;

}
