package br.com.vitorgabrielti.teste_escriba.atribuicoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ATRIBUICAO_CARTORIO")
public class AtribuicaoCartorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Size(max = 20, message = "O tamanho máximo do campo ID permitido é de 20 caracteres")
    @Column(length = 20, nullable = false)
    private String id;

    @NotNull
    @Column(length = 50, nullable = false)
    @Size(max = 50, message = "O tamanho máximo do campo Nome permitido é de 50 caracteres")
    private String nome;

    @Column(nullable = false)
    @NotNull
    private Boolean situacao = true;

    @Override
    public String toString() {
        return "Código: " + getId() + "Nome: " + getNome();
    }

    public AtribuicaoCartorioDTO toDto() {
        return new AtribuicaoCartorioDTO(this.id, this.nome);
    }
}