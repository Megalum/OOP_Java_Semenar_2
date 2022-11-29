package service;

import data.StudyGroup;
import data.User;
import util.ReaderFromTxt;
import util.WriterToTxt;

import java.util.Objects;

public class StudyGroupServis implements DataService{

    @Override
    public void create(User user1, String fileName) {
        User user;
        for (int i = 0; i < ((StudyGroup)user1).getSize(); i++) {
            user = ((StudyGroup)user1).getUser(i);
            WriterToTxt.write(user, fileName);
        }
    }

    @Override
    public User read(String fileName) {
        return ReaderFromTxt.read(fileName);
    }
}
