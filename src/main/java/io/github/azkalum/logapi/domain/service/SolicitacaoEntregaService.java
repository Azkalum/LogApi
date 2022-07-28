package io.github.azkalum.logapi.domain.service;

import io.github.azkalum.logapi.domain.exception.NegocioException;
import io.github.azkalum.logapi.domain.model.Cliente;
import io.github.azkalum.logapi.domain.model.Entrega;
import io.github.azkalum.logapi.domain.model.StatusEntrega;
import io.github.azkalum.logapi.domain.repository.ClienteRepository;
import io.github.azkalum.logapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){

        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }

}
