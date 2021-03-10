package com.ecnu.edu.petapibase.user.query;

import com.ecnu.edu.petapibase.common.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 13862
 * @description
 * @date 2020/11/27 13:55
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommunityNotesQuery extends PageQuery {
    private static final long serialVersionUID = -5403962107417535187L;
}
