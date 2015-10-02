-- # --- !Ups

--
--         d8888      888      888
--        d88888      888      888
--       d88P888      888      888
--      d88P 888  .d88888  .d88888 888d888 .d88b.  .d8888b  .d8888b
--     d88P  888 d88" 888 d88" 888 888P"  d8P  Y8b 88K      88K
--    d88P   888 888  888 888  888 888    88888888 "Y8888b. "Y8888b.
--   d8888888888 Y88b 888 Y88b 888 888    Y8b.          X88      X88
--  d88P     888  "Y88888  "Y88888 888     "Y8888   88888P'  88888P'
--
--
--
CREATE TABLE public.address(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	street text NOT NULL,
	zip text NOT NULL,
	state text NOT NULL,
	city text NOT NULL,
	country text NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	is_deleted boolean NOT NULL DEFAULT false,
	longitude decimal(9,6),
	latitude decimal(9,6),
	CONSTRAINT address_id_primary PRIMARY KEY (id)

);

-- DROP INDEX IF EXISTS public.address_extid_idx CASCADE;
CREATE INDEX address_extid_idx ON public.address
USING btree
(
	ext_id ASC NULLS LAST
);

--
--
--  88888888888              d8b
--      888                  Y8P
--      888
--      888  888d888 8888b.  888 88888b.   .d88b.   .d88b.
--      888  888P"      "88b 888 888 "88b d8P  Y8b d8P  Y8b
--      888  888    .d888888 888 888  888 88888888 88888888
--      888  888    888  888 888 888  888 Y8b.     Y8b.
--      888  888    "Y888888 888 888  888  "Y8888   "Y8888
--
--
--
CREATE TABLE public.trainee(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	firstname text,
	lastname text,
	mobile text,
	phone text,
	email text,
	email_verified bool NOT NULL DEFAULT false,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	ptoken text,
	is_deleted bool NOT NULL DEFAULT false,
	delete_reason text,
	is_active bool NOT NULL DEFAULT true,
	inactive_reason text,
	id_address bigint,
	username text,
	profiles text NOT NULL,
	roles text NOT NULL,
	fullname text,
	avatarurl text,
	CONSTRAINT trainee_id_primary PRIMARY KEY (id)

);

-- DROP INDEX IF EXISTS public.trainee_extid_idx CASCADE;
CREATE INDEX trainee_extid_idx ON public.trainee
USING btree
(
	ext_id ASC NULLS LAST
);
-- DROP INDEX IF EXISTS public.trainee_username_idx CASCADE;
CREATE INDEX trainee_username_idx ON public.trainee
USING btree
(
	username ASC NULLS LAST
);
-- DROP INDEX IF EXISTS public.trainee_roles_idx CASCADE;
CREATE INDEX trainee_roles_idx ON public.trainee
USING btree
(
	roles ASC NULLS LAST
);

-- ALTER TABLE public.trainee DROP CONSTRAINT IF EXISTS trainee_uq CASCADE;
ALTER TABLE public.trainee ADD CONSTRAINT trainee_uq UNIQUE (id_address);

-- ALTER TABLE public.trainee DROP CONSTRAINT IF EXISTS address_fk CASCADE;
ALTER TABLE public.trainee ADD CONSTRAINT trainee_address_fk FOREIGN KEY (id_address)
REFERENCES public.address (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

--
--  8888888b.                  888
--  888   Y88b                 888
--  888    888                 888
--  888   d88P 8888b.  888d888 888888 88888b.   .d88b.  888d888
--  8888888P"     "88b 888P"   888    888 "88b d8P  Y8b 888P"
--  888       .d888888 888     888    888  888 88888888 888
--  888       888  888 888     Y88b.  888  888 Y8b.     888
--  888       "Y888888 888      "Y888 888  888  "Y8888  888
--
--
--
CREATE TABLE public.partner(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	firstname text,
	lastname text,
	mobile text,
	phone text,
	email text,
	email_verified bool NOT NULL DEFAULT false,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	ptoken text,
	is_deleted bool NOT NULL DEFAULT false,
	delete_reason text,
	is_active bool NOT NULL DEFAULT true,
	inactive_reason text,
	id_address bigint,
	username text,
	profiles text NOT NULL,
	roles text NOT NULL,
	fullname text,
	avatarurl text,
	CONSTRAINT partner_id_primary PRIMARY KEY (id)

);

-- DROP INDEX IF EXISTS public.partner_extid_idx CASCADE;
CREATE INDEX partner_extid_idx ON public.partner
USING btree
(
	ext_id ASC NULLS LAST
);
-- DROP INDEX IF EXISTS public.partner_username_idx CASCADE;
CREATE INDEX partner_username_idx ON public.partner
USING btree
(
	username ASC NULLS LAST
);
-- DROP INDEX IF EXISTS public.partner_roles_idx CASCADE;
CREATE INDEX partner_roles_idx ON public.partner
USING btree
(
	roles ASC NULLS LAST
);

-- ALTER TABLE public.partner DROP CONSTRAINT IF EXISTS partner_uq CASCADE;
ALTER TABLE public.partner ADD CONSTRAINT partner_uq UNIQUE (id_address);

-- ALTER TABLE public.partner DROP CONSTRAINT IF EXISTS address_fk CASCADE;
ALTER TABLE public.partner ADD CONSTRAINT partner_address_fk FOREIGN KEY (id_address)
REFERENCES public.address (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

--   .d8888b.  888                  888 d8b
--  d88P  Y88b 888                  888 Y8P
--  Y88b.      888                  888
--   "Y888b.   888888 888  888  .d88888 888  .d88b.
--      "Y88b. 888    888  888 d88" 888 888 d88""88b
--        "888 888    888  888 888  888 888 888  888
--  Y88b  d88P Y88b.  Y88b 888 Y88b 888 888 Y88..88P
--   "Y8888P"   "Y888  "Y88888  "Y88888 888  "Y88P"
--
--
CREATE TABLE public.studio(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	name text NOT NULL,
	mobile text,
	phone text,
	email text,
	sporttype text,
	description text,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	is_deleted bool NOT NULL DEFAULT false,
	deleted_reason text,
	id_address bigint NOT NULL,
	id_partner bigint,
	avatarurl text,
	CONSTRAINT studio_id_primary PRIMARY KEY (id)

);

-- DROP INDEX IF EXISTS public.studio_extid_idx CASCADE;
CREATE INDEX studio_extid_idx ON public.studio
USING btree
(
	ext_id ASC NULLS LAST
);

-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS address_fk CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT address_fk FOREIGN KEY (id_address)
REFERENCES public.address (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS studio_uq CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT studio_uq UNIQUE (id_address);

-- ALTER TABLE public.studio DROP CONSTRAINT IF EXISTS trainee_fk CASCADE;
ALTER TABLE public.studio ADD CONSTRAINT partner_fk FOREIGN KEY (id_partner)
REFERENCES public.partner (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

--   .d88888b.   .d888  .d888
--  d88P" "Y88b d88P"  d88P"
--  888     888 888    888
--  888     888 888888 888888 .d88b.  888d888
--  888     888 888    888   d8P  Y8b 888P"
--  888     888 888    888   88888888 888
--  Y88b. .d88P 888    888   Y8b.     888
--   "Y88888P"  888    888    "Y8888  888
--
--
--
CREATE TABLE public.offer(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	name text NOT NULL,
	nr_access smallint NOT NULL,
	nr_access_same smallint NOT NULL,
	price decimal(5,2) NOT NULL,
	is_deleted bool NOT NULL DEFAULT false,
	CONSTRAINT offer_id_idx PRIMARY KEY (id)

);

-- DROP INDEX IF EXISTS public.offer_ext_id_idx CASCADE;
CREATE INDEX offer_ext_id_idx ON public.offer
USING btree
(
	ext_id ASC NULLS LAST
);

--   .d8888b.           888                                d8b          888    d8b
--  d88P  Y88b          888                                Y8P          888    Y8P
--  Y88b.               888                                             888
--   "Y888b.   888  888 88888b.  .d8888b   .d8888b 888d888 888 88888b.  888888 888  .d88b.  88888b.
--      "Y88b. 888  888 888 "88b 88K      d88P"    888P"   888 888 "88b 888    888 d88""88b 888 "88b
--        "888 888  888 888  888 "Y8888b. 888      888     888 888  888 888    888 888  888 888  888
--  Y88b  d88P Y88b 888 888 d88P      X88 Y88b.    888     888 888 d88P Y88b.  888 Y88..88P 888  888
--   "Y8888P"   "Y88888 88888P"   88888P'  "Y8888P 888     888 88888P"   "Y888 888  "Y88P"  888  888
--                                                             888
--                                                             888
--                                                             888
CREATE TABLE public.subscription(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	is_active bool NOT NULL DEFAULT true,
	canceled_on timestamp,
	id_offer bigint NOT NULL,
	id_trainee bigint NOT NULL,
	CONSTRAINT subscription_id_primary PRIMARY KEY (id)

);

-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS trainee_fk CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT trainee_fk FOREIGN KEY (id_trainee)
REFERENCES public.trainee (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS subscription_uq CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT subscription_uq UNIQUE (id_trainee);

-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS offer_fk CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT offer_fk FOREIGN KEY (id_offer)
REFERENCES public.offer (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.subscription DROP CONSTRAINT IF EXISTS subscription_uq1 CASCADE;
ALTER TABLE public.subscription ADD CONSTRAINT subscription_uq1 UNIQUE (id_offer);

-- DROP INDEX IF EXISTS public.subscription_ext_id_idx CASCADE;
CREATE INDEX subscription_ext_id_idx ON public.subscription
USING btree
(
	ext_id ASC NULLS LAST
);

--  88888888888 d8b                                 888
--      888     Y8P                                 888
--      888                                         888
--      888     888 88888b.d88b.   .d88b.  .d8888b  888888 .d88b.  88888b.
--      888     888 888 "888 "88b d8P  Y8b 88K      888   d88""88b 888 "88b
--      888     888 888  888  888 88888888 "Y8888b. 888   888  888 888  888
--      888     888 888  888  888 Y8b.          X88 Y88b. Y88..88P 888 d88P
--      888     888 888  888  888  "Y8888   88888P'  "Y888 "Y88P"  88888P"
--                                                                 888
--                                                                 888
--                                                                 888
CREATE TABLE public.time_stop(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	stop_on date NOT NULL,
	reason text NOT NULL,
	created_on date NOT NULL,
	id_subscription bigint NOT NULL,
	CONSTRAINT timestop_id_primary PRIMARY KEY (id)

);

-- ALTER TABLE public.time_stop DROP CONSTRAINT IF EXISTS subscription_fk CASCADE;
ALTER TABLE public.time_stop ADD CONSTRAINT subscription_fk FOREIGN KEY (id_subscription)
REFERENCES public.subscription (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- DROP INDEX IF EXISTS public.timestop_ext_id_idx CASCADE;
CREATE INDEX timestop_ext_id_idx ON public.time_stop
USING btree
(
	ext_id ASC NULLS LAST
);


--   .d8888b.  888                                 8888888b.            .d888 d8b          d8b 888    d8b
--  d88P  Y88b 888                                 888  "Y88b          d88P"  Y8P          Y8P 888    Y8P
--  888    888 888                                 888    888          888                     888
--  888        888  8888b.  88888888 88888888      888    888  .d88b.  888888 888 88888b.  888 888888 888  .d88b.  88888b.
--  888        888     "88b    d88P     d88P       888    888 d8P  Y8b 888    888 888 "88b 888 888    888 d88""88b 888 "88b
--  888    888 888 .d888888   d88P     d88P        888    888 88888888 888    888 888  888 888 888    888 888  888 888  888
--  Y88b  d88P 888 888  888  d88P     d88P         888  .d88P Y8b.     888    888 888  888 888 Y88b.  888 Y88..88P 888  888
--   "Y8888P"  888 "Y888888 88888888 88888888      8888888P"   "Y8888  888    888 888  888 888  "Y888 888  "Y88P"  888  888
--
--
--
CREATE TABLE public.clazz_definition(
  id bigserial NOT NULL,
  ext_id text NOT NULL,
  start_from timestamp NOT NULL,
  end_at timestamp NOT NULL,
  active_from timestamp NOT NULL DEFAULT NOW(),
  active_till timestamp,
  name text NOT NULL,
  recurrence text NOT NULL,
  contingent smallint NOT NULL,
  created_on timestamp NOT NULL DEFAULT NOW(),
  updated_on timestamp NOT NULL DEFAULT NOW(),
  id_studio bigint NOT NULL,
  avatarurl text,
  description text,
  tags text,
  deleted_on timestamp,
  CONSTRAINT clazz_definition_id_primary PRIMARY KEY (id)

);

-- ALTER TABLE public.clazz DROP CONSTRAINT IF EXISTS studio_fk CASCADE;
ALTER TABLE public.clazz_definition ADD CONSTRAINT studio_fk FOREIGN KEY (id_studio)
REFERENCES public.studio (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- DROP INDEX IF EXISTS public.clazz_ext_id_idx CASCADE;
CREATE INDEX clazz_definition_ext_id_idx ON public.clazz_definition
USING btree
(
  ext_id ASC NULLS LAST
);
--   .d8888b.  888
--  d88P  Y88b 888
--  888    888 888
--  888        888  8888b.  88888888 88888888
--  888        888     "88b    d88P     d88P
--  888    888 888 .d888888   d88P     d88P
--  Y88b  d88P 888 888  888  d88P     d88P
--   "Y8888P"  888 "Y888888 88888888 88888888
--
--
--
CREATE TABLE public.clazz(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	start_from timestamp NOT NULL,
	end_at timestamp NOT NULL,
	contingent smallint NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	updated_on timestamp NOT NULL DEFAULT NOW(),
	search_meta text NOT NULL,
	id_clazzdef bigint NOT NULL,
	CONSTRAINT clazz_id_primary PRIMARY KEY (id),
  CONSTRAINT uniq_clazz UNIQUE (start_from,end_at, id_clazzdef)

);

-- ALTER TABLE public.clazz DROP CONSTRAINT IF EXISTS clazzdef_fk CASCADE;
ALTER TABLE public.clazz ADD CONSTRAINT clazzdef_fk FOREIGN KEY (id_clazzdef)
REFERENCES public.clazz_definition (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- DROP INDEX IF EXISTS public.clazz_ext_id_idx CASCADE;
CREATE INDEX clazz_ext_id_idx ON public.clazz
USING btree
(
  ext_id ASC NULLS LAST
);
-- DROP INDEX IF EXISTS public.clazz_search_meta_idx CASCADE;
CREATE INDEX clazz_search_meta_idx ON public.clazz
USING btree
(
  search_meta ASC NULLS LAST
);

-- DROP INDEX IF EXISTS public.clazz_clazz_def_id_idx CASCADE;
CREATE INDEX clazz_clazz_def_id_idx ON public.clazz
USING btree
(
  id_clazzdef ASC NULLS LAST
);

--  8888888b.                   d8b          888                    888    d8b
--  888   Y88b                  Y8P          888                    888    Y8P
--  888    888                               888                    888
--  888   d88P .d88b.   .d88b.  888 .d8888b  888888 888d888 8888b.  888888 888  .d88b.  88888b.
--  8888888P" d8P  Y8b d88P"88b 888 88K      888    888P"      "88b 888    888 d88""88b 888 "88b
--  888 T88b  88888888 888  888 888 "Y8888b. 888    888    .d888888 888    888 888  888 888  888
--  888  T88b Y8b.     Y88b 888 888      X88 Y88b.  888    888  888 Y88b.  888 Y88..88P 888  888
--  888   T88b "Y8888   "Y88888 888  88888P'  "Y888 888    "Y888888  "Y888 888  "Y88P"  888  888
--                          888
--                     Y8b d88P
--                      "Y88P"
CREATE TABLE public.registration(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	id_trainee bigint NOT NULL,
	id_clazz bigint NOT NULL,
	CONSTRAINT id_registration_primary PRIMARY KEY (id)

);

-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS trainee_fk CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT trainee_fk FOREIGN KEY (id_trainee)
REFERENCES public.trainee (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS clazz_fk CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT clazz_fk FOREIGN KEY (id_clazz)
REFERENCES public.clazz (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.registration DROP CONSTRAINT IF EXISTS registration_uq CASCADE;
ALTER TABLE public.registration ADD CONSTRAINT registration_uq UNIQUE (id_clazz, id_trainee);

--  DROP INDEX IF EXISTS public.registration_ext_id_idx CASCADE;
CREATE INDEX registration_ext_id_idx ON public.registration
USING btree
(
	ext_id ASC NULLS LAST
);

--  888888b.   d8b 888 888
--  888  "88b  Y8P 888 888
--  888  .88P      888 888
--  8888888K.  888 888 888
--  888  "Y88b 888 888 888
--  888    888 888 888 888
--  888   d88P 888 888 888
--  8888888P"  888 888 888
--
--
--
CREATE TABLE public.bill(
	id bigserial NOT NULL,
	ext_id text NOT NULL,
	amount decimal(5,2) NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	vat smallint NOT NULL,
	id_trainee bigint,
	CONSTRAINT pk_bill PRIMARY KEY (id)
);

-- DROP INDEX IF EXISTS public.ext_id_idx CASCADE;
CREATE INDEX ext_id_idx ON public.bill
USING btree
(
	ext_id ASC NULLS LAST
);

-- ALTER TABLE public.bill DROP CONSTRAINT IF EXISTS trainee_fk CASCADE;
ALTER TABLE public.bill ADD CONSTRAINT trainee_fk FOREIGN KEY (id_trainee)
REFERENCES public.trainee (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;

--  888      .d88888b.   .d8888b.  8888888 888b    888      88888888888     d8888 888888b.   888      8888888888 .d8888b.
--  888     d88P" "Y88b d88P  Y88b   888   8888b   888          888        d88888 888  "88b  888      888       d88P  Y88b
--  888     888     888 888    888   888   88888b  888          888       d88P888 888  .88P  888      888       Y88b.
--  888     888     888 888          888   888Y88b 888          888      d88P 888 8888888K.  888      8888888    "Y888b.
--  888     888     888 888  88888   888   888 Y88b888          888     d88P  888 888  "Y88b 888      888           "Y88b.
--  888     888     888 888    888   888   888  Y88888          888    d88P   888 888    888 888      888             "888
--  888     Y88b. .d88P Y88b  d88P   888   888   Y8888          888   d8888888888 888   d88P 888      888       Y88b  d88P
--  88888888 "Y88888P"   "Y8888P88 8888888 888    Y888          888  d88P     888 8888888P"  88888888 8888888888 "Y8888P"
--
--
--
--  888                       d8b          d8b           .d888
--  888                       Y8P          Y8P          d88P"
--  888                                                 888
--  888      .d88b.   .d88b.  888 88888b.  888 88888b.  888888 .d88b.
--  888     d88""88b d88P"88b 888 888 "88b 888 888 "88b 888   d88""88b
--  888     888  888 888  888 888 888  888 888 888  888 888   888  888
--  888     Y88..88P Y88b 888 888 888  888 888 888  888 888   Y88..88P
--  88888888 "Y88P"   "Y88888 888 888  888 888 888  888 888    "Y88P"
--                        888
--                   Y8b d88P
--                    "Y88P"
CREATE TABLE public.login_info(
	id bigserial NOT NULL,
	provider_id text NOT NULL,
	provider_key text NOT NULL,
	last_used timestamp NOT NULL DEFAULT NOW(),
	expiration timestamp NOT NULL DEFAULT NOW(),
	fingerprint text,
	created_on timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_login_info PRIMARY KEY (id)

);
-- DROP INDEX IF EXISTS public.idx_login_info_provider_key CASCADE;
CREATE INDEX idx_login_info_provider_key ON public.login_info
USING btree
(
	provider_id,
	provider_key
)	WITH (FILLFACTOR = 90);

--  88888888888              d8b                                 888                   d8b          d8b           .d888
--      888                  Y8P                                 888                   Y8P          Y8P          d88P"
--      888                                                      888                                             888
--      888  888d888 8888b.  888 88888b.   .d88b.   .d88b.       888  .d88b.   .d88b.  888 88888b.  888 88888b.  888888 .d88b.
--      888  888P"      "88b 888 888 "88b d8P  Y8b d8P  Y8b      888 d88""88b d88P"88b 888 888 "88b 888 888 "88b 888   d88""88b
--      888  888    .d888888 888 888  888 88888888 88888888      888 888  888 888  888 888 888  888 888 888  888 888   888  888
--      888  888    888  888 888 888  888 Y8b.     Y8b.          888 Y88..88P Y88b 888 888 888  888 888 888  888 888   Y88..88P
--      888  888    "Y888888 888 888  888  "Y8888   "Y8888       888  "Y88P"   "Y88888 888 888  888 888 888  888 888    "Y88P"
--                                                                                 888
--                                                                            Y8b d88P
--                                                                             "Y88P"                                           s
CREATE TABLE public.trainee_login_info(
	created_on timestamp NOT NULL DEFAULT NOW(),
	id_trainee bigint NOT NULL,
	id_login_info bigint NOT NULL
);

-- ALTER TABLE public.trainee_login_info DROP CONSTRAINT IF EXISTS trainee_fk CASCADE;
ALTER TABLE public.trainee_login_info ADD CONSTRAINT trainee_fk FOREIGN KEY (id_trainee)
REFERENCES public.trainee (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.trainee_login_info DROP CONSTRAINT IF EXISTS trainee_login_info_trainee_uq CASCADE;
ALTER TABLE public.trainee_login_info ADD CONSTRAINT trainee_login_info_trainee_uq UNIQUE (id_trainee);

-- ALTER TABLE public.trainee_login_info DROP CONSTRAINT IF EXISTS login_info_fk CASCADE;
ALTER TABLE public.trainee_login_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.trainee_login_info DROP CONSTRAINT IF EXISTS trainee_login_info_trainee_li_uq CASCADE;
ALTER TABLE public.trainee_login_info ADD CONSTRAINT trainee_login_info_trainee_li_uq UNIQUE (id_login_info);

--  88888888888              d8b                                                                                                        888      d8b           .d888
--      888                  Y8P                                                                                                        888      Y8P          d88P"
--      888                                                                                                                             888                   888
--      888  888d888 8888b.  888 88888b.   .d88b.   .d88b.       88888b.   8888b.  .d8888b  .d8888b  888  888  888  .d88b.  888d888 .d88888      888 88888b.  888888 .d88b.
--      888  888P"      "88b 888 888 "88b d8P  Y8b d8P  Y8b      888 "88b     "88b 88K      88K      888  888  888 d88""88b 888P"  d88" 888      888 888 "88b 888   d88""88b
--      888  888    .d888888 888 888  888 88888888 88888888      888  888 .d888888 "Y8888b. "Y8888b. 888  888  888 888  888 888    888  888      888 888  888 888   888  888
--      888  888    888  888 888 888  888 Y8b.     Y8b.          888 d88P 888  888      X88      X88 Y88b 888 d88P Y88..88P 888    Y88b 888      888 888  888 888   Y88..88P
--      888  888    "Y888888 888 888  888  "Y8888   "Y8888       88888P"  "Y888888  88888P'  88888P'  "Y8888888P"   "Y88P"  888     "Y88888      888 888  888 888    "Y88P"
--                                                               888
--                                                               888
--
CREATE TABLE public.trainee_password_info(
	id bigserial NOT NULL,
	id_login_info bigint NOT NULL,
	hasher text NOT NULL,
	password text NOT NULL,
	salt text,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_trainee_password_info PRIMARY KEY (id)

);

-- ALTER TABLE public.trainee_password_info DROP CONSTRAINT IF EXISTS trainee_login_info_fk CASCADE;
ALTER TABLE public.trainee_password_info ADD CONSTRAINT trainee_login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.trainee_password_info DROP CONSTRAINT IF EXISTS trainee_password_info_trainee_li_uq CASCADE;
ALTER TABLE public.trainee_password_info ADD CONSTRAINT trainee_password_info_trainee_li_uq UNIQUE (id_login_info);



--  8888888b.                  888                                   888                   d8b          d8b           .d888
--  888   Y88b                 888                                   888                   Y8P          Y8P          d88P"
--  888    888                 888                                   888                                             888
--  888   d88P 8888b.  888d888 888888 88888b.   .d88b.  888d888      888  .d88b.   .d88b.  888 88888b.  888 88888b.  888888 .d88b.
--  8888888P"     "88b 888P"   888    888 "88b d8P  Y8b 888P"        888 d88""88b d88P"88b 888 888 "88b 888 888 "88b 888   d88""88b
--  888       .d888888 888     888    888  888 88888888 888          888 888  888 888  888 888 888  888 888 888  888 888   888  888
--  888       888  888 888     Y88b.  888  888 Y8b.     888          888 Y88..88P Y88b 888 888 888  888 888 888  888 888   Y88..88P
--  888       "Y888888 888      "Y888 888  888  "Y8888  888          888  "Y88P"   "Y88888 888 888  888 888 888  888 888    "Y88P"
--                                                                                     888
--                                                                                Y8b d88P
--                                                                                 "Y88P"                                                                                                                     "Y88P"                                           s
CREATE TABLE public.partner_login_info(
	created_on timestamp NOT NULL DEFAULT NOW(),
	id_partner bigint NOT NULL,
	id_login_info bigint NOT NULL
);

-- ALTER TABLE public.partner_login_info DROP CONSTRAINT IF EXISTS partner_fk CASCADE;
ALTER TABLE public.partner_login_info ADD CONSTRAINT partner_fk FOREIGN KEY (id_partner)
REFERENCES public.partner (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.partner_login_info DROP CONSTRAINT IF EXISTS partner_login_info_partner_uq CASCADE;
ALTER TABLE public.partner_login_info ADD CONSTRAINT partner_login_info_partner_uq UNIQUE (id_partner);

-- ALTER TABLE public.partner_login_info DROP CONSTRAINT IF EXISTS login_info_fk CASCADE;
ALTER TABLE public.partner_login_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.partner_login_info DROP CONSTRAINT IF EXISTS partner_login_info_partner_li_uq CASCADE;
ALTER TABLE public.partner_login_info ADD CONSTRAINT partner_login_info_partner_li_uq UNIQUE (id_login_info);

--  8888888b.                  888                                                                                                          888
--  888   Y88b                 888                                                                                                          888
--  888    888                 888                                                                                                          888
--  888   d88P 8888b.  888d888 888888 88888b.   .d88b.  888d888      88888b.   8888b.  .d8888b  .d8888b  888  888  888  .d88b.  888d888 .d88888
--  8888888P"     "88b 888P"   888    888 "88b d8P  Y8b 888P"        888 "88b     "88b 88K      88K      888  888  888 d88""88b 888P"  d88" 888
--  888       .d888888 888     888    888  888 88888888 888          888  888 .d888888 "Y8888b. "Y8888b. 888  888  888 888  888 888    888  888
--  888       888  888 888     Y88b.  888  888 Y8b.     888          888 d88P 888  888      X88      X88 Y88b 888 d88P Y88..88P 888    Y88b 888
--  888       "Y888888 888      "Y888 888  888  "Y8888  888          88888P"  "Y888888  88888P'  88888P'  "Y8888888P"   "Y88P"  888     "Y88888
--                                                                   888
--                                                                   888
--                                                                   888
CREATE TABLE public.partner_password_info(
	id bigserial NOT NULL,
	id_login_info bigint NOT NULL,
	hasher text NOT NULL,
	password text NOT NULL,
	salt text,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_partner_password_info PRIMARY KEY (id)

);

-- ALTER TABLE public.partner_password_info DROP CONSTRAINT IF EXISTS partner_login_info_fk CASCADE;
ALTER TABLE public.partner_password_info ADD CONSTRAINT partner_login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.partner_password_info DROP CONSTRAINT IF EXISTS partner_password_info_partner_li_uq CASCADE;
ALTER TABLE public.partner_password_info ADD CONSTRAINT partner_password_info_partner_li_uq UNIQUE (id_login_info);

--   .d88888b.        d8888          888    888       .d8888b.       d8b           .d888
--  d88P" "Y88b      d88888          888    888      d88P  Y88b      Y8P          d88P"
--  888     888     d88P888          888    888             888                   888
--  888     888    d88P 888 888  888 888888 88888b.       .d88P      888 88888b.  888888 .d88b.
--  888     888   d88P  888 888  888 888    888 "88b  .od888P"       888 888 "88b 888   d88""88b
--  888     888  d88P   888 888  888 888    888  888 d88P"           888 888  888 888   888  888
--  Y88b. .d88P d8888888888 Y88b 888 Y88b.  888  888 888"            888 888  888 888   Y88..88P
--   "Y88888P" d88P     888  "Y88888  "Y888 888  888 888888888       888 888  888 888    "Y88P"
--
--
--
-- DROP TABLE IF EXISTS public.oauth2_info CASCADE;
CREATE TABLE public.oauth2_info(
	id bigserial NOT NULL,
	id_login_info bigint NOT NULL,
	access_token text NOT NULL,
	token_type text,
	expires_in integer,
	refresh_token text,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_oauth2_info PRIMARY KEY (id)

);

-- ALTER TABLE public.oauth2_info DROP CONSTRAINT IF EXISTS login_info_fk CASCADE;
ALTER TABLE public.oauth2_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.oauth2_info DROP CONSTRAINT IF EXISTS oauth2_info_trainee_li_uq CASCADE;
ALTER TABLE public.oauth2_info ADD CONSTRAINT oauth2_info_trainee_li_uq UNIQUE (id_login_info);

--   .d88888b.        d8888          888    888       d888        d8b           .d888
--  d88P" "Y88b      d88888          888    888      d8888        Y8P          d88P"
--  888     888     d88P888          888    888        888                     888
--  888     888    d88P 888 888  888 888888 88888b.    888        888 88888b.  888888 .d88b.
--  888     888   d88P  888 888  888 888    888 "88b   888        888 888 "88b 888   d88""88b
--  888     888  d88P   888 888  888 888    888  888   888        888 888  888 888   888  888
--  Y88b. .d88P d8888888888 Y88b 888 Y88b.  888  888   888        888 888  888 888   Y88..88P
--   "Y88888P" d88P     888  "Y88888  "Y888 888  888 8888888      888 888  888 888    "Y88P"
--
--
--
-- DROP TABLE IF EXISTS public.oauth1_info CASCADE;
CREATE TABLE public.oauth1_info(
	id bigserial NOT NULL,
	token text NOT NULL,
	secret text NOT NULL,
	id_login_info bigint NOT NULL,
	created timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT pk_oauth1_info PRIMARY KEY (id)

);
-- ALTER TABLE public.oauth1_info DROP CONSTRAINT IF EXISTS login_info_fk CASCADE;
ALTER TABLE public.oauth1_info ADD CONSTRAINT login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;

-- ALTER TABLE public.oauth1_info DROP CONSTRAINT IF EXISTS oauth1_info_trainee_li_uq CASCADE;
ALTER TABLE public.oauth1_info ADD CONSTRAINT oauth1_info_trainee_li_uq UNIQUE (id_login_info);

--   .d88888b.                             d8b      888             d8888 888    888            d8b 888               888
--  d88P" "Y88b                            Y8P      888            d88888 888    888            Y8P 888               888
--  888     888                                     888           d88P888 888    888                888               888
--  888     888 88888b.   .d88b.  88888b.  888  .d88888          d88P 888 888888 888888 888d888 888 88888b.  888  888 888888 .d88b.  .d8888b
--  888     888 888 "88b d8P  Y8b 888 "88b 888 d88" 888         d88P  888 888    888    888P"   888 888 "88b 888  888 888   d8P  Y8b 88K
--  888     888 888  888 88888888 888  888 888 888  888        d88P   888 888    888    888     888 888  888 888  888 888   88888888 "Y8888b.
--  Y88b. .d88P 888 d88P Y8b.     888  888 888 Y88b 888       d8888888888 Y88b.  Y88b.  888     888 888 d88P Y88b 888 Y88b. Y8b.          X88
--   "Y88888P"  88888P"   "Y8888  888  888 888  "Y88888      d88P     888  "Y888  "Y888 888     888 88888P"   "Y88888  "Y888 "Y8888   88888P'
--              888
--              888
--              888
CREATE TABLE public.openidattributes(
	id text NOT NULL,
	key text NOT NULL,
	value text NOT NULL,
	CONSTRAINT pk_openidattributes_info PRIMARY KEY (id)

);

--   .d88888b.                             d8b      888      8888888           .d888
--  d88P" "Y88b                            Y8P      888        888            d88P"
--  888     888                                     888        888            888
--  888     888 88888b.   .d88b.  88888b.  888  .d88888        888   88888b.  888888 .d88b.
--  888     888 888 "88b d8P  Y8b 888 "88b 888 d88" 888        888   888 "88b 888   d88""88b
--  888     888 888  888 88888888 888  888 888 888  888        888   888  888 888   888  888
--  Y88b. .d88P 888 d88P Y8b.     888  888 888 Y88b 888        888   888  888 888   Y88..88P
--   "Y88888P"  88888P"   "Y8888  888  888 888  "Y88888      8888888 888  888 888    "Y88P"
--              888
--              888
--              888

CREATE TABLE public.openidinfo(
	id text NOT NULL,
	id_login_info bigint NOT NULL,
	CONSTRAINT pk_openidinfo_info PRIMARY KEY (id)

);

-- ALTER TABLE public.openidinfo DROP CONSTRAINT IF EXISTS oidinfo_info_trainee_li_uq CASCADE;
ALTER TABLE public.openidinfo ADD CONSTRAINT oidinfo_info_trainee_li_uq UNIQUE (id_login_info);

-- ALTER TABLE public.openidinfo DROP CONSTRAINT IF EXISTS login_info_fk CASCADE;
ALTER TABLE public.openidinfo ADD CONSTRAINT oidinfo_info_login_info_fk FOREIGN KEY (id_login_info)
REFERENCES public.login_info (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;


--  888
--  888
--  888
--  888      .d88b.   .d88b.   .d88b.   .d88b.  888d888
--  888     d88""88b d88P"88b d88P"88b d8P  Y8b 888P"
--  888     888  888 888  888 888  888 88888888 888
--  888     Y88..88P Y88b 888 Y88b 888 Y8b.     888
--  88888888 "Y88P"   "Y88888  "Y88888  "Y8888  888
--                        888      888
--                   Y8b d88P Y8b d88P
--                    "Y88P"   "Y88P"
-- This Table is for error logging purpose. All errors will be logged here
-- and can be analyzed afterwards. To make the system stable.
CREATE TABLE public.logger(
	id bigserial NOT NULL,
	rootid text NOT NULL,
	title text NOT NULL,
	exception text NOT NULL,
	stacktrace text NOT NULL,
	req_header text NOT NULL,
	req_method text NOT NULL,
	req_address text NOT NULL,
	req_uri text NOT NULL,
	created_on timestamp NOT NULL DEFAULT NOW(),
	CONSTRAINT logger_id_primary PRIMARY KEY (id)

);

CREATE EXTENSION "uuid-ossp";



--  888     888 8888888 8888888888 888       888  .d8888b.
--  888     888   888   888        888   o   888 d88P  Y88b
--  888     888   888   888        888  d8b  888 Y88b.
--  Y88b   d88P   888   8888888    888 d888b 888  "Y888b.
--   Y88b d88P    888   888        888d88888b888     "Y88b.
--    Y88o88P     888   888        88888P Y88888       "888
--     Y888P      888   888        8888P   Y8888 Y88b  d88P
--      Y8P     8888888 8888888888 888P     Y888  "Y8888P"
--
--
--

--   .d8888b.  888                                 888     888 d8b
--  d88P  Y88b 888                                 888     888 Y8P
--  888    888 888                                 888     888
--  888        888  8888b.  88888888 88888888      Y88b   d88P 888  .d88b.  888  888  888
--  888        888     "88b    d88P     d88P        Y88b d88P  888 d8P  Y8b 888  888  888
--  888    888 888 .d888888   d88P     d88P          Y88o88P   888 88888888 888  888  888
--  Y88b  d88P 888 888  888  d88P     d88P            Y888P    888 Y8b.     Y88b 888 d88P
--   "Y8888P"  888 "Y888888 88888888 88888888          Y8P     888  "Y8888   "Y8888888P"
--
--
--
CREATE VIEW clazz_view AS
	select c.id, c.ext_id, c.start_from, c.end_at, cd.name, c.contingent,
		cd.avatarurl, cd.description, cd.tags, c.search_meta, nr_of_regs, c.id_clazzdef
	from (
				 select c.id, c.ext_id, c.start_from, c.end_at, c.contingent,
					 c.created_on, c.updated_on, c.search_meta, c.id_clazzdef,
					 count(r.id_clazz) as nr_of_regs
				 from clazz c
					 left join registration r on r.id_clazz = c.id
				 group by c.id) as c, clazz_definition cd
	where c.id_clazzdef = cd.id;

-- # --- !Downs

-- DROP TABLE IF EXISTS public.logger CASCADE;
-- DROP TABLE IF EXISTS public.registration CASCADE;
-- DROP TABLE IF EXISTS public.clazz CASCADE;
-- DROP TABLE IF EXISTS public.studio CASCADE;
-- DROP TABLE IF EXISTS public.trainee_login_info CASCADE;
-- DROP TABLE IF EXISTS public.bill CASCADE;
-- DROP TABLE IF EXISTS public.time_stop CASCADE;
-- DROP TABLE IF EXISTS public.subscription CASCADE;
-- DROP TABLE IF EXISTS public.trainee CASCADE;
-- DROP TABLE IF EXISTS public.address CASCADE;
-- DROP TABLE IF EXISTS public.offer CASCADE;
-- DROP TABLE IF EXISTS public.password_info CASCADE;
-- DROP TABLE IF EXISTS public.oauth1_info CASCADE;
-- DROP TABLE IF EXISTS public.oauth2_info CASCADE;
-- DROP TABLE IF EXISTS public.openidinfo CASCADE;
-- DROP TABLE IF EXISTS public.openidattributes CASCADE;
-- DROP TABLE IF EXISTS public.login_info CASCADE;
