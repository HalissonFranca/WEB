import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import ClientesList from './pages/Clientes/ClientesList';
import ClienteForm from './pages/Clientes/ClienteForm';
import ProdutosList from './pages/Produtos/ProdutosList';
import ProdutoForm from './pages/Produtos/ProdutoForm';
import PedidosList from './pages/Pedidos/PedidosList';
import PedidoForm from './pages/Pedidos/PedidoForm';
import MenuBar from './MenuBar';

function App() {
  return (
    <Router>
      <MenuBar /> {/* MenuBar visível em todas as páginas */}
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/clientes" element={<ClientesList />} />
        <Route path="/clientes/novo" element={<ClienteForm />} />
        <Route path="/produtos" element={<ProdutosList />} />
        <Route path="/produtos/novo" element={<ProdutoForm />} />
        {/*<Route path="/pedidos" element={<PedidosList />} />
        <Route path="/pedidos/novo" element={<PedidoForm />} />*/}
      </Routes>
    </Router>
  );
}

export default App;
