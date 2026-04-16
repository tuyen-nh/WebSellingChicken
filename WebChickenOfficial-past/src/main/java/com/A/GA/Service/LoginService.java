package com.A.GA.Service;

import com.A.GA.Model.Login;
import com.A.GA.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    public Login CheckLogin(String TKUser, String password, String role ) {
        if (!LoginRepository.tableLogin.isEmpty()){
            return  loginRepository.checkLogin(TKUser,password,role);
        }
        return null;
    }
    public String register(String TKUser, String password, String role) {
        for (Login login : LoginRepository.tableLogin) {
            if (login.getTKUser().equals(TKUser)) {
                return "Tài khoản đã tồn tại!";
            }
        }
        loginRepository.registerUser(TKUser, password, role);
        return "Đăng ký thành công!";
    }

    public String image() {
        return loginRepository.loadImage();
    }
}
