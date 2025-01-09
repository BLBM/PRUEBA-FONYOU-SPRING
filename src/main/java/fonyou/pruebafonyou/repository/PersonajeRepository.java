package fonyou.pruebafonyou.repository;

import fonyou.pruebafonyou.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {



}
