import java.util.List;
import java.util.ArrayList;

public class Favorito {

    private Usuario usuario;
    private List<Caracteristica> filtroSelecionado;
    private String ordenacao;

    @Override
    public String toString() {
        return "Favorito{" +
                "usuario=" + usuario +
                ", filtroSelecionado=" + filtroSelecionado +
                ", ordenacao='" + ordenacao + '\'' +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Caracteristica> getFiltroSelecionado() {
        return filtroSelecionado;
    }

    public void setFiltroSelecionado(List<Caracteristica> filtroSelecionado) {
        this.filtroSelecionado = filtroSelecionado;
    }

    public String getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }
}
