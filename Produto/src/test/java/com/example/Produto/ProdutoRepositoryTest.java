//package com.example.Produto;
//
//import com.example.Produto.model.Produto;
//import com.example.Produto.percistence.ProdutoRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//public class ProdutoRepositoryTest {
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//
//    @Test
//    public void quandoSalvarProduto_entaoEncontrarPorNome() {
//        Produto produto = new Produto();
//        produto.setNome("Tv");
//        produto.setId(1L);
//        produto.setPreco(10.0);
//
//        Produto produto2 = new Produto();
//        produto2.setNome("Monitor");
//        produto2.setId(2L);
//        produto2.setPreco(100.0);
//
//
//        // Salvar o produto
//        produtoRepository.save(produto);
//        produtoRepository.save(produto2);
//        System.out.println("Produto salvo com sucesso");
//
//        // Lendo o produto do repositório
//        Optional<Produto> encontrado = produtoRepository.findById(2L);
//        assertTrue(encontrado.isPresent(), "O produto deve estar presente após o salvamento.");
//
//        produto = encontrado.get();
//        System.out.println("Produto encontrado: " + produto.toString());
//
//        //Verificando se o nome do produto é o mesmo
//        assertEquals("Monitor", produto.getNome());
//    }
//}
