package dao.hibernate;

/**
 * Created by vlad on 04.12.16.
 */
import model.Course;
import org.junit.Test;

import static org.junit.Assert.*;

public class DAOHibernateCourseAnnotationTest {

    @Test
    public void DAOHibernateCourseSetAnnotationTest(){
        Course course = new Course(){{
        }};
        course.setAnnotation();
    }


}
