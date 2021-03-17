package com.ecnu.edu.petgateway.jwt.util;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Leo Qin
 */
@Slf4j
public class ResponseUtil {

    public static <T> void getResponse(HttpServletResponse response, HttpStatus httpStatus, String message, T data) {
        response.setStatus(httpStatus.value());
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(response.getWriter(), CommonRes.getCommonRes(httpStatus.value(), message, data));
        } catch (IOException e) {
            log.error("io异常", e);
            ResponseUtil.getResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, "io异常", "io异常");
        }
    }
}
