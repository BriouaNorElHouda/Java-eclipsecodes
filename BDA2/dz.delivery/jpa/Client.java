package jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTID")
    private int clientId;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Order> orders;




    
}
