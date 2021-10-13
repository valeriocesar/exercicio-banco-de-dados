package ExercicioCurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // Consulta
    public List<Curso> list() {

        // Cria uma lista do curso
        List<Curso> cursos = new ArrayList<>();

        // Cria a conexão utilizando a ConnectionFactory
        try (Connection conn = ConnectionFactory.getConnection()) {

            // Cria a consulta SQL
            String sql = "SELECT * FROM curso";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Executa a consulta e recebe no retorno no objeto rs
            ResultSet rs = stmt.executeQuery();

            // Percorre os valores
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracao_horas = rs.getInt("duracao_horas");
                String data_conclusao = rs.getString("data_conclusao");

                // Adiciona os registros na lista
                cursos.add(new Curso(
                        id,
                        nome,
                        duracao_horas,
                        data_conclusao
                ));
            }
        } catch (SQLException e) {
            System.out.println("Houve um erro na consulta." + '\n');
            e.printStackTrace();
        }

        // Retorna os dados da lista
        return cursos;
    }

    // Consulta com filtro
    public Curso getById(int id) {

        // Cria o objeto Curso pois vai retornar apenas um valor
        Curso curso = new Curso();

        // Cria a conexão utilizando a ConnectionFactory
        try (Connection conn = ConnectionFactory.getConnection()) {

            // Cria a consulta SQL com parâmetro
            String sql = "SELECT * FROM curso WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa a consulta e recebe no retorno no objeto rs
            ResultSet rs = stmt.executeQuery();

            // Percorre os valores
            if (rs.next()) {
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaoHoras(rs.getInt("duracao_horas"));
                curso.setDataConclusao(rs.getString("data_conclusao"));
            }

        } catch (SQLException e) {
            System.out.println("Houve um erro na consulta." + '\n');
            e.printStackTrace();
        }

        // Retorna o curso encontrado no banco de dados
        return curso;
    }

    // Inserção
    public void create(Curso curso) {

        // Cria a conexão utilizando a ConnectionFactory
        try (Connection conn = ConnectionFactory.getConnection()) {

            // Cria a inserção SQL com parâmetro
            String sql = "INSERT INTO curso(nome, duracao_horas, data_conclusao) VALUES(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setString(3, curso.getDataConclusao());

            // Executa inserção e retorna número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserido com sucesso! Foi adicionado " + rowsAffected + " registro." + '\n');
        } catch (SQLException e) {
            System.out.println("Houve um erro na inserção." + '\n');
            e.printStackTrace();
        }
    }

    // Delete
    public void delete(int id) {

        // Cria a conexão utilizando a ConnectionFactory
        try (Connection conn = ConnectionFactory.getConnection()) {

            // Cria o delete SQL com parâmetro
            String sql = "DELETE FROM curso WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executa delete e retorna número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Excluído com sucesso! Foi deletado " + rowsAffected + " registro." + '\n');
        } catch (SQLException e) {
            System.out.println("Houve um erro na exclusão." + '\n');
            e.printStackTrace();
        }
    }

    // Atualizar
    public void update(Curso curso) {

        // Cria a conexão utilizando a ConnectionFactory
        try (Connection conn = ConnectionFactory.getConnection()) {

            // Cria o update SQL com parâmetro
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ?, data_conclusao = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setString(3, curso.getDataConclusao());
            stmt.setInt(4, curso.getId()); // Id é o parâmetro

            // Executa update e retorna número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualizado com Sucesso! Foi atualizado " + rowsAffected + " registro." + '\n');
        } catch (SQLException e) {
            System.out.println("Houve um erro na atualização." + '\n');
            e.printStackTrace();
        }
    }

}