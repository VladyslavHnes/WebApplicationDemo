package dao.requests;

import dao.DAOInterface;
import model.Course;
import model.Teacher;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOShowCourses implements DAOInterface {

    public static ArrayList<Course> getCourses() throws java.io.IOException{
        ArrayList<Course> arrayList = new ArrayList<Course>();
        Class cl = DAOShowCourses.class;
        ClassLoader classLoader = cl.getClassLoader();
        URL urlCourses = classLoader.getResource("database/Courses");
        File fileCourses = new File(urlCourses.getPath());
        URL urlTeachers = classLoader.getResource("database/Teachers");
        File fileTeachers = new File(urlTeachers.getPath());
        BufferedReader brCourses = new BufferedReader(new FileReader(fileCourses));
        BufferedReader brTeacher = new BufferedReader(new FileReader(fileTeachers));
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
        return arrayList;

    }


}

