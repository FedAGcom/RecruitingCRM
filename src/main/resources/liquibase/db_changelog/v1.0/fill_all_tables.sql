    INSERT INTO role (role)
    VALUES
            ('USER'),
            ('ADMIN'),
            ('USER_INACTIVE'),
            ('ADMIN_INACTIVE');

    INSERT INTO vacancy_status(status)
    VALUES
            ('PREPARED'),
            ('OPEN'),
            ('CLOSE'),
            ('ARCHIVE');

    INSERT INTO vacancy(title, position, salary, creation_date, comment, description, status, delete)
    VALUES
            ('Java Developer', 'Java Developer', 50000, '2021-03-12', 'comment', 'description', 'CLOSE', false),
            ('PHP Developer', 'PHP Developer', 60000, '2022-09-01', 'comment', 'description', 'OPEN', false),
            ('Javascript Developer', 'Javascript Developer', 70000, '2022-09-05', 'comment', 'description', 'PREPARED', false);


    INSERT INTO hr(first_name, lastname, login, password, role, creation_date, active)
    VALUES
           ('Ivan', 'Ivanov', 'ivani@yandex.ru', '$2y$10$kIThCfP4phXKomRPQ6eZT.yCQAeWAGycIcSmdVZ/4Mf/U.EGeTDNW', 'USER', '2020-10-27 02:00:00', true),
           ('Aleksandr', 'Sidorov', 'alexs@yandex.ru', '2425', 'USER',  '2021-11-13 02:00:00', true),
           ('Dmitry', 'Androsov', 'da@yandex.ru', 'user', 'ADMIN', '2020-08-21 02:00:00', true),
           ('Ivan', 'Petrov', 'ivanp@yandex.ru', '21646', 'ADMIN', '2021-10-15 02:00:00', true);


    INSERT INTO candidate(first_name, lastname, phone_number, email, residence,
                          country, city, position, salary, birthdate, creation_date,
                          hr_id, status, total_rating, cv_link, vacancy_id, delete)
    VALUES
            ('Aleksey', 'Smirnov', '89357638746', 'smirnov@yandex.ru', 'RF',
             'Russia', 'Vologda', 'Java Developer', 75000, '1998-11-05', '2020-08-21 12:00:00',
             1, 'NEW', 4.0, 'https:/', 1, FALSE),
            ('Aleksandr', 'Popov', '89847938745', 'alpopov@yandex.ru', 'RF',
             'Russia', 'Saint-Petersburg', 'Javascript Developer', 65000, '1996-05-12', '2022-08-12 12:00:00',
             3, 'OFFER', 5.0, 'https:/', 3, FALSE),
            ('Dmitry', 'Petrov', '897389562854', 'dmp@yandex.ru', 'RF',
             'Russia', 'Moscow', 'PHP Developer', 85000, '1990-12-13', '2021-10-22 12:00:00',
             2, 'ACCEPT', 3.0, 'https:/', 2, FALSE);

    INSERT INTO candidate_exp(candidate_id, position, comment, date_start, date_end, delete)
    VALUES
            (2, 'PHP Developer', 'comment', '2020-01-02', '2021-03-12', false),
            (2, 'HR', 'comment', '2018-01-02', '2019-03-12', false),
            (1, 'QA', 'comment', '2021-12-13', '2022-02-12', false);

    INSERT INTO feedback(candidate_id, hr_id, rating, comment, created, updated, deleted)
    VALUES
            (1, 1, 5, 'good', '2022-04-12', '2022-05-12', false),
            (1, 2, 3, 'bad', '2021-06-23', null, false),
            (2, 3, 5, 'good', '2020-11-12', '2021-03-23', false),
            (3, 4, 3, 'bad', '2019-09-11', '2022-02-12', false),
            (2, 3, 5, 'good', '2018-01-01', null, false);


    INSERT INTO hr_to_vacancy(hr_id, vacancy_id)
    VALUES
            (1, 1),
            (2, 2),
            (3, 3),
            (4, 3);

--     INSERT INTO hr_to_urm(hr_id, role)
--     VALUES
--             (1, 'ADMIN'),
--             (2, 'ADMIN'),
--             (3, 'USER'),
--             (4, 'USER'),
--             (1, 'USER');

    INSERT INTO candidate_status(status)
    VALUES
         ('NEW'),
         ('ACCEPT'),
         ('CV_APPROVE'),
         ('INTERVIEW_APPOINTED'),
         ('INTERVIEW_PASSED'),
         ('ON_APPROVAL'),
         ('OFFER'),
         ('PROBATION'),
         ('STAFF'),
         ('DENIAL_BY_HR'),
         ('DENIAL_BY_CANDIDATE');



