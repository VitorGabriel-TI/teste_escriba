package br.com.vitorgabrielti.teste_escriba.cartorios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartorioDTO {

    private Integer id;
    private String nome;

    public static List<CartorioDTO> converter(List<Cartorio> cartorios) {
        return cartorios.stream().map(cartorio -> new CartorioDTO(cartorio.getId(), cartorio.getNome())).collect(Collectors.toList());
    }
}
