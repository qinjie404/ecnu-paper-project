package com.ecnu.edu.petapibase.user.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQuery implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
}
