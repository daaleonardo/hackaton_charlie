DELETE FROM customer;
INSERT INTO customer(ID, CREATIONTIME, UPDATETIME, VERSION, FIRSTNAME, LASTNAME, GENDER, AGE, EMAIL, PASSWORD, BIO) VALUES
  (1, TIMESTAMP '2017-10-10 08:45:56.468', TIMESTAMP '2017-10-10 08:45:56.468', 0, 'Rui', 'LOL', 'Male', 28, 'mail@gmail.com', 'password' 'I am rui'),
  (2, TIMESTAMP '2017-10-10 08:45:56.481', TIMESTAMP '2017-10-10 08:45:56.481', 0, 'Glitter', 'Sparkles', 'Female', 33, 'mail@gmail.com', 'password', 'I am Glitter'),
  (3, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Bruno', 'Something', 'Male', 48, 'mail@gmail.com', 'password', 'I am Bruno'),
  (4, TIMESTAMP '2017-10-10 08:45:56.482', TIMESTAMP '2017-10-10 08:45:56.482', 0, 'Sofia', 'Sofina', 'Female', 30, 'mail@gmail.com', 'password', 'I am Sofia');

