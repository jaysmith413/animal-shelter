
BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pet_information, volunteer_information CASCADE;

DROP SEQUENCE IF EXISTS seq_pet_id;
DROP SEQUENCE IF EXISTS seq_volunteer_app_id;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
INCREMENT BY 1
START WITH 3001
NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id') PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar(50),
	last_name varchar(50),
	phone_number varchar(20),
	email_address varchar(80),
	has_logged_in boolean DEFAULT false
);

CREATE SEQUENCE seq_pet_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE pet_information (
	pet_id int NOT NULL DEFAULT nextval('seq_pet_id') PRIMARY KEY,
	pet_name varchar(50) NOT NULL,
	pet_type varchar(50) NOT NULL,
	pet_age int,
	pet_gender varchar(50),
	pet_special_needs varchar(50),
	adopted boolean,
	pet_picture varchar(1000),
	personality_traits varchar(100),
	good_with_kids boolean,
	good_with_other_animals boolean
);

CREATE SEQUENCE seq_volunteer_app_id
INCREMENT BY 1
START WITH 2001
NO MAXVALUE;

CREATE TABLE volunteer_information(

	application_id int NOT NULL DEFAULT nextval('seq_volunteer_app_id') PRIMARY KEY,
	volunteer_user_id int,
	first_name varchar(20),
	last_name varchar(20),
	phone_number varchar(20),
	email_address varchar(50),
	over_eighteen boolean,
	approved varchar(20) DEFAULT 'pending',
	allergies varchar(1000),
	skills varchar (1000),
	
	CONSTRAINT FK_volunteer_user_id FOREIGN KEY (volunteer_user_id) REFERENCES users (user_id)
);

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('peanut', 'dog', 6, 'female', 'no', 'yes', 'https://tse1.mm.bing.net/th?q=homophobic%20dog%20template', 'lazy, nervous', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('clifford', 'dog', 9, 'female', 'no', 'yes', 'https://m.media-amazon.com/images/I/81F0PqLk8yL._UF1000,1000_QL80_.jpg', 'larger than life, red', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('doggy', 'dog', 16, 'male', 'yes - diabetes', 'no', 'https://www.thesprucepets.com/thmb/HKCGLfgi4t2x34XDNLZ8_iK-HAk=/6000x0/filters:no_upscale():strip_icc()/rules-for-walking-your-dog-1117437-06-c93d684a3f3149958c316fb2dc6c7f57.jpg', 'loves going on walks', 'no', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('fluffy', 'cat', 8, 'female', 'yes- blind', 'no', 'https://media.istockphoto.com/id/499170514/photo/cat-going-blind-with-cataracts.jpg?s=612x612&w=0&k=20&c=BaGypwr4cb38QOJktK2V0RlzU2i082AWma7eB2rxbO4=', 'hides often', 'no', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('frizzle', 'bird', 8, 'female', 'no', 'yes', 'https://assets.petco.com/petco/image/upload/f_auto,q_auto/Bird%20600x400', 'loud, loves to bite', 'yes', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('king julien', 'lemur', 18, 'male', 'no', 'yes', 'https://www.akronzoo.org/sites/default/files/styles/uncropped_xl/public/2022-05/Ring-tailed-lemur-main.png?itok=T7g7bQt6', 'loud, loves to sing', 'yes', 'yes');

COMMIT TRANSACTION;
