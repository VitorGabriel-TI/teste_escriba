INSERT INTO TB_CARTORIO (nome, observacao, situacao_id)
VALUES ('Cartório do Rio Branco', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório Central da Cidade', 'Observação do Cartório', 'SIT_BLOQUEADO'),
       ('Cartório São Gabriel', '', 'SIT_ATIVO'),
       ('Cartório da União', '', 'SIT_BLOQUEADO'),
       ('Cartório São Lucas', '', 'SIT_ATIVO'),
       ('Cartório do Jardim das Flores', '', 'SIT_BLOQUEADO'),
       ('Cartório Terra Nova', '', 'SIT_ATIVO'),
       ('Cartório São Gabriel', '', 'SIT_BLOQUEADO'),
       ('Cartório Vista Alegre', 'Observação do Cartório', 'SIT_ATIVO'),
       ('Cartório São Pedro', '', 'SIT_BLOQUEADO'),
       ('Cartório Imobiliário', '', 'SIT_ATIVO'),
       ('Cartório de Contas', 'Observação do Cartório', 'SIT_BLOQUEADO');


INSERT INTO TB_ATRIBUICAO_HAS_CARTORIO (cartorio_id, atribuicao_id)
VALUES (1, '1'),
       (1, '2'),
       (2, '2'),
       (2, '3'),
       (3, '3'),
       (4, '4'),
       (5, '5'),
       (6, '6'),
       (7, '7'),
       (8, '1'),
       (9, '2'),
       (10, '1'),
       (11, '4'),
       (12, '5');
