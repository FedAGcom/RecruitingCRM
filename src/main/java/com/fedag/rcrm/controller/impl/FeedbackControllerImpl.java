package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;
import com.fedag.rcrm.service.FeedbackService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/feedbacks")
public class FeedbackControllerImpl {
    private final FeedbackService feedbackService;

    @Operation(summary = "Получение Отзыва по ID")
    @ApiResponse(responseCode = "200", description = "Отзыв найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Отзыв не найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/{id}")
    public FeedbackResponseDto findById(@PathVariable Long id){
        return feedbackService.findById(id);
    }

    @Operation(summary = "Получение страницы с Отзывами")
    @ApiResponse(responseCode = "200", description = "Отзывы найдены",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping
    public ResponseEntity<Page<FeedbackResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable){
        return new ResponseEntity<>(feedbackService.findAll(pageable), HttpStatus.OK);
    }

    @Operation(summary = "Удаление Отзыва по ID")
    @ApiResponse(responseCode = "200", description = "Отзыв удалён",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Отзыв не найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        feedbackService.deleteById(id);
        return new ResponseEntity<>("Feedback deleted", HttpStatus.OK);
    }

    @Operation(summary = "Обновление Отзыва по ID")
    @ApiResponse(responseCode = "200", description = "Отзыв обновлён",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Отзыв не найден",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PatchMapping("/{id}")
    public ResponseEntity<FeedbackResponseDto> update(@PathVariable Long id,
                                                @RequestBody @Valid FeedbackRequestUpdateDto feedbackRequestUpdateDto) {
        FeedbackResponseDto feedback = feedbackService.update(id, feedbackRequestUpdateDto);

        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @Operation(summary = "Создание Отзыва")
    @ApiResponse(responseCode = "200", description = "Отзыв создан",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Ошибка клиента",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Ошибка сервера",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping
    public ResponseEntity<FeedbackResponseDto> create(@RequestParam Long candidateId,
                                                      @RequestBody @Valid FeedbackRequestDto feedbackRequestDto) {
        //FeedbackResponseDto feedback = feedbackService.create(feedbackRequestDto);

        //return new ResponseEntity<>(feedback, HttpStatus.CREATED);
        return null;
    }

}
