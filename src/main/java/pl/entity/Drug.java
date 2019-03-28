package pl.entity;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="drugs")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String activeIngredient;

    @NotNull
    private int activeIngredAmount;

    private boolean myDrug;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    public Drug() {
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeIngredient='" + activeIngredient + '\'' +
                ", activeIngredAmount=" + activeIngredAmount +
                '}';
    }

    public boolean isMyDrug() {
        return myDrug;
    }

    public void setMyDrug(boolean myDrug) {
        this.myDrug = myDrug;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public int getActiveIngredAmount() {
        return activeIngredAmount;
    }

    public void setActiveIngredAmount(int activeIngredAmount) {
        this.activeIngredAmount = activeIngredAmount;
    }
}
