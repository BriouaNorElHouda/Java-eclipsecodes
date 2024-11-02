package jpa;

import javax.persistence.*;

@Entity
@Table(name = "orderline")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMOL")
    private int numOL;

    @ManyToOne
    @JoinColumn(name = "NUMO")
    private Order order;

    
}
