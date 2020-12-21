package com.ecnu.edu.petgateway.jwt.filter;

import com.ecnu.edu.petapibase.base.entity.CommonRes;
import com.ecnu.edu.petgateway.jwt.util.JwtUtil;
import com.ecnu.edu.petgateway.jwt.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 授权过滤器
 *
 * @author Leo Qin
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    /**
     * 授权认证入口
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String token = request.getHeader("Token");
        // 如果请求头中没有token信息则返回失败信息
        if (token == null) {
            ResponseUtil.getResponse(response, HttpStatus.UNAUTHORIZED, CommonRes.FAIL_STATUS, "授权失败", "获取token失败");
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        try {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
        } catch (Exception e) {
            logger.error("授权失败", e);
            //返回json形式的错误信息
            ResponseUtil.getResponse(response, HttpStatus.UNAUTHORIZED, CommonRes.FAIL_STATUS, "授权失败", e.getMessage());
            return;
        }
        chain.doFilter(request, response);
    }

    /**
     * 这里从token中获取用户信息并新建一个token
     *
     * @param token
     * @return
     * @throws Exception
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String token) throws Exception {
        boolean expiration = jwtUtil.isExpiration(token);
        if (expiration) {
            throw new Exception("token超时了");
        } else {
            String username = jwtUtil.getUserName(token);
            if (username != null) {
                //todo: 从redis获取角色权限信息,角色前必须加ROLE_
                List<GrantedAuthority> authorityList = new ArrayList<>();
                authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new UsernamePasswordAuthenticationToken(username, null, authorityList);
            }
        }
        return null;
    }
}
