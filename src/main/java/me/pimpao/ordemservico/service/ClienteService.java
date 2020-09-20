package me.pimpao.ordemservico.service;

import me.pimpao.ordemservico.dto.ClienteDto;
import me.pimpao.ordemservico.ui.model.response.ClienteResponseModel;

public interface ClienteService {

    ClienteResponseModel criar(ClienteDto clienteDto);

}
