package dev.mhasan.ispmanage.repository;

import dev.mhasan.ispmanage.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
