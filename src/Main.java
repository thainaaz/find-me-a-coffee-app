import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> listaUsuarios = new ArrayList<>();
        int opcao;

        do {
            System.out.println("==== Menu ====");
            System.out.println("1. Criar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("CADASTRO");
                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();

                    System.out.println("Digite a senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite o nome : ");
                    String nome = scanner.nextLine();

                    Usuario novoUsuario = new Usuario(nome, email, senha);
                    listaUsuarios.add(novoUsuario);

                    break;
                case 2:
                    System.out.println("Listar usuários");
                    for (Usuario u : listaUsuarios) {
                        System.out.println(u);
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();

    }

}