import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean emailValido(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // MOCK LOCAIS

    public static List<Local> gerarLocaisMock() {
        List<Local> listaLocal = new ArrayList<>();

        Local novoLocal = new Local(
                "Café Cultura",
                "https://g.co/kgs/RUSFRsf",
                "Café Cultura (E)coar e (e)levar a cultura do café especial brasileiro! ☕️ Franquia de cafeterias - associada à ABF. 🍽 Estamos no iFood e com Take Away!"
        );

        listaLocal.add(novoLocal);

        return listaLocal;
    }
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Local> listaLocal = gerarLocaisMock();

        int opcao;

        do {
            System.out.println("==== Menu ====");
            System.out.println("1. Criar usuário");
            System.out.println("2. Encontrar um café");
            System.out.println("3. Avaliar um café");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("CADASTRO");

                    System.out.println("Digite o email: ");

                    String email = scanner.nextLine();
                    while (!Main.emailValido(email)) {
                        System.out.println("Email inválido! Tente novamente: ");
                        email = scanner.nextLine();
                    }
                    System.out.println("Digite a senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite o nome : ");
                    String nome = scanner.nextLine();

                    Usuario novoUsuario = new Usuario(nome, email, senha);
                    listaUsuarios.add(novoUsuario);

                    break;
                case 2:
                    System.out.println("Encontrar um café");
                    System.out.println("1. Café mais próximo");
                    System.out.println("2. Café Pet friendly");
                    System.out.println("3. Café vegano");
                    System.out.println("0. Sair");

                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println(listaLocal);
                            break;
                        case 2:
                            break;

                        case 0:
                            System.out.println("Saindo do sistema...");
                            break;

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }

                    break;
                case 3:
                    System.out.println("Qual café deseja avaliar?");
                    System.out.println("1. Café cultura");
                    System.out.println("2. Quiero Café");
                    System.out.println("3. Garapuvu Café");
                    System.out.println("4. Café Decor");
                    System.out.println("0. Sair");

                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcao) {
                        case 1:
                            System.out.println("Você esteve no Café Cultura recentemente e deseja avaliar esse local? Escolha uma das opções abaixo");
                            System.out.println("1. Pet Friendly");
                            System.out.println("2. Opções veganas");
                            System.out.println("3. Coworking");
                            System.out.println("0. Sair");

                            opcao = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcao) {
                                case 1:



                            }


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