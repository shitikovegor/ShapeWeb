package com.shitikov.shape.controller.command.type;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.impl.*;

public enum CommandType {
    SHOW_FILES("show files", new ShowFilesCommand()),
    READ_FILE("read file", new ReadFileCommand()),
    EMPTY_COMMAND("empty command", new EmptyCommand());

    private String name;
    private Command command;

    CommandType(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public com.shitikov.shape.controller.command.Command getCommand() {
        return command;
    }
}
