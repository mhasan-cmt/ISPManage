package dev.mhasan.ispmanage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String mobile;
    private Long servicePackageId;
    private Long areaId;
    private Long linemanId;
    private String connectionId;
    private String connectionPass;
    private LocalDate joinDate;
    private String email;
    private String password;
    private String role;
}
