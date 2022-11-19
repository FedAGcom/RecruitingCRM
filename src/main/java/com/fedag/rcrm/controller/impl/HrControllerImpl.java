package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.service.impl.HRServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/hrs")
public class HrControllerImpl {

    private final HRServiceImpl hrService;

    @GetMapping("/{id}")
    public HRResponseDto getHR(@PathVariable Long id){
        return hrService.findById(id);
    }

    @GetMapping
    public List<HRResponseDto> getAllHRs(){
        return hrService.getAllHRs();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHR(@PathVariable Long id){
        HRResponseDto hr = hrService.findById(id);
        //
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }




}
