package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.security.HrDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HrDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private HRRepo repo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HRModel model = repo.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Hr with login: " + username + " not found"));
        return HrDetailsImpl.build(model);
    }
}
