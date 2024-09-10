package br.com.vitorgabrielti.teste_escriba.cartorios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    Cartorio findByNome(String s);
}
