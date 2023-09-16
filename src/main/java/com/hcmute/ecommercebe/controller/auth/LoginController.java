package com.hcmute.ecommercebe.controller.auth;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.dto.auth.LoginRequest;
import com.hcmute.ecommercebe.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth/login")
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping("")
    public ResponseBaseAbstract login(@RequestBody LoginRequest request) {
        return this.authService.login(request);
    }
}
