CREATE ROLE gr_app WITH
    LOGIN
    NOSUPERUSER
    CREATEDB
    NOCREATEROLE
    INHERIT
    NOREPLICATION
    CONNECTION LIMIT -1;

-- Role: regitra_user
-- DROP ROLE IF EXISTS regitra_user;

CREATE ROLE regitra_user WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    CREATEDB
    NOCREATEROLE
    NOREPLICATION
    ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:Cd3lJvxzV3GuiIMIzrW9bA==$0SU0CENO7pfJwYemWQo87KXhDD3Nbxce4x/dTw9xulg=:t0B+uhBPpQEsa9qVq+yvdILhB0TefXq9bI+kiuxwARs=';

GRANT gr_app TO regitra_user;

COMMENT ON ROLE regitra_user IS 'User for our small regitra application';


-- Database: regitra

-- DROP DATABASE IF EXISTS regitra;

CREATE DATABASE regitra
    WITH
    OWNER = gr_app
    ENCODING = 'UTF8'
    LC_COLLATE = 'Lithuanian_Lithuania.1257'
    LC_CTYPE = 'Lithuanian_Lithuania.1257'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GRANT TEMPORARY, CONNECT ON DATABASE regitra TO PUBLIC;

GRANT ALL ON DATABASE regitra TO gr_app;

-- table person create

CREATE TABLE public.person
(
    id bigint NOT NULL,
    name character varying(20) NOT NULL,
    surname character varying(50) NOT NULL,
    age smallint,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.person
    OWNER to gr_app;