package com.fedag.rcrm.security.jwt;

import com.fedag.rcrm.security.HrDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter { // GenericFilterBean

    @Autowired
    private JwtTokenProvider provider;

    @Autowired
    private HrDetailsServiceImpl service;


    // в чем смысл данного метода?
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = parseJwt(request);

            // проверка токена
            if (token != null && provider.validateToken(token)) {

                // получние логина из токена
                String login = provider.getLoginFromJwtToken(token);

                // получение дто деталей из логина
                UserDetails userDetails = service.loadUserByUsername(login);

                // получение аворизационного токена на основе деталей, credentials и авторизации.
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // что тут происходит?
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // в SecurityContextHolder кладем авторизационный токен. а зачем?
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            // здесь логирование
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }
}