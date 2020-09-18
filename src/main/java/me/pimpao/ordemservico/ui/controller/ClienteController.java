package me.pimpao.ordemservico.ui.controller;

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

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody ClienteRequestModel clienteRequestModel, UriComponentsBuilder uriComponentsBuilder) {
        ClienteResponse clienteResponse = clienteService.fromRequest(clienteRequestModel);
        URI uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(clienteResponse.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
