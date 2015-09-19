-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: gymixx | type: DATABASE --
-- -- DROP DATABASE IF EXISTS gymixx;
-- CREATE DATABASE gymixx
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'en_US.UTF8'
-- 	LC_CTYPE = 'en_US.UTF8'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public.users | type: TABLE --
-- DROP TABLE IF EXISTS public.users CASCADE;
CREATE TABLE public.users(
	id bigserial NOT NULL,
	ext_id varchar NOT NULL,
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	mobile varchar,
	phone varchar,
	email varchar,
	email_verified bool NOT NULL DEFAULT false,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	ptoken varchar,
	is_deleted bool NOT NULL DEFAULT false,
	delete_reason varchar,
	is_inactive bool NOT NULL DEFAULT false,
	inactive_reason varchar,
	id_address bigint NOT NULL,
	username varchar,
	profiles text NOT NULL,
	roles varchar NOT NULL,
	CONSTRAINT user_id_primary PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.users OWNER TO postgres;
-- ddl-end --

-- object: user_extid_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.user_extid_idx CASCADE;
CREATE INDEX user_extid_idx ON public.users
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
	id_users bigint,
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
	country varchar NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	"houseName" varchar,
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
	is_inactive bool NOT NULL DEFAULT false,
	id_users bigint NOT NULL,
	id_offer bigint NOT NULL,
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

-- object: users_fk | type: CONSTRAINT --
-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS users_fk CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT users_fk FOREIGN KEY (id_users)
REFERENCES public.users (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: subscription_uq | type: CONSTRAINT --
-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS subscription_uq CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT subscription_uq UNIQUE (id_users);
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
-- ALTER TABLE public.users DROP CONSTRAINT IF EXISTS address_fk CASCADE;
ALTER TABLE public.users ADD CONSTRAINT address_fk FOREIGN KEY (id_address)
REFERENCES public.address (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: users_uq | type: CONSTRAINT --
-- ALTER TABLE public.users DROP CONSTRAINT IF EXISTS users_uq CASCADE;
ALTER TABLE public.users ADD CONSTRAINT users_uq UNIQUE (id_address);
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

-- object: public.class | type: TABLE --
-- DROP TABLE IF EXISTS public.class CASCADE;
CREATE TABLE public.class(
	id serial NOT NULL,
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
ALTER TABLE public.class OWNER TO postgres;
-- ddl-end --

-- object: studio_fk | type: CONSTRAINT --
-- ALTER TABLE public.class DROP CONSTRAINT IF EXISTS studio_fk CASCADE;
ALTER TABLE public.class ADD CONSTRAINT studio_fk FOREIGN KEY (id_studio)
REFERENCES public.studio (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: public.registration | type: TABLE --
-- DROP TABLE IF EXISTS public.registration CASCADE;
CREATE TABLE public.registration(
	id serial NOT NULL,
	ext_id varchar NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	id_users bigint NOT NULL,
	id_class integer NOT NULL,
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
CREATE INDEX training_ext_id_idx ON public.class
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

-- object: users_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS users_fk CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT users_fk FOREIGN KEY (id_users)
REFERENCES public.users (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: class_fk | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS class_fk CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT class_fk FOREIGN KEY (id_class)
REFERENCES public.class (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: registration_uq | type: CONSTRAINT --
-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT registration_uq UNIQUE (id_class);
-- ddl-end --

-- object: public.oauth2_info | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth2_info CASCADE;
CREATE TABLE public.oauth2_info(
	provider character varying(64) NOT NULL,
	key text NOT NULL,
	access_token text NOT NULL,
	token_type character varying(64),
	expires_in integer,
	refresh_token character varying(64),
	params text,
	created timestamp,
	CONSTRAINT pk_oauth2_info PRIMARY KEY (provider,key)

);
-- ddl-end --
ALTER TABLE public.oauth2_info OWNER TO postgres;
-- ddl-end --

-- object: public.session_info | type: TABLE --
-- DROP TABLE IF EXISTS public.session_info CASCADE;
CREATE TABLE public.session_info(
	id text NOT NULL,
	provider character varying(64) NOT NULL,
	key text NOT NULL,
	last_used timestamp NOT NULL,
	expiration timestamp NOT NULL,
	fingerprint text,
	created timestamp NOT NULL,
	CONSTRAINT pk_session_info PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.session_info OWNER TO postgres;
-- ddl-end --

-- object: public.oauth1_info | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth1_info CASCADE;
CREATE TABLE public.oauth1_info(
	provider character varying(64) NOT NULL,
	key text NOT NULL,
	token text NOT NULL,
	secret text NOT NULL,
	created timestamp NOT NULL,
	CONSTRAINT pk_oauth1_info PRIMARY KEY (provider,key)

);
-- ddl-end --
ALTER TABLE public.oauth1_info OWNER TO postgres;
-- ddl-end --

-- object: public.openid_info | type: TABLE --
-- DROP TABLE IF EXISTS public.openid_info CASCADE;
CREATE TABLE public.openid_info(
	provider character varying(64) NOT NULL,
	key text NOT NULL,
	id text NOT NULL,
	attributes text NOT NULL,
	created timestamp NOT NULL,
	CONSTRAINT pk_openid_info PRIMARY KEY (provider,key)

);
-- ddl-end --
ALTER TABLE public.openid_info OWNER TO postgres;
-- ddl-end --

-- object: public.password_info | type: TABLE --
-- DROP TABLE IF EXISTS public.password_info CASCADE;
CREATE TABLE public.password_info(
	provider character varying(64) NOT NULL,
	key text NOT NULL,
	hasher character varying(64) NOT NULL,
	password character varying(256) NOT NULL,
	salt character varying(256),
	created timestamp NOT NULL,
	CONSTRAINT pk_password_info PRIMARY KEY (provider,key)

);
-- ddl-end --
ALTER TABLE public.password_info OWNER TO postgres;
-- ddl-end --

-- object: public.user_profiles | type: TABLE --
-- DROP TABLE IF EXISTS public.user_profiles CASCADE;
CREATE TABLE public.user_profiles(
	provider character varying(64) NOT NULL,
	key text NOT NULL,
	email character varying(256),
	first_name character varying(512),
	last_name character varying(512),
	full_name character varying(512),
	avatar_url character varying(512),
	created timestamp NOT NULL,
	CONSTRAINT user_profiles_provider_key_idx UNIQUE (provider,key)

);
-- ddl-end --
ALTER TABLE public.user_profiles OWNER TO postgres;
-- ddl-end --

-- object: user_profiles_email_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.user_profiles_email_idx CASCADE;
CREATE INDEX user_profiles_email_idx ON public.user_profiles
	USING btree
	(
	  email
	)	WITH (FILLFACTOR = 90);
-- ddl-end --

-- object: idx_session_info_provider_key | type: INDEX --
-- DROP INDEX IF EXISTS public.idx_session_info_provider_key CASCADE;
CREATE INDEX idx_session_info_provider_key ON public.session_info
	USING btree
	(
	  provider,
	  key
	)	WITH (FILLFACTOR = 90);
-- ddl-end --

-- object: public.requests | type: TABLE --
-- DROP TABLE IF EXISTS public.requests CASCADE;
CREATE TABLE public.requests(
	id uuid NOT NULL,
	auth_provider character varying(64) NOT NULL,
	auth_key text NOT NULL,
	remote_address character varying(64) NOT NULL,
	method character varying(10) NOT NULL,
	host text NOT NULL,
	secure boolean NOT NULL,
	path text NOT NULL,
	query_string text,
	lang text,
	cookie text,
	referrer text,
	user_agent text,
	started timestamp NOT NULL,
	duration integer NOT NULL,
	status integer NOT NULL,
	id_users bigint,
	CONSTRAINT requests_pkey PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.requests OWNER TO postgres;
-- ddl-end --

-- object: users_fk | type: CONSTRAINT --
-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS users_fk CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT users_fk FOREIGN KEY (id_users)
REFERENCES public.users (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: users_profiles_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_profiles_idx CASCADE;
CREATE INDEX users_profiles_idx ON public.users
	USING btree
	(
	  profiles ASC NULLS LAST
	);
-- ddl-end --

-- object: users_username_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_username_idx CASCADE;
CREATE INDEX users_username_idx ON public.users
	USING btree
	(
	  username ASC NULLS LAST
	);
-- ddl-end --

-- object: users_roles_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_roles_idx CASCADE;
CREATE INDEX users_roles_idx ON public.users
	USING btree
	(
	  roles ASC NULLS LAST
	);
-- ddl-end --

-- object: users_fk | type: CONSTRAINT --
-- ALTER TABLE public.requests DROP CONSTRAINT IF EXISTS users_fk CASCADE;
ALTER TABLE public.requests ADD CONSTRAINT users_fk FOREIGN KEY (id_users)
REFERENCES public.users (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: id_users_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.id_users_idx CASCADE;
CREATE INDEX id_users_idx ON public.requests
	USING btree
	(
	  id_users ASC NULLS LAST
	);
-- ddl-end --


