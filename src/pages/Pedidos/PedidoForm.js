import React, { useState, useEffect } from 'react';
import axios from 'axios';

const PedidoForm = ({ fetchPedidos }) => {
    const [clienteId, setClienteId] = useState('');
    const [produtoId, setProdutoId] = useState('');
    const [clientes, setClientes] = useState([]);
    const [produtos, setProdutos] = useState([]);

    useEffect(() => {
        fetchClientes();
        fetchProdutos();
    }, []);

    const fetchClientes = async () => {
        try {
            const response = await axios.get('http://localhost:8080/clientes');
            setClientes(response.data);
        } catch (error) {
            console.error('Erro ao buscar clientes:', error);
        }
    };

    const fetchProdutos = async () => {
        try {
            const response = await axios.get('http://localhost:8080/produtos');
            setProdutos(response.data);
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        if (!clienteId || !produtoId) {
            alert("Todos os campos são obrigatórios!");
            return;
        }

        // Aqui enviamos a lista de produtos, mesmo que tenha apenas um produto
        const pedido = {
            idCliente: Number(clienteId),
            idsProdutos: [Number(produtoId)]  // Enviando um array com um único ID de produto
        };

        try {
            // Enviando a requisição para o backend
            await axios.post('http://localhost:8080/pedidos', pedido, {
                headers: {
                    'Content-Type': 'application/json',
                },
            })
                .then(response => {
                    // Log da resposta do servidor
                    console.log('Resposta do servidor:', response);
                    fetchPedidos();  // Atualiza a lista de pedidos após o cadastro
                    alert('Pedido cadastrado com sucesso!');
                })
                .catch(error => {
                    console.error('Erro ao cadastrar pedido:', error.response ? error.response.data : error.message);
                    alert('Erro ao cadastrar pedido. Verifique os dados.');
                });
        } catch (error) {
            console.error('Erro ao enviar pedido:', error);
        }
    };


    return (
        <div className="form-container">
            <h2>Cadastrar Pedido</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>ID do Cliente:</label>
                    <input
                        type="number"
                        value={clienteId}
                        onChange={(e) => setClienteId(e.target.value)}
                        placeholder="Digite o ID do Cliente"
                        required
                    />
                </div>

                <div className="form-group">
                    <label>ID do Produto:</label>
                    <input
                        type="number"
                        value={produtoId}
                        onChange={(e) => setProdutoId(e.target.value)}
                        placeholder="Digite o ID do Produto"
                        required
                    />
                </div>

                <button type="submit">Cadastrar Pedido</button>
            </form>
        </div>
    );
};

export default PedidoForm;
