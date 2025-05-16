import java.util.List;
import java.util.ArrayList;

public class Avaliacao {
    private String nota;
    private String descricao;
    private String data;

    @Override
    public String toString() {
        return "Avaliacao{" +
                "nota='" + nota + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
