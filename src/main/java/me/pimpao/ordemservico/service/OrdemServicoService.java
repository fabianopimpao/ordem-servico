package me.pimpao.ordemservico.service;

import me.pimpao.ordemservico.dto.OrdemServicoDto;
import me.pimpao.ordemservico.dto.OrdemServicoUpdateDto;
import me.pimpao.ordemservico.ui.model.response.OrdemServicoResponseModel;

import java.util.List;

public interface OrdemServicoService {

    OrdemServicoResponseModel criar(OrdemServicoDto ordemServicoDto);

    void assumirOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto);

    void iniciarOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto);

    void concluirOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto);

    void bloquearOrdemServico(OrdemServicoUpdateDto ordemServicoUpdateDto);

    List<OrdemServicoResponseModel> consultarOrdensPendentesPorResponsavel(String responsavel);
}
