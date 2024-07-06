package model.family_tree;

import java.util.Comparator;

public class Family_TreeComporatorByName <T extends TreeNode<T>> implements Comparator<T>{
    public static void sortByName() {

    }

    @Override
    public int compare(T o1, T o2){ return o1.getName().compareTo(o2.getName());}
}

