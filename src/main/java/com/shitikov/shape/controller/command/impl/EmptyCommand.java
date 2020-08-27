package com.shitikov.shape.controller.command.impl;

import com.shitikov.shape.controller.command.PagePath;
import com.shitikov.shape.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.INDEX;
    }
}
