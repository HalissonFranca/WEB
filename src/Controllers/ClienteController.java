package com.example.Produto.Controllers;//package com.example.Produto.Controllers;
//
//import com.example.Produto.model.Cliente;
//import com.example.Produto.Service.ClienteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//// ClienteController.java
//@RestController
//@RequestMapping("/clientes")
//public class ClienteController {
//    @Autowired
//    private ClienteService clienteService;
//
//    @PostMapping
//    public Cliente salvar(@RequestBody Cliente cliente) {
//        return clienteService.salvar(cliente);
//    }
//
//    @GetMapping
//    public List<Cliente> listarTodos() {
//        return clienteService.listarTodos();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
//        Optional<Cliente> cliente = clienteService.listarPorId(id);
//        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/nome/{nome}")
//    public ResponseEntity<Cliente> listarPorNome(@PathVariable String nome) {
//        Optional<Cliente> cliente = clienteService.listarPorNome(nome);
//        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//}
//
import com.example.Produto.Service.ClienteService;
import com.example.Produto.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Salvar um novo cliente")
    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @Operation(summary = "Listar todos os clientes")
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Listar cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.listarPorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Listar cliente por nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Cliente> listarPorNome(@PathVariable String nome) {
        Optional<Cliente> cliente = clienteService.listarPorNome(nome);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
