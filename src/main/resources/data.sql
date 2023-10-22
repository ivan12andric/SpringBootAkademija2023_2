create table test
(
    id int primary key auto_increment,
    naziv varchar(50),
    opis varchar(255)
);

insert into test(naziv, opis) values ('Iva', 'ne radi joj punjač');




create table pretraga_letova
(
    id int primary key auto_increment,
    polazni_aerodrom varchar(3),
    dolazni_aerodrom varchar(3),
    datum_polaska date,
    datum_povratka date,
    broj_putnika int,

    korisnik_kreirao varchar(50),
    datum_kreiranja date,
    korisnik_azuriranja varchar(50),
    datum_azuriranja date
)