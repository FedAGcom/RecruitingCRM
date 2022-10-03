package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.service.impl.HRServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/hrs")
@Api(value = "HR", tags = "HR API")
public class HrControllerImpl {
    private final HRServiceImpl hrService;

    @Operation(summary = "Получение HR по ID")
    @ApiResponse(responseCode = "200", description = "HR найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "HR не найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HRResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(hrService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Получение страницы с HRs")
    @ApiResponse(responseCode = "200", description = "HRs найдены",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Page<HRResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(hrService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Получение страницы с HRs по роли")
    @ApiResponse(responseCode = "200", description = "HRs найдены",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("role/{role}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Page<HRResponseDto>> findAllByRole(@PathVariable String role,
                                                             @PageableDefault(size = 5)
                                                             Pageable pageable) {
        Page<HRResponseDto> users = hrService.findAllByRole(role, pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Удаление HR по ID")
    @ApiResponse(responseCode = "200", description = "HR удалён",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "HR не найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        hrService.deleteById(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @Operation(summary = "Обновление HR по ID")
    @ApiResponse(responseCode = "200", description = "HR обновлён",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "HR не найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HRResponseDto> update(@PathVariable Long id,
                                                @RequestBody @Valid HRRequestUpdateDto hrRequestUpdate) {
        HRResponseDto hrResponseDto = hrService.update(id, hrRequestUpdate);

        return new ResponseEntity<>(hrResponseDto, HttpStatus.OK);
    }

    @Operation(summary = "Создание HR")
    @ApiResponse(responseCode = "200", description = "HR создан",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping
    public ResponseEntity<HRResponseDto> create(@RequestBody @Valid HRRequestDto hrRequestDto) {
        HRResponseDto hrResponseDto = hrService.create(hrRequestDto);

        return new ResponseEntity<>(hrResponseDto, HttpStatus.CREATED);
    }
}
