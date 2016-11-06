package dao.requests;

import controller.teacher.SetImageTeacherController;
import dao.DAOInterface;
import model.Course;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOShowCourses implements DAOInterface {

    private DAOShowCourses(){}


    public static List<Course> getCourses(){
        Logger logger = Logger.getLogger(SetImageTeacherController.class);
        List<Course> arrayList = new ArrayList<>();
        Class cl = DAOShowCourses.class;
        ClassLoader classLoader = cl.getClassLoader();
        URL urlCourses = classLoader.getResource("database/Courses");
        File fileCourses = new File(urlCourses.getPath());
        URL urlTeachers = classLoader.getResource("database/Teachers");
        File fileTeachers = new File(urlTeachers.getPath());
        try(
                java.io. BufferedReader brCourses = new BufferedReader(new FileReader(fileCourses));
                java.io. BufferedReader brTeacher = new BufferedReader(new FileReader(fileTeachers))
        ) {
            String lineCourses;
            String lineTeachers;
            while(((lineCourses = brCourses.readLine()) != null) &&
                    (lineTeachers = brTeacher.readLine()) != null) {
                Course course = new Course();
                course.setSubject(lineCourses);
                String [] teacherLastNameAndFirstName = lineTeachers.split(" ");
                course.setFirstNameOfTeacher(teacherLastNameAndFirstName[0]);
                course.setLastNameOfTeacher(teacherLastNameAndFirstName[1]);
                arrayList.add(course);
            }
        }catch (IOException e) {
            logger.info(e);
        }
        return arrayList;
    }
}

