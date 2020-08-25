package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Car_info {

    public Integer id;
    public Integer brand_id;
    public Integer group_id;
    public Integer series_id;
    public String full_name;
    public String ciname;
    public String brand_name;
    public String group_name;
    public String series_name;
    public Integer state;
    public Integer minprice;
    public Integer maxprice;
    public String year;

    public Car_brand car_brand;
    public Car_series_group car_series_group;
    public Car_series car_series;

}
