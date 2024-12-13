import React, { useState } from 'react';
import axios from 'axios';
import { AppBar, Toolbar, Typography, Button } from '@mui/material';

const ProdutoForm = ({ fetchProdutos }) => {
    const [nome, setNome] = useState('');
    const [preco, setPreco] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        if (!nome || !preco || preco <= 0) {
            alert("Todos os campos são obrigatórios e o preço deve ser maior que zero!");
            return;
        }

        const produto = { nome, preco };
        try {
            await axios.post('http://localhost:8080/produtos', produto);
            fetchProdutos();  // Atualiza a lista de produtos
            setNome('');
            setPreco('');
        } catch (error) {
            console.error('Erro ao cadastrar produto:', error);
        }
    };

    return (
        <div>


            {/* Formulário de Produto */}
            <div>
                <h2>Cadastrar Produto</h2>
                <form onSubmit={handleSubmit}>
                    <div>
                        <label>Nome:</label>
                        <input
                            type="text"
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <label>Preço:</label>
                        <input
                            type="number"
                            value={preco}
                            onChange={(e) => setPreco(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit">Cadastrar Produto</button>
                </form>
            </div>
        </div>
    );
};

export default ProdutoForm;