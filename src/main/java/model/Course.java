package model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by vlad on 27.10.16.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Course {

    private String firstName;
    private String lastName;
    private String mark;
    private String backgroundImageURL;



    public String getBackgroundImageURL() {
        return backgroundImageURL;
    }

    public void setBackgroundImageURL(String backgroundImageURL) {
        this.backgroundImageURL = backgroundImageURL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String setAnnotation(String annotation) throws NoSuchFieldException,IllegalAccessException{
        final Something oldAnnotation = (Something) Foobar.class.getAnnotations()[0];
        System.out.println("oldAnnotation = " + oldAnnotation.someProperty());
        Annotation newAnnotation = new Something() {

            @Override
            public String someProperty() {
                return "another value";
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return oldAnnotation.annotationType();
            }
        };
        Field field = Class.class.getDeclaredField("annotations");
        field.setAccessible(true);
        Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) field.get(Foobar.class);
        annotations.put(Something.class, newAnnotation);

        Something modifiedAnnotation = (Something) Foobar.class.getAnnotations()[0];
        return modifiedAnnotation.someProperty();
    }

}
