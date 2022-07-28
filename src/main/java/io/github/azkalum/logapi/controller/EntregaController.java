package io.github.azkalum.logapi.controller;

import io.github.azkalum.logapi.domain.model.Entrega;
import io.github.azkalum.logapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitarEntrega(@RequestBody Entrega entrega){
        return solicitacaoEntregaService.solicitar(entrega);
    }

}
