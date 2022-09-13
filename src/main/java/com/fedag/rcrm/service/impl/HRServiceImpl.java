package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityAlreadyExistsException;
import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.HRMapper;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.service.HRService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import static com.fedag.rcrm.enums.Role.*;

@Service
@RequiredArgsConstructor
public class HRServiceImpl implements HRService {
    private final HRMapper hrMapper;
    private final HRRepo hrRepo;

    @Override
    public HRResponseDto findById(Long id) {
        HRModel hrModel = hrRepo.findById(id).orElseThrow(()->new EntityNotFoundException("HR", "ID", id));
        return hrMapper.toResponse(hrModel);
    }

    @Override
    public HRResponseDto findByLogin(String login) {
        HRModel hrModel = hrRepo.findByLogin(login).orElseThrow(()-> new EntityNotFoundException("HR", "login", login));
        return hrMapper.toResponse(hrModel);
    }

    @Override
    public Page<HRResponseDto> findAll(Pageable pageable) {
        return hrRepo.findAll(pageable).map(hrMapper::toResponse);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.findById(id);
        hrRepo.deleteById(id);
    }

    @Transactional
    @Override
    public HRResponseDto update(Long id, HRRequestUpdateDto hrRequestUpdateDto) {
        HRModel hr = hrMapper.fromRequestUpdate(hrRequestUpdateDto);
        if (hrRepo.findByLogin(hr.getLogin()).isPresent()) {
            throw new EntityAlreadyExistsException("HR", "login", hr.getLogin());
        }
        HRModel target = hrRepo.findById(id).orElseThrow(()->new EntityNotFoundException("HR", "ID", id));
        HRModel update = hrMapper.merge(hr, target);
        return hrMapper.toResponse(hrRepo.save(update));
    }

    @Transactional
    @Override
    public HRResponseDto create(HRRequestDto hrRequest) {
        HRModel hr = hrMapper.fromRequest(hrRequest);
        if (hrRepo.findByLogin(hr.getLogin()).isPresent()) {
            throw new EntityAlreadyExistsException("HR", "login", hr.getLogin());
        }
        return hrMapper.toResponse(hrRepo.save(hr));

    }

    @Override
    public Page<HRResponseDto> findAllByRoleUser(Pageable pageable) {
        return  hrRepo.findAllByRolesContains(USER, pageable).map(hrMapper::toResponse);
    }

    @Override
    public Page<HRResponseDto> findAllByRoleAdmin(Pageable pageable) {
        return hrRepo.findAllByRolesContains(ADMIN, pageable).map(hrMapper::toResponse);
    }

    @Override
    public Page<HRResponseDto> findAllByActiveTrue(Pageable pageable) {
        return hrRepo.findAllByActiveTrue(pageable).map(hrMapper::toResponse);
    }
}
