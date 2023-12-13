package com.dt.copeland.service;

import com.dt.copeland.dto.LoginDTO;
import com.dt.copeland.dto.RegisterDTO;

public interface AuthenticationService {

    String register(RegisterDTO registerDTO);

    Boolean login(LoginDTO loginDTO);
}
