package me.pimpao.ordemservico.service.impl;

import me.pimpao.ordemservico.dto.DetalheOrdemDto;
import me.pimpao.ordemservico.io.entity.DetalheOrdemEntity;
import me.pimpao.ordemservico.io.entity.OrdemServicoEntity;
import me.pimpao.ordemservico.io.repository.DetalheOrdemRepository;
import me.pimpao.ordemservico.io.repository.OrdemServicoRepository;
import me.pimpao.ordemservico.service.DetalheOrdemService;
import me.pimpao.ordemservico.service.exception.ObjectNotFoundException;
import me.pimpao.ordemservico.shared.util.DetalheOrdemMapper;
import me.pimpao.ordemservico.ui.model.response.DetalheResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalheOrdemServiceImpl implements DetalheOrdemService {

    @Autowired
    private DetalheOrdemRepository detalheOrdemRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    public DetalheResponseModel criar(DetalheOrdemDto detalheOrdemDto) {
        OrdemServicoEntity ordemServicoEntity = ordemServicoRepository.findByOrdemId(detalheOrdemDto.getOrdemId());
        if (ordemServicoEntity == null) {
            throw new ObjectNotFoundException("Ordem de serviço não encontrada");
        }
        DetalheOrdemEntity detalheOrdemEntity = DetalheOrdemMapper.mapEntity(ordemServicoEntity, detalheOrdemDto);
        DetalheOrdemEntity novoDetalheOrdemEntity = detalheOrdemRepository.save(detalheOrdemEntity);
        return DetalheOrdemMapper.mapResponseModel(novoDetalheOrdemEntity);
    }

}
