package com.fedag.rcrm.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}


/**
 * Переопределим AuthenticationEntryPoint.
 *
 * В стандартном веб-приложении, когда осуществляется обращение к защищенному ресурсу
 * и в секьюрити контексте отсутствует объект Authentication,
 * Spring Security перенаправляет пользователя на страницу аутентификации.
 * Однако для REST-сервиса более подходящим поведением
 * в этом случае было бы возвращать HTTP статус 401 (UNAUTHORIZED).
 */
