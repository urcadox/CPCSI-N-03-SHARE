--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2016-09-12 14:27:32 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 178 (class 3079 OID 11903)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2066 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 16744)
-- Name: don; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE don (
    id integer NOT NULL,
    projet_id integer,
    personne_id integer
);


--
-- TOC entry 177 (class 1259 OID 16747)
-- Name: don_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE don_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2067 (class 0 OID 0)
-- Dependencies: 177
-- Name: don_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE don_id_seq OWNED BY don.id;


--
-- TOC entry 172 (class 1259 OID 16721)
-- Name: personne; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE personne (
    id integer NOT NULL,
    nom character varying(500),
    prenom character varying(500),
    datenaiss date,
    login character varying(100),
    mdp character varying(100)
);


--
-- TOC entry 173 (class 1259 OID 16724)
-- Name: personne_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE personne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2068 (class 0 OID 0)
-- Dependencies: 173
-- Name: personne_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE personne_id_seq OWNED BY personne.id;


--
-- TOC entry 174 (class 1259 OID 16735)
-- Name: projet; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE projet (
    id integer NOT NULL,
    nom character varying(100),
    objectif integer
);


--
-- TOC entry 175 (class 1259 OID 16738)
-- Name: projet_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE projet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2069 (class 0 OID 0)
-- Dependencies: 175
-- Name: projet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE projet_id_seq OWNED BY projet.id;


--
-- TOC entry 1942 (class 2604 OID 16749)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY don ALTER COLUMN id SET DEFAULT nextval('don_id_seq'::regclass);


--
-- TOC entry 1940 (class 2604 OID 16726)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY personne ALTER COLUMN id SET DEFAULT nextval('personne_id_seq'::regclass);


--
-- TOC entry 1941 (class 2604 OID 16740)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY projet ALTER COLUMN id SET DEFAULT nextval('projet_id_seq'::regclass);


--
-- TOC entry 1948 (class 2606 OID 16754)
-- Name: don_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY don
    ADD CONSTRAINT don_pkey PRIMARY KEY (id);


--
-- TOC entry 1944 (class 2606 OID 16734)
-- Name: personne_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id);


--
-- TOC entry 1946 (class 2606 OID 16766)
-- Name: projet_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY projet
    ADD CONSTRAINT projet_pkey PRIMARY KEY (id);


--
-- TOC entry 1949 (class 2606 OID 16755)
-- Name: don_personne_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY don
    ADD CONSTRAINT don_personne_id_fkey FOREIGN KEY (personne_id) REFERENCES personne(id);


--
-- TOC entry 1950 (class 2606 OID 16760)
-- Name: don_personne_id_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY don
    ADD CONSTRAINT don_personne_id_fkey1 FOREIGN KEY (personne_id) REFERENCES personne(id);


-- Completed on 2016-09-12 14:27:32 CEST

--
-- PostgreSQL database dump complete
--

