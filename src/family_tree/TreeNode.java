package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode <T> extends Serializable {
    void setID(long id);
    long getID();
    T getFather();
    T getMother();
    boolean addChild(T Human);
    boolean addParent(T Human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void getSpouse(T Human);


}
