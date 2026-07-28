package com.corleone.estoque.event;

import com.corleone.produto.entity.Produto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EstoqueBaixoEvent {

    private final Produto produto;

}