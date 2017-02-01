package model;


import javax.persistence.*;

/**
 * Created by vlad on 27.08.2016.
 */
@Entity
@Table(name = "students")
public class Student extends User{
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
