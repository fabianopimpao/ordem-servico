package me.pimpao.ordemservico.shared.util;

import me.pimpao.ordemservico.dto.ClienteDto;
import me.pimpao.ordemservico.dto.EnderecoDto;
import me.pimpao.ordemservico.io.entity.ClienteEntity;
import me.pimpao.ordemservico.io.entity.EnderecoEntity;
import me.pimpao.ordemservico.ui.model.request.ClienteRequestModel;
import me.pimpao.ordemservico.ui.model.response.ClienteResponseModel;
import me.pimpao.ordemservico.ui.model.response.EnderecoResponseModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static ClienteDto mapDto(ClienteRequestModel clienteRequestModel) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNome(clienteRequestModel.getNome());
        clienteDto.setTelefone(clienteRequestModel.getTelefone());
        clienteDto.setEmail(clienteRequestModel.getEmail());
        List<EnderecoDto> enderecos = clienteRequestModel.getEnderecos().stream().map(enderecoRequestModel -> EnderecoMapper.mapDto(enderecoRequestModel)).collect(Collectors.toList());
        clienteDto.setEnderecos(enderecos);
        return clienteDto;
    }

    public static ClienteEntity mapEntity(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setClienteId(UUID.randomUUID().toString());
        clienteEntity.setNome(clienteDto.getNome());
        clienteEntity.setTelefone(clienteDto.getTelefone());
        clienteEntity.setEmail(clienteDto.getEmail());
        List<EnderecoEntity> enderecos = clienteDto.getEnderecos().stream().map(enderecoDto -> EnderecoMapper.mapEntity(clienteEntity, enderecoDto)).collect(Collectors.toList());
        clienteEntity.setEnderecos(enderecos);
        return clienteEntity;
    }

    public static ClienteResponseModel mapResponseModel(ClienteEntity clienteEntity) {
        ClienteResponseModel clienteResponseModel = new ClienteResponseModel();
        clienteResponseModel.setClienteId(clienteEntity.getClienteId());
        clienteResponseModel.setTelefone(clienteEntity.getTelefone());
        clienteResponseModel.setEmail(clienteEntity.getEmail());
        List<EnderecoResponseModel> enderecos = clienteEntity.getEnderecos().stream().map(enderecoEntity -> EnderecoMapper.mapResponseModel(enderecoEntity)).collect(Collectors.toList());
        clienteResponseModel.setEnderecos(enderecos);
        return clienteResponseModel;
    }
}
