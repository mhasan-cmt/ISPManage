package dev.mhasan.ispmanage.entity;

import dev.mhasan.ispmanage.enumeration.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private PaymentStatus paymentStatus;
    private LocalDate date;
}
