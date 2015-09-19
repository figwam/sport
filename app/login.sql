-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.8.1
-- PostgreSQL version: 9.4
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: test | type: DATABASE --
-- -- DROP DATABASE IF EXISTS test;
-- CREATE DATABASE test
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'en_US.UTF8'
-- 	LC_CTYPE = 'en_US.UTF8'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

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

-- object: public.users | type: TABLE --
-- DROP TABLE IF EXISTS public.users CASCADE;
CREATE TABLE public.users(
	id uuid NOT NULL,
	username character varying(256),
	profiles text[] NOT NULL,
	roles character varying(64)[] NOT NULL,
	created timestamp NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.users OWNER TO postgres;
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

-- object: users_profiles_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_profiles_idx CASCADE;
CREATE INDEX users_profiles_idx ON public.users
	USING gin
	(
	  profiles
	)	WITH (FILLFACTOR = 90);
-- ddl-end --

-- object: users_username_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_username_idx CASCADE;
CREATE UNIQUE INDEX users_username_idx ON public.users
	USING btree
	(
	  username
	)	WITH (FILLFACTOR = 90);
-- ddl-end --

-- object: users_roles_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.users_roles_idx CASCADE;
CREATE INDEX users_roles_idx ON public.users
	USING gin
	(
	  roles
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
	user_id uuid NOT NULL,
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
	CONSTRAINT requests_pkey PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.requests OWNER TO postgres;
-- ddl-end --

-- object: requests_account_idx | type: INDEX --
-- DROP INDEX IF EXISTS public.requests_account_idx CASCADE;
CREATE INDEX requests_account_idx ON public.requests
	USING btree
	(
	  user_id
	)	WITH (FILLFACTOR = 90);
-- ddl-end --

-- object: requests_users_fk | type: CONSTRAINT --
-- ALTER TABLE public.requests DROP CONSTRAINT IF EXISTS requests_users_fk CASCADE;
ALTER TABLE public.requests ADD CONSTRAINT requests_users_fk FOREIGN KEY (user_id)
REFERENCES public.users (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


