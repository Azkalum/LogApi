package io.github.azkalum.logapi.domain.repository;

import io.github.azkalum.logapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);

}
