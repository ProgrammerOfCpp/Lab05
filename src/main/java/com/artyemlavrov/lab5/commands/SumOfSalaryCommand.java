package com.artyemlavrov.lab5.commands;

import com.artyemlavrov.lab5.Interpreter;

public class SumOfSalaryCommand extends Command {
    public SumOfSalaryCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        if (collection.getElementsCount() == 0) {
            ioManager.writeLine("Коллекция пуста.");
        } else {
            ioManager.writeLine("Сумма: " + collection.getSumOfSalary());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести сумму значений поля salary для всех элементов коллекции";
    }

    @Override
    public String getName() {
        return "sum_of_salary";
    }
}
