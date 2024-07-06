package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI<presenter> implements View{

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствую!");
        while (work) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            // метод проверки данных на валидность
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }

    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo(){
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите возраст");
        String ageStr = scanner.nextLine();
        //метод проверки на валидность
        int age = Integer.parseInt(ageStr);
        presenter.addHuman(name, age);
        addHuman();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
