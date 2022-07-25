drop table Client_info;
drop table Goods;
drop table Orders;
drop table Clients;

create table Clients (
                         client_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         name varchar(100) NOT NULL,
                         surename varchar(100) NOT NULL
);

create table Orders(
                       order_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       client_id int NOT NULL REFERENCES Clients(client_id),
                       create_date TIMESTAMP
);

create table Goods(
                      goods_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      title varchar(100) NOT NULL,
                      price double,
                      add_date DATETIME,
                      count int default(1),
                      order_id int NOT NULL REFERENCES Orders (order_id)
);

create table Client_info(
                            info_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            age int CHECK ( age > 10 ),
                            phone varchar(10),
                            email varchar(30) UNIQUE NOT NULL ,
                            created_at TIMESTAMP,
                            updated_at DATETIME,
                            foreign key (info_id) REFERENCES Clients(client_id)
);

INSERT INTO Clients (name, surename) VALUES ('Aleksandr', 'Shunin');
INSERT INTO Clients (name, surename) VALUES ('Aleksey', 'Pupkin');
INSERT INTO Clients (name, surename) VALUES ('Leonid', 'Ivanov');
INSERT INTO Clients (name, surename) VALUES ('Petr', 'Petrov');
INSERT INTO Clients (name, surename) VALUES ('Grigoriy', 'Sidorov');
INSERT INTO Clients (name, surename) VALUES ('Boris', 'Jonson');
INSERT INTO Clients (name, surename) VALUES ('Tom', 'Cruis');
INSERT INTO Clients (name, surename) VALUES ('Igor', 'Perepelkin');
INSERT INTO Clients (name, surename) VALUES ('Vlad', 'Severov');