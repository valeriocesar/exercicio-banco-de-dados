package ExercicioCurso;

import java.util.List;

public class QueriesExecution {

    public static void main(String[] args) {

        CursoDAO cursoDAO = new CursoDAO();

        System.out.println("----- Bootcamp everis New Talents #2 Java -----" + '\n');

        // ----- Consulta ----- //
        List<Curso> cursos = cursoDAO.list();

        //cursos.forEach(System.out::println);


        // ----- Consulta com filtro ----- //
        //Curso cursoParaConsulta = cursoDAO.getById(10);

        //System.out.println(cursoParaConsulta);


        // ----- Inserção ----- //
        Curso cursoParaInsercao = new Curso(
                "Introducao a orientacao a objetos com Java",
                2,
                "22/09/2021"
        );

        //cursoDAO.create(cursoParaInsercao);
        //cursoDAO.list().stream().forEach(System.out::println);


        // ----- Delete ----- //
        //cursoDAO.delete(6);

        //cursoDAO.list().stream().forEach(System.out::println);


        // ----- Atualizar ----- //
        Curso cursoParaAtualizar = cursoDAO.getById(10);
        cursoParaAtualizar.setNome("Desenvolvimento basico em Java");
        cursoParaAtualizar.setDuracaoHoras(6);
        cursoParaAtualizar.setDataConclusao("22/09/2021");

        //cursoDAO.update(cursoParaAtualizar);
        //cursoDAO.list().stream().forEach(System.out::println);


    }

}

