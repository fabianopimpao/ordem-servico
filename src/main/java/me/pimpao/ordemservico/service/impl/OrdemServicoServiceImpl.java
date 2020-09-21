package me.pimpao.ordemservico.service.impl;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.dto.OrdemServicoUpdateDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EquipamentoEntity;
import me.pimpao.ordemservico.io.entity.OrdemServicoEntity;
import me.pimpao.ordemservico.io.enumeration.StatusOrdem;
import me.pimpao.ordemservico.io.repository.ClienteRepository;
import me.pimpao.ordemservico.io.repository.EquipamentoRepository;
import me.pimpao.ordemservico.io.repository.OrdemServicoRepository;
import me.pimpao.ordemservico.service.OrdemServicoService;
import me.pimpao.ordemservico.service.exception.ObjectNotFoundException;
import me.pimpao.ordemservico.shared.util.OrdemServicoMapper;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        if (clienteEntity == null) {
            throw new ObjectNotFoundException("Cliente não encontrado!");
        }

        EquipamentoEntity equipamentoEntity = equipamentoRepository.findByEquipamentoId(ordemServicoDto.getEquipamentoId());
        if (equipamentoEntity == null) {
            throw new ObjectNotFoundException("Equipamento não encontrado!");
        }

        OrdemServicoEntity ordemServicoEntity = OrdemServicoMapper.mapEntity(clienteEntity, equipamentoEntity, ordemServicoDto);
        OrdemServicoEntity novaOrdemServicoEntity = ordemServicoRepository.save(ordemServicoEntity);
        return OrdemServicoMapper.mapResponseModel(novaOrdemServicoEntity);
    }

    @Override
    public void assumirOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto) {
        OrdemServicoEntity ordemServicoEntity = ordemServicoRepository.findByOrdemId(ordemServicoUpdateDto.getOrdemId());
        if (ordemServicoEntity == null) {
            throw new ObjectNotFoundException("Ordem de serviço não encontrada!");
        }

        if (ordemServicoUpdateDto.getResponsavel().isEmpty()) {
            throw new ObjectNotFoundException("Responsável não foi informado!");
        }

        ordemServicoEntity.setResponsavel(ordemServicoUpdateDto.getResponsavel());
        ordemServicoRepository.save(ordemServicoEntity);
    }

    @Override
    public void iniciarOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto) {
        OrdemServicoEntity ordemServicoEntity = ordemServicoRepository.findByOrdemIdAndResponsavel(ordemServicoUpdateDto.getOrdemId(), ordemServicoUpdateDto.getResponsavel());
        if (ordemServicoEntity == null) {
            throw new ObjectNotFoundException("Ordem de serviço não encontrada!");
        }

        if (ordemServicoUpdateDto.getResponsavel().isEmpty()) {
            throw new ObjectNotFoundException("Responsável não foi informado!");
        }

        ordemServicoEntity.setDataInicial(LocalDateTime.now());
        ordemServicoEntity.setStatus(StatusOrdem.EM_ANDAMENTO);
        ordemServicoRepository.save(ordemServicoEntity);
    }

    @Override
    public void concluirOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto) {
        OrdemServicoEntity ordemServicoEntity = ordemServicoRepository.findByOrdemIdAndResponsavel(ordemServicoUpdateDto.getOrdemId(), ordemServicoUpdateDto.getResponsavel());
        if (ordemServicoEntity == null) {
            throw new ObjectNotFoundException("Ordem de serviço não encontrada!");
        }

        if (ordemServicoUpdateDto.getResponsavel().isEmpty()) {
            throw new ObjectNotFoundException("Responsável não foi informado!");
        }

        ordemServicoEntity.setDataConclusao(LocalDateTime.now());
        ordemServicoEntity.setStatus(StatusOrdem.CONCLUIDA);
        ordemServicoRepository.save(ordemServicoEntity);
    }

    @Override
    public void bloquearOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto) {
        OrdemServicoEntity ordemServicoEntity = ordemServicoRepository.findByOrdemIdAndResponsavel(ordemServicoUpdateDto.getOrdemId(), ordemServicoUpdateDto.getResponsavel());
        if (ordemServicoEntity == null) {
            throw new ObjectNotFoundException("Ordem de serviço não encontrada!");
        }

        if (ordemServicoUpdateDto.getResponsavel().isEmpty()) {
            throw new ObjectNotFoundException("Responsável não foi informado!");
        }

        ordemServicoEntity.setStatus(StatusOrdem.BLOQUEADA);
        ordemServicoRepository.save(ordemServicoEntity);
    }

    @Override
    public List<OrdemServicoResponseModel> consultarOrdensPendentesPorResponsavel(String responsavel) {
        if (responsavel.isEmpty()) {
            throw new ObjectNotFoundException("Responsável não foi informado!");
        }

        List<OrdemServicoEntity> ordens = ordemServicoRepository.findByResponsavelAndStatus(responsavel, StatusOrdem.PENDENTE);
        return ordens.stream().map(OrdemServicoMapper::mapResponseModel).collect(Collectors.toList());
    }
}
