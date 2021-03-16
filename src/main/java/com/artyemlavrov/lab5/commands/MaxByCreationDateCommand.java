package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.types.Worker;

public class MaxByCreationDateCommand extends Command {
    public MaxByCreationDateCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Worker best = collection.getMaxByCreationDate();
        if (best == null) {
            ioManager.writeLine("Элементы отсутствуют.");
        } else {
            ioManager.writeLine(best.toString());
        }
    }

    @Override
    public String getDescription() {
        return "вывести любой объект из коллекции, значение поля creationDate которого является максимальным";
    }

    @Override
    public String getName() {
        return "max_by_creation_date ";
    }
}
