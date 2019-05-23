package pl.coderslab.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public enum UserStatus {
    ACTIVE,
    UNACTIVE,
    PENDING,

}
