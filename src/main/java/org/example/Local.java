import org.example.roles.*;
import java.util.ArrayList;
import java.util.List;

public class Local {

    private String nome;
    private String linkMaps;
    private String descricao;
    private List<Caracteristica> caracteristicaList;
    private List <Avaliacao> avaliacaoList;

    public Local(String nome, String linkMaps, String descricao) {
        this.nome = nome;
        this.linkMaps = linkMaps;
        this.descricao = descricao;
        this.caracteristicaList = new ArrayList<>();
        this.avaliacaoList = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getLinkMaps() {
        return linkMaps;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLinkMaps(String linkMaps) {
        this.linkMaps = linkMaps;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarCaracteristica(Caracteristica c) {
        caracteristicaList.add(c);
    }
    public List<Caracteristica> getCaracteristicaList() { return caracteristicaList;}
    public void adicionarAvaliacao(Avaliacao a) {
        avaliacaoList.add(a);
    }
    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    @Override
    public String toString() {
        return "📍 " + nome + "\n"
                + "📝 " + descricao + "\n"
                + "🔗 " + linkMaps + "\n";
    }


}
