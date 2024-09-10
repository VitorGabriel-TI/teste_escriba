package br.com.vitorgabrielti.teste_escriba.situacoes;

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
@RequestMapping("/api/situacao")
public class SituacaoCartorioController {

    @Autowired
    private SituacaoCartorioService situacaoCartorioService;

    @GetMapping
    @ApiPageableSwagger2
    public ResponseEntity<List<SituacaoCartorioDTO>> listarTodos(@ApiIgnore @PageableDefault(size = 10) Pageable pageable) {
        var situacaoCartorios = situacaoCartorioService.listarTodos(pageable);
        return ResponseEntity.ok(situacaoCartorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SituacaoCartorio> buscarPorId(@PathVariable String id) {
        Optional<SituacaoCartorio> situacaoCartorio = situacaoCartorioService.buscarPorId(id);
        return situacaoCartorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SituacaoCartorio> criar(@Valid @RequestBody SituacaoCartorio situacaoCartorio) {
        SituacaoCartorio situacaoCriada = situacaoCartorioService.salvar(situacaoCartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(situacaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SituacaoCartorioDTO> atualizar(@PathVariable String id, @Valid @RequestBody SituacaoCartorioRequestDTO situacaoCartorioAtualizado) {
        SituacaoCartorio situacaoCartorio = situacaoCartorioService.atualizar(id, situacaoCartorioAtualizado);
        return ResponseEntity.ok(SituacaoCartorioDTO.converter(situacaoCartorio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        situacaoCartorioService.deletar(id);
        return ResponseEntity.ok().body("Situação: " + id + " excluída com sucesso!");
    }
}
