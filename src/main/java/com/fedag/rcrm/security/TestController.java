package com.fedag.rcrm.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {

    @GetMapping("/all")
    public String getAll() {
        return "PUBLIC API";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public String getUserApi() {
        return "USER API";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAdmin() {
        return "ADMIN API";
    }

    @GetMapping("/admin-and-user")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public String getAdminAndUser() {
        return "ADMIN AND USER API";
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('USER')")
    public String getTest() {
        return "TEST";
    }
}
