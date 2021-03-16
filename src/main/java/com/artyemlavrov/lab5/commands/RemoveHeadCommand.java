package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.types.Worker;

public class RemoveHeadCommand extends Command {
    public RemoveHeadCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Worker head = collection.getHead();
        if (head == null) {
            ioManager.writeLine("Элементы отсутствуют.");
        } else {
            collection.remove(head.getId());
            ioManager.writeLine("Первый элемент коллекции удалён.");
        }
    }

    @Override
    public String getDescription() {
        return ": вывести первый элемент коллекции и удалить его";
    }

    @Override
    public String getName() {
        return "remove_head";
    }
}
