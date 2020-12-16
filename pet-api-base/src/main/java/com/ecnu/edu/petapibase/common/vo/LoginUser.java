package com.ecnu.edu.petapibase.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 13862
 * @description
 * @date 2020/12/16 10:34
 */
@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = -5972874651738825552L;
    private String userName;
    private String password;
    private Boolean rememberMe;
}
