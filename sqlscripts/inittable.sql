-- Make sure we are using our sergiob database
\c sergiob;

CREATE TABLE IF NOT EXISTS payload
(
    id BIGSERIAL ,
    flowid bigint NOT NULL,
    appname character varying(100) COLLATE pg_catalog."default",
    requesttype character varying(3) COLLATE pg_catalog."default",
    integrationname character varying(100) COLLATE pg_catalog."default",
    payload text COLLATE pg_catalog."default",
    createtime timestamp without time zone,
    CONSTRAINT payload_pkey PRIMARY KEY (id)
)

--TABLESPACE pg_default;

--ALTER TABLE public.payload
--  OWNER to sergiob;
