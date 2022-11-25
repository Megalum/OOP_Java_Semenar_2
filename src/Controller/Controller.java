package Controller;

import data.*;
import service.DataService;
import service.StudyGroupServis;
import java.util.logging.Logger;

public class Controller {
    public void buttonClick(){
        Logger logger = Logger.getAnonymousLogger();

        User teacher = new Teacher("Математика","Сергей", "20.06.1984");
        User student = new Student("012","Иван", "20.06.1996");
        User student1 = new Student("010","Дмитрий", "12.05.1996");
        User student2 = new Student("008","Виктор", "01.05.1996");
        User student3 = new Student("006","Сергей", "20.03.1996");
        User student4 = new Student("004","Роман", "01.01.1996");

        User teacher1 = new Teacher("Информатика","Игорь", "10.11.1979");
        User student10 = new Student("001","Станислав", "02.07.1998");
        User student11 = new Student("002","Марина", "12.06.1998");
        User student12 = new Student("003","Алла", "14.04.1998");
        User student13 = new Student("005","Сергей", "20.10.1998");
        User student14 = new Student("007","Анатолий", "09.08.1998");

        User group = new StudyGroup();
        ((StudyGroup)group).add(teacher);
        ((StudyGroup)group).add(student);
        ((StudyGroup)group).add(student1);
        ((StudyGroup)group).add(student2);
        ((StudyGroup)group).add(student3);
        ((StudyGroup)group).add(student4);
        DataService studyGroupServis = new StudyGroupServis();
        studyGroupServis.create((StudyGroup)group, "Group1.txt");
        logger.info(studyGroupServis.read("Group1.txt").toString());

        User group1 = new StudyGroup();
        ((StudyGroup)group1).add(teacher1);
        ((StudyGroup)group1).add(student10);
        ((StudyGroup)group1).add(student11);
        ((StudyGroup)group1).add(student12);
        ((StudyGroup)group1).add(student13);
        ((StudyGroup)group1).add(student14);
        studyGroupServis.create((StudyGroup)group1, "Group2.txt");
        logger.info(studyGroupServis.read("Group2.txt").toString());
    }
}
