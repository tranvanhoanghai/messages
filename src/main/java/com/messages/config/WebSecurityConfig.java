package com.messages.config;

import com.messages.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService iUserService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(iUserService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

        @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .antMatchers("/login").permitAll()      // không check authen trên link "login"
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**").permitAll()

                .antMatchers("/").hasRole("MEMBER")     // chỉ cho phép các user có GrantedAuthority là ROLE_roleName mới được phép truy cập
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()                       // check authen trên tất cả các link khác
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/chat")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();






//            .formLogin()                                            // sử dụng formlogin
//                .loginPage("/login")                                // page login được generate thông qua controller xử lý "/login"
//                .permitAll()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/")
//                .failureUrl("/login?error")
//                .and()
//            .exceptionHandling()
//                .accessDeniedPage("/403");
    }
}
