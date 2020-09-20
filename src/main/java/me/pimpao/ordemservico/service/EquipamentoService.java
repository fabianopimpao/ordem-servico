package me.pimpao.ordemservico.service;

import me.pimpao.ordemservico.dto.EquipamentoDto;
import me.pimpao.ordemservico.ui.model.response.EquipamentoResponseModel;

public interface EquipamentoService {

    EquipamentoResponseModel criar(EquipamentoDto equipamentoDto);
}
