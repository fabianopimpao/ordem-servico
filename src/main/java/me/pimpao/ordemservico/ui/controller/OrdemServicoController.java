package me.pimpao.ordemservico.ui.controller;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.dto.OrdemServicoUpdateDto;
import me.pimpao.ordemservico.service.OrdemServicoService;
import me.pimpao.ordemservico.shared.util.OrdemServicoMapper;
import me.pimpao.ordemservico.ui.model.request.OrdemServicoRequestModel;
import me.pimpao.ordemservico.ui.model.request.OrdemServicoUpdateRequestModel;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @PutMapping(value = "/assumirOrdem/{id}")
    public ResponseEntity<Void> assumirOrdem(@PathVariable("id") String id, @RequestBody OrdemServicoUpdateRequestModel ordemServicoUpdateRequestModel) {
        OrdemServicoUpdateDto ordemServicoUpdateDto = OrdemServicoMapper.mapUpdateDto(id, ordemServicoUpdateRequestModel);
        ordemServicoService.assumirOrdemServico(ordemServicoUpdateDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/iniciarOrdem/{id}")
    public ResponseEntity<Void> iniciarOrdem(@PathVariable("id") String id, @RequestBody OrdemServicoUpdateRequestModel ordemServicoUpdateRequestModel) {
        OrdemServicoUpdateDto ordemServicoUpdateDto = OrdemServicoMapper.mapUpdateDto(id, ordemServicoUpdateRequestModel);
        ordemServicoService.iniciarOrdemServico(ordemServicoUpdateDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/concluirOrdem/{id}")
    public ResponseEntity<Void> concluirOrdem(@PathVariable("id") String id, @RequestBody OrdemServicoUpdateRequestModel ordemServicoUpdateRequestModel) {
        OrdemServicoUpdateDto ordemServicoUpdateDto = OrdemServicoMapper.mapUpdateDto(id, ordemServicoUpdateRequestModel);
        ordemServicoService.concluirOrdemServico(ordemServicoUpdateDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/bloquearOrdem/{id}")
    public ResponseEntity<Void> BloquearOrdem(@PathVariable("id") String id, @RequestBody OrdemServicoUpdateRequestModel ordemServicoUpdateRequestModel) {
        OrdemServicoUpdateDto ordemServicoUpdateDto = OrdemServicoMapper.mapUpdateDto(id, ordemServicoUpdateRequestModel);
        ordemServicoService.bloquearOrdemServico(ordemServicoUpdateDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/ordensPendentes/{responsavel}")
    public ResponseEntity<List<OrdemServicoResponseModel>> consultarOrdemPendentesPorResponsavel(@PathVariable("responsavel") String responsavel) {
        List<OrdemServicoResponseModel> ordens = ordemServicoService.consultarOrdensPendentesPorResponsavel(responsavel);
        return ResponseEntity.ok(ordens);
    }
 }
