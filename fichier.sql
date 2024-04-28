mysql> create database GestionScolaire;
Query OK, 1 row affected (0,01 sec)

mysql> use GestionScolaire;
Database changed
mysql> create table Etudiant(
    -> id_etudiant int primary key,
    -> nom varchar(20),
    -> prenom varchar(40),
    -> email varchar(50),
    -> password varchar(10));
Query OK, 0 rows affected (0,06 sec)

mysql> create table Cours(
    -> id int primary key,
    -> nom varchar(30),
    -> description text);
Query OK, 0 rows affected (0,12 sec)

mysql> create table Note(
    -> id int primary key,
    -> note float,
    -> id_etudiant int,
    -> id_cour int,
    -> foreign key (id_etudiant) references Etudiant(id_etudiant),
    -> foreign key (id_cour) references Cours(id));
Query OK, 0 rows affected (0,09 sec)
