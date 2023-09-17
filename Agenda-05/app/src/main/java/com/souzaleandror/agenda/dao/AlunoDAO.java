package com.souzaleandror.agenda.dao;

import androidx.annotation.Nullable;
import com.souzaleandror.agenda.model.Aluno;
import java.util.ArrayList;

public class AlunoDAO {
    private final static ArrayList<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }
    private static void atualizaIds() {
        contadorDeIds++;
    }
    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);

        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }
    @Nullable
    private static Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno alunoEscolhido) {
        Aluno alunoDevolvido = buscaAlunoPeloId(alunoEscolhido);
        if(alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }
}
