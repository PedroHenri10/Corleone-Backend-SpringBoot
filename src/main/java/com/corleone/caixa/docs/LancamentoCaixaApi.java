package com.corleone.caixa.docs;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Lançamentos de Caixa", description = "Operações relacionadas aos lançamentos realizados nos caixas.")
@RequestMapping("/v1/api/lancamentos-caixa")
public interface LancamentoCaixaApi {
    
}
