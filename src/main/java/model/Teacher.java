package model;

/**
 * Created by vlad on 27.08.2016.
 */
public class Teacher extends User{
    private String subject;
    
     public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
}