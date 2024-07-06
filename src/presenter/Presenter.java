package presenter;

import model.family_tree.Family_TreeComporatorByBirthDate;
import model.family_tree.Family_TreeComporatorByName;
import model.family_tree.Family_TreeIterator;
import model.family_tree.human.Human;
import view.View;

public class Presenter {
    private View view;
    private Human human;

    public Presenter(View view) {
        this.view = view;
        human = new Human();
    }

    public void addHuman(String name, int age){
        Human.addHuman(name, age);
        getHumanListInfo();

    }

    public void getHumanListInfo(){
        String answer = Human.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        Family_TreeComporatorByName.sortByName();
        getHumanListInfo();
    }

    public void sortByAge() {
        Family_TreeComporatorByBirthDate.sortByAge();
        getHumanListInfo();
    }
}
