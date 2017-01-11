package model;

import javax.persistence.*;


/**
 * Created by vlad on 27.10.16.
 */
@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="course")
public abstract class Course {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "firstName")
    protected String firstName;
    @Column(name = "lastName")
    protected String lastName;
    @Column(name = "BackgroundImageURL")
    protected String BackgroundImageURL;
    @Column(name = "mark")
    protected int mark;



    public String getBackgroundImageURL() {
        return BackgroundImageURL;
    }

    public void setBackgroundImageURL(String imageURL) {
        this.BackgroundImageURL = BackgroundImageURL;
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

    public int getMark() {return mark;}

    public void setMark(int mark) {
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
