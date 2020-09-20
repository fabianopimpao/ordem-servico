package me.pimpao.ordemservico.ui.controller;

import me.pimpao.ordemservico.dto.EquipamentoDto;
import me.pimpao.ordemservico.service.EquipamentoService;
import me.pimpao.ordemservico.shared.util.EquipamentoMapper;
import me.pimpao.ordemservico.ui.model.request.EquipamentoRequestModel;
import me.pimpao.ordemservico.ui.model.response.EquipamentoResponseModel;
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
@RequestMapping(value = "/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody EquipamentoRequestModel equipamentoRequestModel, UriComponentsBuilder uriComponentsBuilder) {
        EquipamentoDto equipamentoDto = EquipamentoMapper.mapDto(equipamentoRequestModel);
        EquipamentoResponseModel equipamentoResponseModel = equipamentoService.criar(equipamentoDto);
        URI uri = uriComponentsBuilder.path("/equipamentos/{id}").buildAndExpand(equipamentoResponseModel.getEquipamentoId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
