import React, { useState, useEffect } from 'react';
import axios from 'axios';
import PedidoForm from './PedidoForm';

const PedidosList = () => {
    const [pedidos, setPedidos] = useState([]);
    const [buscarCliente, setBuscarCliente] = useState('');
    const [clientes, setClientes] = useState([]);
    const [produtos, setProdutos] = useState([]);

    useEffect(() => {
        fetchPedidos();
        fetchClientes();
        fetchProdutos();
    }, []);

    const fetchPedidos = async () => {
        try {
            const response = await axios.get('http://localhost:8080/pedidos');
            setPedidos(response.data);
        } catch (error) {
            console.error('Erro ao buscar pedidos:', error);
        }
    };

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

    const handleBuscar = (event) => {
        setBuscarCliente(event.target.value);
    };

    const pedidosFiltrados = pedidos.filter(pedido => {
        if (pedido.idCliente && buscarCliente) {
            return pedido.idCliente.toString().includes(buscarCliente);
        }
        return true;
    });

    const getClienteNome = (idCliente) => {
        const cliente = clientes.find(cliente => cliente.id === idCliente);
        return cliente ? cliente.nome : 'Cliente desconhecido';
    };

    const getProdutoNome = (idProduto) => {
        const produto = produtos.find(produto => produto.id === idProduto);
        return produto ? produto.nome : 'Produto não encontrado';
    };

    return (
        <div>

            <div className="container">
                <h2>Lista de Pedidos</h2>
                <input
                    type="text"
                    placeholder="Buscar por ID do Cliente"
                    value={buscarCliente}
                    onChange={handleBuscar}
                />
                <PedidoForm fetchPedidos={fetchPedidos} />
                <ul>
                    {pedidosFiltrados.length > 0 ? (
                        pedidosFiltrados.map((pedido) => (
                            <li key={pedido.id}>
                                <strong>Pedido ID:</strong> {pedido.id}<br />
                                <strong>Cliente:</strong> {getClienteNome(pedido.idCliente)}<br />
                                <strong>Produtos:</strong>
                                {Array.isArray(pedido.idsProdutos) && pedido.idsProdutos.length > 0
                                    ? pedido.idsProdutos.map(idProduto => getProdutoNome(idProduto)).join(', ')
                                    : 'Sem produtos'}
                            </li>
                        ))
                    ) : (
                        <li>Não há pedidos encontrados.</li>
                    )}
                </ul>
            </div>
        </div>
    );
};

export default PedidosList;
