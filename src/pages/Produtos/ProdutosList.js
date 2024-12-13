import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ProdutoForm from './ProdutoForm';

const ProdutosList = () => {
    const [produtos, setProdutos] = useState([]);
    const [buscarNome, setBuscarNome] = useState('');

    useEffect(() => {
        fetchProdutos();
    }, []);

    const fetchProdutos = async () => {
        try {
            const response = await axios.get('http://localhost:8080/produtos');
            setProdutos(response.data);
        } catch (error) {
            console.error('Erro ao buscar produtos:', error);
        }
    };

    const handleBuscar = () => {
        if (buscarNome) {
            setProdutos(produtos.filter(produto => produto.nome.includes(buscarNome)));
        } else {
            fetchProdutos();
        }
    };

    return (
        <div className="container">
            <h2>Lista de Produtos</h2>
            <input
                type="text"
                placeholder="Buscar por nome"
                value={buscarNome}
                onChange={(e) => setBuscarNome(e.target.value)}
            />
            <button onClick={handleBuscar}>Buscar</button>
            <ProdutoForm fetchProdutos={fetchProdutos} />
            <ul>
                {produtos.map((produto) => (
                    <li key={produto.id}>{produto.nome} - R${produto.preco}</li>
                ))}
            </ul>
        </div>
    );
};

export default ProdutosList;
