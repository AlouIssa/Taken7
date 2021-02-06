package be.vdab.artikelsartikelgroepen.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "artikels")
public class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal prijs;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artikelGroepId")
    private ArtikelGroep artikelGroep;
//  De Constructor is niet nodig voor dit project
//    public Artikel(String naam, BigDecimal prijs, ArtikelGroep artikelGroep) {
//        this.naam = naam;
//        this.prijs = prijs;
//        this.artikelGroep = artikelGroep;
//    }
//    public Artikel(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public ArtikelGroep getArtikelGroep() {
        return artikelGroep;
    }
}
