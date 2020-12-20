package com.ecnu.edu.petgateway.jwt.handler;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.ecnu.edu.petgateway.jwt.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未认证出处理
 *
 * @author Leo Qin
 */
public class UnAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.getResponse(httpServletResponse, HttpStatus.UNAUTHORIZED, CommonRes.FAIL_STATUS, "认证失败", e.getMessage());
    }
}
