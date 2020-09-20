package me.pimpao.ordemservico.ui.controller;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.service.OrdemServicoService;
import me.pimpao.ordemservico.shared.util.OrdemServicoMapper;
import me.pimpao.ordemservico.ui.model.request.OrdemServicoRequestModel;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;
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
@RequestMapping(value = "/ordens")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody OrdemServicoRequestModel ordemServicoRequestModel, UriComponentsBuilder uriComponentsBuilder) {
        OrdemServicoDto ordemServicoDto = OrdemServicoMapper.mapDto(ordemServicoRequestModel);
        OrdemServicoResponseModel ordemServicoResponseModel = ordemServicoService.criar(ordemServicoDto);
        URI uri = uriComponentsBuilder.path("/ordens/{id}").buildAndExpand(ordemServicoResponseModel.getOrdemId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
