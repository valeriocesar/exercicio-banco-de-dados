package ExercicioCurso;

// É um espelho do banco de dados
public class Curso {

    private int id;
    private String nome;
    private int duracao_horas;
    private String data_conclusao;

    public Curso(int id, String nome, int duracao_horas, String data_conclusao) {
        this.id = id;
        this.nome = nome;
        this.duracao_horas = duracao_horas;
        this.data_conclusao = data_conclusao;
    }

    public Curso(String nome, int duracao_horas, String data_conclusao) {
        this.nome = nome;
        this.duracao_horas = duracao_horas;
        this.data_conclusao = data_conclusao;
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

    public int getDuracao_horas() {
        return duracao_horas;
    }

    public void setDuracao_horas(int duracao_horas) {
        this.duracao_horas = duracao_horas;
    }

    public String getData_conclusao() {
        return data_conclusao;
    }

    public void setData_conclusao(String data_conclusao) {
        this.data_conclusao = data_conclusao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Disciplina: ").append(nome).append('\n');
        sb.append("Duração da disciplina: ").append(duracao_horas).append(" hora(s)" + '\n');
        sb.append("Data da conclusão: ").append(data_conclusao).append('\n');
        sb.append("-----");
        return sb.toString();
    }
}