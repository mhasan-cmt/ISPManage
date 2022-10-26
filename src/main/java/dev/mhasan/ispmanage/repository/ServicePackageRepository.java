package dev.mhasan.ispmanage.repository;

import dev.mhasan.ispmanage.entity.ServicePackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicePackageRepository extends JpaRepository<ServicePackage, Long> {
}
