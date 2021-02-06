package be.vdab.artikelsartikelgroepen.repositories;

import be.vdab.artikelsartikelgroepen.domain.ArtikelGroep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtikelGroepRepository extends JpaRepository<ArtikelGroep, Long> {
    Optional<ArtikelGroep> findByNaam(String woord);
}
