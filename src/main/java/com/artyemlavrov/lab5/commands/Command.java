package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.Interpreter;
import com.artyemlavrov.lab5.WorkersCollection;

/**
 * Класс, позволяющий определять поведение и свойства комманд.
 */
public abstract class Command {
    protected final Interpreter interpreter;
    protected final IOManager ioManager;
    protected final WorkersCollection collection;

    public Command(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.ioManager = interpreter.getIOManager();
        this.collection = interpreter.getCollection();
    }

    public abstract void execute();

    public abstract String getDescription();

    public abstract String getName();
}
