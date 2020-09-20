package me.pimpao.ordemservico.service;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;

public interface OrdemServicoService {

    OrdemServicoResponseModel criar(OrdemServicoDto ordemServicoDto);
}
