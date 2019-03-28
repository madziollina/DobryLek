package pl.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.validationGroup.FullValidation;
import pl.validationGroup.PartValidation;

import javax.persistence.*;
import javax.validation.groups.Default;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames = {"login" , "email"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {Default.class, FullValidation.class})
    private String firstName, lastName;

    @NotBlank(groups = {Default.class, FullValidation.class})
    private String login;

    @NotBlank(groups = {Default.class, FullValidation.class, PartValidation.class})
    @Email(groups = {Default.class, FullValidation.class, PartValidation.class})
    private String email;

    @NotBlank(groups = {FullValidation.class, PartValidation.class})
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Drug> drugs = new ArrayList<>();

    public User() {
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
