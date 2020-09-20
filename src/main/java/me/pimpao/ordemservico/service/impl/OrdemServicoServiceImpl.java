package me.pimpao.ordemservico.service.impl;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EquipamentoEntity;
import me.pimpao.ordemservico.io.entity.OrdemServicoEntity;
import me.pimpao.ordemservico.io.repository.ClienteRepository;
import me.pimpao.ordemservico.io.repository.EquipamentoRepository;
import me.pimpao.ordemservico.io.repository.OrdemServicoRepository;
import me.pimpao.ordemservico.service.OrdemServicoService;
import me.pimpao.ordemservico.shared.util.OrdemServicoMapper;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    public OrdemServicoResponseModel criar(OrdemServicoDto ordemServicoDto) {

        ClienteEntity clienteEntity = clienteRepository.findByClienteId(ordemServicoDto.getClienteId());
        EquipamentoEntity equipamentoEntity = equipamentoRepository.findByEquipamentoId(ordemServicoDto.getEquipamentoId());

        OrdemServicoEntity ordemServicoEntity = OrdemServicoMapper.mapEntity(clienteEntity, equipamentoEntity, ordemServicoDto);
        OrdemServicoEntity novaOrdemServicoEntity = ordemServicoRepository.save(ordemServicoEntity);
        return OrdemServicoMapper.mapResponseModel(novaOrdemServicoEntity);
    }
}
