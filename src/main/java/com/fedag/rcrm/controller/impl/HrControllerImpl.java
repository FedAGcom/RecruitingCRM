package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.controller.UserController;
import com.fedag.rcrm.model.dto.HRDto;
import com.fedag.rcrm.service.impl.HRServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HrControllerImpl implements UserController {


    private final HRServiceImpl hrService;

    @GetMapping(value = "/hr/{id}")
    public HRDto getHR(@PathVariable Long id) {
        HRDto hrdto = hrService.getHR(id);
        System.out.println("");
        return hrdto;
    }
}
