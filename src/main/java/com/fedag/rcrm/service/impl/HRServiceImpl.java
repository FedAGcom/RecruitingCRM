package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.enums.Role;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HRServiceImpl implements HRService {
    private final HRMapper hrMapper;
    private final HRRepo hrRepo;

    @Override
    public HRResponseDto findById(Long id) {
        log.info("Поиск HR с Id: {}", id);
        HRModel hrModel = hrRepo.findById(id).orElseThrow(()->new EntityNotFoundException("HR", "ID", id));
        HRResponseDto result = hrMapper.toResponse(hrModel);
        log.info("HR с Id: {} найден", id);
        return result;
    }

    @Override
    public HRResponseDto findByLogin(String login) {
        log.info("Поиск HR по логину: {}", login);
        HRModel hrModel = hrRepo.findByLogin(login).orElseThrow(()-> new EntityNotFoundException("HR", "login", login));
        HRResponseDto result = hrMapper.toResponse(hrModel);
        log.info("HR с логином: {} найден", login);
        return result;
    }

    @Override
    public Page<HRResponseDto> findAll(Pageable pageable) {
        log.info("Получение страницы с HR");
        Page<HRResponseDto> result = hrRepo.findAll(pageable).map(hrMapper::toResponse);
        log.info("Страница с HR получена");
        return result;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        log.info("Удаление HR с Id: {}", id);
        this.findById(id);
        hrRepo.deleteById(id);
        log.info("HR с Id: {} удален", id);
    }

    @Transactional
    @Override
    public HRResponseDto update(Long id, HRRequestUpdateDto hrRequestUpdateDto) {
        log.info("Обновление HR с Id: {}", id);
        HRModel hr = hrMapper.fromRequestUpdate(hrRequestUpdateDto);
        HRModel target = hrRepo.findById(id).orElseThrow(()->new EntityNotFoundException("HR", "ID", id));
        if (!hr.getLogin().equals(target.getLogin())){
            if (hrRepo.findByLogin(hr.getLogin()).isPresent()) {
                throw new EntityAlreadyExistsException("HR", "login", hr.getLogin());
            }
        }
        HRModel update = hrMapper.toUpdateModel(hr, target);
        HRResponseDto result = hrMapper.toResponse(hrRepo.save(update));
        log.info("HR с Id: {} обновлен", id);
        return result;
    }

    @Transactional
    @Override
    public HRResponseDto create(HRRequestDto hrRequest) {
        log.info("Создание HR");
        HRModel hr = hrMapper.fromRequest(hrRequest);
        if (hrRepo.findByLogin(hr.getLogin()).isPresent()) {
            throw new EntityAlreadyExistsException("HR", "login", hr.getLogin());
        }
        HRResponseDto result = hrMapper.toResponse(hrRepo.save(hr));
        log.info("HR создан");
        return result;

    }

    @Override
    public Page<HRResponseDto> findAllByRole(String role, Pageable pageable) {
        log.info("Получение страницы с HR с ролью: {}", role);
        Page<HRResponseDto> result = hrRepo.findAllByRolesContainsAndActiveTrue(Role.valueOf(role.toUpperCase()), pageable)
                .map(hrMapper::toResponse);
        log.info("Страница с HR с ролью: {} получена", role);
        return result;
    }
}
