package Inicio;

import Inicio.dao.ClienteMapDAO;
import Inicio.dao.IClienteDAO;
import Inicio.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida! Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar ou 5 para sair.",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite Os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Numero, Cidade, Estado",
                        "CADASTRO DE CLIENTE", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if(isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF para consultar",
                        "CONSULTAR CLIENTE", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            }
        }
    }
                                                                                                                         //Abaixo estão os métodos de cada opção.

                                                                                                                         //Tentar validar se todos campos estão preenchidos.
    private static boolean isOpcaoValida(String opcao) {                                                                 //Se não estiver, passar no construtor, onde o valor é nulo.
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);    //Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],null,dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6])
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isSair(String opcao) {
        return ("5".equals(opcao));
    }
                                                                                                                         //Abaixo está a execução do que acontece em cada opção.

    private static boolean cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showInputDialog(null,"Cliente cadastrado com sucesso","Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } else {
            JOptionPane.showInputDialog(null,"Cliente já se encontra cadastrado","ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }

    private static void consultar(String dados) {                                                                        //Validar se entrou somente os 11 digitos (apenas numeros) do cpf.
        iClienteDAO.consultar(Long.parseLong(dados));
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até Logo");
        System.exit(0);
    }

}
