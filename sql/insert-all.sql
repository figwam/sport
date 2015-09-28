-- # --- !Ups

DELETE FROM clazz_definition;
DELETE FROM studio;
DELETE FROM partner;
DELETE FROM address;
DELETE FROM partner_password_info;
DELETE FROM partner_login_info;
DELETE FROM login_info;

select setval('clazz_definition_id_seq',1);
select setval('address_id_seq',1);
select setval('partner_id_seq',1);
select setval('studio_id_seq',1);
select setval('login_info_id_seq',1);
select setval('partner_password_info_id_seq',1);

INSERT INTO address (ext_id,street,zip,state,city,country,longitude,latitude)
	VALUES
		-- Partner Addresses
		('adr00001-5f9a-11e5-9d70-feff819cdc9f','Gesellschaftsstrasse 73','3012',
					'Bern','Bern','Switzerland','46.954995', '7.432121'),
		('adr00002-5f9a-11e5-9d70-feff819cdc9f','Hallerstrasse 1','3012',
		 'Bern','Bern','Switzerland', '46.951679', '7.434954'),
		('adr00003-5f9a-11e5-9d70-feff819cdc9f','Speichergasse 4','3011',
		 'Bern','Bern','Switzerland', '46.950300', '7.442698'),
		-- Studio Addresses
		('adr00004-5f9a-11e5-9d70-feff819cdc9f','Gesellschaftsstrasse 73','3012',
		 'Bern','Bern','Switzerland','46.954995', '7.432121'),
		('adr00005-5f9a-11e5-9d70-feff819cdc9f','Hallerstrasse 1','3012', 'Bern',
		 'Bern','Switzerland', '46.951679', '7.434954'),
		('adr00006-5f9a-11e5-9d70-feff819cdc9f','Speichergasse 4','3011', 'Bern',
		 'Bern','Switzerland', '46.950300', '7.442698');

INSERT INTO partner (ext_id, firstname, lastname, mobile, phone, email,
										 id_address, username,
										 profiles, roles, fullname, avatarurl) VALUES (
	'par00001-5f9a-11e5-9d70-feff819cdc9f','Stefan','Waldner','0791112233','0312223333',
	'stefan@leone.ch',2,'stefan@leone.ch','None','None','Stefan Waldner',
	'http://www.leoneacademy.ch/wp-content/uploads/2013/02/stefu_001.jpg'),

	(	'par00002-5f9a-11e5-9d70-feff819cdc9f','Alexander','Schamne','0791112233','0312223333',
	'alexander.schamne@gmail.com',3,'alexander.schamne@gmail.com','None','None','Alexander Schamne',
	'https://lh3.googleusercontent.com/-tIf-c0HRvWo/AAAAAAAAAAI/AAAAAAAAAHc/sgaIELQzwcQ/photo.jpg'),

	('par00003-5f9a-11e5-9d70-feff819cdc9f','Andreas','Bolt','0791112233','0312223333',
	'andreas.bolt@gmail.com',4,'andreas.bolt@gmail.com','None','None','Andreas Bolt',
	'https://bern.emchberger.ch/sites/default/files/styles/132x174sc/public/bolt_andreas_web.jpg');

INSERT INTO studio (ext_id, name, mobile, phone, email, id_address, id_partner, sporttype, avatarurl,description) VALUES
	('stu00001-5f9a-11e5-9d70-feff819cdc9f','Leone Academy','0791112233','0312223333','leone@leone.ch',5,2,'Kickboxen','http://www.leoneacademy.ch/wp-content/uploads/2013/02/logo.gif','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.'),
	('stu00002-5f9a-11e5-9d70-feff819cdc9f','Alex Outdoor Crossfit','0791112233','0312223333','alex@outdoor.ch',6,3,'Crossfit','http://www.leoneacademy.ch/wp-content/uploads/2013/02/logo.gif','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.'),
	('stu00003-5f9a-11e5-9d70-feff819cdc9f','Bolt Muscle Gym','0791112233','0312223333','bolt@muscle.ch',7,4,'Fitness','http://www.leoneacademy.ch/wp-content/uploads/2013/02/logo.gif','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.');


INSERT INTO login_info (provider_id, provider_key)
	VALUES ('credentials', 'stefan@leone.ch'),
			('credentials', 'alexander.schamne@gmail.com'),
			('credentials', 'andreas.bolt@gmail.com');

INSERT INTO partner_login_info (id_partner, id_login_info)
VALUES (2, 2),(3, 3),(4, 4);

INSERT INTO partner_password_info (id_login_info, hasher, password)
	VALUES (2, 'bcrypt', '$2a$10$IJsMs8yzNR4Twwh1JpQBUej8bKRUtnOLX2IVVU9JiGN06ru2keyLy'),
		(3, 'bcrypt', '$2a$10$IJsMs8yzNR4Twwh1JpQBUej8bKRUtnOLX2IVVU9JiGN06ru2keyLy'),
		(4, 'bcrypt', '$2a$10$IJsMs8yzNR4Twwh1JpQBUej8bKRUtnOLX2IVVU9JiGN06ru2keyLy');

INSERT INTO clazz_definition (ext_id, start_from, end_at, name, recurrence,  contingent, id_studio)
		VALUES ('cld00001-5f9a-11e5-9d70-feff819cdc9f','2015-09-28 17:00:00.000000','2015-09-27 17:45:00.000000',
		'Sandsack','WEEKLY','5',2);



-- Angebote auf unserem Portal
INSERT INTO offer(
	ext_id,
	name,
	nr_access,
	nr_access_same,
	price
) VALUES ('off00001-5f9a-11e5-9d70-feff819cdc9f','Basis',4,2,59),
('off00002-5f9a-11e5-9d70-feff819cdc9f','Standard',6,4,89),
('off00003-5f9a-11e5-9d70-feff819cdc9f','Premium',8,6,119);


-- # --- !Downs

-- DELETE FROM studio;
-- DELETE FROM partner;
-- DELETE FROM address;

