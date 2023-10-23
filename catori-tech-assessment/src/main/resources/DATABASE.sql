CREATE TABLE contact (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    lastName VARCHAR(255),
    address TEXT,
    phoneNumber VARCHAR(20),
    vat VARCHAR(20)
);

alter table if exists Contact alter column id set data type bigint;
create sequence Contact_SEQ start with 1 increment by 50;

INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('John', 'Doe', '123 Main St', '555-123-4567', '12345A');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Alice', 'Smith', '456 Elm St', '555-987-6543', '98765B');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Bob', 'Johnson', '789 Oak St', '555-567-1234', '56789C');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Eva', 'Brown', '567 Pine St', '555-234-5678', '23456D');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('David', 'Williams', '890 Cedar St', '555-876-5432', '87654E');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Maria', 'Jones', '234 Birch St', '555-432-7654', '43210F');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Sam', 'Davis', '456 Maple St', '555-765-4321', '76543G');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Olivia', 'Miller', '678 Oak St', '555-345-6789', '34567H');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Daniel', 'Wilson', '321 Elm St', '555-654-3210', '65432I');
INSERT INTO contact (name, lastName, address, phoneNumber, vat) VALUES ('Sophia', 'Anderson', '123 Cedar St', '555-876-5432', '87654J');

SELECT * FROM contact

