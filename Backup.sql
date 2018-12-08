--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.11
-- Dumped by pg_dump version 9.6.11

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
-- Name: alumno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alumno (
    matricula_alumno bigint NOT NULL,
    a_materno character varying(50) NOT NULL,
    a_paterno character varying(50) NOT NULL,
    nombre character varying(100) NOT NULL,
    id_expediente integer
);


ALTER TABLE public.alumno OWNER TO postgres;

--
-- Name: calificacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.calificacion (
    id_calificacion bigint NOT NULL,
    id_curso bigint NOT NULL,
    matricula_alumno bigint NOT NULL,
    c_obtenida bigint DEFAULT 5 NOT NULL
);


ALTER TABLE public.calificacion OWNER TO postgres;

--
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    id_curso bigint NOT NULL,
    horario character varying(50) NOT NULL,
    nombre character varying(100) NOT NULL,
    matricula_profesor bigint,
    matricula_alumno integer NOT NULL
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- Name: curso_matricula_alumno_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.curso_matricula_alumno_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.curso_matricula_alumno_seq OWNER TO postgres;

--
-- Name: curso_matricula_alumno_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.curso_matricula_alumno_seq OWNED BY public.curso.matricula_alumno;


--
-- Name: expediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expediente (
    direccion character varying(100),
    f_nacimiento character varying(20),
    m_aprobadas bigint,
    m_reprobadas bigint,
    telefono character varying(20),
    id_expediente integer NOT NULL
);


ALTER TABLE public.expediente OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: hibernate_sequences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);


ALTER TABLE public.hibernate_sequences OWNER TO postgres;

--
-- Name: profesor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profesor (
    matricula_profesor bigint NOT NULL,
    a_materno character varying(100) NOT NULL,
    a_paterno character varying(100) NOT NULL,
    direccion character varying(100),
    nombre character varying(50) NOT NULL,
    telefono character varying(20) NOT NULL
);


ALTER TABLE public.profesor OWNER TO postgres;

--
-- Name: curso matricula_alumno; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso ALTER COLUMN matricula_alumno SET DEFAULT nextval('public.curso_matricula_alumno_seq'::regclass);


--
-- Data for Name: alumno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alumno (matricula_alumno, a_materno, a_paterno, nombre, id_expediente) FROM stdin;
2	Tello	Escobar	Israel	\N
6	Tello	Escobar	José Christian	\N
16	Garrido	Garrido	Manuel	17
\.


--
-- Data for Name: calificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.calificacion (id_calificacion, id_curso, matricula_alumno, c_obtenida) FROM stdin;
7	5	6	10
\.


--
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (id_curso, horario, nombre, matricula_profesor, matricula_alumno) FROM stdin;
5	L-V 8:00 - 14:00	Curso Spring Boot	4	6
\.


--
-- Name: curso_matricula_alumno_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.curso_matricula_alumno_seq', 1, true);


--
-- Data for Name: expediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.expediente (direccion, f_nacimiento, m_aprobadas, m_reprobadas, telefono, id_expediente) FROM stdin;
Algo Algo	14/12/1997	15	1	212121212121	17
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 19, true);


--
-- Data for Name: hibernate_sequences; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hibernate_sequences (sequence_name, next_val) FROM stdin;
default	0
\.


--
-- Data for Name: profesor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profesor (matricula_profesor, a_materno, a_paterno, direccion, nombre, telefono) FROM stdin;
4	Tello	Escobar	Calle 5 Cholula	Julio Ivan	2222222222
\.


--
-- Name: alumno alumno_matricula_alumno_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_matricula_alumno_key UNIQUE (matricula_alumno);


--
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (matricula_alumno);


--
-- Name: calificacion calificacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacion
    ADD CONSTRAINT calificacion_pkey PRIMARY KEY (id_calificacion);


--
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id_curso);


--
-- Name: expediente expediente_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expediente
    ADD CONSTRAINT expediente_pk PRIMARY KEY (id_expediente);


--
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);


--
-- Name: profesor profesor_matricula_profesor_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_matricula_profesor_key UNIQUE (matricula_profesor);


--
-- Name: profesor profesor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (matricula_profesor);


--
-- Name: calificacion Calificacion_fkey_alumno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacion
    ADD CONSTRAINT "Calificacion_fkey_alumno" FOREIGN KEY (matricula_alumno) REFERENCES public.alumno(matricula_alumno);


--
-- Name: calificacion Calificacion_fkey_curso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calificacion
    ADD CONSTRAINT "Calificacion_fkey_curso" FOREIGN KEY (id_curso) REFERENCES public.curso(id_curso);


--
-- Name: curso Curso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT "Curso_fkey" FOREIGN KEY (matricula_profesor) REFERENCES public.profesor(matricula_profesor);


--
-- Name: curso Curso_fkey_alumno; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT "Curso_fkey_alumno" FOREIGN KEY (matricula_alumno) REFERENCES public.alumno(matricula_alumno);


--
-- Name: alumno alumno_expediente_id_expediente_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.alumno
    ADD CONSTRAINT alumno_expediente_id_expediente_fk FOREIGN KEY (id_expediente) REFERENCES public.expediente(id_expediente);


--
-- PostgreSQL database dump complete
--

