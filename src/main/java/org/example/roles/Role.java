package org.example.roles;

import java.util.List;

public class Role {

    private String nome;
    private String email;
    private String senha;
    private String role;

    public Role(String nome, String email, String senha, String role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getSenha() {
        return senha;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método valida se o email já existe em alguma das listas das subclasses de Role, ainda que com roles diferentes.
    public static boolean validaEmailUnico(String email, List<? extends Role>... listas) {
        for (List<? extends Role> lista : listas) {
            for (Role r : lista) {
                if (r.getEmail().equalsIgnoreCase(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método valida se existe algum usuário válido com o email informado.

    public static boolean validaUser(String email, List<? extends Role>... listas) {
        for (List<? extends Role> lista : listas) {
            for (Role r : lista) {
                if (r.getEmail().equalsIgnoreCase(email))
                    return true;
            }
        }
        return false;
    }

    public static boolean validaSenha(String senha, List<? extends Role>... listas) {
        for (List<? extends Role> lista : listas) {
            for (Role r : lista) {
                if (r.getSenha().equalsIgnoreCase(senha)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Role{" +
                "nome: '" + nome + '\'' +
                ", email: '" + email + '\'' +
                ", senha: '" + senha + '\'' +
                ", role: '" + role + '\'' +
                '}';
    }
}
