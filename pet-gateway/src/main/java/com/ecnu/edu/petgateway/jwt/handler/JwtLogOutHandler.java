package com.ecnu.edu.petgateway.jwt.handler;

import com.ecnu.edu.petgateway.jwt.util.JwtUtil;
import com.ecnu.edu.petgateway.jwt.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登出处理
 *
 * @author Leo Qin
 */
public class JwtLogOutHandler implements LogoutHandler {

    private JwtUtil jwtUtil;

    public JwtLogOutHandler(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        // 1.从header中获取token
        String token = httpServletRequest.getHeader(JwtUtil.TOKEN_HEADER);

        // 2.若token不为空，则删除，从redis删除token
        if (StringUtils.isNotBlank(token)) {
            String userName = jwtUtil.getUserName(token);
            // todo:从redis删除token
        }
        ResponseUtil.getResponse(httpServletResponse, HttpStatus.OK, "登出成功", "登出成功");
    }
}
