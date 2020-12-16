package com.ecnu.edu.petauth.jwt.config;

import com.ecnu.edu.petauth.jwt.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 静态资源访问无需认证
                .antMatchers("/image/**").permitAll()
                // admin开头的请求，需要admin权限
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                // 需登陆才能访问的url
                .antMatchers("/notes/**").hasRole("USER")
                //默认其它的请求都需要认证，这里一定要添加
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                // CRSF禁用，因为不使用session
                .csrf().disable()
                // 禁用session
                .sessionManagement().disable()
                // 禁用form登录
                .formLogin().disable()
                // 支持跨域
                .cors()
                .and()
                // 添加header设置，支持跨域和ajax请求
                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
                new Header("Access-control-Allow-Origin","*"),
                new Header("Access-Control-Expose-Headers","Authorization"))))
                .and()
                //使用默认的logoutFilter
                .logout()
                //logout成功后返回200
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .and()
                .sessionManagement().disable();
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","HEAD", "OPTION"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.addExposedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
