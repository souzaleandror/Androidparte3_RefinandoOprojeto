package com.souzaleandror.agenda;

import android.app.Application;

import com.souzaleandror.agenda.dao.AlunoDAO;
import com.souzaleandror.agenda.model.Aluno;

public class AgendaApplication extends Application {
    private final AlunoDAO dao = new AlunoDAO();
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunoDeTeste();
    }

    private void criaAlunoDeTeste() {
        dao.salva(new Aluno("test1", "123123", "test1@gmail.com"));
        dao.salva(new Aluno("test2", "321123", "test2@gmail.com"));
    }
}
