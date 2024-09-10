package br.com.vitorgabrielti.teste_escriba.situacoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoCartorioRepository extends JpaRepository<SituacaoCartorio, String> {
    SituacaoCartorio findByNome(String nome);
}
