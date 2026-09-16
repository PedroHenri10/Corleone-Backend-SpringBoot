package com.corleone.caixa.docs;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Caixa", description = "Operações relacionadas ao controle e movimentação dos caixas da pizzaria.")
@RequestMapping("/v1/api/caixas")
public interface CaixaApi {
}
