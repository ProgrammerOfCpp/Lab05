package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.types.Worker;

public class ShowCommand extends Command {
    public ShowCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        for (Worker worker : collection.getAll()) {
            ioManager.writeLine(worker.toString());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
