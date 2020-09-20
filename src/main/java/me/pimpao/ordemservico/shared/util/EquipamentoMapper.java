package me.pimpao.ordemservico.shared.util;

import me.pimpao.ordemservico.dto.EquipamentoDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EquipamentoEntity;
import me.pimpao.ordemservico.ui.model.request.EquipamentoRequestModel;
import me.pimpao.ordemservico.ui.model.response.EquipamentoResponseModel;

import java.util.UUID;

public class EquipamentoMapper {

    public static EquipamentoDto mapDto(EquipamentoRequestModel equipamentoRequestModel) {
        EquipamentoDto equipamentoDto = new EquipamentoDto();
        equipamentoDto.setDescricao(equipamentoRequestModel.getDescricao());
        equipamentoDto.setMarca(equipamentoRequestModel.getMarca());
        equipamentoDto.setTipo(equipamentoRequestModel.getTipo());
        equipamentoDto.setSituacao(equipamentoRequestModel.getSituacao());
        equipamentoDto.setClienteId(equipamentoRequestModel.getClienteId());
        return equipamentoDto;
    }

    public static EquipamentoEntity mapEntity(EquipamentoDto equipamentoDto, ClienteEntity clienteEntity) {
        EquipamentoEntity equipamentoEntity = new EquipamentoEntity();
        equipamentoEntity.setEquipamentoId(UUID.randomUUID().toString());
        equipamentoEntity.setDescricao(equipamentoDto.getDescricao());
        equipamentoEntity.setMarca(equipamentoDto.getMarca());
        equipamentoEntity.setTipo(equipamentoDto.getTipo());
        equipamentoEntity.setSituacao(equipamentoDto.getSituacao());
        equipamentoEntity.setCliente(clienteEntity);

        return equipamentoEntity;
    }

    public static EquipamentoResponseModel mapResponseModel(EquipamentoEntity equipamentoEntity) {
        EquipamentoResponseModel equipamentoResponseModel = new EquipamentoResponseModel();
        equipamentoResponseModel.setEquipamentoId(equipamentoEntity.getEquipamentoId());
        equipamentoResponseModel.setDescricao(equipamentoEntity.getDescricao());
        equipamentoResponseModel.setMarca(equipamentoEntity.getMarca());
        equipamentoResponseModel.setTipo(equipamentoEntity.getTipo());
        equipamentoResponseModel.setSituacao(equipamentoEntity.getSituacao());

        return equipamentoResponseModel;
    }
}
