package me.pimpao.ordemservico.io.repository;

import me.pimpao.ordemservico.io.entity.OrdemServicoEntity;
import me.pimpao.ordemservico.io.enumeration.StatusOrdem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServicoEntity, Long> {

    List<OrdemServicoEntity> findByResponsavelAndStatus(String responsavel, StatusOrdem pendente);

    OrdemServicoEntity findByOrdemId(String ordemId);

    OrdemServicoEntity findByOrdemIdAndResponsavel(String ordemId, String responsavel);
}
