package br.com.vitorgabrielti.teste_escriba.situacoes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoCartorioDTO {

    private String id;
    private String nome;

    public static List<SituacaoCartorioDTO> converter(List<SituacaoCartorio> situacaoCartorios) {
        return situacaoCartorios.stream().map(situacaoCartorio -> new SituacaoCartorioDTO(situacaoCartorio.getId(), situacaoCartorio.getNome())).collect(Collectors.toList());
    }

    public static SituacaoCartorioDTO converter(SituacaoCartorio situacaoCartorio) {
        return SituacaoCartorioDTO.builder().id(situacaoCartorio.getId()).nome(situacaoCartorio.getNome()).build();
    }
}
