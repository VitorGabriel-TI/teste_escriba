package br.com.vitorgabrielti.teste_escriba.atribuicoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtribuicaoCartorioRepository extends JpaRepository<AtribuicaoCartorio, String> {
    AtribuicaoCartorio findByNome(String nome);

    AtribuicaoCartorio findFirstByIdOrNome(String id, String nome);
}
