package com.fedag.rcrm.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fedag.rcrm.model.HRModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class HrDetailsImpl implements UserDetails {

    private Long id;
    private String login;

    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public HrDetailsImpl(Long id, String login, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    public HrDetailsImpl() {
    }

    public static HrDetailsImpl build(HRModel model) {
        HrDetailsImpl details = new HrDetailsImpl();
//        List<GrantedAuthority> authorities = model.getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(model.getRole().getName()));


        details.setId(model.getId());
        details.setLogin(model.getLogin());
        details.setPassword(String.valueOf(model.getPassword()));
        details.setAuthorities(authorities);
        return details;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HrDetailsImpl details = (HrDetailsImpl) o;
        return Objects.equals(id, details.id)
                && Objects.equals(login, details.login)
                && Objects.equals(password, details.password)
                && Objects.equals(authorities, details.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, authorities);
    }
}
