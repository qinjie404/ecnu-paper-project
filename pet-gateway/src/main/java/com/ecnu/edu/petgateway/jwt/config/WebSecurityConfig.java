package com.ecnu.edu.petgateway.jwt.config;

import com.ecnu.edu.petgateway.jwt.filter.JwtAuthenticationFilter;
import com.ecnu.edu.petgateway.jwt.filter.JwtAuthorizationFilter;
import com.ecnu.edu.petgateway.jwt.handler.JwtLogOutHandler;
import com.ecnu.edu.petgateway.jwt.service.JwtUserDetailServiceImpl;
import com.ecnu.edu.petgateway.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @author 13862
 * @description
 * @date 2020/12/16 11:29
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置需要拦截的资源
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http// CRSF禁用，因为不使用session
            .csrf().disable()
            // 禁用session
            .sessionManagement().disable()
            // 禁用form登录
            .formLogin().disable()
            // 支持跨域
            .cors()
            .and()
            .authorizeRequests()
            //默认其它的请求都需要认证，这里一定要添加
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtUtil))
            .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtUtil))
            .logout().logoutUrl("/logout").addLogoutHandler(new JwtLogOutHandler(jwtUtil))
            .and();
    }

    /**
     * 解决跨域问题
     *
     * @return
     */
    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 是否允许请求带有验证信息
        configuration.setAllowCredentials(true);
        // 允许访问的客户端域名
        configuration.setAllowedOrigins(Arrays.asList("*"));
        // 允许服务端访问的客户端请求头
        configuration.setAllowedMethods(Arrays.asList("*"));
        // 允许访问的方法名,GET POST等
        configuration.setAllowedHeaders(Arrays.asList("*"));
        // 暴露哪些头部信息 不能用*因为跨域访问默认不能获取全部头部信息
        configuration.addExposedHeader("Token");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * 配置不需要拦截的资源
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 放行的资源
        web.ignoring()
                // 允许对于网站静态资源的无授权访问
                .antMatchers(
                        "/swagger-ui.html",
                        "/swagger-ui/*",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/webjars/**",
                        "/actuator/**",
                        "/druid/**",
                        "/*/v2/api-docs"
                );
    }

    /**
     * 配置加密方法跟UserDetailsService对象
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailService).passwordEncoder(passwordEncoder());
    }
}
