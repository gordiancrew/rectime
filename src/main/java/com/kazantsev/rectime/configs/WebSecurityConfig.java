package com.kazantsev.rectime.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/rectime").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
        http.csrf().disable().authorizeRequests()

                .antMatchers("/rectime").not().fullyAuthenticated()
                .antMatchers("/clients").hasRole("ADMIN")
                .antMatchers("/specialists").hasRole("USER")
                .antMatchers("/addclient","/style.css").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/addspecialist")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/addspecialist");
    }

}
