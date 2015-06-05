-- Database: guestbook

-- DROP DATABASE guestbook;

CREATE DATABASE guestbook
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_India.1252'
       LC_CTYPE = 'English_India.1252'
       CONNECTION LIMIT = -1;

-- Schema: public

-- DROP SCHEMA public;

CREATE SCHEMA public
  AUTHORIZATION postgres;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public
  IS 'standard public schema';

-- Table: tbl_user_comments

-- DROP TABLE tbl_user_comments;

CREATE TABLE tbl_user_comments
(
  id integer NOT NULL,
  comment character varying,
  user_id integer,
  creation_time date DEFAULT ('now'::text)::date,
  CONSTRAINT tbl_user_comments_pkey PRIMARY KEY (id),
  CONSTRAINT tbl_user_comments_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES tbl_users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbl_user_comments
  OWNER TO postgres;

-- Table: tbl_users

-- DROP TABLE tbl_users;

CREATE TABLE tbl_users
(
  id integer NOT NULL,
  address character varying(255) DEFAULT NULL::character varying,
  creation_time date DEFAULT ('now'::text)::date,
  email_address character varying(255) DEFAULT NULL::character varying,
  password character varying(255) DEFAULT NULL::character varying,
  username character varying(255) DEFAULT NULL::character varying,
  CONSTRAINT tbl_users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tbl_users
  OWNER TO postgres;


