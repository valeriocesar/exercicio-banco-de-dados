package ExercicioCurso;

// É um espelho do banco de dados
public class Curso {

    private int id;
    private String nome;
    private int duracaoHoras;
    private String dataConclusao;

    public Curso(int id, String nome, int duracaoHoras, String dataConclusao) {
        this.id = id;
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.dataConclusao = dataConclusao;
    }

    public Curso(String nome, int duracaoHoras, String dataConclusao) {
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.dataConclusao = dataConclusao;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Disciplina: ").append(nome).append('\n');
        sb.append("Duração da disciplina: ").append(duracaoHoras).append(" hora(s)" + '\n');
        sb.append("Data da conclusão: ").append(dataConclusao).append('\n');
        sb.append("-----");
        return sb.toString();
    }
}