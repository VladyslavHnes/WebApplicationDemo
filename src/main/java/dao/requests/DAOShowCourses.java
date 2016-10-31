package dao.requests;

import dao.DAOInterface;
import model.Course;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vlad on 26.10.16.
 */
public class DAOShowCourses implements DAOInterface {

    public static ArrayList<Course> arrayList;

    public static ArrayList<Course> getCourses()throws Exception{
        URL url = DAOShowCourses.class.getResource("database/Courses");
        File file = new File(url.getPath());
        BufferedReader brCourses = new BufferedReader(new FileReader(file));
        BufferedReader brTeacher = new BufferedReader(new FileReader("database/Teachers"));
        String lineCourses;
        String lineTeachers;
        while(((lineCourses = brCourses.readLine()) != null) &&
                (lineTeachers = brTeacher.readLine()) != null) {
            Course course = new Course();
            course.setSubject(lineCourses);
            String[] arrayTeacher = lineTeachers.split(" ");
            course.setFirstNameOfTeacher(arrayTeacher[0]);
            course.setLastNameOfTeacher(arrayTeacher[1]);
            arrayList.add(course);
        }
        return arrayList;

    }


}

