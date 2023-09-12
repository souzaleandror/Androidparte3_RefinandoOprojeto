#### 12/09/2023

Curso de Android parte 3: refinando o projeto

@01-Personalizando layout da lista de alunos

@@01
Introdução

Olá! Sou o instrutor Alex Felipe, e apresentarei a terceira parte do curso Fundamentos no Android: Refinando o Projeto.
É importante que você tenha concluído as duas primeiras partes e suas atividades antes de iniciar este, pois será preciso o conhecimento base e o projeto desenvolvido anteriormente para avançar.

Nesta etapa do curso, iremos implementar novas features e funcionalidades, além de focar em algumas técnicas para aumentar a qualidade do projeto de acordo com o padrão de desenvolvedores Android.

O primeiro passo será criar um layout personalizado para os alunos em uma list view. Para isso, teremos alguns desafios: como o caso de um Adapter personalizado que veremos mais adiante.

Depois, resolveremos a questão de rotação da tela apresentada no curso anterior, a partir da camada application e sua utilização.

Outra feature que desenvolveremos será no momento de remoção dos alunos através de uma caixa de diálogo ou dialog que confirma a ação, proporcionando uma maior atenção ao usuário.

Vamos lá!

@@02
Atualização do conteúdo
PRÓXIMA ATIVIDADE

Atualização do conteúdo
Desde a gravação do curso, houve algumas mudanças em relação ao Android Studio e SDK do Android. O curso, gravado em janeiro de 2019, utilizou a versão 3.2.1 do Android Studio e o SDK 28 do Android.

Considerando as mudanças ocorridas nesse período, atualizamos o conteúdo do curso com base no que temos hoje. (Janeiro de 2021)

Mudanças no projeto
Isso significa que o projeto, disponibilizado no começo das aulas e no final do curso, foi atualizado. Na atualização migramos para a API 30 (Android 11), utilizamos o AndroidX em vez do Android Support e adicionamos o suporte do Java 8 (ambos mencionados durante o curso).

Mudanças no ambiente de desenvolvimento
Agora, temos a versão 4.1 do Android Studio disponível. A revisão e a atualização do conteúdo foram baseadas nesta versão do AS, portanto, você pode utilizar a versão 4.1 sem problemas.

Se preferir, você pode usar uma versão mais recente, caso esteja disponível.
Mudanças no conteúdo do curso
Quando ocorrem essas mudanças, que são diferentes do conteúdo do curso, é muito comum duvidarmos e questionarmos se o que está sendo ensinado no curso é válido para o momento atual.

Não se preocupe! O objetivo da avaliação é manter o conteúdo atualizado sem impactar na sua experiência durante os estudos. É válido ressaltar que, devido à atualização, há mudanças visuais no AS.

Nos casos em que a diferença for muito grande do que é visto em vídeo, no exercício seguinte serão apresentadas as instruções necessárias.

No geral, mudanças não são algo ruim, muito pelo contrário! Elas mostram que o Android framework e o AS estão em constante evolução e isso é excelente, pois indica uma melhoria constante :)

Código-fonte com as mudanças
Caso tenha interesse em verificar todas as mudanças na atualização, confira o commit de atualização do projeto final.

Se tiver alguma dúvida sobre as mudanças, fique à vontade em entrar em contato com a gente.

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/b118735cbc997630d51d9ad123d0be0cb7909659

@@03
Orientações iniciais e organização do curso
PRÓXIMA ATIVIDADE

Pré-requisitos
Neste curso, esperamos que você já tenha todo o conhecimento ensinado no segundo curso de fundamentos de Android.

Caso você não tenha feito o curso, mas acredita que possa começar a partir daqui, fique à vontade para continuar, porém, se tiver algum conteúdo que não foi explicado com tanta atenção, muito provavelmente é porque já foi explicado em um desses cursos. De qualquer forma, você pode entrar em contato com a gente por meio do fórum.

Como o curso está organizado
Cada aula vai ter vídeos e exercícios, sendo que cada vídeo vai manter, pelo menos, um exercício.

Esse é um curso classificado como intermediário, isso significa que alguns exercícios não serão tão passo a passo como um curso básico. Mas não se preocupe, todas as orientações necessárias serão apresentadas.

Fique à vontade para primeiro assistir a aula, prestar atenção no conteúdo, e depois executar o que foi feito em aula apenas no exercício.

Se preferir executar as etapas junto com o instrutor, fique à vontade, porém, saiba que daremos todo auxílio necessário nos exercícios. Recomendamos fortemente primeiro assistir a aula com atenção para depois praticar :)

https://cursos.alura.com.br/course/fundandroid-2

@@04
Preparando o ambiente - Baixando o projeto inicial
PRÓXIMA ATIVIDADE

Neste curso continuaremos com o projeto desenvolvido no segundo curso de fundamentos de Android. Caso você tenha feito o projeto, pode continuar com ele sem nenhum problema. Caso contrário, você pode baixar o projeto inicial a abrí-lo no Android Studio.
Para abrir o projeto a partir do arquivo baixado, faça a extração do zip para um local onde costuma deixar seus projetos.

Então, na tela inicial do Android Studio, clique em Open an existing Android Studio project. Nesse instante vai abrir um explorador de arquivos, encontre o projeto que foi extraído, então clique em OK.

Para abrir o projeto no AS 4.1, utilize a opção Open an Existing Project ao invés de Open an existing Android Studio project.
Nesse instante, o Android Studio vai rodar algumas tasks do Gradle para configurar o projeto, então aguarde a finalização. Depois que terminar, execute em um dispositivo e veja se o App funciona.

https://github.com/alura-cursos/fundamentos-android-parte-3/archive/projeto-inicial.zip

@@05
Personalizando layout do aluno

Nosso aplicativo já funciona muito bem! Mas devemos pensar na qualidade geral do projeto. Há diversas melhorias visuais ou via código que podemos aplicar, e que serão o foco nesta etapa.
Então vamos começar:

O primeiro passo será sobre a lista de alunos e a adição de informações. Ao longo do curso, trabalhamos com uma lista simples contendo somente o nome do aluno. E se tratando de um projeto de agenda, é importante que apresente outros dados, como o telefone de contato.

Para isso, entraremos na classe Aluno.java e vamos concatenar a informação de:

@NonNull
@Override
public String toString() { return nome; }COPIAR CÓDIGO
para

@NonNull
@Override
public String toString() { return nome + " - " + telefone; }COPIAR CÓDIGO
Após a execução do projeto pelo Android Studio, ele apresentará o resultado. Agora com a informação disponível, é preciso prestar atenção ao visual que tornará o produto mais atrativo.

Vamos nos dedicar ao layout personalizado de cada item da lista via arquivo estático.

Entre em "res > layout" Use o atalho "alt + insert" para abrir o menu "New" e selecionar a opção "Layout resource file".

No campo "file name", insira o nome do layout que representará o item da lista. Podemos padronizar escrevendo "item_aluno" por exemplo, identificando-o.

Agora, vamos definir nosso "Root element" como LinearLayout e finalizar, gerando o arquivo item_aluno.xml.

Já aprendemos como criar nossos layouts. O próximo passo é personalizar e aplicar dois textviews:

<TextView android: id="@+id/item_aluno_nome"
    android: layout_width="match_parent"
    android: layout_height="wrap_content" />

<TextView android: id="@+id/item_aluno_telefone"
    android: layout_width="match_parent"
    android: layout_height="wrap_content" />COPIAR CÓDIGO
Para vermos como o texto de cada item está ficando sem ter de executar o layout, usaremos o tools a ser importado desta forma, por exemplo:

<TextView android: id="@+id/item_aluno_nome"
    android: layout_width="match_parent"
    android: layout_height="wrap_content"
    tools:text="Alex"/> 

<TextView android: id="@+id/item_aluno_telefone"
    android: layout_width="match_parent"
    android: layout_height="wrap_content"
    tools:text="1122223333"/> COPIAR CÓDIGO
Para personalizar o tamanho da fonte de forma que permita a proporção e a acessibilidade, bem como a distância agradável das margens, adicione:

<TextView android: id="@+id/item_aluno_nome"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textSize="24sp"
    android:layout_margin="8dp"
    tools:text="Alex"/> COPIAR CÓDIGO
<TextView android: id="@+id/item_aluno_telefone"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginStart="8dp"
    android:layout_marginEnd="8dp"
    tools:text="1122223333"/> COPIAR CÓDIGO

Agora com o layout pronto, temos que aplicá-lo no list view modificando o Adapter que faz a renderização dos elementos que queremos.

Para isso, voltaremos à classe ListaAlunosActivity.java. No final, modifique:

private void configuraAdapter(ListView listaDeAlunos) {
    adapter = new ArrayAdapter<>(
            context: this,
            android.R.layout.simple_list_item_1);
    listaDeAlunos.set.Adapter(adapter);
}COPIAR CÓDIGO
Para:

private void configuraAdapter(ListView listaDeAlunos) {
    adapter = new ArrayAdapter<>(
            context: this,
            R.layout.item_aluno);
    listaDeAlunos.set.Adapter(adapter);
}COPIAR CÓDIGO
Execute o projeto e visualize no emulador o resultado.

Porém, um erro inesperado acontece e temos que resolvê-lo. Usaremos o LogCatch para tentar executar novamente, limpando o Log e filtrando para exibir somente os erros do nosso aplicativo. Logo aparece java.lang.IllegalStateExcepiton: ArrayAdapter requires the resource ID to be a TextView, significando que o estado deve ser apenas um TextView.

Tendo isso em vista, comentaremos o trecho final do LinearLayout, assim como começo layout para testar a execução, deixando apenar um TextView.

Como resultado, concluímos que se quisermos fazer uma lista com layout personalizado, precisaremos de um Adapter alternativo. Vejamos na próxima etapa.

@@06
Criando layout personalizado
PRÓXIMA ATIVIDADE

Crie um layout que vai representar cada aluno na ListView. Para isso, crie um arquivo com o nome item_aluno e implemente um layout que apresenta um aspecto visual similar a este:


Lembre-se de usar o tools para apresentar o texto do TextView apenas durante a edição.

O layout não precisa ser exatamente o mesmo, você pode usar a sua criatividade para fazer algo diferente. Ao menos, coloque um layout que tenha uma view para o nome e outra para o telefone.
Esse exercício não precisa executar o projeto, apenas atinja o mesmo resultado visual do layout personalizado no editor.

O código do layout implementado ficou da seguinte maneira:
item_aluno.xml:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/item_aluno_nome"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="8dp"
        android:textSize="24sp"
        tools:text="Alex" />

    <TextView
        android:id="@+id/item_aluno_telefone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        tools:text="1122223333" />

</LinearLayout>COPIAR CÓDIGO
Caso queira realizar o mesmo teste com o ArrayAdapter, segue o mesmo layout que mantém apenas o TextView para o nome disponível:

<?xml version="1.0" encoding="utf-8"?>
<!--<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"-->
    <!--xmlns:tools="http://schemas.android.com/tools"-->
    <!--android:orientation="vertical"-->
    <!--android:layout_width="match_parent"-->
    <!--android:layout_height="match_parent">-->

<TextView android:id="@+id/item_aluno_nome"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textSize="24sp"
    android:layout_margin="8dp"
    tools:text="Alex"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools" />

    <!--<TextView android:id="@+id/item_aluno_telefone"-->
        <!--android:layout_width="match_parent"-->
        <!--android:layout_height="wrap_content"-->
        <!--android:layout_marginStart="8dp"-->
        <!--android:layout_marginEnd="8dp"-->
        <!--tools:text="1122223333"/>-->

<!--</LinearLayout>-->COPIAR CÓDIGO
E o código Java:

ListaAlunosActivity.java:
private void configuraAdapter(ListView listaDeAlunos) {
    adapter = new ArrayAdapter<>(
            this,
            R.layout.item_aluno);
    listaDeAlunos.setAdapter(adapter);
}COPIAR CÓDIGO
Esse teste não é necessário, pois vamos resolver aos poucos a implementação do layout personalizado.

@@07
Implementando o BaseAdapter

Identificamos a necessidade de um Adapter alternativo para que cada elemento de uma ListView tenha um layout personalizado.
Retomando nosso projeto, podemos perceber um método ListaDeAlunos.setAdapter() que pode receber qualquer referência que faça a implementação de um ListAdapter, a interface exigida.

Como a implementação da ListAdapter não é tão simples, o Android disponibiliza outra classe abstrata com comportamento similar ao ArrayAdapter que permite a personalização que procuramos, o BaseAdapter.

A única diferença é só permitir a implementação de métodos necessários à personalização do Adapter. Então,

Private void configuraAdapter(ListView ListaDeAlunos) {
    adapter = new ArrayAdapter<>(
             context: this,
             R.layout.item_aluno);
    listaDeAlunos.setAdapter(new BaseAdapter()  {
    // código omitido
    }
//código omitido
}COPIAR CÓDIGO
Assim, novos quatro métodos são apresentados na sequência. O primeiro, getCount(), indica a quantidade de elementos que um Adapter terá, e nós podemos inserir a quantidade de alunos da lista. Por exemplo:

@Override
public int getCount()  {
    return dao.todos().size();
}COPIAR CÓDIGO
Porém, esta implementação ficará acoplada ao nosso dao, e vimos que o ArrayAdapter funciona de forma independente. Ou seja, cada vez que implementarmos um Adapter, sempre haverá uma lista interna que representará seu conjunto de dados, o DataSet.

Ao invés de usar nossa atual implementação do dao, podemos criar nosso próprio Dataset especializado do Adapter:

Private void configuraAdapter (ListView ListaDeAlunos) {
    adapter = new ArrayAdapter<>(
             context: this,
             R.layout.item_aluno);
    listaDeAlunos.setAdapter(new BaseAdapter() {

        private final List<Aluno> alunos = new ArrayList<>();

        @Override
        public int getCount() {
            return alunos.size();
        }
// código omitido
}COPIAR CÓDIGO
O método seguinte representa o elemento que queremos com base em uma posição, devolvendo-o. A posição será o parâmetro i que devolverá o Object, os quais podemos modificar para facilitar o uso, desta forma:

@Override
public Aluno getItem(int posicao) {
    return alunos.get(posicao);
}COPIAR CÓDIGO
Em seguida, será representado o Id do elemento que estamos lidando. Atente ao fato de que em alguns casos a implementação não possui Id, podendo então ser mantido o valor inicial, compatível ou não com o public long. Porém, em nosso caso, há compatibilidade e Id definido anteriormente.

@Override
public long getItemId(int posicao) {
    return alunos.get(posicao).getId();
}COPIAR CÓDIGO
Passando ao próximo método, podemos alterar o layout do nosso projeto, o getView. Relembre o procedimento similar dos nossos menus a partir de um arquivo estático com o processo de inflate, através do LayoutInflater.

Aqui, usaremos este objeto com o método de implementação from que representa a origem deste layout, como trabalhamos no AdaptView.

@Override
public View getView(int i, View view, ViewGroup viewGroup) {
    View viewCriada = LayoutInflater
        .from(ListaAlunosActivity.this)
        .inflate(R.layout.item_aluno, viewGroup);
    return viewCriada;
}COPIAR CÓDIGO
Ao executar, identificamos um problema: visualmente, os alunos não estão sendo apresentados. Isso acontece porque apenas criamos a instância do BaseAdapter, enquanto as operações de adição estão sendo feitas a partir do ArrayAdapter.

A seguir, trabalharemos somente com nossa nova instância e veremos os resultados.

@@08
Implementando métodos do BaseAdapter
PRÓXIMA ATIVIDADE

Dentro do setAdapter() da ListView, implemente a classe abstrata BaseAdapter como classe anônima. Ela exige a implementação dos seguintes métodos:
getCount() -> representa a quantidade de elementos do adapter;
getItem() -> Retorna o elemento pela posição;
getItemId() -> retornar o id do elemento pela posição;
getView() -> cria a view para cada elemento.
Para os métodos getCount(), getItem() e getItemId(), utilize os métodos da lista de alunos de acordo com o objetivo do método.

No getView() faça o processo de inflar layout a partir do LayoutInflater. Dentre as opções disponíveis, considere o uso do método estático from() que recebe um Context, para depois chamar o inflate() enviando o layout (item_aluno) e o ViewGroup (ListView recebida via parâmetro).

Por fim, teste o App e veja se ele não quebra.

Nesse momento, não deve aparecer a lista de alunos, pois as demais operações ainda estão sendo feitas com o ArrayAdapter. O código de implementação do BaseAdapter ficou da seguinte maneira:
ListaAlunosActivity.java:
private void configuraAdapter(ListView listaDeAlunos) {
    adapter = new ArrayAdapter<>(
            this,
            R.layout.item_aluno);
    listaDeAlunos.setAdapter(new BaseAdapter() {

        private final List<Aluno> alunos = new ArrayList<>();

        @Override
        public int getCount() {
            return alunos.size();
        }

        @Override
        public Aluno getItem(int posicao) {
            return alunos.get(posicao);
        }

        @Override
        public long getItemId(int posicao) {
            return alunos.get(posicao).getId();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewCriada = LayoutInflater
                    .from(ListaAlunosActivity.this)
                    .inflate(R.layout.item_aluno, viewGroup);
            return viewCriada;
        }
    });
}COPIAR CÓDIGO
A seguir vamos migrar o uso do ArrayAdapter para o BaseAdapter.

@@09
Criando o adapter personalizado

Vamos dar continuidade à implementação do Adapter personalizado modificando a referência do ArrayAdapter para o BaseAdapter.
Para isso, removeremos a seguinte parte da inicialização:

adapter = new ArrayAdapter<>(
    context: this,
    R.layout.item_aluno);COPIAR CÓDIGO
E eliminaremos também o atributo que criamos para disponibilizar o acesso a todos os membros da Activity, encerrando a compilação:

private ArrayAdapter<Aluno> adapter;COPIAR CÓDIGO
Agora, criaremos a nova referência através do próprio Android Studio. Selecionando todo o código usado para implementar a classe anônima via BaseAdapter, utilizamos o atalho "Ctrl + Alt + F" para extrair o atributo. Manteremos o mesmo nome para os demais membros continuarem tendo acesso.

Feito isso, criamos um Adapter personalizado com a nova referência já com o setAdapter, declarado no início.

Porém, as chamadas não estão mais funcionando da mesma forma. Isso acontece porque os comportamentos que queremos não são tão genéricos para atender as assinaturas do próprio BaseAdapter.

Ou seja, quando pedimos o getItem, este não retorna um aluno, e sim um Object. É preciso uma classe específica para implementar o BaseAdapter fazendo com que haja uma assinatura que se comporte de acordo com o que planejamos.

Nesta nova classe, teremos os métodos clear(), addAll() e remove() que não pertencem originalmente ao BaseAdapter, e sim a um outro Adapter, como o caso do ArrayList que faz sua própria implementação.

Portanto, sempre que utilizar o BaseAdapter e necessitar de comportamentos que alteram o DataSet ou que retornem o que planeja, precisará de uma classe específica.

Criaremos então um Adapter personalizado com uma classe destinada aos componentes visuais do nosso projeto dentro do pacote ui.activity. Pelo atalho "Alt + Insert", selecionamos "Java Class", nomeando como "ListaAlunosAdapter". No campo "package", altere para br.com.alura.agenda.ui.adapter e finalize.

Realizaremos agora a implementação de um BaseAdapter em nossa nova classe. Para facilitar, podemos selecionar, copiar do ListaAlunosActivity.java e colar no novo pacote toda a implementação que fizemos até o método getView. No momento em que colamos o trecho, o programa pede que importemos algumas classes que estão sendo utilizadas. Clique em OK.

Como a referência pertencia a um contexto anterior, necessitamos de um novo:

@Override
public View getView(int i, view view, ViewGroup viewGroup) {
    View virewCriada = LayoutInflater
        from(context)
        inflate(R.layout.item_aluno,viewGroup);
}COPIAR CÓDIGO
Selecione context, e com o atalho "Alt + Enter" abra a caixa e clique em "Create field 'context' in 'ListaAlunosAdapter'", originando um novo atributo sem inicialização.

Quando utilizarem nosso Adapter, o próprio Android Studio gera o construtor que enviará o contexto a partir do "Alt+Enter">"Add contructor parameter".

Sendo possível compilar, precisamos modificar esta referência em Activity. Vamos alterar de:

private void configuraAdapter(ListView listaDeAlunos) { 
    adapter = new BaseAdapter() {        
}COPIAR CÓDIGO
Para inicializar:

private void configuraAdapter(ListView listaDeAlunos) { 
    adapter = new ListaAlunosAdapter(context:this);
    listaDeAlunos.setAdapter(adapter);
}COPIAR CÓDIGO
Retornando ao início do atributo ainda em Activity, para termos a capacidade de adicionar os comportamentos específicos do nosso projeto, podemos modificar da seguinte forma:

public static final String TITULO APPBAR = "Lista de Alunos"
private final AlunoDAO dao = new AlunoDAO();
private ListaAlunosAdapter adapter;COPIAR CÓDIGO
Alguns métodos já são compilados automaticamente, enquanto outros temos que implementar, como no caso de clear(), addAll() e remove(). Para isso, selecione-os um por vez e use o atalho "Alt+Enter" e vá na opção "Create method 'clear' in 'ListaAlunosAdapter'". Insira o DataSet obtendo:

public void clear() {
    alunos.clear();
}

public void addAll(List<Aluno>alunos) {
    this.alunos.addAll(alunos);
}

public void remove(Aluno aluno) {
    alunos.remove(aluno);
}COPIAR CÓDIGO
Desta forma, os códigos voltam a compilar, fazendo com que funcione da maneira esperada. Para testarmos o resultado das alterações, voltaremos com nosso layout, descomentaremos o bloco Linearlayout e TextView em item_aluno.xml utilizando "Ctrl+barra" e eliminaremos as declarações do NameSpace em TextView.

Use o atalho "Shift + F10" para executar e visualizar no emulador. Novamente, uma quebra inesperada.

Para resolver, voltamos ao LogCatch para filtrar e encontrar o erro, como já foi demonstrado. Percebemos que a questão foi justamente no nosso Adapter, em específico na adição do AdapterView.

Vamos retornar ao GetView. Observamos que a implementação do LayoutInflater está correta, mas precisamos entender este processo — quando inflamos um layout, indicamos seu arquivo de origem e para qual irá se encaixar.

Geralmente, inflar um layout diretamente em um LinearLayout ocorre sem problemas. Em nosso caso, utilizamos AdapterViews, o que delega a responsabilidade do processo de vinculação dos itens aos Adapters, gerando a Exception que detectamos anteriormente.

Portanto, precisamos somente indicar que o processo de inflate não realizará o comportamento padrão, adicionando um argumento false que automaticamente gerará attachToRoot:

@Override
public View getView(int i, View view, ViewGroup viewGroup){
    View viewCriada = LayoutInflater
        .from(context)
        .inflate(R.layout.item_aluno, viewGroup, attachthoRoot: false);
    return viewCriada;
}COPIAR CÓDIGO
Executaremos novamente. Podemos ver que o layout se comportou como esperado. Mas precisamos retornar às referências dos TextViews para adicionar as informações dos alunos que veremos a seguir.

@@10
Implementando Adapter personalizado
PRÓXIMA ATIVIDADE

Crie o Adapter personalizado para que seja possível migrar do ArrayAdapter para o novo Adapter e manter os comportamentos de antes, como notificar a atualização e remoção de alunos no dataset.
Para isso, crie a classe ListaAlunosAdapter no pacote br.com.alura.agenda.ui.adapter. Faça extensão da classe BaseAdapter e envie todos os métodos sobrescritos da BaseAdapter que está na ListaAlunosActivity para o adapter.

Lembre-se de aplicar os imports necessários para que tudo compile.
Muito provavelmente haverá um problema de compilação no processo de inflar o layout. Isso acontece pelo fato de não obter uma referência de Context.

Crie um atributo do tipo Context e o envie no from() do LayoutInflater. Então, peça o Context via construtor.

Na ListaAlunosActivity, mude a referência do adapter para que utilize a ListaAlunosAdapter. Em seguida, no método de configuração do adapter, faça a inicialização do adapter com a nova classe.

Implemente os métodos clear(), addAll() e remove().

As implementações de ambos são chamadas equivalentes, porém, para a lista de alunos, por exemplo, no clear() basta apenas chamar o clear() da lista de alunos.
Teste o App e veja se aparece as views personalizadas. Considerando essa implementação, deve apenas o espaço ocupado com base na altura ocupada pelo item_aluno.xml.

Caso você tenha deixado o layout comentado, para que apresente o espaço ocupado pelo layout.

@@Deve apresentar a seguinte tela na lista de alunos:


O código de implementação ficou da seguinte maneira:

ListaAlunosActivity.java:
public class ListaAlunosActivity extends AppCompatActivity {

    // demais atributos
    private ListaAlunosAdapter adapter;

    // restante do código

    private void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ListaAlunosAdapter(this);
        listaDeAlunos.setAdapter(adapter);
    }
}COPIAR CÓDIGO
ListaAlunosAdapter.java:
package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

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
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }

}COPIAR CÓDIGO
Então temos o código do layout sem os comentários:

item_aluno.xml:
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/item_aluno_nome"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="8dp"
        android:textSize="24sp"
        tools:text="Alex" />

    <TextView
        android:id="@+id/item_aluno_telefone"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginEnd="8dp"
        tools:text="1122223333" />

</LinearLayout>

@@11
Vinculando dados do adapter

Para finalizar a implementação do Adapter personalizado, vamos vincular as informações dos alunos aos Views que produzimos para nosso layout.
Podemos pegar a referência da View e realizar o mesmo comportamento da Activity por meio de um recurso de varredura disponível no Android Studio chamado FindViewById, que resgata os dados do nosso LinearLayout.

@Override
public View getView(int posicao, View view, ViewGroup viewGroup) {
View Criada = LayoutInflater
    .from(context)
    .inflate(R.layout.item_aluno, viewGroup, attachThoRoot:false);
ViewCriada.findViewById(R.id.item_aluno_nome).var
return viewCriada;
}COPIAR CÓDIGO
Para continuar o comportamento, faça as importações e as indicações necessárias:

@Override
public View getView(int posicao, View view, ViewGroup viewGroup) {
View Criada = LayoutInflater
    .from(context)
    .inflate(R.layout.item_aluno, viewGroup, attachThoRoot:false);
TextView nome = viewById.findViewById(R.id.item_aluno_nome);
nome.setText();
return viewCriada;
}COPIAR CÓDIGO
E para acessar as informações do aluno, alteramos o argumento i para posicao e assim vincular as informações e obter os retornos planejados por meio do DataSet, desta forma:

@Override
public View getView(int posicao, View view, ViewGroup viewGroup) {
View Criada = LayoutInflater
    .from(context)
    .inflate(R.layout.item_aluno, viewGroup, attachThoRoot:false);
Aluno alunoDevolvido = alunos.get(posicao);
TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
nome.setText(alunoDevolvido.getNome());
TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
telefone.setText(alunoDevolvido.getTelefone());
return viewCriada;
}COPIAR CÓDIGO
Execute, faça um teste editando informações no emulador e veja o resultado esperado. Lembrando que caso queira modificar mais algum aspecto do layout, basta retornar ao item_aluno.xml e fazer as alterações a serem executadas.

@@12
Apresentando informações do aluno na View
PRÓXIMA ATIVIDADE

Vincule as informações do aluno com a view. Para isso, com o objeto que representa a view criada, busque os TextViews que representam o nome e o telefone do aluno a partir do método findViewById().
Após buscar as views, busque o aluno contido no dataset a partir da posição recebida via parâmetro do getView(). Então envie o nome e telefone do aluno encontrado nas views que foram buscas respectivamente.

Após aplicar o vínculo entre o aluno e o novo layout, rode o App e veja se a lista de alunos apresenta o novo layout com as informações esperadas.

O App deve apresentar o seguinte aspecto visual:


O código deve ficar da seguinte maneira:

ListaAlunosAdapter.java:
@Override
public View getView(int posicao, View view, ViewGroup viewGroup) {
    View viewCriada = LayoutInflater
            .from(context)
            .inflate(R.layout.item_aluno, viewGroup, false);
    Aluno alunoDevolvido = alunos.get(posicao);
    TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
    nome.setText(alunoDevolvido.getNome());
    TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
    telefone.setText(alunoDevolvido.getTelefone());
    return viewCriada;
}COPIAR CÓDIGO
Neste momento, você pode modificar o layout conforme sua preferência, como mudar o tamanho da fonte, aplicar cores e etc.

@@13
Sobre a criação de um adapter personalizado
PRÓXIMA ATIVIDADE

Durante a implementação do adapter personalizado, vimos que é necessário a criação de uma classe nova que faça extensão de BaseAdapter. Por qual motivo existe essa necessidade?


Para possibilitar a sobrescrita dos métodos abstratos da BaseAdapter.
 
Somos capazes de implementar os métodos abstratos via classe anônima, portanto, não precisamos criar uma classe específica pra isso.
Alternativa correta
Para implementar novos comportamentos para o Adapter.
 
Exato! Quando criamos uma classe somos capazes de implementar novos comportamentos que a classe BaseAdapter não possui.
Alternativa correta
Para permitir o uso do LayoutInflater na criação da View.
 
A criação da view não depende de uma classe específica que faça extensão de BaseAdapter, inclusive, fomos capazes de implementar o getView() via classe anônima.
Alternativa correta
Para que seja possível compilar o código no momento que setamos o adapter.
 
Podemos enviar o adapter apenas via referência do BaseAdapter, a única exigência é que seja uma implementação qualquer de ListAdapter.

@@14
O que aprendemos?
PRÓXIMA ATIVIDADE

Nesta aula, aprendemos a:
Criar layouts personalizados para ListView;
Migrar de ArrayAdapter para adapter personalizado;
Implementar Adapter personalizado por meio do BaseAdapter.