package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMBERR")
    private int Numberr;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OrderLine> rOrderLine;


    public int getNumberr() {
        return Numberr;
    }

    public void setNumberr(int numberr) {
        Numberr = numberr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
}
