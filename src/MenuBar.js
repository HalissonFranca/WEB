import React from 'react';
import { AppBar, Toolbar, Typography, Button } from '@mui/material';

const MenuBar = () => (
    <AppBar position="static">
        <Toolbar>
            <Typography variant="h6" style={{ flexGrow: 1 }}>
                Sistema de Gestão
            </Typography>
            <Button color="inherit" href="/">Inicio</Button>
            <Button color="inherit" href="/clientes">Clientes</Button>
            <Button color="inherit" href="/produtos">Produtos</Button>
            {/*<Button color="inherit" href="/pedidos">Pedidos</Button>*/}
        </Toolbar>
    </AppBar>
);

export default MenuBar;
