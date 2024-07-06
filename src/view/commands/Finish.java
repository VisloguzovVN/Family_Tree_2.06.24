package view.commands;

import view.ConsoleUI;

public class Finish extends Comand {

    public Finish(ConsoleUI consoleUI) {
        super("Завершение работы", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUi().finish();
    }
}