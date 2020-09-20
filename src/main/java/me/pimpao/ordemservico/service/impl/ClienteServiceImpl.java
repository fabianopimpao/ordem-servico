package me.pimpao.ordemservico.service.impl;

import me.pimpao.ordemservico.dto.ClienteDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.repository.ClienteRepository;
import me.pimpao.ordemservico.service.ClienteService;
import me.pimpao.ordemservico.shared.util.ClienteMapper;
import me.pimpao.ordemservico.ui.model.response.ClienteResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteResponseModel criar(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = ClienteMapper.mapEntity(clienteDto);
        ClienteEntity novoClienteEntity = clienteRepository.save(clienteEntity);
        return ClienteMapper.mapResponseModel(novoClienteEntity);
    }
}
