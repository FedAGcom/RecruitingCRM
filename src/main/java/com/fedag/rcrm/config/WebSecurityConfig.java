package com.fedag.rcrm.config;


import com.fedag.rcrm.service.impl.HrDetailsServiceImpl;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    private HrDetailsServiceImpl service;

}
