package com.souzaleandror.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.souzaleandror.agenda.dao.AlunoDAO;
import com.souzaleandror.agenda.model.Aluno;
import com.souzaleandror.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {
    private final Context context;
    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(this.context);
        dao = new AlunoDAO();
    }

    public void confirmaRemocao(final MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Removendo o aluno")
                .setMessage("Tem certeza que quer remover o aluno")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    assert menuInfo != null;
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Nao", null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.notifyDataSetChanged();
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        adapter.notifyDataSetChanged();
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void ConfiguraAdapter(ListView listStudents) {

        listStudents.setAdapter(adapter);
    }

}
