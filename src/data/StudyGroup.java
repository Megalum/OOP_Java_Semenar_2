package data;

import java.util.ArrayList;

public class StudyGroup extends User{

    ArrayList<User> group = new ArrayList<>();

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

    public User getUzer(int i){
        return group.get(i);
    }

}
