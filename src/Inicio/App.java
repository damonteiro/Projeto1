package Inicio;

import Inicio.dao.ClienteMapDAO;
import Inicio.dao.IClienteDAO;

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

//        while (isOpcaoValida(opcao)) {
//           if (isOpcaoSair(opcao)) {
//               sair();
//           }
//        }

        while (isOpcaoCadastro(opcao)) {
            if (cadastrar(opcao)) {
                sair();
            }
        }

        while (isOpcaoSair(opcao)) {
             sair(); {
            }
        }

    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        System.exit(0);
    }

    private static boolean cadastrar(String opcao) {
        return false;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            JOptionPane.showInputDialog(null, "Até Logo");
            System.exit(0);
        }
        return false;
    }



}