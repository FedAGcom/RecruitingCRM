package com.fedag.rcrm.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.mapper.HRMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.UserRoleModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HRMapperImpl implements HRMapper {
    private final ObjectMapper objectMapper;

    @Override
    public HRResponseDto toResponse(HRModel hrModel) {
        HRResponseDto responseDto = new HRResponseDto();
        responseDto.setId(hrModel.getId());
        responseDto.setFirstName(hrModel.getFirstName());
        responseDto.setLastname(hrModel.getLastname());
        responseDto.setLogin(hrModel.getLogin());
//        if (hrModel.getRoles()!=  null){
//            responseDto.setRoles(hrModel.getRoles()
//                    .stream()
//                    .map((UserRoleModel t) -> t.getName().name())
//                    .collect(Collectors.toList()));
//        }
        responseDto.setRole(hrModel.getRole().getName());
        responseDto.setCreationDate(hrModel.getCreationDate());
        responseDto.setActive(hrModel.isActive());
        if (hrModel.getCandidates() !=null){
            responseDto.setCandidatesId(hrModel.getCandidates()
                    .stream()
                    .map(CandidateModel::getId)
                    .collect(Collectors.toList()));
        }
        if(hrModel.getVacancies()!=null){
            responseDto.setVacanciesId(hrModel.getVacancies()
                    .stream()
                    .map(VacancyModel::getId)
                    .collect(Collectors.toList()));
        }
        return responseDto;
    }

    @Override
    public HRModel fromRequest(HRRequestDto hrRequestDto) {

        HRModel hrModel = new HRModel();
        hrModel.setFirstName(hrRequestDto.getFirstName());
        hrModel.setLastname(hrRequestDto.getLastname());

        hrModel.setLogin(hrRequestDto.getLogin());
        hrModel.setPassword(hrModel.getPassword());

        Set<UserRoleModel> userRoleModelSet = new HashSet<>();

//        for (String role : hrRequestDto.getRoles()) {
//            if (role.equals("USER")) {
//                userRoleModelSet.add(new UserRoleModel(Role.USER));
//            }
//            if (role.equals("ADMIN")) {
//                userRoleModelSet.add(new UserRoleModel(Role.ADMIN));
//            }
//        }
        hrModel.setRole(Role.valueOf(hrRequestDto.getRole()));
        hrModel.setLogin(hrModel.getLogin());
        hrModel.setPassword(hrModel.getPassword());

//        return objectMapper.convertValue(hrRequestDto, HRModel.class);
        return hrModel;
    }

    @Override
    public HRModel fromRequestUpdate(HRRequestUpdateDto hrRequestUpdateDto) {
        return objectMapper.convertValue(hrRequestUpdateDto, HRModel.class);
    }

    @Override
    public HRModel toUpdateModel(HRModel source, HRModel target) {
        target.setFirstName(source.getFirstName());
        target.setLastname(source.getLastname());
        target.setLogin(source.getLogin());
        return target;
    }
}
