package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.security.HrDetailsServiceImpl;
import com.fedag.rcrm.service.CurrentHRService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrentHRServiceImpl implements CurrentHRService {
    private final HrDetailsServiceImpl hrDetailsService;

    @Override
    public HRModel getCurrentHR() {
        log.info("Получение текущего пользователя из Security Context");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        HRModel result = hrDetailsService.getHRByLogin(auth.getName());
        log.info("Текущий пользователь из Security Context получен");
        return result;
    }
}
