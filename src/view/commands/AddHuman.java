package view.commands;

import model.family_tree.human.Human;
import view.ConsoleUI;

public class AddHuman extends Comand{

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить члена семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUi().addHuman();
    }
}



