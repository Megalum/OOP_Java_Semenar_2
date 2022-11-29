package service;

import data.Flow;
import data.StudyGroup;
import util.StreamComparator;
import java.util.ArrayList;

public class FlowService implements StreamComparator {
    ArrayList<Flow> flows = new ArrayList<>();

    public void add(Flow input){
        flows.add(input);
    }

    public void sort(){
        for(int i = 0; i < flows.size() - 1; i++){
            for (int j = i + 1; j < flows.size(); j++) {
                if (comparison(flows.get(i), flows.get(j))){
                    Flow variable = flows.get(i);
                    flows.set(i,flows.get(j));
                    flows.set(j,variable);
                }
            }
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < flows.size(); i++) {
            out += flows.get(i) + "\n-- new Flow --\n";
        }
        return out;
    }

    @Override
    public boolean comparison(Flow flowFirst, Flow flowSecond) {
        return (flowFirst.getSize() < flowSecond.getSize());
    }
}
