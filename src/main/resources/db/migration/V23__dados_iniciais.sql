INSERT INTO configuracao(cfg_chave, cfg_valor, cfg_descricao) VALUES
('HORARIO_ABERTURA', '18:00', 'Horário de abertura'),
('HORARIO_FECHAMENTO', '23:30', 'Horário de fechamento'),
('TAXA_ENTREGA_PADRAO', '8.00', 'Taxa padrão de entrega'),
('TEMPO_MEDIO_PREPARO', '35', 'Tempo médio de preparo em minutos');

INSERT INTO role(rol_nome, rol_descricao) VALUES
('ROLE_ADMIN', 'Administrador do sistema'),
('ROLE_GERENTE', 'Gerente da operação'),
('ROLE_GARCOM', 'Atendimento de mesas'),
('ROLE_CAIXA', 'Operador de caixa'),
('ROLE_ATENDENTE', 'Atendimento balcão e delivery'),
('ROLE_COZINHA', 'Produção dos pedidos'),
('ROLE_ENTREGADOR', 'Realiza entregas'),
('ROLE_CLIENTE', 'Cliente da pizzaria');

INSERT INTO permissao (per_nome, per_descricao, per_modulo) VALUES
('CARGO_VISUALIZAR', 'Visualizar cargos', 'CARGO'),
('CARGO_CRIAR', 'Criar cargos', 'CARGO'),
('CARGO_EDITAR', 'Editar cargos', 'CARGO'),
('CARGO_EXCLUIR', 'Excluir cargos', 'CARGO');

INSERT INTO permissao(per_nome, per_descricao, per_modulo) VALUES
('DASHBOARD_VISUALIZAR', 'Visualizar dashboard administrativo', 'DASHBOARD'),

('PEDIDO_VISUALIZAR', 'Visualizar pedidos', 'PEDIDO'),
('PEDIDO_CRIAR', 'Criar pedidos', 'PEDIDO'),
('PEDIDO_EDITAR', 'Editar pedidos', 'PEDIDO'),
('PEDIDO_CANCELAR', 'Cancelar pedidos', 'PEDIDO'),
('PEDIDO_FINALIZAR', 'Finalizar pedidos', 'PEDIDO'),

('MESA_VISUALIZAR', 'Visualizar mesas', 'MESA'),
('MESA_ABRIR', 'Abrir mesa', 'MESA'),
('MESA_FECHAR', 'Fechar mesa', 'MESA'),
('MESA_RESERVAR', 'Reservar mesa', 'MESA'),

('DELIVERY_VISUALIZAR', 'Visualizar entregas', 'DELIVERY'),
('DELIVERY_ATUALIZAR', 'Atualizar entrega', 'DELIVERY'),

('PRODUCAO_VISUALIZAR', 'Visualizar produção', 'PRODUCAO'),
('PRODUCAO_ATUALIZAR', 'Atualizar produção', 'PRODUCAO'),

('CAIXA_VISUALIZAR', 'Visualizar caixa', 'CAIXA'),
('CAIXA_ABRIR', 'Abrir caixa', 'CAIXA'),
('CAIXA_FECHAR', 'Fechar caixa', 'CAIXA'),
('CAIXA_LANCAMENTO', 'Lançamento de caixa', 'CAIXA'),

('PRODUTO_VISUALIZAR', 'Visualizar produtos', 'PRODUTO'),
('PRODUTO_CRIAR', 'Criar produtos', 'PRODUTO'),
('PRODUTO_EDITAR', 'Editar produtos', 'PRODUTO'),
('PRODUTO_EXCLUIR', 'Excluir produtos', 'PRODUTO'),

('CATEGORIA_VISUALIZAR', 'Visualizar categorias', 'CATEGORIA'),
('CATEGORIA_CRIAR', 'Criar categorias', 'CATEGORIA'),
('CATEGORIA_EDITAR', 'Editar categorias', 'CATEGORIA'),
('CATEGORIA_EXCLUIR', 'Excluir categorias', 'CATEGORIA'),

('SABOR_VISUALIZAR', 'Visualizar sabores', 'SABOR'),
('SABOR_CRIAR', 'Criar sabores', 'SABOR'),
('SABOR_EDITAR', 'Editar sabores', 'SABOR'),
('SABOR_EXCLUIR', 'Excluir sabores', 'SABOR'),

('TAMANHO_VISUALIZAR', 'Visualizar tamanhos', 'TAMANHO'),
('TAMANHO_CRIAR', 'Criar tamanhos', 'TAMANHO'),
('TAMANHO_EDITAR', 'Editar tamanhos', 'TAMANHO'),
('TAMANHO_EXCLUIR', 'Excluir tamanhos', 'TAMANHO'),

('BORDA_VISUALIZAR', 'Visualizar bordas', 'BORDA'),
('BORDA_CRIAR', 'Criar bordas', 'BORDA'),
('BORDA_EDITAR', 'Editar bordas', 'BORDA'),
('BORDA_EXCLUIR', 'Excluir bordas', 'BORDA'),

('INGREDIENTE_VISUALIZAR', 'Visualizar ingredientes', 'INGREDIENTE'),
('INGREDIENTE_CRIAR', 'Criar ingredientes', 'INGREDIENTE'),
('INGREDIENTE_EDITAR', 'Editar ingredientes', 'INGREDIENTE'),
('INGREDIENTE_EXCLUIR', 'Excluir ingredientes', 'INGREDIENTE'),

('ESTOQUE_VISUALIZAR', 'Visualizar estoque', 'ESTOQUE'),
('ESTOQUE_MOVIMENTAR', 'Movimentar estoque', 'ESTOQUE'),

('FORNECEDOR_VISUALIZAR', 'Visualizar fornecedores', 'FORNECEDOR'),
('FORNECEDOR_CRIAR', 'Criar fornecedores', 'FORNECEDOR'),
('FORNECEDOR_EDITAR', 'Editar fornecedores', 'FORNECEDOR'),
('FORNECEDOR_EXCLUIR', 'Excluir fornecedores', 'FORNECEDOR'),

('CLIENTE_VISUALIZAR', 'Visualizar clientes', 'CLIENTE'),
('CLIENTE_CRIAR', 'Criar clientes', 'CLIENTE'),
('CLIENTE_EDITAR', 'Editar clientes', 'CLIENTE'),
('CLIENTE_EXCLUIR', 'Excluir clientes', 'CLIENTE'),

('FUNCIONARIO_VISUALIZAR', 'Visualizar funcionários', 'FUNCIONARIO'),
('FUNCIONARIO_CRIAR', 'Criar funcionários', 'FUNCIONARIO'),
('FUNCIONARIO_EDITAR', 'Editar funcionários', 'FUNCIONARIO'),
('FUNCIONARIO_EXCLUIR', 'Excluir funcionários', 'FUNCIONARIO'),

('USUARIO_VISUALIZAR', 'Visualizar usuários', 'USUARIO'),
('USUARIO_CRIAR', 'Criar usuários', 'USUARIO'),
('USUARIO_EDITAR', 'Editar usuários', 'USUARIO'),
('USUARIO_EXCLUIR', 'Excluir usuários', 'USUARIO'),

('CUPOM_VISUALIZAR', 'Visualizar cupons', 'CUPOM'),
('CUPOM_CRIAR', 'Criar cupons', 'CUPOM'),
('CUPOM_EDITAR', 'Editar cupons', 'CUPOM'),
('CUPOM_EXCLUIR', 'Excluir cupons', 'CUPOM'),

('PROMOCAO_VISUALIZAR', 'Visualizar promoções', 'PROMOCAO'),
('PROMOCAO_CRIAR', 'Criar promoções', 'PROMOCAO'),
('PROMOCAO_EDITAR', 'Editar promoções', 'PROMOCAO'),
('PROMOCAO_EXCLUIR', 'Excluir promoções', 'PROMOCAO'),

('AVALIACAO_VISUALIZAR', 'Visualizar avaliações', 'AVALIACAO'),
('AVALIACAO_MODERAR', 'Moderar avaliações', 'AVALIACAO'),

('APP_CARDAPIO', 'Acessar cardápio', 'APP_CLIENTE'),
('APP_CARRINHO', 'Gerenciar carrinho', 'APP_CLIENTE'),
('APP_CHECKOUT', 'Realizar checkout', 'APP_CLIENTE'),
('APP_PEDIDOS', 'Visualizar pedidos', 'APP_CLIENTE'),
('APP_CUPONS', 'Visualizar cupons', 'APP_CLIENTE'),
('APP_ENDERECOS', 'Gerenciar endereços', 'APP_CLIENTE'),
('APP_FAVORITOS', 'Gerenciar favoritos', 'APP_CLIENTE'),
('APP_AVALIACOES', 'Criar avaliações', 'APP_CLIENTE'),
('APP_NOTIFICACOES', 'Visualizar notificações', 'APP_CLIENTE'),
('APP_PERFIL', 'Editar perfil', 'APP_CLIENTE');