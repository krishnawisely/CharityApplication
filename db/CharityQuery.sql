create schema charity_app;
use charity_app;

CREATE TABLE admin(
	id INT AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id)
);

ALTER TABLE admin MODIFY email VARCHAR(50) NOT NULL UNIQUE;

CREATE TABLE donor(
	id INT AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    gender VARCHAR(10),
    date_of_birth DATE,
    active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id)
);

CREATE TABLE fund_request(
	id INT AUTO_INCREMENT,
    admin_id INT NOT NULL,
    request_type VARCHAR(50) NOT NULL,
    description VARCHAR(50),
    amount DECIMAL(15,4) NOT NULL,
    date DATE,
    expire_date DATE NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id),
    FOREIGN KEY(admin_id) REFERENCES admin(id)
);

ALTER TABLE fund_request MODIFY date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

CREATE TABLE transaction(
	id INT AUTO_INCREMENT,
    donor_id INT NOT NULL,
    fund_request_id INT NOT NULL,
    amount DECIMAL(15,4),
    PRIMARY KEY(id),
    FOREIGN KEY(donor_id) REFERENCES donor(id),
    FOREIGN KEY(fund_request_id) REFERENCES fund_request(id)
);

ALTER TABLE transaction ADD date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

DESC admin;
DESC donor;
DESC fund_request;
DESC transaction;

INSERT INTO admin(
	name,
    email,
    password
) VALUES(
	'admin',
    'admin@gmail.com',
    'mypass'
);

INSERT INTO donor(
	name,
    email,
    password,
    gender,
    date_of_birth
) VALUES(
	'krishna',
    'krishna@gmail.com',
    'mypass',
    'male',
    str_to_date('05/06/1997','%d/%m/%Y')
);

INSERT INTO fund_request(
	admin_id,
    request_type,
    description,
    amount,
    expire_date
) VALUES(
	1,
    'OTHERS',
    'Others fund',
    25000,
    str_to_date('20/09/2019','%d/%m/%Y')
);

SELECT * from fund_request;

INSERT INTO transaction(
	donor_id,
    fund_request_id,
    amount
) VALUES(
	1,
    7,
    10000
);

SELECT request_type,amount FROM fund_request WHERE request_type = 'FOOD';
SELECT SUM(amount) as Fund_Needed FROM transaction WHERE fund_request_id = 3;

SELECT request_type,description,expire_date,amount,
(amount - (SELECT SUM(amount) as Fund_Needed FROM transaction WHERE fr.id = fund_request_id)) AS needed_amount
FROM fund_request fr WHERE request_type = 'FOOD' AND active;

SELECT request_type,description,expire_date,amount AS target_amount,
(
	SELECT IF((SUM(amount) <= fr.amount),(fr.amount - SUM(amount)),0) FROM transaction WHERE fund_request_id = 3 GROUP BY fund_request_id HAVING SUM(amount) <= fr.amount
) AS needed_amount
FROM fund_request fr WHERE request_type = 'EDUCATION' AND amount > (SELECT SUM(amount) FROM transaction WHERE fund_request_id = 3);

SELECT SUM(amount) FROM transaction WHERE fund_request_id = 3;
SELECT IF(SUM(amount) <= 25000,SUM(amount),0) as Fund_Needed FROM transaction WHERE fund_request_id = 7 GROUP BY fund_request_id HAVING SUM(amount) <= 25000;
select * from admin;
select * from donor;
select * from fund_request;
select * from transaction;

SELECT IFNULL(SUM(amount),0) FROM transaction WHERE fund_request_id = 8;
SELECT request_type,description,expire_date,amount,(amount - (SELECT IFNULL(SUM(amount),0)FROM transaction WHERE fund_request_id = 8)) AS needed_amount FROM fund_request fr WHERE request_type = 'others' AND amount > (SELECT IFNULL(SUM(amount),0) FROM transaction WHERE fund_request_id = 8);
SELECT IFNULL(SUM(amount),0) FROM transaction WHERE fund_request_id = 1;
SELECT request_type,amount AS target_amount,amount - (
SELECT IFNULL(SUM(amount),0) FROM transaction WHERE fund_request_id = 1
) AS needed_amount FROM fund_request fr WHERE request_type = 'FOOD';