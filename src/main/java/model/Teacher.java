package model;

import javax.persistence.*;

/**
 * Created by vlad on 27.08.2016.
 */
@Entity
@Table(name = "teachers")
public class Teacher extends User{
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "subject")
    private String subject;
    
    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }

}