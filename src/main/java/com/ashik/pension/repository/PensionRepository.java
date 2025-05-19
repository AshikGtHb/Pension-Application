package com.ashik.pension.repository;

import com.ashik.pension.model.Pension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PensionRepository extends JpaRepository<Pension, Long> {
}
