insert into artikels(naam, prijs, artikelGroepId) VALUES
('banaan',1,(select id from artikelgroepen where naam='food')),
('tafel',90,(select id from artikelgroepen where naam='non-food')),
('stoel',30,(select id from artikelgroepen where naam='non-food'));