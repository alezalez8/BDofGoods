create table Clients (
                         client_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         name varchar(100) NOT NULL,
                         surename varchar(100) NOT NULL
);

create table Orders(
                       order_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       client_id int,
                       goods_id int,
                       create_date TIMESTAMP,
                       foreign key (client_id) REFERENCES Clients(client_id)

);

create table Goods(
                      goods_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                      title varchar(100) NOT NULL,
                      price double,
                      add_date DATETIME,
                      count int,
                      order_id int,
                      foreign key (order_id) REFERENCES Orders (goods_id)

)