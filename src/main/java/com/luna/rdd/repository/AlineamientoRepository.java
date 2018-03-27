package com.luna.rdd.repository;

import com.luna.rdd.model.Alineamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlineamientoRepository extends JpaRepository<Alineamiento, Long> {

}
