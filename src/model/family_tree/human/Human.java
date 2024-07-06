package model.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;



public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human(){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        Human father = null;
        if(father != null){
            parents.add(father);
        }
        Human mother = null;
        if(mother !=null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate){
        this();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        this();
    }

    public static void addHuman(String name, int age) {
    }

    public static String getHumanListInfo() {

        return null;
    }


    public boolean addChild(Human child) {
        return false;
    }

    public boolean addparent(Human parent){
        if (!parents.contains(parent)){
            parents.contains(parent);
            return true;
        }
        return false;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }
    public Human getMother(){
        for (Human parent: parents){
            if(parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        }else{
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) { this.spouse = spouse; }

    public Human getSpouse() {return spouse; }

    public String getName() {return name; }

    public long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public LocalDate getBirthDate() {return birthDate; }

    public LocalDate getDeathDate() {return deathDate; }

    public List<Human> getParents() {return parents; }

    public List<Human> getChildren() {return children; }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender () {return gender; }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if(spouse == null){
            res += "нет";
        }else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        }else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(" дети: ");
        if(children.size() !=0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    public Object getSpouse(Human human2) {
        return null;
    }
}


//Поля: Имя, Отец, Мать
// List<Human.Human> children
//LocalDate birthDate, deathDate
//Human.Gender gender;
