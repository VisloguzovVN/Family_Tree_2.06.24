package view.commands;

import view.ConsoleUI;

public class SortByName extends Comand {

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByName();
    }
}
