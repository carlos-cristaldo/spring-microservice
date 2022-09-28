package com.example.springmicroservices.repository;

import com.example.springmicroservices.model.InmuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInmuebleRepository extends JpaRepository<InmuebleEntity, Long> {
}
