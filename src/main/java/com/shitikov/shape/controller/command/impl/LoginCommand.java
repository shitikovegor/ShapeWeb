package com.shitikov.shape.controller.command.impl;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.PagePath;
import com.shitikov.shape.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginCommand implements Command {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private static final String ERROR_MESSAGE = "Login or password is incorrect.";
    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String page = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        if (LoginService.checkLogin(login, pass)) {
            request.setAttribute("user", login);

            page = PagePath.MENU;
        } else {
            request.setAttribute("errorLoginPassMessage", ERROR_MESSAGE);
            page = PagePath.LOGIN;
        }
        return page;
    }
}
