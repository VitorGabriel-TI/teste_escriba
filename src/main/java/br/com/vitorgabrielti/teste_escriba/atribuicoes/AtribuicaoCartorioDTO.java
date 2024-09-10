package br.com.vitorgabrielti.teste_escriba.atribuicoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtribuicaoCartorioDTO {

    private String id;
    private String nome;

    public static List<AtribuicaoCartorioDTO> converter(List<AtribuicaoCartorio> atribuicaoCartorios) {
        return atribuicaoCartorios.stream().map(atribuicaoCartorio -> new AtribuicaoCartorioDTO(atribuicaoCartorio.getId(), atribuicaoCartorio.getNome())).collect(Collectors.toList());
    }
}
