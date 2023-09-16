package com.hcmute.ecommercebe.service;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.base.SuccessResponse;
import com.hcmute.ecommercebe.domain.dto.auth.LoginRequest;
import com.hcmute.ecommercebe.domain.entity.User;
import com.hcmute.ecommercebe.domain.exception.ServiceExceptionFactory;
import com.hcmute.ecommercebe.jwt.JwtTokenProvider;
import com.hcmute.ecommercebe.repository.UserRepo;
import com.hcmute.ecommercebe.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseBaseAbstract login(LoginRequest loginRequest) {
        User user = this.userRepo.getUserByUsername(loginRequest.getUsername());

        if (user == null) {
            throw ServiceExceptionFactory.unauthorized().setMessage("Username khong ton tai");
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw ServiceExceptionFactory.unauthorized().setMessage("Mat khau khong dung");
        }

        SuccessResponse response = new SuccessResponse();
        response.setMessage("Dang nhap thanh cong");
        Map<String, Object> data = new HashMap<>();
        data.put("user",user);
        data.put("accessToken",this.jwtTokenProvider.generateToken(user));
        response.setData(data);
        return response;
    }
}
