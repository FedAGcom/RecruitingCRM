package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.service.impl.HRServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/users")
    public ResponseEntity<Page<HRResponseDto>> findAllByRoleUser(@PageableDefault(size = 5)
                                                                             Pageable pageable) {
        Page<HRResponseDto> users = hrService.findAllByRoleUser(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<Page<HRResponseDto>> findAllByActiveTrue(@PageableDefault(size = 5)
                                                                         Pageable pageable) {
        Page<HRResponseDto> users = hrService.findAllByActiveTrue(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/admins")
    public ResponseEntity<Page<HRResponseDto>> findAllByRoleAdmin(@PageableDefault(size = 5)
                                                                         Pageable pageable) {
        Page<HRResponseDto> users = hrService.findAllByRoleAdmin(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        hrService.deleteById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HRResponseDto> update(@PathVariable Long id,
                                                    @RequestBody @Valid HRRequestUpdateDto hrRequestUpdate) {
        HRResponseDto hrResponseDto = hrService.update(id, hrRequestUpdate);

        return new ResponseEntity<>(hrResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HRResponseDto> create(@RequestBody @Valid HRRequestDto hrRequestDto) {
        HRResponseDto hrResponseDto = hrService.create(hrRequestDto);

        return new ResponseEntity<>(hrResponseDto, HttpStatus.CREATED);
    }
}
