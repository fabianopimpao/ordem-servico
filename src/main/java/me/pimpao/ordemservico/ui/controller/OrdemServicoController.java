package me.pimpao.ordemservico.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordens")
public class OrdemServicoController {

    @PostMapping
    public String criarOrdem() {
        return "Teste criar ordem";
    }
}
