# --- !Ups

--INSERT INTO "address" (ext_id,street,zip,state,city,country,longitude,latitude)
--	VALUES ('a1846a6e-5f9a-11e5-9d70-feff819cdc9f','Gesellschaftsstrasse 73','3012','Bern','Bern','Switzerland','46.954995', '7.432121'),
--		('b1846a6e-5f9a-11e5-9d70-feff819cdc9f','Hallerstrasse 1','3012', 'Bern','Bern','Switzerland', '46.951679', '7.434954'),
--		('c1846a6e-5f9a-11e5-9d70-feff819cdc9f','Speichergasse 4','3011', 'Bern','Bern','Switzerland', '46.950300', '7.442698');

# --- !Downs

-- select setval('address_id_seq',1);

