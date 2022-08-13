package Inicio.dao;


import Inicio.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

        public Boolean cadastrar(Cliente cliente);
        public void excluir(Long cpf);
        public void alterar(Cliente cliente);
        public Cliente consulta(Long cpf);
        public Collection<Cliente> buscarTodos();

}
