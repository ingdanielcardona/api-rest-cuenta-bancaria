PGDMP     -    %                y            mibanco    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24576    mibanco    DATABASE     f   CREATE DATABASE mibanco WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE mibanco;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    32776    accounts    TABLE     �   CREATE TABLE public.accounts (
    id character varying NOT NULL,
    amount double precision NOT NULL,
    customerid character varying NOT NULL,
    openedat date NOT NULL
);
    DROP TABLE public.accounts;
       public         heap    postgres    false    3            �            1259    24577 	   customers    TABLE     �   CREATE TABLE public.customers (
    id character varying NOT NULL,
    name character varying,
    lastname character varying,
    email character varying
);
    DROP TABLE public.customers;
       public         heap    postgres    false    3            �            1259    32768    transacciones    TABLE     �   CREATE TABLE public.transacciones (
    numero character varying NOT NULL,
    numerocuenta character varying,
    tipo character varying,
    monto double precision,
    fecha date
);
 !   DROP TABLE public.transacciones;
       public         heap    postgres    false    3            �          0    32776    accounts 
   TABLE DATA           D   COPY public.accounts (id, amount, customerid, openedat) FROM stdin;
    public          postgres    false    202            �          0    24577 	   customers 
   TABLE DATA           >   COPY public.customers (id, name, lastname, email) FROM stdin;
    public          postgres    false    200            �          0    32768    transacciones 
   TABLE DATA           Q   COPY public.transacciones (numero, numerocuenta, tipo, monto, fecha) FROM stdin;
    public          postgres    false    201            0           2606    32783    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    202            ,           2606    24584    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    200            .           2606    32775     transacciones transacciones_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.transacciones
    ADD CONSTRAINT transacciones_pkey PRIMARY KEY (numero);
 J   ALTER TABLE ONLY public.transacciones DROP CONSTRAINT transacciones_pkey;
       public            postgres    false    201            �   *   x�3�4�000�4426�4202�50�50�2�4�&���� ��      �   3   x�3426�LI��L��LN,J��K���K��8d��&f��%��r��qqq s7#      �   I  x����nAEk�_<��o�_p�F�@�
������N��v���2fXe��3�̓������k�\�����;���H��2������2�0�L�EM�5ݛy�~ߟ���U��8�3z��ØnHS��3�[���P/���P�|}^�����m��/���S���';br!%�u��?H�B�('��_ǹ >2(�U�f��#���������$���d0���<��(K�4F��q߉uZV4�J����bH�X	Ei�.d5T�[ӣewqd��@R*�g�8t��p�F�a�A,�=!M�s4'=��$2�P������#��8�� E�          �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24576    mibanco    DATABASE     f   CREATE DATABASE mibanco WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE mibanco;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    32776    accounts    TABLE     �   CREATE TABLE public.accounts (
    id character varying NOT NULL,
    amount double precision NOT NULL,
    customerid character varying NOT NULL,
    openedat date NOT NULL
);
    DROP TABLE public.accounts;
       public         heap    postgres    false    3            �            1259    24577 	   customers    TABLE     �   CREATE TABLE public.customers (
    id character varying NOT NULL,
    name character varying,
    lastname character varying,
    email character varying
);
    DROP TABLE public.customers;
       public         heap    postgres    false    3            �            1259    32768    transacciones    TABLE     �   CREATE TABLE public.transacciones (
    numero character varying NOT NULL,
    numerocuenta character varying,
    tipo character varying,
    monto double precision,
    fecha date
);
 !   DROP TABLE public.transacciones;
       public         heap    postgres    false    3            �          0    32776    accounts 
   TABLE DATA           D   COPY public.accounts (id, amount, customerid, openedat) FROM stdin;
    public          postgres    false    202   �       �          0    24577 	   customers 
   TABLE DATA           >   COPY public.customers (id, name, lastname, email) FROM stdin;
    public          postgres    false    200   4        �          0    32768    transacciones 
   TABLE DATA           Q   COPY public.transacciones (numero, numerocuenta, tipo, monto, fecha) FROM stdin;
    public          postgres    false    201   =        0           2606    32783    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    202            ,           2606    24584    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    200            .           2606    32775     transacciones transacciones_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.transacciones
    ADD CONSTRAINT transacciones_pkey PRIMARY KEY (numero);
 J   ALTER TABLE ONLY public.transacciones DROP CONSTRAINT transacciones_pkey;
       public            postgres    false    201           