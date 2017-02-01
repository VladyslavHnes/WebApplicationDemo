package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vlad on 10.01.17.
 */
@Entity
@Table(name = "JavaScript")
public class JavaScript extends Course{
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
