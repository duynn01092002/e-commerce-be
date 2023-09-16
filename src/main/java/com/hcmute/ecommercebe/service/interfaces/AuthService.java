package com.hcmute.ecommercebe.service.interfaces;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.dto.auth.LoginRequest;

public interface AuthService {
    ResponseBaseAbstract login(LoginRequest loginRequest);
}
