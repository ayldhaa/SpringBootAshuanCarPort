package com.aaa.Entity;

import lombok.Data;
import lombok.ToString;

/**
 * 制动配置
 */
@Data
@ToString
public class Chassisbrake {
    private Integer chassid;
    private String bodystructure;
    private String frontbraketype;
    private String rearbraketype;
    private String parkingbraketype;
    private String drivemode;
    private String frontsuspensiontype;

}
