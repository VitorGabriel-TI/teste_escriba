package br.com.vitorgabrielti.teste_escriba.situacoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoCartorioRequestDTO {

    @Size(max = 50, message = "O tamanho máximo do campo Nome permitido é de 50 caracteres")
    private String nome;

    public static List<SituacaoCartorioRequestDTO> converter(List<SituacaoCartorio> situacaoCartorios) {
        return situacaoCartorios.stream().map(situacaoCartorio -> new SituacaoCartorioRequestDTO(situacaoCartorio.getNome())).collect(Collectors.toList());
    }
}
