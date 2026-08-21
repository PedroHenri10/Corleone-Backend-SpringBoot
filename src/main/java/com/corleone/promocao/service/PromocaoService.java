package com.corleone.promocao.service;

import com.corleone.promocao.dto.PromocaoFilter;
import com.corleone.promocao.dto.PromocaoRequest;
import com.corleone.promocao.dto.PromocaoResponse;
import com.corleone.promocao.dto.PromocaoResumoResponse;
import com.corleone.promocao.entity.Promocao;
import com.corleone.promocao.mapper.PromocaoMapper;
import com.corleone.promocao.repository.PromocaoRepository;
import com.corleone.promocao.specification.PromocaoSpecification;
import com.corleone.promocao.validator.PromocaoValidator;
import com.corleone.produto.entity.Produto;
import com.corleone.shared.util.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PromocaoService {

    private final PromocaoRepository repository;
    private final PromocaoMapper mapper;
    private final PromocaoValidator validator;

   public PromocaoResponse criar(PromocaoRequest request){
       validator.validarProdutoJaPromocionado(request.getProdutoId());

       validator.validarPercentual(request.getPercentual());

       validator.validarPeriodo(request.getDataInicio(), request.getDataFim());

       Produto produto = validator.validarProduto(request.getProdutoId());

       Promocao promocao = mapper.toEntity(request, produto);

       if (promocao.getAtiva() == null) {
           promocao.setAtiva(true);
       }

       promocao = repository.save(promocao);

       return mapper.toResponse(promocao);
   }

   public PromocaoResponse atualizar(Integer id, PromocaoRequest request){
       Promocao promocao = validator.validarPromocao(id);

       validator.validarPercentual(request.getPercentual());

       validator.validarPeriodo(request.getDataInicio(), request.getDataFim());

       Produto produto = validator.validarProduto(request.getProdutoId());

       if(!promocao.getProduto().getId().equals(request.getProdutoId())){
           validator.validarProdutoJaPromocionado(request.getProdutoId());
       }

       mapper.updateEntity(promocao, request, produto);

       promocao = repository.save(promocao);

       return mapper.toResponse(promocao);
   }

   public PromocaoResponse buscarPorId(Integer id){
        Promocao promocao = validator.validarPromocao(id);

        return mapper.toResponse(promocao);
   }

    public List<PromocaoResumoResponse> listar(PromocaoFilter filter){

        return repository.findAll(PromocaoSpecification.filtro(filter)).stream().map(mapper::toResumoResponse).toList();
    }

    public List<PromocaoResumoResponse> listarAtivas(){
        return repository
                .findAll(PromocaoSpecification.somenteAtivas())
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public List<PromocaoResumoResponse> listarEmVIgencia(){
       LocalDateTime agora = LocalDateTime.now(DateUtils.BR_ZONE);

        return repository
                .findAll(PromocaoSpecification.emVigencia(agora))
                .stream()
                .map(mapper::toResumoResponse)
                .toList();
    }

    public PromocaoResponse ativar(Integer id) {

        Promocao promocao = validator.validarPromocao(id);

        promocao.setAtiva(true);

        promocao = repository.save(promocao);

        return mapper.toResponse(promocao);
    }

    public PromocaoResponse desativar(Integer id) {

        Promocao promocao = validator.validarPromocao(id);

        promocao.setAtiva(false);

        promocao = repository.save(promocao);

        return mapper.toResponse(promocao);
    }
}