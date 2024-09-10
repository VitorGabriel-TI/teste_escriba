package br.com.vitorgabrielti.teste_escriba.cartorios;

import br.com.vitorgabrielti.teste_escriba.atribuicoes.AtribuicaoCartorio;
import br.com.vitorgabrielti.teste_escriba.situacoes.SituacaoCartorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CARTORIO")
public class Cartorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 150, message = "O tamanho máximo do campo Nome permitido é de 150 caracteres")
    @NotNull
    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 250)
    @Size(max = 250, message = "O tamanho máximo do campo observação permitido é de 250 caracteres")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "situacao_id")
    private SituacaoCartorio situacao;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "TB_ATRIBUICAO_HAS_CARTORIO",
            joinColumns = @JoinColumn(name = "cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "atribuicao_id"))
    private List<AtribuicaoCartorio> atribuicaoCartorioList;

    @Override
    public String toString() {
        return "Código: " + getId() + " Nome: " + getNome();
    }

    public CartorioDTO toDto() {
        return new CartorioDTO(this.id, this.nome);
    }
}