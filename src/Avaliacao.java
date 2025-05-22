import java.util.List;
import java.util.ArrayList;

public class Avaliacao {

    private String avaliacao;

    public Avaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "Avaliacao: " +
                "" + avaliacao;
    }
}
