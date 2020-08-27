package com.shitikov.shape.controller.command.provider;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.type.CommandType;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

import static com.shitikov.shape.controller.command.type.CommandType.EMPTY_COMMAND;

public final class CommandProvider {
    private static final String COMMAND_PARAMETER = "command";

    private CommandProvider() {
    }

    public static Command defineCommand(HttpServletRequest request) {
        Command definedCommand;
        String commandName = request.getParameter(COMMAND_PARAMETER);



        Optional<Command> command = Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.toString()
                        .equalsIgnoreCase(commandName.replace('-','_').toUpperCase()))
                .findFirst()
                .map(CommandType::getCommand);

        definedCommand = command.orElseGet(EMPTY_COMMAND::getCommand);

        return definedCommand;
    }
}