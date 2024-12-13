/*package com.example.Produto.Controllers;
import com.example.Produto.model.Pedido;
import com.example.Produto.model.PedidoDTO;
import com.example.Produto.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody PedidoDTO pedidoDTO) {
        if (pedidoDTO.getIdsProdutos().size() != 1) {
            return ResponseEntity.badRequest().body(null);  // Garantir que o pedido contenha apenas um produto
        }

        Pedido pedido = new Pedido();
        pedido.setIdCliente(pedidoDTO.getIdCliente());
        pedido.setIdsProdutos(pedidoDTO.getIdsProdutos());
        Pedido pedidoSalvo = pedidoService.salvar(pedido);
        return ResponseEntity.ok(pedidoSalvo);
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
*/
// VERSÃO 2
//
//package com.example.Produto.Controllers;
//
//import com.example.Produto.model.Pedido;
//import com.example.Produto.model.PedidoDTO;
//import com.example.Produto.Service.PedidoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/pedidos")
//public class PedidoController {
//    @Autowired
//    private PedidoService pedidoService;
//
//    @PostMapping
//    public ResponseEntity<Pedido> salvar(@RequestBody PedidoDTO pedidoDTO) {
//        if (pedidoDTO.getIdsProdutos().size() != 1) {
//            return ResponseEntity.badRequest().body(null);  // Garantir que o pedido contenha apenas um produto
//        }
//
//        Pedido pedido = new Pedido();
//        pedido.setIdCliente(pedidoDTO.getIdCliente());
//        pedido.setIdsProdutos(pedidoDTO.getIdsProdutos());
//        Pedido pedidoSalvo = pedidoService.salvar(pedido);
//        return ResponseEntity.ok(pedidoSalvo);
//    }
//
//    @GetMapping
//    public List<Pedido> listarTodos() {
//        return pedidoService.listarTodos();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Pedido> listarPorId(@PathVariable Long id) {
//        Optional<Pedido> pedido = pedidoService.listarPorId(id);
//        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
package com.example.Produto.Controllers;

import com.example.Produto.model.Pedido;
import com.example.Produto.model.PedidoDTO;
import com.example.Produto.model.Cliente;
import com.example.Produto.model.Produto;
import com.example.Produto.Service.PedidoService;
import com.example.Produto.percistence.ClienteRepository;
import com.example.Produto.percistence.PedidoRepository;
import com.example.Produto.percistence.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;  // Injetando o ClienteRepository

    @Autowired
    private ProdutoRepository produtoRepository;  // Injetando o ProdutoRepository

    @Autowired
    private PedidoRepository pedidoRepository;  // Injetando o PedidoRepository

    // Método para salvar um pedido
    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody PedidoDTO pedidoDTO) {

        // Buscando o cliente pelo ID
        Cliente cliente = clienteRepository.findById(pedidoDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        // Buscando os produtos pelos IDs fornecidos no pedido
        List<Produto> produtos = produtoRepository.findAllById(pedidoDTO.getIdsProdutos());

        // Criando o pedido com os dados recebidos
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProdutos(produtos);

        // Salvando o pedido no banco de dados
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        // Retornando o pedido salvo com status 201 (Created)
        return ResponseEntity.status(201).body(pedidoSalvo);
    }

    // Método para listar todos os pedidos
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    // Método para listar um pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> listarPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.listarPorId(id);

        // Retorna o pedido se encontrado, senão retorna 404 Not Found
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para listar pedidos por ID do cliente
    @GetMapping("/cliente/{idCliente}")
    public List<Pedido> listarPorIdCliente(@PathVariable Long idCliente) {
        return pedidoService.listarPorIdCliente(idCliente);
    }

    // Método para listar pedidos por ID do produto
    @GetMapping("/produto/{idProduto}")
    public List<Pedido> listarPorIdProduto(@PathVariable Long idProduto) {
        return pedidoService.listarPorIdProduto(idProduto);
    }
}




