//package com.example.Produto.Controllers;
//
//import com.example.Produto.model.Produto;
//import com.example.Produto.Service.ProdutoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//// ClienteController.java
//@RestController
//@RequestMapping("/produto")
//public class ProdutoController {
//    @Autowired
//    private ProdutoService produtoService;
//
//    @PostMapping
//    public Produto salvar(@RequestBody Produto produto) {
//        return produtoService.salvar(produto);
//    }
//
//    @GetMapping
//    public List<Produto> listarTodos() {
//        return produtoService.listarTodos();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Produto> listarPorId(@PathVariable Long id) {
//        return produtoService.listarPorId(id);
//    }
//
//    @GetMapping("/nome/{nome}")
//    public Optional<Produto> listarPorNome(@PathVariable String nome) {
//        return produtoService.listarPorNome(nome);
//    }
//}
//

package com.example.Produto.Controllers;

import com.example.Produto.model.Produto;
import com.example.Produto.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.listarPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> listarPorNome(@PathVariable String nome) {
        Optional<Produto> produto = produtoService.listarPorNome(nome);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
