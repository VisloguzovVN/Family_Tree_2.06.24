package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Comand> comands;

    public MainMenu(ConsoleUI consoleUI) {
        comands = new ArrayList<>();
        comands.add(new AddHuman(consoleUI));
        comands.add(new GetHumanListInfo(consoleUI));
        comands.add(new SortByAge(consoleUI));
        comands.add(new SortByName(consoleUI));
        comands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд:\n");
        for (int i = 0; i < comands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(comands.get(i).getDescription());
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }
    public void execute(int choice){
        Comand comand = comands.get(choice-1);
        comand.execute();
    }
}
