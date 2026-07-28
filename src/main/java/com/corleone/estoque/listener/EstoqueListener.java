package com.corleone.estoque.listener;

import com.corleone.estoque.event.EstoqueBaixoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EstoqueListener {

    @EventListener
    public void estoqueBaixo(EstoqueBaixoEvent event) {

        log.warn(
                "Produto {} atingiu estoque mínimo.",
                event.getProduto().getNome()
        );

    }

}
