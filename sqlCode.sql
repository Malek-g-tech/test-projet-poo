CREATE DATABASE IF NOT EXISTS pharmacie;
USE pharmacie;


CREATE TABLE IF NOT EXISTS Medicament (
    id_m INT AUTO_INCREMENT PRIMARY KEY,
    libelle varchar(50),
    quantite INT,
    prix FLOAT
);

CREATE TABLE IF NOT EXISTS Fournisseur (
    id_f INT AUTO_INCREMENT PRIMARY KEY,
    nom_fournisseur varchar(50)
);

CREATE TABLE IF NOT EXISTS Client (
    id_c INT AUTO_INCREMENT PRIMARY KEY,
    nom_client varchar(50)
);

--commande du fournisseur on doit savoir le prix unite
CREATE TABLE IF NOT EXISTS Commandes(
    id_m INTEGER ,
    id_f INTEGER ,
    date_commande DATETIME NOT NULL,
    quantite INTEGER NOT NULL,
    prix_unit FLOAT NOT NULL,
    CONSTRAINT c_pk PRIMARY KEY(id_m,id_f,dateC),
    CONSTRAINT for_med FOREIGN KEY(id_m) REFERENCES Medicament(id_m) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT for_fou FOREIGN KEY(id_f) REFERENCES Fournisseur(id_f) ON DELETE CASCADE ON UPDATE CASCADE
);


--vente on doit savoir le prix unite
--car le prix peut changerv vente
CREATE TABLE IF NOT EXISTS Vente(
    id_m INTEGER ,
    id_c INTEGER ,
    dateV DATETIME NOT NULL,
    quantite INTEGER NOT NULL,
    prix_vente FLOAT,
    CONSTRAINT v_pk PRIMARY KEY(id_m,id_c,dateV),
    CONSTRAINT for_med FOREIGN KEY(id_m) REFERENCES Medicament(id_m) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT for_fou FOREIGN KEY(id_c) REFERENCES Client(id_c) ON DELETE CASCADE ON UPDATE CASCADE

);
