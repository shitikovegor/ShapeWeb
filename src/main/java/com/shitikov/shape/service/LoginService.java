package com.shitikov.shape.service;

public class LoginService {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "qwer123";

    public static boolean checkLogin(String enterLogin, String enterPass) {
        return ADMIN_LOGIN.equals(enterLogin) && ADMIN_PASS.equals(enterPass);
    }
}
