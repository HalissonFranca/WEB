//package com.example.Produto.Controllers;
//
//import com.example.Produto.model.Pedido;
//import com.example.Produto.Service.PedidoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//// ClienteController.java
//@RestController
//@RequestMapping("/pedido")
//public class PedidoController {
//    @Autowired
//    private PedidoService pedidoService;
//
//    @PostMapping
//    public Pedido salvar(@RequestBody Pedido pedido) {
//        return pedidoService.salvar(pedido);
//    }
//
//    @GetMapping
//    public List<Pedido> listarTodos() {
//        return pedidoService.listarTodos();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Pedido> listarPorId(@PathVariable Long id) {
//        return pedidoService.listarPorId(id);
//    }
//
//    @GetMapping("/cliente/{idCliente}")
//    public List<Pedido> listarPorIdCliente(@PathVariable Long idCliente) {
//        return pedidoService.listarPorIdCliente(idCliente);
//    }
//
//    @GetMapping("/produto/{idProduto}")
//    public List<Pedido> listarPorIdProduto(@PathVariable Long idProduto) {
//        return pedidoService.listarPorIdProduto(idProduto);
//    }
//}
//

package com.example.Produto.Controllers;

import com.example.Produto.model.Pedido;
import com.example.Produto.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.listarPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Pedido> listarPorIdCliente(@PathVariable Long idCliente) {
        return pedidoService.listarPorIdCliente(idCliente);
    }

    @GetMapping("/produto/{idProduto}")
    public List<Pedido> listarPorIdProduto(@PathVariable Long idProduto) {
        return pedidoService.listarPorIdProduto(idProduto);
    }
}
