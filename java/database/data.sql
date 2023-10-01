BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,has_logged_in) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER',true);
INSERT INTO users (username,password_hash,role,has_logged_in) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN',true);
INSERT INTO users (username, password_hash, role, first_name, last_name, phone_number, email_address, has_logged_in)
VALUES ('newperson', 'password', 'user', 'Bob', 'Smith', '123-456-7890', 'bobsmith@gmail.com', true);

COMMIT TRANSACTION;
