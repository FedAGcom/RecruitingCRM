package com.fedag.rcrm.security;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.repos.HRRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class HrDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HRRepo repo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        HRModel model = repo
                .findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Hr with login: " + login + " not found"));
        return HrDetailsImpl.build(model);
    }

    public HRModel getHRByLogin(String login) {
        log.info("Поиск HR с login: ", login);
        HRModel result = repo
                .findByLogin(login)
                .orElseThrow(() -> {
                    log.info("HR с login: {} не найден", login);
                    throw new EntityNotFoundException("HR", "login", login);
                });
        log.info("HR с login: {} найден", login);
        return result;
    }
}
