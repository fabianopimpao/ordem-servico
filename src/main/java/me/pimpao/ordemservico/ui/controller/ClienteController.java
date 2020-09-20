package me.pimpao.ordemservico.ui.controller;

import me.pimpao.ordemservico.dto.ClienteDto;
import me.pimpao.ordemservico.service.ClienteService;
import me.pimpao.ordemservico.shared.util.ClienteMapper;
import me.pimpao.ordemservico.ui.model.request.ClienteRequestModel;
import me.pimpao.ordemservico.ui.model.response.ClienteResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody ClienteRequestModel clienteRequestModel, UriComponentsBuilder uriComponentsBuilder) {
        ClienteDto clienteDto = ClienteMapper.mapDto(clienteRequestModel);
        ClienteResponseModel clienteResponseModel = clienteService.criar(clienteDto);
        URI uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(clienteResponseModel.getClienteId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
