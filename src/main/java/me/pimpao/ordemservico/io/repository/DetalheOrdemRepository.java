package me.pimpao.ordemservico.io.repository;

import me.pimpao.ordemservico.io.entity.DetalheOrdemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalheOrdemRepository extends JpaRepository<DetalheOrdemEntity, Long> {
}
