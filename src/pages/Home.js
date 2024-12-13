import React from 'react';
import { Link } from 'react-router-dom';
import { Container, Typography, Button, Box } from '@mui/material';

function Home() {
    return (
        <Container style={{ textAlign: 'center', marginTop: '50px' }}>
            <Typography variant="h3" gutterBottom>
                Bem-vindo ao Sistema de Gestão
            </Typography>
            <Typography variant="subtitle1" gutterBottom>
                Escolha uma das opções abaixo para navegar:
            </Typography>
            <Box mt={4}>
                <Button
                    variant="contained"
                    color="primary"
                    component={Link}
                    to="/clientes"
                    style={{ margin: '10px' }}
                >
                    Clientes
                </Button>
                <Button
                    variant="contained"
                    color="secondary"
                    component={Link}
                    to="/produtos"
                    style={{ margin: '10px' }}
                >
                    Produtos
                </Button>
                {/*<Button
                    variant="contained"
                    color="success"
                    component={Link}
                    to="/pedidos"
                    style={{ margin: '10px' }}
                >
                    Pedidos
                </Button>*/}
            </Box>
        </Container>
    );
}

export default Home;
