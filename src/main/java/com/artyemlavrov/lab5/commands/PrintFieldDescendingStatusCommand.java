package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.types.Status;

public class PrintFieldDescendingStatusCommand  extends Command {
    public PrintFieldDescendingStatusCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        for (Status status : collection.getStatusListDescending()) {
            ioManager.write(status + " ");
        }
        ioManager.writeLine("");
    }

    @Override
    public String getDescription() {
        return ": вывести значения поля status всех элементов в порядке убывания";
    }

    @Override
    public String getName() {
        return "print_field_descending_status ";
    }
}
