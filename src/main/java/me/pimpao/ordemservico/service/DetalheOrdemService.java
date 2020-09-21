package me.pimpao.ordemservico.service;

import me.pimpao.ordemservico.dto.DetalheOrdemDto;
import me.pimpao.ordemservico.ui.model.response.DetalheResponseModel;

public interface DetalheOrdemService {

    DetalheResponseModel criar(DetalheOrdemDto detalheOrdemDto);

}
