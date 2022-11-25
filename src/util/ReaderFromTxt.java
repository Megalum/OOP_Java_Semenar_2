package util;

import data.Student;
import data.Teacher;
import data.StudyGroup;
import data.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderFromTxt {
    public static User read(String fileName){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> arrayList = new ArrayList<>();
            User sg = new StudyGroup();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                arrayList.add(line);
            }
            for (int i = 0; i < arrayList.size(); i += 4) {
                if (arrayList.get(i).contains("Teacher")) {
                    User user = new Teacher(arrayList.get(i + 3), arrayList.get(i + 1), arrayList.get(i + 2));
                    ((StudyGroup)sg).add(user);
                }
                if (arrayList.get(i).contains("Student")) {
                    User user = new Student(arrayList.get(i + 3), arrayList.get(i + 1), arrayList.get(i + 2));
                    ((StudyGroup)sg).add(user);
                }
            }
            return sg;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
