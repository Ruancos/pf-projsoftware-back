package insper.com.pf.service;

import insper.com.pf.dto.TarefaRequest;
import insper.com.pf.dto.TarefaResponse;
import insper.com.pf.model.Tarefa;
import insper.com.pf.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public List<TarefaResponse> listar() {
        return tarefaRepository.findAll().stream()
                .map(TarefaResponse::from)
                .toList();
    }

    public TarefaResponse criar(TarefaRequest request) {
        if (request.getTitulo() == null || request.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O titulo da tarefa e obrigatorio");
        }

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(request.getTitulo().trim());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setPrioridade(request.getPrioridade());
        tarefa.setEmailUsuario(request.getEmailUsuario());
        tarefaRepository.save(tarefa);
        return TarefaResponse.from(tarefa);
    }

    public void deletar(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa nao encontrada"));
        tarefaRepository.delete(tarefa);
    }
}





