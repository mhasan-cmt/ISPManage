package dev.mhasan.ispmanage.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mobile;
    @ManyToOne(cascade = CascadeType.ALL)
    private ServicePackage servicePackage;
    @ManyToOne(cascade = CascadeType.ALL)
    private Area area;
    @ManyToOne(cascade = CascadeType.ALL)
    private Lineman lineman;
    private String connectionId;
    private String connectionPass;
    private LocalDate joinDate;
    private String email;
    private String role;
}
