package com.example.oauth2security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .authorizeRequests().antMatchers("/", "/h2-console/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().sameOrigin();//for h2-console frames
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
              auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .withUser(User.withUsername("kasia")
                        .password(passwordEncoder().encode("kasia"))
                        .roles("USER"));
//                .usersByUsernameQuery("SELECT 'name', 'password' from 'USERS' where 'name'=?")
//                .authoritiesByUsernameQuery("SELECT 'USER' from 'USERS' where 'name'=?;")

    }
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
