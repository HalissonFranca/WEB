import React, { useState } from 'react';
import axios from 'axios';

const ClienteForm = ({ fetchClientes }) => {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');
    const [telefone, setTelefone] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        if (!nome || !email || !telefone) {
            alert("Todos os campos são obrigatórios!");
            return;
        }

        const cliente = { nome, email, telefone };
        try {
            const response = await axios.post('http://localhost:8080/clientes', cliente);
            console.log('Cliente cadastrado:', response.data);
            fetchClientes();
            setNome('');
            setEmail('');
            setTelefone('');
        } catch (error) {
            console.error('Erro ao cadastrar cliente:', error.response ? error.response.data : error.message);
        }
    };

    return (
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
                <label>Email:</label>
                <input
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Telefone:</label>
                <input
                    type="text"
                    value={telefone}
                    onChange={(e) => setTelefone(e.target.value)}
                    required
                />
            </div>
            <button type="submit">Cadastrar Cliente</button>
        </form>
    );
};

export default ClienteForm;
