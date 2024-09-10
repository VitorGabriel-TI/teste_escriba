package br.com.vitorgabrielti.teste_escriba.situacoes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_SITUACAO_CARTORIO")
public class SituacaoCartorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Size(max = 20, message = "O tamanho máximo do campo ID permitido é de 20 caracteres")
    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 50, nullable = false, unique = true)
    @NotNull
    @Size(max = 50, message = "O tamanho máximo do campo Nome permitido é de 50 caracteres")
    private String nome;

    @Override
    public String toString() {
        return "Código: " + getId() + "Nome: " + getNome();
    }
}