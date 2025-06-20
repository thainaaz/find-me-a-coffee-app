package org.example.roles;

public class Administrador extends Role {

    public Administrador(String nome, String email, String senha, String role) {

        super(nome, email, senha, role);
    }

    public void gerenciarUsuarios() {
        System.out.println(getNome() + " está gerenciando usuários.");
    }
}
