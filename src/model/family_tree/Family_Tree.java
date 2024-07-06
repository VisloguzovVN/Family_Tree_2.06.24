package model.family_tree;

import model.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Family_Tree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;

    public Family_Tree() {this (new ArrayList<>()); }

    public Family_Tree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add((E) human);
            ((TreeNode<?>) human).setID(humansId++);

            addToParents((E) human);
            addToChildren((E) human);

            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for(E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for(E child: human.getChildren()){
            child.addChild(human);
        }
    }

    public List<E> getSiblings(long id){
        E human = getById(id);
        if(human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for(E parent: human.getParents()){
            for (E child: human.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDevorse(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove (long humansId){
        if (checkId(humansId)){
            E human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public E getById(Long id){
        for (E human: humanList){
            if(human.getID() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(" в дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {humanList.sort(new Family_TreeComporatorByName<>());}

    public void sortByBirthDate() {humanList.sort(new Family_TreeComporatorByBirthDate<>());}

    @Override
    public Iterator<E> iterator() {return new Family_TreeIterator<>(humanList);}
}

//Поля: Список людей (лист), список членов семьи.
//Методы: Добавление, поиск, вывод всего списка и т.д.
