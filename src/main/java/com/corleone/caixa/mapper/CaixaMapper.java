package com.corleone.caixa.mapper;

import com.corleone.caixa.dto.*;
import com.corleone.caixa.entity.Caixa;
import com.corleone.caixa.entity.LancamentoCaixa;
import com.corleone.funcionario.entity.Funcionario;
import com.corleone.pagamento.entity.Pagamento;
import com.corleone.pedido.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CaixaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "dataAbertura", ignore = true)
    @Mapping(target = "dataFechamento", ignore = true)
    @Mapping(target = "valorFechamento", ignore = true)
    @Mapping(target = "valorSistema", ignore = true)
    @Mapping(target = "diferenca", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "lancamentos", ignore = true)
    Caixa toEntity(CaixaRequest request, Funcionario funcionario);

    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    CaixaResponse toResponse(Caixa caixa);

    @Mapping(target = "funcionario", source = "funcionario.nome")
    CaixaResumoResponse toResumoResponse(Caixa caixa);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "dataAbertura", ignore = true)
    @Mapping(target = "dataFechamento", ignore = true)
    @Mapping(target = "valorFechamento", ignore = true)
    @Mapping(target = "valorSistema", ignore = true)
    @Mapping(target = "diferenca", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "lancamentos", ignore = true)
    void updateEntity(@MappingTarget Caixa caixa, CaixaRequest request, Funcionario funcionario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "caixa", source = "caixa")
    @Mapping(target = "funcionario", source = "funcionario")
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "pagamento", source = "pagamento")
    @Mapping(target = "data", ignore = true)
    LancamentoCaixa toEntity(LancamentoCaixaRequest request, Caixa caixa, Funcionario funcionario, Pedido pedido, Pagamento pagamento);

    @Mapping(target = "caixaId", source = "caixa.id")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    @Mapping(target = "pedidoId", source = "pedido.id")
    @Mapping(target = "pagamentoId", source = "pagamento.id")
    @Mapping(target = "pagamento", source = "pagamento.nome")
    LancamentoCaixaResponse toResponse(LancamentoCaixa lancamento);

    @Mapping(target = "caixaId", source = "caixa.id")
    @Mapping(target = "funcionario", source = "funcionario.nome")
    LancamentoCaixaResumoResponse toResumoResponse(LancamentoCaixa lancamento);
}
