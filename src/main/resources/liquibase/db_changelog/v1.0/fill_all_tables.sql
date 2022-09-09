    INSERT INTO vacancy(id, title, position, salary, creation_date, description, status)
    VALUES
            (1, 'Java Developer', 'Java Developer', 50000, '2021-03-12', 'description', 'CLOSE'),
            (2, 'PHP Developer', 'PHP Developer', 60000, '2022-09-01', 'description', 'OPEN'),
            (3, 'Javascript Developer', 'Javascript Developer', 70000, '2022-09-05', 'description', 'PREPARED');


    INSERT INTO hr(id, first_name, lastname, login, password, creation_date)
    VALUES
           (1, 'Ivan', 'Ivanov', 'ivan@yandex.ru', '1234',  '2020-10-27 02:00:00'),
           (2, 'Aleksandr', 'Sidorov', 'alexs@yandex.ru', '2425',  '2021-11-13 02:00:00'),
           (3, 'Dmitry', 'Androsov', 'da@yandex.ru', 'user',  '2020-08-21 02:00:00'),
           (4, 'Ivan', 'Petrov', 'ivan@yandex.ru', '21646',  '2021-10-15 02:00:00');


    INSERT INTO candidate(id, first_name, lastname, email, position, salary, creation_date,
                          hr_id, status, vacancy_id)
    VALUES
            (1, 'Aleksey', 'Smirnov', 'smirnov@yandex.ru', 'Java Developer', 75000, '2020-08-21 12:00:00',
             1, 'NEW', 1),
            (2, 'Alek', 'Smir', 'smirnov@ya.ru', 'PHP Developer', 70000, '2020-08-21 12:01:00',
             1, 'NEW', 1),

    INSERT INTO hr_to_vacancy(hr_id, vacancy_id)
    VALUES
            (1, 1),
            (2, 2),
            (3, 3),
            (4, 3);