package br.pucpr.servico;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.pucpr.servico.config.error.ResponseError;
import br.pucpr.servico.dto.CreateProdutoDto;
import br.pucpr.servico.dto.UpdateProdutoDto;
import br.pucpr.servico.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private String notFound = "Produto não encontrado";

    @GetMapping
    public ResponseEntity<ArrayList<Produto>> getAll() {
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable int id) {
        try {
            return ResponseEntity.ok(produtos.get(id - 1));
        } catch (IndexOutOfBoundsException exception) {
            return ResponseEntity.badRequest().body(new ResponseError(HttpStatus.BAD_REQUEST, notFound));
        }
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody CreateProdutoDto createProdutoDto,
            UriComponentsBuilder uriComponentsBuilder) {
        Produto novoProduto = createProdutoDto.convert(produtos.size() + 1);
        produtos.add(novoProduto);
        URI uri = uriComponentsBuilder.path("/produto/{id}").buildAndExpand(novoProduto.getId()).toUri();
        return ResponseEntity.created(uri).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody UpdateProdutoDto updateProdutoDto) {
        try {
            Produto produtoAtualizado = updateProdutoDto.update(id, produtos);
            return ResponseEntity.ok(produtoAtualizado);
        } catch (IndexOutOfBoundsException exception) {
            return ResponseEntity.badRequest().body(new ResponseError(HttpStatus.BAD_REQUEST, notFound));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id) {
        try {
            produtos.remove(id - 1);
            return ResponseEntity.noContent().build();
        } catch (IndexOutOfBoundsException exception) {
            return ResponseEntity.badRequest().body(new ResponseError(HttpStatus.BAD_REQUEST, notFound));
        }
    }
}
