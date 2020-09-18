package com.ecnu.edu.petapibase.entity.petuser.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 13862
 */
@Data
@Table(name = "pet_user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 9143459192158583455L;
    @Id
    private Integer userId;
    private String userName;

}
