package insper.com.pf.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TarefaRequest {

    private String titulo;
    private String descricao;
    private TipoPrioridade prioridade;
    private String emailUsuario;
}
