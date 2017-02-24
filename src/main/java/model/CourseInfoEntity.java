package model;

/**
 * Created by vlad on 01.02.17.
 */
public class CourseInfoEntity {
    private String subject;
    private String firstNameOfTeacher;
    private String lastNameOfTeacher;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

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
}
