package jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "deliveryguy")
public class DeliveryGuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMD")
    private int numD;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "psswrd")
    private String psswrd;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "NUMAG")
    private Agent agent;

    @OneToMany(mappedBy = "deliveryGuy", cascade = CascadeType.ALL)
    private Set<Order> GOrders;

   
    public int getNumD() {
        return numD;
    }

    public void setNumD(int numD) {
        this.numD = numD;
    }

    // Getter and Setter for firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Repeat for other properties...
}
