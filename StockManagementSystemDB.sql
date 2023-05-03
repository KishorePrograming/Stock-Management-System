Drop database if exists Stockmanagement;

create database Stockmanagement; 

use Stockmanagement;

create table login(
userid int primary key auto_increment,
name varchar(255) not null,
password varchar(255) not null,
usertype varchar(255) not null
);

insert into login(name,password,usertype) values 
("Kishore","123","Admin"),
("Prithiv","123","Receving"),
("Karthick","123","Quality"),
("Vicky","123","Vendor"),
("Praveen","123","Billing"),
("Kumar","123","Retailers");

create table RequestGRN(
tracking_id int primary key auto_increment,
Prod_Id varchar(255) not null,
Prod_Name varchar(255) not null,
Description varchar(255) not null,
Costprice int not null,
RetailPrice int not null,
Qty int not null,
Quality char(4) default 'HOLD',
vehicleno varchar(15) default "By Hand",
Reciving varchar(30) default 'Not Yet Started',
Remarks varchar(14) default 'null'
);

insert into RequestGRN (Prod_Id,Prod_Name,Description,Costprice,RetailPrice,Qty,vehicleno)values
("101","PEN","INK PEN",12,20,1000,"TN 18 AP 2513"),
("102","PENCIL","CORBAN",8,15,5000,"TN 12 AV 2043"),
("103","CAR","Smoothy Driving",10000,15000,10000,"TN 22 AS 2243"),
("104","MEDICINE","MEDICINE DESC",10,18,7000,"TN 25 AY 2019"),
("105","LAPTOP","ELECTRONIC LAPTOP",11000,12000,10000,"TN 21 AY 2020"),
("106","FRIDGE","FRIDGE DESC",4000,4500,1000,"TN 22 AY 2021"),
("107","PHONE","PHONE DESC",18000,18500,8000,"TN 23 AY 2022"),
("108","FAN","FAN DESC",3000,3500,2500,"TN 24 AY 2023"),
("109","BAG","BAG DESC",700,800,500,"TN 25 AY 2024"),
("110","SHOES","SHOES DESC",4000,5500,1600,"TN 26 AY 2025");

create table ProblemVendorProductTable(
tracking_id int not null,
Prod_Id varchar(255) not null,
Prod_Name varchar(255) not null,
Description varchar(255) not null,
Costprice int not null,
RetailPrice int not null,
Qty int not null,
Quality char(4) default 'HOLD',
vehicleno varchar(15) default "By Hand",
Reciving varchar(30) default 'Not Yet Started',
Remarks varchar(14) default 'null'
);

create table TransferTable(
tracking_id int not null,
Prod_Id varchar(255) not null,
Prod_Name varchar(255) not null,
Description varchar(255) not null,
Costprice int not null,
RetailPrice int not null,
Qty int not null,
Quality char(4) default 'HOLD',
vehicleno varchar(15) default "By Hand",
Reciving varchar(30) default 'Not Yet Started',
Remarks varchar(14) default 'null'
);

create table StoreTable(
tracking_id int not null,
Prod_Id varchar(255) not null,
Prod_Name varchar(255) not null,
Description varchar(255) not null,
Costprice int not null,
RetailPrice int not null,
Qty int not null,
Order_Qty int default 0 ,
Quality char(4) default 'HOLD',
vehicleno varchar(15) default "By Hand",
Reciving varchar(30) default 'GRN DONE',
Remarks varchar(14) default 'Clear'
);


Create table RequermentRequest(
S_no int auto_increment primary key,
Order_num varchar(255) not null,
Prod_id int not null,
Prod_Name varchar(255) not null,
Description varchar(255) not null,
Price int not null,
Qty int not null,
Status varchar(255) not null default "Not Started Yet"
);

Create table TransferMaterialRetailer(
S_no int auto_increment primary key,
Invoice_num varchar(255) not null,
Order_num varchar(255) not null,
Prod_id int not null,
Prod_Name varchar(255) not null,
Description Varchar(255) not null,
Price int not null,
Qty int not null,
Status varchar(255) not null default "Picking Completed",
Vehicle varchar(255)  not null default "By Hand",
InvoiceDate DATE not null,
Total_cost int not null
);

CREATE VIEW ReportOfSales AS
SELECT InvoiceDate,Invoice_num,Prod_id,Prod_Name,Description,Qty,Total_cost
FROM TransferMaterialRetailer;

show tables;

select * from login;

select * from RequestGRN;

select * from ProblemVendorProductTable;

select * from TransferTable;

select * from StoreTable;

select Prod_Name from StoreTable where Qty>0;

select * from RequermentRequest;

select * from TransferMaterialRetailer;

select * from ReportOfSales;

SELECT InvoiceDate,Invoice_num,Prod_id,Prod_Name,Description,Qty,Total_cost
FROM ReportOfSales;

SELECT SUM(Total_cost) Total_Cost FROM ReportOfSales;


select * from StoreTable where 0<Qty;

SHOW FULL processlist;

KILL 5;