CREATE TABLE Product (
    id INT PRIMARY KEY,
    name NVARCHAR(50),
    price_per_unit FLOAT,
    active_for_sell BIT
);

INSERT INTO Product (id, name, price_per_unit, active_for_sell) VALUES
(1, 'Coke', 2.00, 1),
(2, 'Pepsi', 2.00, 1),
(3, 'Kizz', 1.50, 1),
(4, 'Redbull', 2.00, 0);
