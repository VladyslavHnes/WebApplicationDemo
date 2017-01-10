package model;

import org.hibernate.cfg.DefaultNamingStrategy;

import javax.persistence.*;

/**
 * Created by vlad on 27.08.2016.
 */
@Entity
@Table(name = "students")
public class Student extends User{

}
