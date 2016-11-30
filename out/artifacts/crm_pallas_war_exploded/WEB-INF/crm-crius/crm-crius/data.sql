SET search_path TO crius;

INSERT INTO language VALUES (1, 'русский', FALSE),
(2, 'українська', FALSE),
(3, 'English', FALSE);

INSERT INTO "user" VALUES (DEFAULT, 'Геннадий Петров',
'petrov@adiddas.com.ua', '456', FALSE, '(044) 466-45-46',
'+30974563232', 'some note', FALSE, DEFAULT, 'http://www.someurl.com/someurl', 1);

INSERT INTO company VALUES (DEFAULT, 'Adiddas LTD', '(044)5888-52-85', 'adiddas@adiddas.com.ua', 'Киев, ул. Малышка', 1, 'adiddas.com.ua', FALSE, 1, '2015-02-18 15:36:38');

INSERT INTO currency VALUES (1, 'грн', TRUE, FALSE),
(2, 'usd', TRUE, FALSE),
(3, 'euro', FALSE, FALSE);

INSERT INTO position VALUES (1, 'administrator', FALSE),
(2, 'director', FALSE),
(3, 'sysadmin', FALSE),
(4, 'sales', FALSE);

INSERT INTO contact VALUES (DEFAULT, 'Володимир Грицків', 1, 1, 'mobile', '0505656545', 'gryts.vol', 'some@ukr.net', FALSE, '2015-12-16 20:38:40', 1),
(DEFAULT, 'Майкл Щур', 1, 2, 'mobile', '05055585957', 'michael.shur', 'michael@ukr.net', FALSE, '2016-02-16 15:16:44', 1);

INSERT INTO stage_deals VALUES (1, 'Рассмотрение', FALSE),
(2, 'Оформление', FALSE),
(3, 'В ожидании', FALSE),
(4, 'Закрито', FALSE);

INSERT INTO deal VALUES (DEFAULT, 'small deal', 3, 1, 2500.25, 1, FAlSE, '2016-02-11 10:26:44', 1),
(DEFAULT, 'big deal', 1, 1, 12500, 1, FAlSE, '2016-02-11 10:26:44', 1);

INSERT INTO note VALUES (DEFAULT, 'some note some some note', 1, '2016-02-11 10:26:44', FALSE, 1, 1, 1);

INSERT INTO "right" VALUES (1, 0, FALSE),
(2, 1, FALSE),
(3, 2, FALSE),
(4, 3, FALSE);

INSERT INTO value_rule VALUES (DEFAULT, 1, 1, TRUE, TRUE,
TRUE, TRUE, TRUE, FALSE);

INSERT INTO tag VALUES (DEFAULT, '#general-01', FALSE),
(DEFAULT, '#general-02', FALSE),
(DEFAULT, '#special-01', FALSE);

INSERT INTO task_type VALUES (1, 'Important', FALSE),
(2, 'Urgent', FALSE),
(3, 'Working', FALSE);

INSERT INTO task_status VALUES (1, 'in process', FALSE),
(2, 'DONE', FALSE),
(3, 'postponed', FALSE);

INSERT INTO task VALUES (DEFAULT, 15, 1, 1, 1, 'Выяснить ситуацию', 1, FALSE, '2016-02-11 10:26:44', 1, 1, 1);

INSERT INTO visit_history VALUES (DEFAULT, 1, '2016-02-11 10:26:44', DEFAULT, DEFAULT, FALSE);

INSERT INTO attached_file VALUES (DEFAULT, 1, '2016-02-11 10:26:44', 'Document', DEFAULT, FALSE, DEFAULT, DEFAULT, 1, 1, 1);










 








