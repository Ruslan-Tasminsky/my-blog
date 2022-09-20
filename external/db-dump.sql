--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE public.account (
    id bigint NOT NULL,
    email character varying(100) NOT NULL,
    name character varying(30) NOT NULL,
    avatar character varying(255),
    created timestamp(0) without time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.account OWNER TO blog;

--
-- Name: account_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE public.account_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_seq OWNER TO blog;

--
-- Name: article; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE public.article (
    id bigint NOT NULL,
    title character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    logo character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    content text NOT NULL,
    id_category integer NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL,
    views bigint DEFAULT 0 NOT NULL,
    comments integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.article OWNER TO blog;

--
-- Name: category; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE public.category (
    id integer NOT NULL,
    name character varying(20) NOT NULL,
    url character varying(20) NOT NULL,
    articles integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.category OWNER TO blog;

--
-- Name: comment; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE public.comment (
    id bigint NOT NULL,
    id_account bigint NOT NULL,
    id_article bigint NOT NULL,
    content text NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.comment OWNER TO blog;

--
-- Name: comment_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE public.comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_seq OWNER TO blog;

--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY public.account (id, email, name, avatar, created) FROM stdin;
\.


--
-- Data for Name: article; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY public.article (id, title, url, logo, description, content, id_category, created, views, comments) FROM stdin;
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY public.category (id, name, url, articles) FROM stdin;
\.


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY public.comment (id, id_account, id_article, content, created) FROM stdin;
\.


--
-- Name: account_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('public.account_seq', 1, false);


--
-- Name: comment_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('public.comment_seq', 1, false);


--
-- Name: account account_email_key; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_email_key UNIQUE (email);


--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- Name: article article_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT article_pkey PRIMARY KEY (id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: category category_url_key; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_url_key UNIQUE (url);


--
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);


--
-- Name: article_idx; Type: INDEX; Schema: public; Owner: blog
--

CREATE INDEX article_idx ON public.article USING btree (id_category);


--
-- Name: comment_idx; Type: INDEX; Schema: public; Owner: blog
--

CREATE INDEX comment_idx ON public.comment USING btree (id_article);


--
-- Name: comment_idx1; Type: INDEX; Schema: public; Owner: blog
--

CREATE INDEX comment_idx1 ON public.comment USING btree (id_account);


--
-- Name: article article_fk; Type: FK CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.article
    ADD CONSTRAINT article_fk FOREIGN KEY (id_category) REFERENCES public.category(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: comment comment_fk; Type: FK CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_fk FOREIGN KEY (id_account) REFERENCES public.account(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- Name: comment comment_fk1; Type: FK CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_fk1 FOREIGN KEY (id_article) REFERENCES public.article(id) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--

