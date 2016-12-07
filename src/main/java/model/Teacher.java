package model;

import javax.persistence.*;

/**
 * Created by vlad on 27.08.2016.
 */
@Entity
@DiscriminatorValue(value="teacherUser")
@Table(name = "teachers")
public class Teacher extends User{
    @Column(name = "subject")
    private String subject;
    
    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }

}