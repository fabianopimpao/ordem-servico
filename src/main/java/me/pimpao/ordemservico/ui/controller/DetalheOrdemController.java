package me.pimpao.ordemservico.ui.controller;

import me.pimpao.ordemservico.dto.DetalheOrdemDto;
import me.pimpao.ordemservico.service.DetalheOrdemService;
import me.pimpao.ordemservico.shared.util.DetalheOrdemMapper;
import me.pimpao.ordemservico.ui.model.request.DetalheRequestModel;
import me.pimpao.ordemservico.ui.model.response.DetalheResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/detalhes")
public class DetalheOrdemController {

    @Autowired
    private DetalheOrdemService detalheOrdemService;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody DetalheRequestModel detalheRequestModel, UriComponentsBuilder uriComponentsBuilder) {
        DetalheOrdemDto detalheOrdemDto = DetalheOrdemMapper.mapDto(detalheRequestModel);
        DetalheResponseModel detalheResponseModel = detalheOrdemService.criar(detalheOrdemDto);
        URI uri = uriComponentsBuilder.path("/detalhes/{id}").buildAndExpand(detalheResponseModel.getDetalheOrdemId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
