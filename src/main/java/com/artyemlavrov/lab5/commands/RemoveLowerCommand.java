package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.readers.complex.WorkerReader;
import com.artyemlavrov.lab5.types.Worker;

public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Worker element = new WorkerReader(ioManager).setNullable(false).read();
        if (collection.removeLower(element)) {
            ioManager.writeLine("Элементы, меньшие указанного, были удалены.");
        } else {
            ioManager.writeLine("Элементы, меньшие указанного, отсутствуют.");
        }
    }

    @Override
    public String getDescription() {
        return "{element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_lower";
    }
}
