package com.example.Produto.Service;

import com.example.Produto.model.Cliente;
import com.example.Produto.model.Pedido;
import com.example.Produto.model.PedidoDTO;
import com.example.Produto.model.Produto;
import com.example.Produto.percistence.ClienteRepository;
import com.example.Produto.percistence.PedidoRepository;
import com.example.Produto.percistence.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// PedidoService.java
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para salvar um pedido
    public Pedido salvar(PedidoDTO pedidoDTO) {

        // Buscando o cliente pelo ID (cliente ID está em pedidoDTO)
        Cliente cliente = clienteRepository.findById(pedidoDTO.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        // Buscando os produtos pelos IDs (produtos ID estão em pedidoDTO)
        List<Produto> produtos = produtoRepository.findAllById(pedidoDTO.getIdsProdutos());

        // Criando um novo pedido e associando cliente e produtos
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);  // Associa o cliente ao pedido
        pedido.setProdutos(produtos);  // Associa os produtos ao pedido

        // Salvando o pedido no banco
        return pedidoRepository.save(pedido);
    }

    // Método para listar todos os pedidos
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    // Método para buscar um pedido pelo ID
    public Optional<Pedido> listarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Método para listar pedidos por ID do cliente
    public List<Pedido> listarPorIdCliente(Long idCliente) {
        return pedidoRepository.findByClienteId(idCliente);  // Método necessário no repositório
    }

    // Método para listar pedidos por ID do produto
    public List<Pedido> listarPorIdProduto(Long idProduto) {
        return pedidoRepository.findByProdutosId(idProduto);  // Método necessário no repositório
    }
}
//
//import com.example.Produto.model.Cliente;
//import com.example.Produto.model.Pedido;
//import com.example.Produto.model.PedidoDTO;
//import com.example.Produto.model.Produto;
//import com.example.Produto.percistence.ClienteRepository;
//import com.example.Produto.percistence.PedidoRepository;
//import com.example.Produto.percistence.ProdutoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class PedidoService {
//
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    // Método para criar um pedido
//    @Transactional
//    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
//        // Buscar o cliente pelo ID
//        Cliente cliente = clienteRepository.findById(pedidoDTO.getIdCliente())
//                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//
//        // Buscar os produtos pelos IDs
//        List<Produto> produtos = produtoRepository.findAllById(pedidoDTO.getIdsProdutos());
//
//        // Verificar se todos os produtos foram encontrados
//        if (produtos.size() != pedidoDTO.getIdsProdutos().size()) {
//            throw new RuntimeException("Um ou mais produtos não encontrados");
//        }
//
//        // Criar o pedido
//        Pedido pedido = new Pedido();
//        pedido.setCliente(cliente);  // Definir o cliente
//        pedido.setProdutos(produtos);  // Definir a lista de produtos
//
//        // Salvar o pedido
//        pedido = pedidoRepository.save(pedido);
//
//        // Converter para DTO e retornar
//        return new PedidoDTO(pedido);
//    }
//
//    // Método para listar todos os pedidos
//    public List<PedidoDTO> listarPedidos() {
//        List<Pedido> pedidos = pedidoRepository.findAll();
//        return pedidos.stream()
//                .map(pedido -> new PedidoDTO(pedido))
//                .collect(Collectors.toList());
//    }
//
//    // Método para buscar um pedido por ID
//    public PedidoDTO buscarPedidoPorId(Long id) {
//        Pedido pedido = pedidoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
//        return new PedidoDTO(pedido);
//    }
//
//    // Método para deletar um pedido
//    @Transactional
//    public void deletarPedido(Long id) {
//        Pedido pedido = pedidoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
//        pedidoRepository.delete(pedido);
//    }
//}
//
//
