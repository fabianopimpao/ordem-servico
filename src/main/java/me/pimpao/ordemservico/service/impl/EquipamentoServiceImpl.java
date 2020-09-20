package me.pimpao.ordemservico.service.impl;

import me.pimpao.ordemservico.dto.EquipamentoDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EquipamentoEntity;
import me.pimpao.ordemservico.io.repository.ClienteRepository;
import me.pimpao.ordemservico.io.repository.EquipamentoRepository;
import me.pimpao.ordemservico.service.EquipamentoService;
import me.pimpao.ordemservico.shared.util.EquipamentoMapper;
import me.pimpao.ordemservico.ui.model.response.EquipamentoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    public EquipamentoResponseModel criar(EquipamentoDto equipamentoDto) {
        ClienteEntity clienteEntity = clienteRepository.findByClienteId(equipamentoDto.getClienteId());
        EquipamentoEntity equipamentoEntity = EquipamentoMapper.mapEntity(equipamentoDto, clienteEntity);
        EquipamentoEntity novoEquipamento = equipamentoRepository.save(equipamentoEntity);
        return EquipamentoMapper.mapResponseModel(novoEquipamento);
    }
}
