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
		(uuid_generate_v1(),'Gesellschaftsstrasse 73','3012',
					'Bern','Bern','Switzerland','46.954995', '7.432121'),
		(uuid_generate_v1(),'Hallerstrasse 1','3012',
		 'Bern','Bern','Switzerland', '46.951679', '7.434954'),
		(uuid_generate_v1(),'Speichergasse 4','3011',
		 'Bern','Bern','Switzerland', '46.950300', '7.442698'),
		-- Studio Addresses
		(uuid_generate_v1(),'Gesellschaftsstrasse 73','3012',
		 'Bern','Bern','Switzerland','46.954995', '7.432121'),
		(uuid_generate_v1(),'Hallerstrasse 1','3012', 'Bern',
		 'Bern','Switzerland', '46.951679', '7.434954'),
		(uuid_generate_v1(),'Speichergasse 4','3011', 'Bern',
		 'Bern','Switzerland', '46.950300', '7.442698');

INSERT INTO partner (ext_id, firstname, lastname, mobile, phone, email,
										 id_address, username,
										 profiles, roles, fullname, avatarurl) VALUES (
	uuid_generate_v1(),'Stefan','Waldner','0791112233','0312223333',
	'stefan@leone.ch',2,'stefan@leone.ch','None','None','Stefan Waldner',
	'http://www.leoneacademy.ch/wp-content/uploads/2013/02/stefu_001.jpg'),

	(	uuid_generate_v1(),'Alexander','Schamne','0791112233','0312223333',
	'alexander.schamne@gmail.com',3,'alexander.schamne@gmail.com','None','None','Alexander Schamne',
	'https://lh3.googleusercontent.com/-tIf-c0HRvWo/AAAAAAAAAAI/AAAAAAAAAHc/sgaIELQzwcQ/photo.jpg'),

	(uuid_generate_v1(),'Andreas','Bolt','0791112233','0312223333',
	'andreas.bolt@gmail.com',4,'andreas.bolt@gmail.com','None','None','Andreas Bolt',
	'https://bern.emchberger.ch/sites/default/files/styles/132x174sc/public/bolt_andreas_web.jpg');

INSERT INTO studio (ext_id, name, mobile, phone, email, id_address, id_partner, sporttype, avatarurl,description) VALUES
	(uuid_generate_v1(),'Leone Academy','0791112233','0312223333','leone@leone.ch',5,2,'Kickboxen','http://www.leoneacademy.ch/wp-content/uploads/2013/02/logo.gif','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.'),
	(uuid_generate_v1(),'Alex Outdoor Crossfit','0791112233','0312223333','alex@outdoor.ch',6,3,'Crossfit','http://www.leoneacademy.ch/wp-content/uploads/2013/02/logo.gif','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.'),
	(uuid_generate_v1(),'Bolt Muscle Gym','0791112233','0312223333','bolt@muscle.ch',7,4,'Fitness','http://www.leoneacademy.ch/wp-content/uploads/2013/02/logo.gif','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.');

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

INSERT INTO clazz_definition (ext_id, active_from, active_till, start_from, end_at, name, recurrence,  contingent, avatarurl, description, id_studio)
		VALUES (uuid_generate_v1(),'2015-09-28 17:00:00.000000','2016-09-27 17:45:00.000000','2015-09-28 17:00:00.000000','2016-09-27 17:45:00.000000',
		'Sandsack','WEEKLY','5','https://www.ywcampls.org/_asset/x953xn/Fitness-page-image.jpg','Trainiere am Sandsack bla bla Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.',2),
			(uuid_generate_v1(),'2015-10-05 17:00:00.000000','2016-09-27 17:45:00.000000','2015-09-25 16:00:00.000000','2015-09-25 17:30:00.000000',
			 'Fitness','WEEKLY','3','https://www.ywcampls.org/_asset/x953xn/Fitness-page-image.jpg','Fitnes Rocks, just do it. bla bla Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.',3),
			(uuid_generate_v1(),'2015-09-23 14:00:00.000000','2015-09-23 15:00:00.000000','2015-09-23 14:00:00.000000','2015-09-23 15:00:00.000000',
			 'Calistenics 4 All','ONETIME','20','https://www.ywcampls.org/_asset/x953xn/Fitness-page-image.jpg','Calistencis outdor ist eine vielseitige Sportart mit eigenem Körpergewicht. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.',4);
;



-- Angebote auf unserem Portal
INSERT INTO offer(
	ext_id,
	name,
	nr_access,
	nr_access_same,
	price
) VALUES (uuid_generate_v1(),'Basis',4,2,59),
(uuid_generate_v1(),'Standard',6,4,89),
(uuid_generate_v1(),'Premium',8,6,119);


-- # --- !Downs

-- DELETE FROM studio;
-- DELETE FROM partner;
-- DELETE FROM address;

