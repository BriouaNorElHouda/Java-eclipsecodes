package jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orderr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMO")
    private int numO;

    @ManyToOne
    @JoinColumn(name = "CLIENTID")
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderLine> orderLines;

 

}
