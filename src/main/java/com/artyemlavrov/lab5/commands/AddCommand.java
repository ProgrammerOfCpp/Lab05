package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.types.Worker;
import com.artyemlavrov.lab5.readers.complex.WorkerReader;

public class AddCommand extends Command {
    public AddCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Worker worker = new WorkerReader(ioManager).setNullable(false).read();
        collection.add(worker);
        ioManager.writeLine("Добавлен объект: " + worker.toString());
    }

    @Override
    public String getDescription() {
        return "{element} : добавить новый элемент в коллекцию";
    }

    @Override
    public String getName() {
        return "add";
    }
}
