package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.service.impl.HRServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HrControllerImpl {

    private final HRServiceImpl hrService;

    @GetMapping(value = "/hr/{id}")
    public HRDto getHR(@PathVariable Long id) {
        return hrService.getHR(id);
    }
}
