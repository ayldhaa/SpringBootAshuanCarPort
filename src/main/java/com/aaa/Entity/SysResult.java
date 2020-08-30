package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysResult {
    private Integer status;
    private String msg;
    private Object obj;
}
