BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,has_logged_in, first_name, last_name, phone_number, email_address) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER',true,'Eric','Cameron','1111111111','datawizard@gmail.com');
INSERT INTO users (username,password_hash,role,has_logged_in, first_name, last_name, phone_number, email_address) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN',true,'Sondra','Coffin','1111111111','ilovepets@gmail.com');


COMMIT TRANSACTION;
