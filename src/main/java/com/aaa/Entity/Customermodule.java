package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString

public class Customermodule {

    private Integer Mid;
    private String Mname;
    private String Murl;
    private List<Customerfun> customerfunList;

}
