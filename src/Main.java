import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean emailValido(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // ------------------ MOCK LOCAIS ------------------------------------- //

    public static List<Local> gerarLocaisMock() {
        List<Local> listaLocal = new ArrayList<>();

        Local novoLocal = new Local(
                "Café Cultura",
                "https://g.co/kgs/PNCfvzH",
                "(E)coar e (e)levar a cultura do café especial brasileiro!\n" +
                        "☕\uFE0FFranquia de cafeterias - associada à ABF.\n" +
                        "\uD83C\uDF7D Estamos no iFood e com Take Away!");
        novoLocal.adicionarCaracteristica(new Caracteristica("Coworking"));


        listaLocal.add(novoLocal);

        novoLocal = new Local(
                "Quiero Café",
                "https://g.co/kgs/RUSFRsf",
                "Café - Restaurante - Bar\n" +
                        "\uD83D\uDE0B Opções para todos os gostos e todas as horas do dia!\n" +
                        "\uD83D\uDCCD 78 unidades espalhadas pelo Brasil");
        novoLocal.adicionarCaracteristica(new Caracteristica("Pet Friendly"));

        listaLocal.add(novoLocal);

        novoLocal = new Local(
                "Garapuvu Café",
                "https://g.co/kgs/eA7Lq2r",
                "Certeza de bons momentos ☀\uFE0F\uD83E\uDD0D\n" +
                        "Café | Bistrô | Happy Hours | Eventos\n" +
                        "Abertos todos os dias, das 08h – 22hrs");

        listaLocal.add(novoLocal);

        return listaLocal;
    }
    // ------------------ SAÌDA  ------------------------------------- //


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Local> listaLocal = gerarLocaisMock();
        List<Caracteristica> caracteristicasDisponiveis = Caracteristica.mockCaracteristicas();

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

                    System.out.println("Seja Bem vindo (a)! O que você deseja fazer? ");


                    break;

                case 2:
                    int opcaoSubmenu;
                    do {
                        System.out.println("Encontrar um café");
                        System.out.println("1. Café mais próximo");
                        System.out.println("2. Café Pet friendly");
                        System.out.println("3. Café vegano");
                        System.out.println("4. Coworking");
                        System.out.println("0. Voltar");

                        opcaoSubmenu = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoSubmenu) {
                            case 1:
                                System.out.println("Cafés mais próximos:");
                                for (Local local : listaLocal) {
                                    System.out.println("- " + local.getNome());
                                    System.out.println("  Link: " + local.getLinkMaps());
                                    System.out.println("  Descrição: " + local.getDescricao());
                                    System.out.println();
                                }
                                break;
                            case 2:
                                System.out.println("Cafés que são Pet Friendly:");
                                boolean encontrou = false;
                                for (Local local : listaLocal) {
                                    for (Caracteristica c : local.getCaracteristicaList()) {
                                        if (c.getNome().equalsIgnoreCase("Pet Friendly")) {
                                            System.out.println(local);
                                            encontrou = true;
                                            break;
                                        }
                                    }
                                }
                                if (!encontrou) {
                                    System.out.println("Nenhum café Pet Friendly encontrado.");
                                }
                                break;
                            case 3:
                                System.out.println("Cafés que são Veganos:");
                                encontrou = false;
                                for (Local local : listaLocal) {
                                    for (Caracteristica c : local.getCaracteristicaList()) {
                                        if (c.getNome().equalsIgnoreCase("Café Vegano")) {
                                            System.out.println(local);
                                            encontrou = true;
                                            break;
                                        }
                                    }
                                }
                                if (!encontrou) {
                                    System.out.println("Nenhum café vegano foi encontrado.");
                                }
                                break;
                            case 4:
                                System.out.println("Cafés que possuem espaço Coworking:");
                                encontrou = false;
                                for (Local local : listaLocal) {
                                    for (Caracteristica c : local.getCaracteristicaList()) {
                                        if (c.getNome().equalsIgnoreCase("Coworking")) {
                                            System.out.println(local);
                                            encontrou = true;
                                            break;
                                        }
                                    }
                                }
                                if (!encontrou) {
                                    System.out.println("Nenhum café com espaço coworking foi encontrado.");
                                }
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    } while (opcaoSubmenu != 0);
                    break;

                case 3:
                    do {
                        System.out.println("Qual café deseja avaliar?");
                        for (int i = 0; i < listaLocal.size(); i++) {
                            System.out.println((i + 1) + ". " + listaLocal.get(i).getNome());
                        }
                        System.out.println("0. Voltar");

                        opcaoSubmenu = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoSubmenu >= 1 && opcaoSubmenu <= listaLocal.size()) {
                            Local cafe = listaLocal.get(opcaoSubmenu - 1);
                            System.out.println("Você esteve no " + cafe.getNome() + " recentemente e deseja avaliar esse local? Escolha uma das opções abaixo");
                            System.out.println("1. Pet Friendly");
                            System.out.println("2. Opções veganas");
                            System.out.println("3. Coworking");
                            System.out.println("0. Cancelar");

                            int escolha = scanner.nextInt();
                            scanner.nextLine();

                            if (escolha >= 1 && escolha <= 3) {
                                Caracteristica escolhida = caracteristicasDisponiveis.get(escolha - 1);
                                cafe.adicionarCaracteristica(escolhida);
                                System.out.println("Característica adicionada! O local possui essas características: ");
                                System.out.println(cafe.getCaracteristicaList());
                            } else if (escolha == 0) {
                                System.out.println("Avaliação cancelada.");
                            } else {
                                System.out.println("Opção inválida.");
                            }
                        } else if (opcaoSubmenu != 0) {
                            System.out.println("Opção inválida.");
                        }

                    } while (opcaoSubmenu != 0);
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