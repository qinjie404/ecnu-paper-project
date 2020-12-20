package com.ecnu.edu.petgateway.jwt.filter;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.ecnu.edu.petapibase.user.domain.UserDO;
import com.ecnu.edu.petgateway.jwt.util.JwtUtil;
import com.ecnu.edu.petgateway.jwt.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 用户登录过滤器
 *
 * @author 13862
 * @description
 * @date 2020/12/16 10:24
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        super.setFilterProcessesUrl("/login");
    }

    /**
     * 登录认证
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UserDO loginUser;
        try {
            // 从输入流中获取到登录的信息
            loginUser = new ObjectMapper().readValue(request.getInputStream(), UserDO.class);
            // 调用UserDetailsService的loadUserByUsername方法查询数据库用户
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            log.error("io异常", e);
            return null;
        }
    }

    /**
     * 认证成功调用
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetails loginUser = (UserDetails) authResult.getPrincipal();
        log.info("认证成功。当前登陆人:{}", loginUser);
        // 生成token
        String token = jwtUtil.createJwtToken(loginUser.getUsername());
        ResponseUtil.getResponse(response, HttpStatus.OK, CommonRes.SUCCESS_STATUS, "认证成功", token);
    }

    /**
     * 认证失败调用
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.error("认证失败", failed);
        ResponseUtil.getResponse(response, HttpStatus.UNAUTHORIZED, CommonRes.FAIL_STATUS, "认证失败", failed.getMessage());
    }
}
