package com.shitikov.shape.controller.command.provider;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.type.CommandType;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

import static com.shitikov.shape.controller.command.type.CommandType.EMPTY_COMMAND;

public final class CommandProvider {

    private CommandProvider() {
    }

    public static Command defineCommand(HttpServletRequest request) {
        Command definedCommand;
        String requestCommand = request.getParameter("command");

        Optional<Command> command = Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.getName().equalsIgnoreCase(requestCommand))
                .findFirst().map(CommandType::getCommand);

        definedCommand = command.orElseGet(EMPTY_COMMAND::getCommand);

        return definedCommand;
    }
}




//    String action = request.getParameter("command");
//        if (action == null || action.isEmpty()) {
//// если команда не задана в текущем запросе
//                return current;
//                }
//// получение объекта, соответствующего команде
//                try {
//                CommandType currentEnum = CommandEnum.valueOf(action.toUpperCase());
//                current = currentEnum.getCurrentCommand();
//                } catch (IllegalArgumentException e) {
//                request.setAttribute("wrongAction", action
//                + MessageManager.getProperty("message.wrongaction"));
//                }
//                return current;