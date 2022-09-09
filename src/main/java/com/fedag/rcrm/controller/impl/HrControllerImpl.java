package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.service.impl.HRServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public HRResponseDto findById(@PathVariable Long id){
        return hrService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Page<HRResponseDto>>  findAll(@PageableDefault(size = 5) Pageable pageable){
        return  new ResponseEntity<>(hrService.findAll(pageable), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHR(@PathVariable Long id){
        HRResponseDto hr = hrService.findById(id);
        //
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
