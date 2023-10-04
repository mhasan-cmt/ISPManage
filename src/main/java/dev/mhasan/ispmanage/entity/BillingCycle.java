package dev.mhasan.ispmanage.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "billing_cycle")
public class BillingCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private ServicePackage servicePackage;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Bill bill;
}
