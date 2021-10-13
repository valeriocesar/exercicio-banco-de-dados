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
                "Desenvolvimento básico em Java",
                6,
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
        cursoParaAtualizar.setDuracao_horas(6);
        cursoParaAtualizar.setData_conclusao("22/09/2021");

        //cursoDAO.update(cursoParaAtualizar);
        //cursoDAO.list().stream().forEach(System.out::println);


    }

}

