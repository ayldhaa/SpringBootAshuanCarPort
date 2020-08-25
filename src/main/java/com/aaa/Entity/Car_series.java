package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car_series {

    public Integer id;
    public Integer group_id;
    public Integer brand_id;
    public String full_name;
    public String csname;
    public String firstletter;
    public Integer seriesstate;
    public Integer seriesorder;

    public Car_brand car_brand;

    public Car_series_group car_series_group;
}
