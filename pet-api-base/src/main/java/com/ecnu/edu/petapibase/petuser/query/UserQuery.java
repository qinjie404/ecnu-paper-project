package com.ecnu.edu.petapibase.petuser.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQuery implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
}
