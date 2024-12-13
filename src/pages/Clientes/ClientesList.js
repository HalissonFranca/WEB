import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ClienteForm from './ClienteForm';

const ClientesList = () => {
    const [clientes, setClientes] = useState([]);
    const [buscarNome, setBuscarNome] = useState('');

    useEffect(() => {
        fetchClientes();
    }, []);

    const fetchClientes = async () => {
        try {
            const response = await axios.get('http://localhost:8080/clientes');
            setClientes(response.data);
        } catch (error) {
            console.error('Erro ao buscar clientes:', error);
        }
    };

    const handleBuscar = () => {
        if (buscarNome) {
            setClientes(clientes.filter(cliente => cliente.nome.includes(buscarNome)));
        } else {
            fetchClientes();
        }
    };

    return (
        <div>
            <div className="container">
                <h2>Lista de Clientes</h2>
                <input
                    type="text"
                    placeholder="Buscar por nome"
                    value={buscarNome}
                    onChange={(e) => setBuscarNome(e.target.value)}
                />
                <button onClick={handleBuscar}>Buscar</button>
                <ClienteForm fetchClientes={fetchClientes} />
                <ul>
                    {clientes.map((cliente) => (
                        <li key={cliente.id}>{cliente.nome} - {cliente.email}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default ClientesList;
