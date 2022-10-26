package dev.mhasan.ispmanage.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Lineman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mobile;
    @ManyToOne(cascade = CascadeType.ALL)
    private Area area;
    private LocalDate joinDate;
}
