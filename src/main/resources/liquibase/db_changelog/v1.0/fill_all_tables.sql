    INSERT INTO hr(id, first_name, lastname, login, password, creation_date)
    VALUES
           (1, 'Ivan', 'Ivanov', 'ivan@yandex.ru', '1234',  '2020-10-27 02:00:00'),
           (2, 'Aleksandr', 'Sidorov', 'alexs@yandex.ru', '2425',  '2021-11-13 02:00:00'),
           (3, 'Dmitry', 'Androsov', 'da@yandex.ru', 'user',  '2020-08-21 02:00:00'),
           (4, 'Ivan', 'Petrov', 'ivan@yandex.ru', '21646',  '2021-10-15 02:00:00');


    INSERT INTO candidate(id, first_name, lastname, phone_number, email, residence,
                          country, city, position, salary, birthdate, creation_date,
                          hr_id, status, total_rating, cv_link, vacancy_id)
    VALUES
            (1, 'Aleksey', 'Smirnov', '89357638746', 'smirnov@yandex.ru', 'RF',
             'Russia', 'Vologda', 'Java Developer', 75000, '1998-11-05', '2020-08-21 12:00:00',
             1, 'NEW', 4.0, 'https:/', 1),
            (2, 'Aleksandr', 'Popov', '89847938745', 'alpopov@yandex.ru', 'RF',
             'Russia', 'Saint-Petersburg', 'Javascript Developer', 65000, '1996-05-12', '2022-08-12 12:00:00',
             3, 'OFFER', 5.0, 'https:/', 2),
            (3, 'Dmitry', 'Petrov', '897389562854', 'dmp@yandex.ru', 'RF',
             'Russia', 'Moscow', 'PHP Developer', 85000, '1990-12-13', '2021-10-22 12:00:00',
             2, 'ACCEPT', 3.0, 'https:/', 3);

    INSERT INTO candidate_exp(id, candidate_id, position, comment, date_start, date_end)
    VALUES
            (1, 2, 'PHP Developer', 'comment', '2020-01-02', '2021-03-12'),
            (2, 2, 'HR', 'comment', '2018-01-02', '2019-03-12'),
            (3, 1, 'QA', 'comment', '2021-12-13', '2022-02-12');

    INSERT INTO candidate_feedback(id, candidate_id, hr_id, rating, comment)
    VALUES
            (1, 1, 1, 5, 'good'),
            (2, 1, 2, 3, 'bad'),
            (3, 2, 3, 5, 'good'),
            (4, 3, 4, 3, 'bad'),
            (5, 2, 3, 5, 'good');

    INSERT INTO vacancy(id, title, position, salary, creation_date, comment, description, status)
    VALUES
            (1, 'Java Developer', 'Java Developer', 50000, '2021-03-12', 'comment', 'description', 'CLOSE'),
            (2, 'PHP Developer', 'PHP Developer', 60000, '2022-09-01', 'comment', 'description', 'OPEN'),
            (3, 'Javascript Developer', 'Javascript Developer', 70000, '2022-09-05', 'comment', 'description', 'PREPARED');

    INSERT INTO hr_to_vacancy(hr_id, vacancy_id)
    VALUES
            (1, 1),
            (2, 2),
            (3, 3),
            (4, 3);

    INSERT INTO hr_to_role(hr_id, role)
    VALUES
            (1, 'ADMIN'),
            (2, 'ADMIN'),
            (3, 'USER'),
            (4, 'USER');