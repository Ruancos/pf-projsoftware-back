package insper.com.pf.dto;

import insper.com.pf.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TarefaResponse {

    private Long id;
    private String nome;
    private String descricao;
    private TipoPrioridade prioridade;
    private String emailUsuario;

    public static TarefaResponse from(Tarefa tarefa) {
        return new TarefaResponse(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrioridade(),
                tarefa.getEmailUsuario()
        );
    }
}


