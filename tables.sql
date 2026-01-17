CREATE TABLE IF NOT EXISTS Medicament (
    id_m INT AUTO_INCREMENT PRIMARY KEY,
    libelle varchar(50),
    quantite INT
);

CREATE TABLE IF NOT EXISTS Fournisseur (
    id_f INT AUTO_INCREMENT PRIMARY KEY,
    nom_fournissuer varchar(50)
);

CREATE TABLE IF NOT EXISTS Client (
    id_c INT AUTO_INCREMENT PRIMARY KEY,
    nom_client varchar(50)
);
