package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;

public class ExitCommand extends Command {
    public ExitCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        interpreter.stop();
    }

    @Override
    public String getDescription() {
        return ": завершить программу (без сохранения в файл)";
    }

    @Override
    public String getName() {
        return "exit";
    }
}
