package me.pimpao.ordemservico.io.repository;

import me.pimpao.ordemservico.io.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteEntity findByClienteId(String clienteId);

}
