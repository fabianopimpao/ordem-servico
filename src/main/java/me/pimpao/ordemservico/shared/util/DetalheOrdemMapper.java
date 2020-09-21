package me.pimpao.ordemservico.shared.util;

import me.pimpao.ordemservico.dto.DetalheOrdemDto;
import me.pimpao.ordemservico.io.entity.DetalheOrdemEntity;
import me.pimpao.ordemservico.io.entity.OrdemServicoEntity;
import me.pimpao.ordemservico.ui.model.request.DetalheRequestModel;
import me.pimpao.ordemservico.ui.model.response.DetalheResponseModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class DetalheOrdemMapper {

    public static DetalheOrdemDto mapDto(DetalheRequestModel detalheRequestModel) {
        DetalheOrdemDto detalheOrdemDto = new DetalheOrdemDto();
        detalheOrdemDto.setOrdemId(detalheRequestModel.getOrdemId());
        detalheOrdemDto.setDataCriacao(LocalDateTime.now());
        detalheOrdemDto.setMotivo(detalheRequestModel.getMotivo());

        return detalheOrdemDto;
    }

    public static DetalheOrdemEntity mapEntity(OrdemServicoEntity ordemServicoEntity, DetalheOrdemDto detalheOrdemDto) {
        DetalheOrdemEntity detalheOrdemEntity = new DetalheOrdemEntity();
        detalheOrdemEntity.setDetalheOrdemId(UUID.randomUUID().toString());
        detalheOrdemEntity.setDataCriacao(detalheOrdemDto.getDataCriacao());
        detalheOrdemEntity.setMotivo(detalheOrdemDto.getMotivo());
        detalheOrdemEntity.setOrdemServicoEntity(ordemServicoEntity);
        return detalheOrdemEntity;
    }

    public static DetalheResponseModel mapResponseModel(DetalheOrdemEntity detalheOrdemEntity) {
        DetalheResponseModel detalheResponseModel = new DetalheResponseModel();
        detalheResponseModel.setDetalheOrdemId(detalheOrdemEntity.getDetalheOrdemId());
        return detalheResponseModel;
    }
}
