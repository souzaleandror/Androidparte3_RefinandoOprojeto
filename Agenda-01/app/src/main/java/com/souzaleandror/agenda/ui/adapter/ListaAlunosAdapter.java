package com.souzaleandror.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.souzaleandror.agenda.R;
import com.souzaleandror.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false);
        Aluno alunoDelvovido = alunos.get(position);
        TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
        nome.setText(alunoDelvovido.getNome());
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
        telefone.setText(alunoDelvovido.getTelefone());
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(ArrayList<Aluno> todos) {
        this.alunos.addAll(todos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }
}
