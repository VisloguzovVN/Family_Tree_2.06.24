package view.commands;

import view.ConsoleUI;

public class SortByAge extends Comand {

    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByAge();
    }
}