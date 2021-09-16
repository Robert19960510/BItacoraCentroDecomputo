--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: alumnos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumnos (
    matricula character varying NOT NULL,
    nombre character varying,
    apellido character varying,
    telefono character varying,
    pin integer
);


ALTER TABLE public.alumnos OWNER TO postgres;

--
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipo (
    id_equipo integer NOT NULL,
    num_equipo integer,
    estado integer,
    mantenimiento integer,
    sala integer
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- Name: equipo_id_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipo_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_id_equipo_seq OWNER TO postgres;

--
-- Name: equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipo.id_equipo;


--
-- Name: registro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.registro (
    id_registro integer NOT NULL,
    matricula character varying,
    nombre character varying,
    apellido character varying,
    fecha character varying,
    hora_entrada character varying,
    hora_salida character varying,
    num_equipo integer
);


ALTER TABLE public.registro OWNER TO postgres;

--
-- Name: registro_id_registro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.registro_id_registro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.registro_id_registro_seq OWNER TO postgres;

--
-- Name: registro_id_registro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.registro_id_registro_seq OWNED BY public.registro.id_registro;


--
-- Name: verificar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.verificar (
    id_verificar integer NOT NULL,
    matricula character varying,
    hora character varying,
    fecha character varying
);


ALTER TABLE public.verificar OWNER TO postgres;

--
-- Name: verificar_id_verificar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.verificar_id_verificar_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.verificar_id_verificar_seq OWNER TO postgres;

--
-- Name: verificar_id_verificar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.verificar_id_verificar_seq OWNED BY public.verificar.id_verificar;


--
-- Name: equipo id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo ALTER COLUMN id_equipo SET DEFAULT nextval('public.equipo_id_equipo_seq'::regclass);


--
-- Name: registro id_registro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro ALTER COLUMN id_registro SET DEFAULT nextval('public.registro_id_registro_seq'::regclass);


--
-- Name: verificar id_verificar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verificar ALTER COLUMN id_verificar SET DEFAULT nextval('public.verificar_id_verificar_seq'::regclass);


--
-- Data for Name: alumnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumnos (matricula, nombre, apellido, telefono, pin) FROM stdin;
16-05-0004	Yanitza	mungarro	234234	1234
16-05-0005	Diego	Benites	234234	1234
16-05-0006	miguel	garcia	234234	1234
16-05-0007	dayana	esquivel	234234	1234
16-05-0003	roberto	cordero	243243	1234
16-05-0008	jonathan	garcia	23332	1234
\.


--
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipo (id_equipo, num_equipo, estado, mantenimiento, sala) FROM stdin;
3	3	0	0	1
5	5	0	0	1
7	2	0	0	2
6	1	0	0	2
4	4	0	0	1
10	5	0	0	2
8	3	0	0	2
9	4	0	0	2
2	2	0	0	1
1	1	1	0	1
\.


--
-- Data for Name: registro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.registro (id_registro, matricula, nombre, apellido, fecha, hora_entrada, hora_salida, num_equipo) FROM stdin;
140	16-05-0003	roberto	cordero	31-05-2018	13:21	14:10	1
\.


--
-- Data for Name: verificar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.verificar (id_verificar, matricula, hora, fecha) FROM stdin;
12	16-05-0003	14:10	31-05-2018
\.


--
-- Name: equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipo_id_equipo_seq', 10, true);


--
-- Name: registro_id_registro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.registro_id_registro_seq', 140, true);


--
-- Name: verificar_id_verificar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.verificar_id_verificar_seq', 12, true);


--
-- Name: alumnos alumnos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (matricula);


--
-- Name: equipo equipo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id_equipo);


--
-- Name: registro registro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro
    ADD CONSTRAINT registro_pkey PRIMARY KEY (id_registro);


--
-- Name: verificar verificar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.verificar
    ADD CONSTRAINT verificar_pkey PRIMARY KEY (id_verificar);


--
-- Name: registro fkalumno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro
    ADD CONSTRAINT fkalumno FOREIGN KEY (matricula) REFERENCES public.alumnos(matricula);


--
-- Name: registro fkequipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.registro
    ADD CONSTRAINT fkequipo FOREIGN KEY (num_equipo) REFERENCES public.equipo(id_equipo);


--
-- PostgreSQL database dump complete
--

