
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
	skills varchar (1000),
	mold boolean,
    house_cleaners boolean,
    other_allergies varchar(1000),
    animal_care boolean,
    grooming boolean,
    cleaning_kennels boolean,
    walking_dogs boolean,
    cat_whisperer boolean,
    customer_service boolean,
    lift_over_thirty_pounds boolean,
    laundry boolean,
    stocking_supplies boolean,
    dander boolean,
    pollen boolean,

	
	CONSTRAINT FK_volunteer_user_id FOREIGN KEY (volunteer_user_id) REFERENCES users (user_id)
);

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('peanut', 'dog', 6, 'female', 'no', 'yes', 'https://www.columbusmonthly.com/gcdn/presto/2021/05/19/NCOM/9ae9effb-bb16-4260-ae29-c6038eec7619-cmm_feat_pets1120_70.jpg?crop=2199,1237,x0,y773&width=2199&height=1237&format=pjpg&auto=webp', 'lazy, nervous', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('clifford', 'dog', 9, 'male', 'no', 'yes', 'https://m.media-amazon.com/images/I/81F0PqLk8yL._UF1000,1000_QL80_.jpg', 'larger than life, red', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('doggy', 'dog', 16, 'male', 'yes - diabetes', 'no', 'https://www.thesprucepets.com/thmb/HKCGLfgi4t2x34XDNLZ8_iK-HAk=/6000x0/filters:no_upscale():strip_icc()/rules-for-walking-your-dog-1117437-06-c93d684a3f3149958c316fb2dc6c7f57.jpg', 'loves going on walks', 'no', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('fluffy', 'cat', 8, 'female', 'yes- blind', 'no', 'https://media.istockphoto.com/id/499170514/photo/cat-going-blind-with-cataracts.jpg?s=612x612&w=0&k=20&c=BaGypwr4cb38QOJktK2V0RlzU2i082AWma7eB2rxbO4=', 'hides often', 'no', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('frizzle', 'bird', 8, 'female', 'no', 'yes', 'https://media.istockphoto.com/id/1288762088/photo/a-jenday-conure-perched-in-a-tree-also-known-as-jandaya-parakeet-is-a-small-neotropical-bird.jpg?s=612x612&w=0&k=20&c=jej18TfwPQYdJQet0_Fu7jlh0c3t4XP85D8z61wg03w=', 'loud, loves to bite', 'yes', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('king julien', 'lemur', 18, 'male', 'no', 'yes', 'https://www.akronzoo.org/sites/default/files/styles/uncropped_xl/public/2022-05/Ring-tailed-lemur-main.png?itok=T7g7bQt6', 'loud, loves to sing', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('jimbo', 'dog', 11, 'female', 'yes- sleep apnea', 'yes', 'https://www.thisdogslife.co/wp-content/uploads/2019/02/marnie-hero-3.png', 'raging termagant, i mean look at that hat', 'no', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('funbun', 'rabbit', 8, 'female', 'yes- cant jump', 'no', 'https://images.squarespace-cdn.com/content/v1/54ff9a97e4b063025cf9895c/1562176262623-5QYBI3C51T1TTDIS2JOJ/Sable+chinchilla+holland+lop+buck?format=2500w', 'old and sad, crisis-mode activated', 'no', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('chubs', 'chinchilla', 9, 'male', 'yes- incontinence', 'no', 'https://a-z-animals.com/media/2021/12/Silver-animals-Chinchilla.jpg', 'happy, dusty', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('snowball', 'rat', 4, 'female', 'no', 'no', 'https://i.redd.it/z74e00rt1m151.jpg', 'energetic, loves to snuggle', 'yes', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('princess', 'rat', 3, 'female', 'no', 'yes', 'https://image.petmd.com/files/styles/863x625/public/2022-06/rat.blanket.jpg', 'climbs everything in sight, will do tricks for treats', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('snowball', 'rabbit', 8, 'male', 'yes- deaf', 'yes', 'https://cdn.shopify.com/s/files/1/0576/1974/2872/files/white-rabbit-running_1024x1024.jpg?v=1646132445', 'energetic, loves to snuggle', 'yes', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('remy', 'rat', 10, 'male', 'Yes- anxiety and imposter syndrome', 'no', 'https://www.animallama.com/wp-content/uploads/2022/12/Top-eared-rat.jpg', 'remarkable sense of smell, clever, determined', 'no', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('mop', 'guinea pig', 5, 'female', 'grooming', 'no', 'https://cdn-iejno.nitrocdn.com/TARXhzDLqFQyjerZSKSDNgEVeSSRbnJJ/assets/images/optimized/rev-0a67014/www.2feet4paws.ae/wp-content/uploads/2020/12/Basic-Guinea-Pig-Care.jpg', 'jumping around', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('Mort', 'lemur', 5, 'male', 'yes- hyperactive', 'no', 'https://i.dailymail.co.uk/i/pix/2016/07/18/15/36637A9900000578-0-The_teacup_sized_mouse_lemurs_are_the_world_s_smallest_and_faste-a-6_1468852350471.jpg', 'loves to run in circles', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('Chrysanthemum', 'chinchilla', 7, 'female', 'no', 'no', 'https://cdn.mos.cms.futurecdn.net/pxj3bPSfYRqK2ZyKLJApNE.jpg', 'chill, likes to sunbathe', 'yes', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('captain', 'african grey', 55, 'male', 'yes- seperation anxiety', 'no', 'https://www.stodels.com/wp-content/uploads/2009/03/8453530769_9bab22d205_b-1.jpg', 'energetic, loves to snuggle', 'yes', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('luna', 'cat', 12, 'female', 'yes- picky eater', 'no', 'https://www.ellevetsciences.com/wp-content/uploads/2023/03/ev_blog_bambina-cat-breed-1024x683.jpg', 'shy, mellow', 'no', 'no');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('kermit', 'toad', 9, 'male', 'none', 'no', 'https://media.cnn.com/api/v1/images/stellar/prod/230722100757-natterjack-toad-file.jpg?c=original', 'hopping', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('Wilbur', 'Tea Cup Pig', 19, 'Male', 'Lack of confidence', 'no', 'https://www.kalmbachfeeds.com/wp-content/uploads/2021/12/Mini-Pig-Article-Blog-Header-12.7.21-1024x536.jpg', 'Lighthearted and playful', 'yes', 'yes');

INSERT INTO pet_information (pet_name, pet_type, pet_age, pet_gender, pet_special_needs, adopted, pet_picture, personality_traits, good_with_kids, good_with_other_animals)
VALUES ('donatello', 'turtle', 30, 'male', 'scares easily', 'no', 'https://images.squarespace-cdn.com/content/v1/5f68be4f3c03e17666b8c09c/1655909386320-AJPHEJFL6GW7EVLVGAPT/box+turtle+new+2.jpg?format=750w', 'likes to cuddle', 'yes', 'yes');

--Testing Volunteer Directory:
--INSERT INTO users (username, password_hash, role, first_name, last_name, phone_number, email_address, has_logged_in)
--VALUES ('newperson', 'password', 'user', 'Bob', 'Smith', '123-456-7890', 'bobsmith@gmail.com', true);
INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills, mold, house_cleaners, other_allergies,
animal_care, grooming, cleaning_kennels, walking_dogs, cat_whisperer,
customer_service, lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Samantha', 'Clark', '555-876-5432', 'samantha.c@aol.com', true, 'pending', 'anything', false, false, 'N/A', true, true, true, true, true, true, true, true, true, false, false);

INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills, mold,
house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, walking_dogs, cat_whisperer, customer_service,
lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Olivia', 'Hall', '555-432-8765', 'olivia.m.hall@gmail.com', false, 'pending', 'animal lover',
false, false, 'none', true,
false, false, true, true, false, false, false, false, false, false);

INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills, mold,
house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, walking_dogs, cat_whisperer, customer_service,
lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Sophia', 'Adams', '555-567-2345', 'sophia123@yahoo.com', true, 'pending', 'I love cats', true, false, 'nothing', true,
true, false, false, true, false, false, false, false, false, false);

INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills, mold,
house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, walking_dogs, cat_whisperer, customer_service,
lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Ethan', 'Mitchell', '555-321-6789', 'emitchell@gmail.com', true, 'pending', 'organization', true, true, 'dust, grass, cats', false,
false, false, false, false, true, true, false, true, true, true);

INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills, mold,
house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, walking_dogs, cat_whisperer, customer_service,
lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Samantha', 'Clark', '555-876-5432', 'samantha.c@aol.com', true, 'pending', 'anything', false, false, 'N/A', true, true, true, true, true, true, true, true, true, false, false);

INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills,
mold, house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, walking_dogs,
cat_whisperer, customer_service, lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Noah', 'Bennett', '555-987-1212', 'ngb@gmail.com', false, 'pending', '-', false, false, 'lactose',
true, true, true, true, true, false, true, true, true, false, false);

INSERT INTO volunteer_information (first_name, last_name, phone_number, email_address, over_eighteen, approved, skills, mold,
house_cleaners, other_allergies, animal_care, grooming, cleaning_kennels, walking_dogs, cat_whisperer, customer_service,
lift_over_thirty_pounds, laundry, stocking_supplies, dander, pollen)
VALUES ('Mia', 'Rodriguez', '555-888-7999', 'mias_dog_training@yahoo.com', true, 'pending', '10 years as a professional dog trainer', false, false,
'no', true, true, true, true, false, false, true, true, true, false, false);

COMMIT TRANSACTION;
