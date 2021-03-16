package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.readers.simple.StringReader;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        String filename = new StringReader(ioManager).setCanBeEmpty(false).setNullable(false).read();

        Interpreter interpreter = new Interpreter(filename);
        interpreter.run();
    }

    @Override
    public String getDescription() {
        return "file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}
