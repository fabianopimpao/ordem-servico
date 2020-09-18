package me.pimpao.ordemservico.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/equipamentos")
public class EquipamentoController {

    @PostMapping
    public String criar() {
        return "Criar equipamento";
    }
}
