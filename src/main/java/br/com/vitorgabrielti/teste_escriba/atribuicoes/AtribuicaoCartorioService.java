package br.com.vitorgabrielti.teste_escriba.atribuicoes;

import br.com.vitorgabrielti.teste_escriba.exception.CampoNaoEncontradoException;
import br.com.vitorgabrielti.teste_escriba.exception.ErroNaoMapeadoException;
import br.com.vitorgabrielti.teste_escriba.exception.RegistroDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AtribuicaoCartorioService {

    @Autowired
    private AtribuicaoCartorioRepository atribuicaoCartorioRepository;

    public List<AtribuicaoCartorioDTO> listarTodos(Pageable pageable) {
        var atribuicaoCartorios = atribuicaoCartorioRepository.findAll(pageable).getContent();
        return AtribuicaoCartorioDTO.converter(atribuicaoCartorios);
    }

    public Optional<AtribuicaoCartorio> buscarPorId(String id) {
        return atribuicaoCartorioRepository.findById(id);
    }

    public AtribuicaoCartorio salvar(AtribuicaoCartorio atribuicaoCartorio) {
        if (Objects.isNull(atribuicaoCartorio)) {
            throw new ErroNaoMapeadoException("Atribuição do cartório não pode ser vazio");
        }
        if (atribuicaoCartorio.getId().isBlank()) {
            throw new CampoNaoEncontradoException("O campo 'ID' é obrigatório");
        }
        if (atribuicaoCartorio.getNome().isEmpty()) {
            throw new CampoNaoEncontradoException("O campo 'Nome' é obrigatório");
        }
        if (atribuicaoCartorio.getSituacao() == null) {
            throw new CampoNaoEncontradoException("O campo 'Situação' é obrigatório");
        }
        var situacaoCartorioDB = atribuicaoCartorioRepository.findFirstByIdOrNome(atribuicaoCartorio.getId(), atribuicaoCartorio.getNome());
        if (Objects.isNull(situacaoCartorioDB)) {
            return atribuicaoCartorioRepository.save(atribuicaoCartorio);
        }
        if (atribuicaoCartorio.getId().equals(situacaoCartorioDB.getId())) {
            throw new RegistroDuplicadoException("Registro já cadastrado!");
        }
        if (atribuicaoCartorio.getNome().equals(situacaoCartorioDB.getNome())) {
            throw new RegistroDuplicadoException("Nome já informado na atribuição: " + situacaoCartorioDB.getId());
        }
        return atribuicaoCartorioRepository.save(atribuicaoCartorio);
    }

    @Transactional
    public AtribuicaoCartorio atualizar(String id, AtribuicaoCartorio atribuicaoCartorioAtualizado) {
        var atribuicaoCartorioExistente = atribuicaoCartorioRepository.findByNome(atribuicaoCartorioAtualizado.getNome());

        if (Objects.isNull(atribuicaoCartorioExistente)) {
            atribuicaoCartorioExistente = atribuicaoCartorioRepository.findById(id).get();
        }

        if (atribuicaoCartorioExistente.getId() != id && atribuicaoCartorioExistente.getNome().equals(atribuicaoCartorioAtualizado.getNome())) {
            throw new RegistroDuplicadoException("Nome já informado na atribuição: " + atribuicaoCartorioExistente.getId());
        }

        if (atribuicaoCartorioAtualizado.getId() != null && !atribuicaoCartorioAtualizado.getId().isEmpty()) {
            atribuicaoCartorioExistente.setId(atribuicaoCartorioExistente.getId());
        }
        if (atribuicaoCartorioAtualizado.getNome() != null && !atribuicaoCartorioAtualizado.getNome().isEmpty()) {
            atribuicaoCartorioExistente.setNome(atribuicaoCartorioAtualizado.getNome());
        }

        return atribuicaoCartorioRepository.save(atribuicaoCartorioExistente);
    }

    public void deletar(String id) {
        atribuicaoCartorioRepository.deleteById(id);
    }
}
