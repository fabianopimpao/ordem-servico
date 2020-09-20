package me.pimpao.ordemservico.shared.util;

import me.pimpao.ordemservico.dto.EnderecoDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EnderecoEntity;
import me.pimpao.ordemservico.ui.model.request.EnderecoRequestModel;
import me.pimpao.ordemservico.ui.model.response.EnderecoResponseModel;

import java.util.UUID;


public class EnderecoMapper {

    public static EnderecoDto mapDto(EnderecoRequestModel enderecoRequestModel) {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setLogradouro(enderecoRequestModel.getLogradouro());
        enderecoDto.setNumero(enderecoRequestModel.getNumero());
        enderecoDto.setComplemento(enderecoRequestModel.getComplemento());
        enderecoDto.setBairro(enderecoRequestModel.getBairro());
        enderecoDto.setCep(enderecoRequestModel.getCep());
        enderecoDto.setCidade(enderecoRequestModel.getCidade());
        enderecoDto.setEstado(enderecoRequestModel.getEstado());
        return enderecoDto;
    }

    public static EnderecoEntity mapEntity(ClienteEntity clienteEntity, EnderecoDto enderecoDto) {
        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setEnderecoId(UUID.randomUUID().toString());
        enderecoEntity.setLogradouro(enderecoDto.getLogradouro());
        enderecoEntity.setNumero(enderecoDto.getNumero());
        enderecoEntity.setComplemento(enderecoDto.getComplemento());
        enderecoEntity.setBairro(enderecoDto.getBairro());
        enderecoEntity.setCep(enderecoDto.getCep());
        enderecoEntity.setCidade(enderecoDto.getCidade());
        enderecoEntity.setEstado(enderecoDto.getEstado());
        enderecoEntity.setCliente(clienteEntity);

        return enderecoEntity;
    }

    public static EnderecoResponseModel mapResponseModel(EnderecoEntity enderecoEntity) {
        EnderecoResponseModel enderecoResponseModel = new EnderecoResponseModel();
        enderecoResponseModel.setEnderecoId(enderecoEntity.getEnderecoId());
        enderecoResponseModel.setLogradouro(enderecoEntity.getLogradouro());
        enderecoResponseModel.setNumero(enderecoEntity.getNumero());
        enderecoResponseModel.setComplemento(enderecoEntity.getComplemento());
        enderecoResponseModel.setBairro(enderecoEntity.getBairro());
        enderecoResponseModel.setCep(enderecoEntity.getCep());
        enderecoResponseModel.setCidade(enderecoEntity.getCidade());
        enderecoResponseModel.setEstado(enderecoEntity.getEstado());
        return enderecoResponseModel;
    }
}
