package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car_series_group {

    public Integer id;
    public Integer brand_id;
    public String csgname;
    public String firstletter;

    public Car_brand car_brand;
}
