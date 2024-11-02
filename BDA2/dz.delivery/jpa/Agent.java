package jpa;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMAG")
    private int numAg;

    @Column(name = "ip_adresse")
    private String ipAdresse;

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

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private Set<DeliveryGuy> deliveryGuy;


    public int getNumAg() {
        return numAg;
    }

    public void setNumAg(int numAg) {
        this.numAg = numAg;
    }


    public String getIpAdresse() {
        return ipAdresse;
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }


}
