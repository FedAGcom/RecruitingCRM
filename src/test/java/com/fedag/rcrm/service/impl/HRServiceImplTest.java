package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityAlreadyExistsException;
import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.HRMapperImpl;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.repos.HRRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HRServiceImplTest {

    @Mock
    private HRMapperImpl hrMapper;

    @Mock
    private HRRepo hrRepo;

    @InjectMocks
    private HRServiceImpl hrService;

    @Test
    public void findHrByIdTestWhenIdIsValid(){
        when(hrRepo.findById(anyLong())).thenReturn(Optional.of(new HRModel()));
        assertDoesNotThrow(()->hrService.findById(anyLong()));
    }

    @Test
    public void findHrByIdTestWhenIdIsInvalid(){
        when(hrRepo.findById(-1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()-> hrService.findById(-1L));
    }

    @Test
    public void findHrByLoginTestWhenLoginExists(){
        when(hrRepo.findByLogin(anyString())).thenReturn(Optional.of(new HRModel()));
        assertDoesNotThrow(()->hrService.findByLogin(anyString()));
    }

    @Test
    public void findHrByLoginTestWhenLoginDoesNotExists(){
        when(hrRepo.findByLogin(anyString())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()-> hrService.findByLogin(anyString()));
    }

    @Test
    public void findAllHRsTest(){
        Pageable pageable = PageRequest.of(0, 5);
        when(hrRepo.findAll(pageable)).thenReturn(new PageImpl<>(Collections.singletonList(new HRModel())));
        hrService.findAll(pageable);
        verify(hrRepo).findAll(pageable);
    }

    @Test
    public void deleteHRByValidId(){
        when(hrRepo.findById(anyLong())).thenReturn(Optional.of(new HRModel()));
        hrService.deleteById(anyLong());
        verify(hrRepo).deleteById(anyLong());
    }

    @Test
    public void deleteHRByInvalidId(){
        when(hrRepo.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()->hrService.deleteById(anyLong()));
    }

    @Test
    public void createHRTestWithExistingLogin(){
        HRModel model = Mockito.mock(HRModel.class);
        HRRequestDto requestDto = Mockito.mock(HRRequestDto.class);

        when(hrMapper.fromRequest(requestDto)).thenReturn(model);
        when(hrRepo.findByLogin(model.getLogin())).thenReturn(Optional.of(new HRModel()));
        assertThrows(EntityAlreadyExistsException.class, ()->hrService.create(requestDto));
    }

    @Test
    public void createHRTestWithNewLogin(){
        HRModel model = Mockito.mock(HRModel.class);
        HRRequestDto requestDto = Mockito.mock(HRRequestDto.class);

        when(hrMapper.fromRequest(requestDto)).thenReturn(model);
        when(hrRepo.findByLogin(model.getLogin())).thenReturn(Optional.empty());
        hrService.create(requestDto);
        verify(hrRepo).save(model);
    }

    @Test
    public void updateHRTestWithValidIdAndLogin(){
        HRRequestUpdateDto requestDto = Mockito.mock(HRRequestUpdateDto.class);
        HRModel model = Mockito.mock(HRModel.class);
        when(hrMapper.fromRequestUpdate(any(HRRequestUpdateDto.class))).thenReturn(model);
        when(hrRepo.findById(anyLong())).thenReturn(Optional.of(model));
        when(model.getLogin()).thenReturn("login");
        when(hrMapper.toUpdateModel(any(HRModel.class), any(HRModel.class))).thenReturn(model);
        hrService.update(1L,requestDto);
        verify(hrRepo).save(any(HRModel.class));
    }

    @Test
    public void updateHRTestWithInvalidId(){
        when(hrRepo.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()->hrService.update(-1L, any(HRRequestUpdateDto.class)));
    }

    @Test
    public void updateHRTestWithValidIdAndInvalidLogin(){
        HRRequestUpdateDto requestDto = Mockito.mock(HRRequestUpdateDto.class);
        HRModel hr = Mockito.mock(HRModel.class);
        HRModel target = Mockito.mock(HRModel.class);
        when(hrMapper.fromRequestUpdate(any(HRRequestUpdateDto.class))).thenReturn(hr);
        when(hrRepo.findById(anyLong())).thenReturn(Optional.of(target));
        when(hr.getLogin()).thenReturn("login1");
        when(target.getLogin()).thenReturn("login2");
        when(hrRepo.findByLogin(anyString())).thenReturn(Optional.of(new HRModel()));
        assertThrows(EntityAlreadyExistsException.class, ()->hrService.update(1L, requestDto));
    }

}
