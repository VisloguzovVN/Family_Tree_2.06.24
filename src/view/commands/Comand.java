package view.commands;

import view.ConsoleUI;

public abstract class Comand {

    private final ConsoleUI consoleUi;
    private String description;
    private ConsoleUI;

    public Comand(String description, ConsoleUI consoleUI){
        this.description = description;
        this.consoleUi = consoleUI;
    }

    public String getDescription(){
        return description;
    }

    ConsoleUI getConsoleUi() {
        return consoleUi;
    }

    public abstract void execute();
}
