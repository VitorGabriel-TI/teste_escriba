package br.com.vitorgabrielti.teste_escriba.cartorios;

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
@RequestMapping("/api/cartorio")
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;

    @GetMapping
    @ApiPageableSwagger2
    public ResponseEntity<List<CartorioDTO>> listarTodos(@ApiIgnore @PageableDefault(size = 10) Pageable pageable) {
        var cartorios = cartorioService.listarTodos(pageable);
        return ResponseEntity.ok(cartorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartorio> buscarPorId(@PathVariable int id) {
        Optional<Cartorio> cartorio = cartorioService.buscarPorId(id);
        return cartorio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cartorio> criar(@Valid @RequestBody Cartorio cartorio) {
        Cartorio cartorioCriado = cartorioService.salvar(cartorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartorioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartorio> atualizar(@PathVariable int id, @Valid @RequestBody Cartorio cartorioAtualizado) {
        Cartorio cartorio = cartorioService.atualizar(id, cartorioAtualizado);
        return ResponseEntity.ok(cartorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        cartorioService.deletar(id);
        return ResponseEntity.ok().body("Cartório: " + id + " excluído com sucesso!");
    }
}
