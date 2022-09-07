package com.fedag.rcrm.config;

import com.fedag.rcrm.service.CandidateService;
import com.fedag.rcrm.service.impl.CandidateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CandidateService candidateService() {
        return new CandidateServiceImpl();
    }
}
