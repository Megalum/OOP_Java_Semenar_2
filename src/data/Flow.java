package data;

import java.util.ArrayList;

public class Flow {

    ArrayList<StudyGroup> group = new ArrayList<>();

    public void add(StudyGroup sg){ group.add(sg); }

    public int getSize(){
        return group.size();
    }

    public StudyGroup get(int index){
        return group.get(index);
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < group.size(); i++) {
            out += "- new Group -\n";
            out += group.get(i) + "\n";
        }
        return out;
    }
}
