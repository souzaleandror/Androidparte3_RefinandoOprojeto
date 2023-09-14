package com.souzaleandror.agenda.ui.activity;

import static com.souzaleandror.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.souzaleandror.agenda.R;
import com.souzaleandror.agenda.dao.AlunoDAO;
import com.souzaleandror.agenda.model.Aluno;
import com.souzaleandror.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunoActivity extends AppCompatActivity {

    public static final String LISTA_DE_ALUNOS = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO();
    private ListaAlunosAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(LISTA_DE_ALUNOS);
        setContentView(R.layout.activity_lista_alunos);
        ConfiguraFabNovoAluno();
        configuraLista();

//        dao.salva(new Aluno("test1", "123123", "test1@gmail.com"));
//        dao.salva(new Aluno("test2", "321123", "test2@gmail.com"));
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
            confirmaRemocao(item);

        }
        return super.onContextItemSelected(item);
    }

    private void confirmaRemocao(final MenuItem item) {
        new AlertDialog.Builder(this)
                .setTitle("Removendo o aluno")
                .setMessage("Tem certeza que quer remover o aluno")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                        Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                        remove(alunoEscolhido);
                    }
                })
                .setNegativeButton("Nao", null)
                .show();
    }

    private void ConfiguraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_aluno_fab);

        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioParaCriacaoDoAluno();
            }
        });
    }

    private void abreFormularioParaCriacaoDoAluno() {
        startActivity(new Intent(ListaAlunoActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void configuraLista() {
        ListView listStudents = findViewById(R.id.activity_lista_alunos_list_view);
        ConfiguraAdapter(listStudents);
        configuraListenerDeCliquePorItem(listStudents);
        registerForContextMenu(listStudents);
    }

    private void configuraListenerDeCliqueLongoPorItem(ListView listStudents) {
        listStudents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("Clique longo", "onItemLongClick: " + position);
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(position);
                remove(alunoEscolhido);
                return false;
            }
        });
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    private void configuraListenerDeCliquePorItem(ListView listStudents) {
        listStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(position);
                abreFormularioModoEditaAluno(alunoEscolhido);
            }
        });
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunoActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }
    private void ConfiguraAdapter(ListView listStudents) {
        adapter = new ListaAlunosAdapter(this);
        listStudents.setAdapter(adapter);
    }
}
