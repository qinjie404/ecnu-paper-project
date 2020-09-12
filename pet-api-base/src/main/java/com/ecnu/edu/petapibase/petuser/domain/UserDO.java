package com.ecnu.edu.petapibase.petuser.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 13862
 */
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 9143459192158583455L;
    private Integer userId;
    private String userName;

}
