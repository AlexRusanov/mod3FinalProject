DELETE FROM voting;
ALTER SEQUENCE voting_id_seq RESTART WITH 1;
DELETE FROM bills;
ALTER SEQUENCE bills_id_seq RESTART WITH 1;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
DELETE FROM sessions;
ALTER SEQUENCE sessions_id_seq RESTART WITH 1;
DELETE FROM deputies;
ALTER SEQUENCE deputies_id_seq RESTART WITH 1;

INSERT INTO deputies (name, surname, gender, birthday, fraction)
VALUES ('Петя', 'Шоколадный', 1, '1956-12-28 00:00:00', 'Кондитерская');
INSERT INTO deputies (name, surname, gender, birthday, fraction)
VALUES ('Юра', 'Закон', 1, '1958-05-13 00:00:00', 'Кондитерская');
INSERT INTO deputies (name, surname, gender, birthday, fraction)
VALUES ('Олег', 'Радикальный', 1, '1970-06-03 00:00:00', 'Вилы на изготовку');
INSERT INTO deputies (name, surname, gender, birthday, fraction)
VALUES ('Юля', 'Роботяща', 0, '1969-08-23 00:00:00', 'Сердешные');
INSERT INTO deputies (name, surname, gender, birthday, fraction)
VALUES ('Саша', 'Пастор', 1, '1964-10-15 00:00:00', 'Сердешные');

INSERT INTO sessions (agenda, date)
VALUES ('Повестка дня 1-ой сессии', '2017-09-01 10:00:00');
INSERT INTO sessions (agenda, date)
VALUES ('Повестка дня 2-ой сессии', '2017-09-08 10:00:00');

INSERT INTO users (email, password, deputy_id, role)
VALUES ('chocobanny@candy.com', '$2a$10$aSjm80I3M5Xu7sj3qWONEuQJQ725oJWsomd5.qHRDpcuXthxQHE9G', 1, 2);
INSERT INTO users (email, password, deputy_id, role)
VALUES ('iamthelaw@gpu.com', '$2a$10$I/nRFDp.vIAUneo1HoMiJeMYT5YhD7VxUplufYPdz.6cAO8fZUUxe', 2, 1);
INSERT INTO users (email, password, deputy_id, role)
VALUES ('pitch@fork.com', '$2a$10$nx6JIpg8O4i/q6lhMob92uoR3wjO71f.nDrwVgtQaYwPEaztUr5Cu', 3, 0);
INSERT INTO users (email, password, deputy_id, role)
VALUES ('she@working.com', '$2a$10$A0cWzvur0joonXW3lF6Qeu0ytqEjDuZ5Dv0pmMJ2gfK/IZJhert6W', 4, 0);
INSERT INTO users (email, password, deputy_id, role)
VALUES ('bloody@pastor.com', '$2a$10$nT37kMGpVivJwpJyGNXI6eqobCXkQs6rccicUH2OgbBgQaOt5pE9a', 5, 0);

INSERT INTO bills (title, author, user_id, submission_date, text, session_id)
VALUES ('Законопроект 1', 'Петя Шоколадный', 1, '2017-08-24 13:15:00', 'Текст законопроекта 1', 1);
INSERT INTO bills (title, author, user_id, submission_date, text, session_id)
VALUES ('Законопроект 2', 'Петя Шоколадный', 1, '2017-08-24 13:30:00', 'Текст законопроекта 2', 1);
INSERT INTO bills (title, author, user_id, submission_date, text, session_id)
VALUES ('Законопроект 3', 'Олег радикальный', 3, '2017-08-23 12:15:00', 'Текст законопроекта 3', 1);
INSERT INTO bills (title, author, user_id, submission_date, text, session_id)
VALUES ('Законопроект 4', 'Юля Роботяща', 4, '2017-08-28 10:45:00', 'Текст законопроекта 4', 1);
INSERT INTO bills (title, author, user_id, submission_date, text, session_id)
VALUES ('Законопроект 5', 'Саша Пастор', 5, '2017-08-29 16:00:00', 'Текст законопроекта 5', 1);
INSERT INTO bills (title, author, user_id, submission_date, text, session_id)
VALUES ('Законопроект 6', 'Юра Закон', 2, '2017-08-30 15:15:00', 'Текст законопроекта 6', 1);

INSERT INTO voting (bill_id, deputy_id, vote)
VALUES (1, 1, 0);
INSERT INTO voting (bill_id, deputy_id, vote)
VALUES (1, 2, 0);
INSERT INTO voting (bill_id, deputy_id, vote)
VALUES (1, 3, 0);
INSERT INTO voting (bill_id, deputy_id, vote)
VALUES (1, 4, 0);
INSERT INTO voting (bill_id, deputy_id, vote)
VALUES (1, 5, 0);