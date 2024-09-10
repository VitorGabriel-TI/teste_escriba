package br.com.vitorgabrielti.teste_escriba.atribuicoes;

import br.com.vitorgabrielti.teste_escriba.infra.ApiPageableSwagger2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atribuicao")
public class AtribuicaoCartorioController {

    @Autowired
    private AtribuicaoCartorioService atribuicaoCartorioService;

    @GetMapping
    @ApiPageableSwagger2
    public ResponseEntity<List<AtribuicaoCartorioDTO>> listarTodos(@ApiIgnore @PageableDefault(size = 10) Pageable pageable) {
        var atribuicaoCartorios = atribuicaoCartorioService.listarTodos(pageable);
        return ResponseEntity.ok(atribuicaoCartorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtribuicaoCartorio> buscarPorId(@PathVariable String id) {
        Optional<AtribuicaoCartorio> atribuicaoCartorio = atribuicaoCartorioService.buscarPorId(id);
        return atribuicaoCartorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AtribuicaoCartorio> criar(@Valid @RequestBody AtribuicaoCartorio atribuicaoCartorio) {
        AtribuicaoCartorio atribuicaoCriada = atribuicaoCartorioService.salvar(atribuicaoCartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(atribuicaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtribuicaoCartorio> atualizar(@PathVariable String id, @Valid @RequestBody AtribuicaoCartorio atribuicaoCartorioAtualizado) {
        AtribuicaoCartorio atribuicaoCartorio = atribuicaoCartorioService.atualizar(id, atribuicaoCartorioAtualizado);
        return ResponseEntity.ok(atribuicaoCartorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        Optional<AtribuicaoCartorio> atribuicaoCartorio = atribuicaoCartorioService.buscarPorId(id);
        if (atribuicaoCartorio.isPresent()) {
            atribuicaoCartorioService.deletar(id);
            return ResponseEntity.ok().body("Atribuição: " + id + " excluída com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atribuição: " + id + " não encontrada!");
        }
    }
}
