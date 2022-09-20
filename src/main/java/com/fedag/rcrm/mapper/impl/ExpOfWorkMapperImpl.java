package com.fedag.rcrm.mapper.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.ExpOfWorkMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.ExpOfWorkModel;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestDto;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.ExpOfWorkResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Component
@RequiredArgsConstructor
@Accessors(chain = true)
public class ExpOfWorkMapperImpl implements ExpOfWorkMapper {

    private final CandidateRepo candidateRepo;

    @Override
    public ExpOfWorkResponseDto toExpResponseDto(ExpOfWorkModel model) {
        ExpOfWorkResponseDto responseDto = new ExpOfWorkResponseDto();
        responseDto.setId(model.getId());
        responseDto.setCandidateId(model.getCandidate().getId());
        responseDto.setPosition(model.getPosition());
        responseDto.setDate_start(model.getDate_start());
        responseDto.setDate_end(model.getDate_end());
        responseDto.setComment(model.getComment());
        responseDto.setDelete(model.isDelete());
        return responseDto;
    }

    @Override
    public List<ExpOfWorkResponseDto> toListExpResponseDto(List<ExpOfWorkModel> list) {
        List<ExpOfWorkResponseDto> listDto = new LinkedList<>();
        for (ExpOfWorkModel model : list) {
            listDto.add(toExpResponseDto(model));
        }
        return listDto;
    }

    @Override
    public ExpOfWorkModel toExpModelRequest(ExpOfWorkRequestDto requestDto, Long candidateId) {
        ExpOfWorkModel model = new ExpOfWorkModel();
        CandidateModel candidateModel = candidateRepo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));
        model.setCandidate(candidateModel);
        model.setPosition(requestDto.getPosition());
        model.setDate_start(requestDto.getDate_start());
        model.setDate_end(requestDto.getDate_end());
        model.setComment(requestDto.getComment());
        return model;
    }

    @Override
    public ExpOfWorkModel toExpModelUpdate(ExpOfWorkModel source, ExpOfWorkRequestUpdateDto dto, CandidateModel candidate) {
        source.setCandidate(candidate);
        source.setPosition(dto.getPosition());
        source.setDate_start(dto.getDate_start());
        source.setDate_end(dto.getDate_end());
        source.setComment(dto.getComment());
        source.setDelete(dto.isDelete());
        return source;
    }
}
