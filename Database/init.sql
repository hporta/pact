CREATE DATABASE dome;
use dome;

/* Entites */
CREATE TABLE Commande
       (cmd_id INT PRIMARY KEY AUTO_INCREMENT,
       cmd_date DATETIME,
       cmd_montant DECIMAL(5,2) CHECK (cmd_montant > 0)
       );

CREATE TABLE Item
       (it_id INT PRIMARY KEY AUTO_INCREMENT,
       it_nom VARCHAR(30),
       it_description VARCHAR(250),
       it_prix DECIMAL(5,2) CHECK (it_prix > 0),
       it_stock INT
       );

CREATE TABLE Categories
       (cat_nom VARCHAR(30) PRIMARY KEY
       );


/* Association */
CREATE TABLE Comporte
       (cmd_id INT REFERENCES Commande(cmd_id),
       it_id INT REFERENCES Item(it_id),
       cmp_quantite INT,
       
       PRIMARY KEY(cmd_id,it_id)
       );

CREATE TABLE Associe
       (it_id INT REFERENCES Item(it_id),
        cat_nom VARCHAR(30) REFERENCES Categories(cat_nom),
       PRIMARY KEY(it_id,cat_nom)
       );



/* Insertion de données dans la base */
INSERT INTO Item VALUES (1,'Coca-cola','Bouteille de 25cL pour vous désaltérer',2.00,50);
INSERT INTO Item VALUES (2,'Fanta','Fanta au gout inégalable',2.0,50);
INSERT INTO Item VALUES (3,'Perrier','Les fines bulles de Perrier sont très rafraichissantes',2.0,30);
INSERT INTO Item VALUES (4,'Kronenbourg','De la bonne bière',4.2,100);
INSERT INTO Item VALUES (5,'Heineken','Une très très bonne bière',4.2,75);
INSERT INTO Item VALUES (6,'Café','Un expresso bien noir',1.0,150);


INSERT INTO Categories VALUES ('Alcoolisé');
INSERT INTO Categories VALUES ('Café');

INSERT INTO Associe VALUES (4,'Alcoolisé');
INSERT INTO Associe VALUES (5,'Alcoolisé');
INSERT INTO Associe VALUES (6,'Café');

INSERT INTO Commande Values(1,NOW(),7.0);
INSERT INTO Commande VALUES(2,NOW(),4.2);
INSERT INTO Commande Values(3,NOW(),4.0);

INSERT INTO Comporte Values(1,1,2); /* 2 cocas */
INSERT INTO Comporte Values(1,6,3); /* 3 cafés */
INSERT INTO Comporte Values(2,4,1); /* 1 Kro */
INSERT INTO Comporte Values(3,2,1); /* 1 Fanta */
INSERT INTO Comporte Values(3,3,1); /* 1 perrier */
