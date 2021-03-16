package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.readers.complex.WorkerReader;
import com.artyemlavrov.lab5.readers.simple.number.IntegerReader;
import com.artyemlavrov.lab5.types.Worker;

public class UpdateCommand extends Command {
    public UpdateCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Integer id = new IntegerReader(ioManager).setNullable(false).read();
        Worker value = new WorkerReader(ioManager).setNullable(false).read();
        Worker element = collection.get(id);
        if (element == null) {
            ioManager.writeLine("Элемент с данным ключём не найден");
        } else {
            collection.remove(id);
            collection.add(value);
            ioManager.writeLine("Значение обновлено: " + value.toString());
        }
    }

    @Override
    public String getDescription() {
        return "id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}
