-- Criando a tabela de pessoas

CREATE TABLE public."Pessoas"
(
   
   nome CHARACTER VARYING(30) NOT NULL
   
) 
WITH (
  OIDS = FALSE
)
;

COMMENT ON COLUMN public."Pessoas".nome IS 'nome da pessoa';
  IS 'Tabela de Pessoas';

-- inserte na tabela de pessoas, para teste 

INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 01' );
INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 02' );
INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 03' );
INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 04' );
INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 05' );
INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 06' );
INSERT INTO public."Pessoas" ( nome ) VALUE ( 'Teste 07' );