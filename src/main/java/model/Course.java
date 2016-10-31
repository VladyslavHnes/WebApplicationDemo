package model;

/**
 * Created by vlad on 27.10.16.
 */
public class Course {

    private String firstNameOfTeacher;
    private String lastNameOfTeacher;
    private String subject;


    public String getFirstNameOfTeacher() {
        return firstNameOfTeacher;
    }

    public void setFirstNameOfTeacher(String firstNameOfTeacher) {
        this.firstNameOfTeacher = firstNameOfTeacher;
    }

    public String getLastNameOfTeacher() {
        return lastNameOfTeacher;
    }

    public void setLastNameOfTeacher(String lastNameOfTeacher) {
        this.lastNameOfTeacher = lastNameOfTeacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
