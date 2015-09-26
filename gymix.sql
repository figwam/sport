-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---

-- Database  creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: gymix | type: DATABASE --
-- -- DROP DATABASE IF EXISTS gymix;
-- CREATE DATABASE gymix
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public."user" | type: TABLE --
-- DROP TABLE IF EXISTS public."user" CASCADE;
CREATE TABLE public."user"(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	firstname varchar,
	lastname varchar,
	mobile varchar,
	phone varchar,
	email varchar,
	email_verified bool NOT NULL DEFAULT false,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	ptoken varchar,
	is_deleted bool NOT NULL DEFAULT false,
	delete_reason varchar,
	is_active bool NOT NULL DEFAULT true,
	inactive_reason varchar,
	id_address bigint NOT NULL,
	username varchar,
	profiles text NOT NULL,
	roles varchar NOT NULL,
	fullname varchar,
	"avatarURL" varchar,
	CONSTRAINT user_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public."user" OWNER TO postgres;
-- ddl-end --

-- object: user_extid_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.user_extid_idx CASCADE;
CREATE INDEX user_extid_idx ON public."user"
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: public.studio | type: TABLE --
-- DROP TABLE IF EXISTS public.studio CASCADE;
CREATE TABLE public.studio(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	name varchar NOT NULL,
	mobile smallint,
	phone smallint NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	is_deleted bool NOT NULL DEFAULT false,
	deleted_reason varchar,
	id_address bigint NOT NULL,
	id_user bigint,
	CONSTRAINT studio_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.studio OWNER TO postgres;
-- ddl-end --

-- object: public.address | type: TABLE --
-- DROP TABLE IF EXISTS public.address CASCADE;
CREATE TABLE public.address(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	street varchar NOT NULL,
	housenr varchar NOT NULL,
	zip varchar NOT NULL,
	state varchar NOT NULL,
	country varchar NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	houseName varchar,
	is_deleted boolean NOT NULL DEFAULT false,
	longitude decimal(9,6),
	latitude decimal(9,6),
	CONSTRAINT address_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.address OWNER TO postgres;
-- ddl-end --

-- object: public.offer | type: TABLE --
-- DROP TABLE IF EXISTS public.offer CASCADE;
CREATE TABLE public.offer(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL,
	name varchar NOT NULL,
	nr_access smallint NOT NULL,
	nr_access_same smallint NOT NULL,
	price decimal(5,2) NOT NULL,
	is_deleted bool NOT NULL DEFAULT false,
	CONSTRAINT offer_id_idx PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.offer OWNER TO postgres;
-- ddl-end --

-- object: address_extid_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.address_extid_idx CASCADE;
CREATE INDEX address_extid_idx ON public.address
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: studio_extid_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.studio_extid_idx CASCADE;
CREATE INDEX studio_extid_idx ON public.studio
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: public.subscription | type: TABLE --
-- DROP TABLE IF EXISTS public.subscription CASCADE;
CREATE TABLE public.subscription(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	is_active bool NOT NULL DEFAULT true,
	canceled_on timestamp,
	id_offer bigint NOT NULL,
	id_user bigint NOT NULL,
	CONSTRAINT subscription_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.subscription OWNER TO postgres;
-- ddl-end --

-- object: public.time_stop | type: TABLE --
-- DROP TABLE IF EXISTS public.time_stop CASCADE;
CREATE TABLE public.time_stop(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	stop_on date NOT NULL,
	reason varchar NOT NULL,
	created_on date NOT NULL,
	id_subscription bigint NOT NULL,
	CONSTRAINT timestop_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.time_stop OWNER TO postgres;
-- ddl-end --

-- object: user_fk | type: CONSTRAINT --
-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS user_fk CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES public."user" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: subscription_uq | type: CONSTRAINT --
-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS subscription_uq CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT subscription_uq UNIQUE (id_user);
-- ddl-end --

-- object: offer_fk | type: CONSTRAINT --
-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS offer_fk CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT offer_fk FOREIGN KEY (id_offer)
REFERENCES public.offer (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: subscription_uq1 | type: CONSTRAINT --
-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS subscription_uq1 CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT subscription_uq1 UNIQUE (id_offer);
-- ddl-end --

-- object: subscription_fk | type: CONSTRAINT --
-- ALTER TABLE public.time_stop DROP CONSTRAINT IF EXISTS subscription_fk CASCADE;
ALTER TABLE public.time_stop ADD CONSTRAINT subscription_fk FOREIGN KEY (id_subscription)
REFERENCES public.subscription (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: address_fk | type: CONSTRAINT --
-- ALTER TABLE public."user" DROP CONSTRAINT IF EXISTS address_fk CASCADE;
ALTER TABLE public."user" ADD CONSTRAINT address_fk FOREIGN KEY (id_address)
REFERENCES public.address (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: user_uq | type: CONSTRAINT --
-- ALTER TABLE public."user" DROP CONSTRAINT IF EXISTS user_uq CASCADE;
ALTER TABLE public."user" ADD CONSTRAINT user_uq UNIQUE (id_address);
-- ddl-end --

-- object: address_fk | type: CONSTRAINT --
-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS address_fk CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT address_fk FOREIGN KEY (id_address)
REFERENCES public.address (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: studio_uq | type: CONSTRAINT --
-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS studio_uq CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT studio_uq UNIQUE (id_address);
-- ddl-end --

-- object: public.clazz | type: TABLE --
-- DROP TABLE IF EXISTS public.clazz CASCADE;
CREATE TABLE public.clazz(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	start_from timestamp NOT NULL,
	end_at timestamp NOT NULL,
	name varchar NOT NULL,
	recurring bool NOT NULL DEFAULT true,
	contingent smallint NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	id_studio bigint NOT NULL,
	CONSTRAINT training_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.clazz OWNER TO postgres;
-- ddl-end --

-- object: studio_fk | type: CONSTRAINT --
-- ALTER TABLE public.clazz DROP CONSTRAINT IF EXISTS studio_fk CASCADE;
ALTER TABLE public.clazz ADD CONSTRAINT studio_fk FOREIGN KEY (id_studio)
REFERENCES public.studio (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: public.registration | type: TABLE --
-- DROP TABLE IF EXISTS public.registration CASCADE;
CREATE TABLE public.registration(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	id_user bigint NOT NULL,
	id_clazz bigint NOT NULL,
	CONSTRAINT id_registration_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.registration OWNER TO postgres;
-- ddl-end --

-- object: subscription_ext_id_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.subscription_ext_id_idx CASCADE;
CREATE INDEX subscription_ext_id_idx ON public.subscription
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: offer_ext_id_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.offer_ext_id_idx CASCADE;
CREATE INDEX offer_ext_id_idx ON public.offer
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: timestop_ext_id_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.timestop_ext_id_idx CASCADE;
CREATE INDEX timestop_ext_id_idx ON public.time_stop
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: training_ext_id_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.training_ext_id_idx CASCADE;
CREATE INDEX training_ext_id_idx ON public.clazz
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: registration_ext_id_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.registration_ext_id_idx CASCADE;
CREATE INDEX registration_ext_id_idx ON public.registration
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: user_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS user_fk CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES public."user" (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: clazz_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT clazz_fk FOREIGN KEY (id_clazz)
REFERENCES public.clazz (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT registration_uq UNIQUE (id_clazz);
-- ddl-end --













-- object: public.login_info | type: TABLE --
-- DROP TABLE IF EXISTS public.login_info CASCADE;
CREATE TABLE public.login_info(
	id bigserial NOT NULL,
	provider_id varchar NOT NULL,
	provider_key text NOT NULL,
	last_used timestamp NOT NULL DEFAULT NOW(),
	expiration timestamp NOT NULL DEFAULT NOW(),
	fingerprint text,
	created_on timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_login_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.login_info OWNER TO postgres;
-- ddl-end --

-- object: public.registration | type: TABLE --
-- DROP TABLE IF EXISTS public.registration CASCADE;
CREATE TABLE public.user_login_info(
	created_on timestamp NOT NULL DEFAULT NOW(),
	id_user bigint NOT NULL,
	id_login_info bigint NOT NULL
);
-- ddl-end --
ALTER TABLE public.user_login_info OWNER TO postgres;
-- object: user_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS user_fk CASCADE;
ALTER TABLE public.user_login_info ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES public.user (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --
-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.user_login_info ADD CONSTRAINT user_login_info_user_uq UNIQUE (id_user);
-- ddl-end --

-- object: clazz_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.user_login_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.user_login_info ADD CONSTRAINT user_login_info_user_li_uq UNIQUE (id_login_info);
-- ddl-end --


-- object: public.password_info | type: TABLE --
-- DROP TABLE IF EXISTS public.password_info CASCADE;
CREATE TABLE public.password_info(
	id bigserial NOT NULL,
	id_login_info bigint NOT NULL,
	hasher varchar NOT NULL,
	password varchar NOT NULL,
	salt varchar,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_password_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.password_info OWNER TO postgres;
-- ddl-end --
-- object: clazz_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.password_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.password_info ADD CONSTRAINT password_info_user_li_uq UNIQUE (id_login_info);
-- ddl-end --

-- object: public.oauth2_info | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth2_info CASCADE;
CREATE TABLE public.oauth2_info(
	id bigserial NOT NULL,
	id_login_info bigint NOT NULL,
	access_token text NOT NULL,
	token_type varchar,
	expires_in integer,
	refresh_token varchar,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_oauth2_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.oauth2_info OWNER TO postgres;
-- ddl-end --
-- object: clazz_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.oauth2_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.oauth2_info ADD CONSTRAINT oauth2_info_user_li_uq UNIQUE (id_login_info);
-- ddl-end --
-- object: public.oauth1_info | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth1_info CASCADE;
CREATE TABLE public.oauth1_info(
	id bigserial NOT NULL,
    token varchar NOT NULL,
    secret varchar NOT NULL,
	id_login_info bigint NOT NULL,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_oauth1_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.oauth1_info OWNER TO postgres;
-- ddl-end --
-- object: clazz_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.oauth1_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.oauth1_info ADD CONSTRAINT oauth1_info_user_li_uq UNIQUE (id_login_info);
-- ddl-end --

CREATE TABLE public.openidattributes(
	id varchar NOT NULL,
	key varchar NOT NULL,
	value varchar NOT NULL,
	CONSTRAINT pk_openidattributes_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.openidattributes OWNER TO postgres;

CREATE TABLE public.openidinfo(
	id varchar NOT NULL,
	id_login_info bigint NOT NULL,
	CONSTRAINT pk_openidinfo_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.openidinfo OWNER TO postgres;
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.openidinfo ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.openidinfo ADD CONSTRAINT oidinfo_info_user_li_uq UNIQUE (id_login_info);

-- object: idx_session_info_provider_key | type: INDEX --
-- DROP INDEX IF EXISTS public.idx_session_info_provider_key CASCADE;
CREATE INDEX idx_login_info_provider_key ON public.login_info
	USING btree
	(
	  provider_id,
	  provider_key
	)	WITH (FILLFACTOR = 90);
-- ddl-end --

-- object: user_fk | type: CONSTRAINT --
-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS user_fk CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES public."user" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: users_username_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_username_idx CASCADE;
CREATE INDEX users_username_idx ON public."user"
	USING btree
	(
	  username ASC NULLS LAST
	);
-- ddl-end --

-- object: users_roles_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_roles_idx CASCADE;
CREATE INDEX users_roles_idx ON public."user"
	USING btree
	(
	  roles ASC NULLS LAST
	);
-- ddl-end --

-- object: public.bill | type: TABLE --
-- DROP TABLE IF EXISTS public.bill CASCADE;
CREATE TABLE public.bill(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	amount decimal(5,2) NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	vat smallint NOT NULL,
	id_user bigint,
	CONSTRAINT pk_bill PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public.bill OWNER TO postgres;
-- ddl-end --

-- object: ext_id_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.ext_id_idx CASCADE;
CREATE INDEX ext_id_idx ON public.bill
	USING btree
	(
	  ext_id ASC NULLS LAST
	);
-- ddl-end --

-- object: user_fk | type: CONSTRAINT --
-- ALTER TABLE public.bill DROP CONSTRAINT IF EXISTS user_fk CASCADE;
ALTER TABLE public.bill ADD CONSTRAINT user_fk FOREIGN KEY (id_user)
REFERENCES public."user" (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

drop table public.registration;
drop table public.clazz;
drop table public.studio;
drop table public.user_login_info;
drop table public.bill;
drop table public.time_stop;
drop table public.subscription;
drop table public."user";
drop table public.address;
drop table public.offer;
drop table public.password_info;
drop table public.oauth1_info;
drop table public.oauth2_info;
drop table public.openidinfo;
drop table public.openidattributes;
drop table public.login_info;
