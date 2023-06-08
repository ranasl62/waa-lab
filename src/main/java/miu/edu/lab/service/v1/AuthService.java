package miu.edu.lab.service.v1;


import miu.edu.lab.dto.v1.request.LoginRequest;
import miu.edu.lab.dto.v1.request.RefreshTokenRequest;
import miu.edu.lab.dto.v1.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
