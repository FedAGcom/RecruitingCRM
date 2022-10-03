package com.fedag.rcrm.security;

import com.fedag.rcrm.mapper.HRMapper;
import com.fedag.rcrm.message.MessageResponse;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.security.JwtResponseDto;
import com.fedag.rcrm.model.dto.security.LoginRequestDto;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationRestControllerV1 {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    HRRepo hrRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider provider;

    @Autowired
    HRMapper hrMapper;

    // метод для аутентификации пользователя
    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getLogin(),
                        loginRequestDto.getPassword()));

        // идем в SecurityContextHolder и кладем в контекст нашу аутентификацию подтверждая то что у нас прошла аутентификация успешно
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // создаем токен на основе аутентификации
        String token = provider.generateJwtToken(authentication);
        HrDetailsImpl details = (HrDetailsImpl) authentication.getPrincipal();

        List<String> roles = details.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponseDto(token, details.getId(), details.getLogin(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody HRRequestDto request) {
        // проверка на существующий логин
        if (hrRepo.existsByLogin(request.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("ERROR: login already exist"));
        }
        HRModel hrModel = hrMapper.fromRequest(request);
        String password = passwordEncoder.encode(String.valueOf(request.getPassword()));
        hrModel.setPassword(password.toCharArray());

        hrRepo.save(hrModel);
        return ResponseEntity.ok(new MessageResponse("New user was registered"));
    }
}














