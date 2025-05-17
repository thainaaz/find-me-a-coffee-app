import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Caracteristica {

    private String nome;

    public Caracteristica(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }


// MOCK Características

    public static List<Caracteristica> mockCaracteristicas() {
        List<Caracteristica> lista = new ArrayList<>();
        lista.add(new Caracteristica("Pet friendly"));
        lista.add(new Caracteristica("Opções veganas"));
        lista.add(new Caracteristica("Coworking"));
        return lista;
    }
}

