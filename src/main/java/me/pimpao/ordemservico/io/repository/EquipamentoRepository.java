package me.pimpao.ordemservico.io.repository;

import me.pimpao.ordemservico.io.entity.EquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<EquipamentoEntity, Long> {

    EquipamentoEntity findByEquipamentoId(String equipamentoId);

}
