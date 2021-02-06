package be.vdab.artikelsartikelgroepen.repositories;

import be.vdab.artikelsartikelgroepen.domain.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ArtikelRepository extends JpaRepository<Artikel, Long> {
    @Query("select max(a.prijs) from Artikel a") int findHoogstePrijs();
    List<Artikel> findByPrijsBetween(BigDecimal van, BigDecimal tot);
    List<Artikel> findByArtikelGroepNaam(String woord);

// Hieronder extra methods ter controle / uittesten om fout op te zoeken
    List<Artikel> findByPrijsGreaterThanEqual(BigDecimal vanaf);
    Optional<Artikel> findByNaam(String woord);
}
