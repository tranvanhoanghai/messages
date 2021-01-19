package com.messages.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // Sét đặt dịch vụ để tìm kiếm User trong Database.
//        // Và sét đặt PasswordEncoder.
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .antMatchers("/login").permitAll()      // không check authen trên link "login"
                .antMatchers("/register").permitAll()
                .antMatchers("/").hasRole("MEMBER")     // chỉ cho phép các user có GrantedAuthority là ROLE_roleName mới được phép truy cập
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()                       // check authen trên tất cả các link khác
                .and()
            .formLogin()                                            // sử dụng formlogin
                .loginPage("/login")                                // page login được generate thông qua controller xử lý "/login"
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403");
    }
}
