package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Comand {

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Получить список членов семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUi().getHumanListInfo();
    }
}