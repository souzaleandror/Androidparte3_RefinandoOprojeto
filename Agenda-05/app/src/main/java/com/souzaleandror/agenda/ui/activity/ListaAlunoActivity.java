package com.souzaleandror.agenda.ui.activity;

import static com.souzaleandror.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.souzaleandror.agenda.R;
import com.souzaleandror.agenda.model.Aluno;
import com.souzaleandror.agenda.ui.ListaAlunosView;

public class ListaAlunoActivity extends AppCompatActivity {
    public static final String LISTA_DE_ALUNOS = "Lista de Alunos";
    private ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(LISTA_DE_ALUNOS);
        setContentView(R.layout.activity_lista_alunos);
        ConfiguraFabNovoAluno();
        configuraLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_aluno_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(final MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.activity_lista_aluno_menu_remover) {
            listaAlunosView.confirmaRemocao(item);
        }
        return super.onContextItemSelected(item);
    }
    private void ConfiguraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_aluno_fab);
        botaoNovoAluno.setOnClickListener(v -> abreFormularioParaCriacaoDoAluno());
    }
    private void abreFormularioParaCriacaoDoAluno() {
        startActivity(new Intent(ListaAlunoActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }
    private void configuraLista() {
        ListView listStudents = findViewById(R.id.activity_lista_alunos_list_view);
        listaAlunosView.ConfiguraAdapter(listStudents);
        configuraListenerDeCliquePorItem(listStudents);
        registerForContextMenu(listStudents);
    }
    private void configuraListenerDeCliquePorItem(ListView listStudents) {
        listStudents.setOnItemClickListener((adapterView, view, position, id) -> {
            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(position);
            abreFormularioModoEditaAluno(alunoEscolhido);
        });
    }
    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunoActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }
}