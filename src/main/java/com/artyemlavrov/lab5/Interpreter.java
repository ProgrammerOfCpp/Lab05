package com.artyemlavrov.lab5;

import com.artyemlavrov.lab5.commands.*;

import java.io.IOException;
import java.util.*;

enum InterpreterMode { CONSOLE, SCRIPT }

/**
 * Класс, организующий цикл обработки команд.
 */
public class Interpreter {
    private InterpreterMode mode = InterpreterMode.CONSOLE;
    private final IOManager ioManager = new IOManager();
    private final Map<String, Command> commands = new HashMap<>();
    private final List<String> history = new LinkedList<>();
    private final WorkersCollection collection = new WorkersCollection();
    private boolean stopFlag = false;

    /**
     * Конструктор, в котором происходит регистрация поддерживаемых команд.
     */
    public Interpreter() {
        registerCommand(new HelpCommand(this));
        registerCommand(new InfoCommand(this));
        registerCommand(new ShowCommand(this));
        registerCommand(new AddCommand(this));
        registerCommand(new UpdateCommand(this));
        registerCommand(new RemoveByIdCommand(this));
        registerCommand(new ClearCommand(this));
        registerCommand(new SaveCommand(this));
        registerCommand(new ExecuteScriptCommand(this));
        registerCommand(new ExitCommand(this));
        registerCommand(new RemoveHeadCommand(this));
        registerCommand(new RemoveLowerCommand(this));
        registerCommand(new HistoryCommand(this));
        registerCommand(new SumOfSalaryCommand(this));
        registerCommand(new MaxByCreationDateCommand(this));
        registerCommand(new PrintFieldDescendingStatusCommand(this));
    }

    /**
     * Конструктор, инициализирующий интерпретатор, исполняющий скрипт из файла.
     * @param scriptPath Путь к файлу
     */
    public Interpreter(String scriptPath) {
        this();
        try {
            ioManager.setInputFile(scriptPath);
            mode = InterpreterMode.SCRIPT;
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }

    /**
     * Метод, регистрирующий комманду.
     * @param command Ссылка на экземпляр комманды.
     */
    private void registerCommand(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * Метод, запускающий основной цикл интерпретатора.
     */
    public void run() {
        while (shouldContinue()) {
            readAndExecuteCommand();
        }
    }

    /**
     * Метод, определяющий, стоит ли продожлать выполнение рабочего цикла.
     * @return true - выполнение продолжается, false - был вызвон метод exit, либо файл со скриптом был прочитан до конца.
     */
    private boolean shouldContinue() {
        if (stopFlag) {
            return false;
        }
        switch (mode) {
            case CONSOLE:
                return true;
            case SCRIPT:
                return ioManager.hasNext();
        }
        return false;
    }

    /**
     * Метод, осуществляющий чтение и исполнение очередной команды.
     */
    private void readAndExecuteCommand() {
        Command command = readCommand();
        if (command == null) {
            ioManager.writeLine("Команда с указанным именем не найдена!");
        } else {
            command.execute();
            ioManager.writeLine("");
            history.add(command.getName());
        }
    }

    /**
     * Метод, осуществляющий чтение очередной комманды.
     * @return Ссылка на экземпляр распознанной комманды.
     */
    private Command readCommand() {
        String name;
        do {
            name = ioManager.readNext().trim();
        } while (name.isEmpty());
        return getCommandByName(name);
    }

    /**
     * Метод, осуществляющий загрузку коллекции из файла.
     * @param filename Путь к файлу.
     */
    public void loadCollectionFromFile(String filename) {
        collection.loadFromFile(filename);
    }

    /**
     * Метод, прекращающий работу интерпретатора.
     */
    public void stop() {
        stopFlag = true;
    }

    /**
     * Метод, возвращающий поддерживаемые комманды.
     * @return Ссылка на коллекцию экземпляров комманд.
     */
    public Collection<Command> getAllCommands() {
        return commands.values();
    }

    /**
     * Метод, позволяющий получить экземлпляр комманды по имени.
     * @param name Имя комманды.
     * @return Ссылка на экземпляр комманды.
     */
    public Command getCommandByName(String name) {
        return commands.get(name.trim());
    }

    /**
     * Метод, возвращающий список имён всех выполненных комманд.
     * @return Список строк с именами комманд.
     */
    public List<String> getHistory() {
        return history;
    }

    /**
     * Метод, возвращающий объект класса IOManager, используемного интерпрератором при работе с вводом-выводом.
     * @return Ссылка на объект класса IOManager.
     */
    public IOManager getIOManager() {
        return ioManager;
    }

    /**
     * Метод, возращающий объект класса WorkersCollection, с которым происходят манипуляции в ходе исполения комманд.
     * @return Ссылка на объект класса WorkersCollection.
     */
    public WorkersCollection getCollection() {
        return collection;
    }
}
