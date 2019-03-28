package pl.entity;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name="drugs_users")
public class DrugsUsers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn
    private User users;


    @ManyToOne
    @JoinColumn
    private Drug drug;

    private String myDoze;

    private String time;

    public DrugsUsers(User user, String myDoze, String time) {
        this.users = user;
        this.myDoze = myDoze;
        this.time = time;
    }

    public DrugsUsers() {
    }

    public String getMyDoze() {
        return myDoze;
    }

    public void setMyDoze(String myDoze) {
        this.myDoze = myDoze;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
