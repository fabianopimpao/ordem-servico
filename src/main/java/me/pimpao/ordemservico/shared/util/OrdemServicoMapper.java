package me.pimpao.ordemservico.shared.util;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EquipamentoEntity;
import me.pimpao.ordemservico.io.entity.OrdemServicoEntity;
import me.pimpao.ordemservico.io.enumeration.StatusOrdem;
import me.pimpao.ordemservico.ui.model.request.OrdemServicoRequestModel;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;

import java.time.LocalDateTime;
import java.util.UUID;


public class OrdemServicoMapper {

    public static OrdemServicoDto mapDto(OrdemServicoRequestModel ordemServicoRequestModel) {
        OrdemServicoDto ordemServicoDto = new OrdemServicoDto();
        ordemServicoDto.setClienteId(ordemServicoRequestModel.getClienteId());
        ordemServicoDto.setEquipamentoId(ordemServicoRequestModel.getEquipamentoId());
        ordemServicoDto.setDataCriacao(LocalDateTime.now());

        return ordemServicoDto;
    }

    public static OrdemServicoEntity mapEntity(ClienteEntity clienteEntity, EquipamentoEntity equipamentoEntity, OrdemServicoDto ordemServicoDto) {
        OrdemServicoEntity ordemServicoEntity = new OrdemServicoEntity();
        ordemServicoEntity.setOrdemId(UUID.randomUUID().toString());
        ordemServicoEntity.setDataCriacao(ordemServicoDto.getDataCriacao());
        ordemServicoEntity.setStatus(StatusOrdem.PENDENTE);
        ordemServicoEntity.setClienteEntity(clienteEntity);
        ordemServicoEntity.setEquipamentoEntity(equipamentoEntity);

        return ordemServicoEntity;
    }

    public static OrdemServicoResponseModel mapResponseModel(OrdemServicoEntity ordemServicoEntity) {
        OrdemServicoResponseModel ordemServicoResponseModel = new OrdemServicoResponseModel();
        ordemServicoResponseModel.setOrdemId(ordemServicoEntity.getOrdemId());
        ordemServicoResponseModel.setDataCriacao(ordemServicoResponseModel.getDataCriacao());
        ordemServicoResponseModel.setDataInicial(ordemServicoEntity.getDataInicial());
        ordemServicoResponseModel.setDataConclusao(ordemServicoEntity.getDataConclusao());
        ordemServicoResponseModel.setClienteId(ordemServicoEntity.getClienteEntity().getClienteId());
        ordemServicoResponseModel.setEquipamentoId(ordemServicoEntity.getEquipamentoEntity().getEquipamentoId());
        ordemServicoResponseModel.setResponsavel(ordemServicoEntity.getResponsavel());

        return ordemServicoResponseModel;
    }
}
