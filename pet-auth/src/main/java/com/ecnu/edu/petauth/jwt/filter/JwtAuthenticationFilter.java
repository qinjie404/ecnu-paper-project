package com.ecnu.edu.petauth.jwt.filter;

import com.ecnu.edu.petapibase.common.vo.LoginUser;
import com.ecnu.edu.petauth.jwt.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录过滤器
 *
 * @author 13862
 * @description
 * @date 2020/12/16 10:24
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ThreadLocal<Boolean> rememberMe = new ThreadLocal<>();
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginUser loginUser;
        try {
            // 从输入流中获取到登录的信息
            loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
            rememberMe.set(loginUser.getRememberMe());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword())
            );
        } catch (IOException e) {
            log.error("io异常", e);
            return null;
        }
    }

    /**
     * 验证成功
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
        super.successfulAuthentication(request, response, chain, authResult);
        LoginUser loginUser = (LoginUser) authResult.getPrincipal();
        log.info("loginUser:{}", loginUser);
        boolean isRemember = rememberMe.get();
        String token = jwtUtil.createJwtToken(loginUser.getUserName(), isRemember);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setHeader("token", JwtUtil.TOKEN_PREFIX + token);
    }

    /**
     * 验证失败
     *
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        log.error("登录失败", failed);
        response.getWriter().write("登录失败: " + failed);
    }
}
