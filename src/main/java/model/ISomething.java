package model;

import javax.persistence.Table;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by vlad on 04.12.16.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Something extends Table {
    String someProperty();
}

