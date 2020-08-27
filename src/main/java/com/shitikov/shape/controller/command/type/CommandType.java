package com.shitikov.shape.controller.command.type;

import com.shitikov.shape.controller.command.Command;
import com.shitikov.shape.controller.command.impl.*;

public enum CommandType {
    LOGIN(new LoginCommand()),
    SHOW_FILES(new ShowFilesCommand()),
    READ_FILE(new ReadFileCommand()),
    UPLOAD_FILE(new UploadFileCommand()),
    EMPTY_COMMAND(new EmptyCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
