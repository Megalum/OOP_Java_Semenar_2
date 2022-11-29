package data;

import java.util.ArrayList;
import java.util.Iterator;

public class StudyGroup extends User implements Iterator<User>, Iterable {

    ArrayList<User> group = new ArrayList<>();
    private Integer humanInd = 0;

    public void add(User user){
        group.add(user);
    }

    @Override
    public String toString() {
        String sb = "";
        for (int i = 0; i < group.size(); i++) {
            sb += group.get(i) + "\n";
        }
        return sb;
    }

    public int getSize(){
        return group.size();
    }

    public User getUser(int i){
        return group.get(i);
    }

    @Override
    public boolean hasNext() {
        return (this.humanInd < this.group.size());
    }

    @Override
    public User next() {
        return this.group.get(this.humanInd++);
    }

    @Override
    public Iterator<User> iterator() {
        ArrayList<User> human = new ArrayList<>();
        human.addAll(this.group);
        Iterator<User> iter = human.iterator();
        return iter;
    }

    @Override
    public void remove() {
        if (this.humanInd == 0 ){
            this.group.set(0, new Teacher());
        } else if (this.humanInd < this.group.size()){
            this.group.remove(this.humanInd);
        }
    }

    public void removeStudentByName(String remove){
        for (int i = 0; i < group.size(); i++) {
            if(group.get(i).getName().equals(remove)){
                group.remove(i);
            }
        }
    }
}
