package util;

import data.Student;
import data.Teacher;
import data.User;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToTxt {
    public static void write(User user, String fileName) {
        try (FileWriter printWriter = new FileWriter(fileName, true)) {
            String className = user.getClass().getSimpleName();
            printWriter.write(className + "\n");
            printWriter.write(user.getName() +"\n");
            printWriter.write(user.getBirthday() +"\n");
            if (className.equals("Student")){
                Student temp = (Student) user;
                printWriter.write(temp.getStudentId()+"\n");
            }
            if (className.equals("Teacher")){
                Teacher temp = (Teacher) user;
                printWriter.write(temp.getDisciplesTaught() +"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
