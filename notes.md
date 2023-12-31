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

Nesta aula, aprendemos a:
Criar layouts personalizados para ListView;
Migrar de ArrayAdapter para adapter personalizado;
Implementar Adapter personalizado por meio do BaseAdapter.

#### 13/09/2023

@02-Conhecendo a camada Application

@@01
Notificando mudança do dataset

Nesta etapa do curso, analisaremos o código implementado e verificaremos a necessidade de aplicar alguma refatoração. Sugerimos que verifique os imports utilizando o atalho "Ctrl + Alt + O" para otimização.
Em ListaAlunosAdapter.java, as referências não modificadas podem ser declaradas final, como no caso do context que permanece constante:

public class ListaAlunosAdapter extends Base Adapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;
    // código omitido
}COPIAR CÓDIGO
Outras implementações que fizemos como GetCount, GetItem e GetItemId não apresentam necessidade de alteração.

Entretanto, o GetView é mais complexo e podemos extrair alguns métodos como o LayoutInflater por meio do atalho "Ctrl + Alt + M". Uma caixa de diálogo se abre para inserirmos criaView no campo "Name", ou outro comportamento similar que dê a compreensão de que estamos criando uma view para nosso Adapter.

Em seguida, podemos extrair mais comportamentos para continuar a vinculação dos alunos às views.

Selecionando todo o procedimento do TextView nome e acionando o mesmo atalho para extração, indicamos pelo nome vincula.

Você pode também modificar os métodos viewCriada e alunoDevolvido para apenas view e aluno respectivamente, tornando o Get View mais simples por meio do atalho "Shift + F6".

É importante observar que, para adicionarmos os alunos, precisamos limpar a nossa lista primeiro. Este procedimento é denominado de atualizaAlunos dentro da Activity, e utiliza duas chamadas do Adapter: clear() e addAll().

Estes dois comportamentos podem ficar encapsulados direto no Adapter, visto que ambos o atualizam. Para isso, podemos torná-los privados, e outro novo que ficará disponível e responsável por limpar e adicionar alunos, tornando nosso código mais conciso:

private void clear() { alunos.clear(); }

private void addAll(List<Aluno> alunos) { this.alunos.addAll(alunos); }

public void atualiza(List<Alunos> alunos){
    this.alunos.clear();
    this.alunos.addAll(alunos);
}

public void remove(Aluno aluno) { alunos.remove(aluno); }COPIAR CÓDIGO
Feito isso, podemos apagar os dois primeiros métodos, deixando apenas o atualiza() ativo, já que exerce as mesmas funções. Em Activity, os substituímos pelo novo método para tornar o comportamento ainda mais consistente:

private void atualizaAlunos() {
    adapter.atualiza(dao.todos());
}COPIAR CÓDIGO
Use "Shift + F10" para executar e testar nosso aplicativo. Podemos perceber que a ação de "adicionar" não apresenta problemas enquanto a de "remover" apresenta. Entenderemos o porquê.

Há comportamentos que não solucionados somente na interação com o dataSet, necessitando da notificação para o Adapter, como é neste caso.

Voltando ao ListaAlunosAdapter.java, devemos notificar a modificação no dataSet adicionando notifyDataSetChanged(); ao método remove. É interessante adicionar esta notificação inclusive ao atualiza, evitando futuros erros.

Após isso, podemos executar no emulador novamente e verificar que as ações foram realizadas com sucesso.

Em seguida, veremos outras melhorias que podem ser aplicadas ao nosso projeto.

@@02
Refatorando o código do adapter

Caso você precise do projeto com todas as alterações realizadas na aula passada, você pode baixá-lo por meio deste link.
Refatore o código do adapter. Durante o processo, extraia métodos para facilitar a compreensão do código, como também para encapsular comportamentos, como é o caso da atualização do dataset.

Após refatoração, execute o App e veja se mantém o mesmo comportamento de antes, porém, com um código mais simples de ser lido.

https://github.com/alura-cursos/fundamentos-android-parte-3/archive/aula-1.zip

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/ac7a98e49c2fb1db284f8e707eff0b0acd2d465b

@@03
Entendo a entidade Application

Visualizando nosso projeto no emulador, percebemos nas outras etapas que, ao rotacionar a tela de retrato para paisagem, a lista apresenta a duplicação de alunos a cada rotação.
Isso ocorre porque inserimos nossos alunos no banco de dados da nossa Activity, que é destruída e volta ao seu estado inicial de criação quando rotacionamos o dispositivo.

Para evitar esse comportamento indesejado, vamos utilizar uma entidade estável muito importante para o sistema operacional Android que mantém o estado global do aplicativo chamada Application, que precede a Activity Launcher apresentada anteriormente.

Nesta tag, estão declaradas as Activities que podem ser vistas em AndroidManifest.xml.

Na criação de um aplicativo, as Activities são mostradas na execução deste. Porém, há um passo anterior que envolve a instância Application criada antes de qualquer outra entidade e seu estado inicial chamado OnCreate().

Se quisermos que alguns membros estáticos sejam executados apenas uma única vez a exemplo da adição de alunos, é nesta etapa que devemos inseri-los.

Agora que sabemos como utilizar esta entidade, faremos a implementação a seguir.

@@04
Sobre a camada Application

Vimos que a utilização da camada Application é uma alternativa que evita o problema de salvar os alunos de exemplo cada vez que a orientação da tela muda. Por quais motivos a Application funciona?


A Application não é destruída ao rotacionar a tela.
 
Exato! A Application é a entidade que mantém o estado global da aplicação, portanto, é a entidade mais estável do App.
Alternativa correta
A Application permite configurar a Activity para que chame o onCreate() apenas uma vez.
 
Alternativa correta
A Application impede a Activity de ser destruída.
 
Alternativa correta
A Application executa o estado de criação uma única vez.
 
Isso mesmo! A Application é uma entidade que permite a execução de tarefas uma única vez e se mantém estável enquanto o App não é destruído.

@@05
Implementando a Application

Agora que conhecemos a camada Application, sabemos evitar a questão apresentada na rotação da tela. Daremos início à sua implementação.
Da mesma forma que fazemos na Activity, partimos de uma classe que fará uma extensão e representará a Application no Android Framework.

Esta entidade é exclusiva. Ou seja, geraremos apenas uma Application para nosso projeto, que pode ser inserida em nosso pacote raiz e não necessariamente em um pacote específico.

Para a criação, use o atalho "Alt + Insert" e clique em "Java Class". No campo "Name", decidimos inserir AgendaApplication para demonstrar a exclusividade dessa configurações para nosso aplicativo.

Agora que temos a classe, faremos a extensão desta forma:

package br.com.alura.agenda;

public class AgendaApplication extends Application {
}COPIAR CÓDIGO
Como faremos uma Application personalizada, é necessário registrar no AndroidManifest.xml utilizando o atributo name:

<application
    android: allowBackup="true"
    android:icon="@mipmap/ic_laucher"
    android:label="Agenda"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:theme="@style/AppTheme"
    android:name=".AgendaApplication">COPIAR CÓDIGO
De volta à Application, vamos implementar seu estado de criação e migrar os comportamentos estáticos que queremos da Activity para a nova camada, ficando desta forma:

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno(nome "Alex", telefone: "1122223333", email: "alex@alura.com.br"));
        dao.salva(new Aluno(nome "Fran", telefone: "1122223333", email: fran@gmail.com"));
    }

}COPIAR CÓDIGO
Podemos simplificar selecionando os comportamentos migrados e extraindo um método privado por meio do atalho "Ctrl + Alt + M", nomeando como "criaAlunosDeTeste" para indicar o que estamos fazendo.

Vamos executar o projeto e analisar se a Application mantém a responsabilidade de executar apenas uma vez.

Conferimos que ao rotacionar, a quantidade de alunos na lista permanece a mesma, demonstrando a utilidade deste procedimento.

Vale lembrar que, se for inserido um comportamento muito demorado na Application, a apresentação da Activity poderá demorar também.

Para testar, vamos inserir Thread.sleep(millis:2000); na Application e executar. Podemos perceber a demora na apresentação, o que prejudica a qualidade do aplicativo.

Portanto, é importante ter consciência do impacto desta camada na execução final do projeto.

@@06
Criando a Application do projeto

Evite o problema de salvar os alunos cada vez que rotaciona o dispositivo. Para isso, crie a classe AgendaApplication que estenda de Application. Você pode manter no pacote raiz do projeto se preferir (br.com.alura.agenda).
Em seguida, no arquivo de manifesto, na tag application, faça referência à Application definindo o atributo android:name enviando como valor a AgendaApplication.

Então, sobrescreva o método onCreate() da AgendaApplication e migre todo o código que salva os alunos de exemplo da ListaAlunosActivity para este método.

Rode o App, mude a orientação do dispositivo algumas vezes e veja se é mantida a mesma quantidade de alunos na lista.

Deve ser mantida a mesma quantidade de alunos independentemente da quantidade de rotações realizadas. O código para esta implementação fica da seguinte maneira:
AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="br.com.alura.agenda">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        android:name=".AgendaApplication">
        <!-- Activities declaradas -->
    </application>

</manifest>COPIAR CÓDIGO
AgendaApplication.java:
package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}COPIAR CÓDIGO
Na Activity, basicamente não existe mais o código que salva os alunos de exemplo.

@@07
Sobre cuidados na Application

Durante a implementação da Application, notamos que se não ficarmos atentos, podemos comprometer a experiência do nosso usuário com o nosso App... Qual é esse problema que pode acontecer?

A Application pode bloquear a mudança de orientação da Activity.
 
Alternativa correta
A Application pode deixar de ser criada, inicializando a Activity launcher diretamente.
 
Alternativa correta
A Application pode impedir a inicialização da Activity launcher.
 
Exato! Qualquer tarefa que demanda tempo durante a criação da Application afeta o tempo de exibição Activity launcher.
Alternativa correta
A Application pode executar novamente o estado de criação.

@@08
O que aprendemos?

Nesta aula, aprendemos a:
Refatorar o código do Adapter personalizado;
Executar rotinas apenas uma única vez com a Application;
Evitar possíveis problemas com a Application.

#### 14/09/2023

@03-Implementando caixa Dialog

@@01
Adicionando o dialog

Outro ponto de melhoria que podemos considerar está relacionado à ação de remover um aluno.
Para realizar essa ação no aplicativo, devemos pressionar o item desejado e clicar em "remover", eliminando os dados permanentemente.

Devemos considerar uma técnica que confira mais consciência ao usuário ao confirmar ou não esta ação, evitando possíveis erros.

O Android Studio já possui um componente que interage diretamente com o usuário chamado dialog(). Nesta etapa, vamos implementá-lo.

Para entender melhor o funcionamento, faremos sua implementação no onCreate() da ListaAlunosActivity.java a princípio.

Criamos uma nova instância dessa classe base que recebe como dependência um context e podemos apresentá-lo na tela pelo método show():

@Override
protected void onCreate(@Nullable Bundle savedInstancesState); {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_alunos);
    setTitle(TITULO_APPBAR);
    configuraFabNovoAluno();
    configuraLista();
    Dialog dialog = new(context:this);
    dialog.show();

}COPIAR CÓDIGO
Ao executar o dispositivo, não há uma caixa de diálogo propriamente dita na tela, mas nota-se que esta ficou sombreada.

Isso ocorre porque o comportamento visual padrão dessa nova classe é apresentar uma view sobreposta à da Activity, mudando o foco de interação.

Agora, configuraremos uma mensagem específica e botões de ação para o usuário. Os desenvolvedores da Android disponibilizam outros métodos especialistas que implementam estes comportamentos que desejamos.

Alteraremos a classe base de dialog() e usar a AlertDialog(). Imediatamente, o sistema apresenta um problema que indica a falta de um construtor para esta referência, significando que há um outro padrão a ser usado conhecido como Builder().

Então, ao invés de fazer a instância a partir da própria classe, usamos uma subclasse da AlertDialog() que permite o comportamento de instância.

O sistema utiliza este construtor por ser um padrão de projeto bastante comum para desenvolvedores, permitindo a construção de diversas configurações no momento da criação da instância e realizando chamadas encadeadas.

Com isso em mente, temos a capacidade de inserir os comportamentos desejados, escrevendo null para o argumento listener:

@Override
protected void onCreate(@Nullable Bundle savedInstancesState); {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_alunos);
    setTitle(TITULO_APPBAR);
    configuraFabNovoAluno();
    configuraLista();
    new AlertDialog
        .Builder(context:this)
        .setTitle("Removendo aluno")
        .setMessage("Tem certeza que quer remover o aluno?")
        .setPositiveButton(text:"Sim", listener:null)
        .setNegativeButton(text:"Não", listener:null)
        .show();
}COPIAR CÓDIGO
Vamos executar e observar o resultado por meio do "Shift + F10". Vemos que a caixa de diálogo é apresentada mas ainda não executa a ação de remover o aluno ao responder positivamente à mensagem.

Vejamos como implementar estes comportamentos a seguir.

@@02
Implementando o AlertDialog

Caso você precise do projeto com todas as alterações realizadas na aula passada, você pode baixá-lo por meio deste link.
Implemente o dialog para que o usuário confirme a remoção do aluno. Para isso, no onCreate() faça a instância da classe AlertDialog.Builder() enviando a referência de Context via construtor.

Com acesso ao builder, insira um título, mensagem, botão positivo e negativo para o dialog, chamando os seus setters respectivamente.

Após configurar todos esses detalhes, mostre o dialog chamando o método show(). Teste o App e veja se o dialog aparece conforme o esperado.

https://github.com/alura-cursos/fundamentos-android-parte-3/archive/aula-2.zip

O App deve apresentar o seguinte aspecto visual:


O código de implementação fica da seguinte maneira:

ListaAlunosActivity.java:
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_alunos);
    setTitle(TITULO_APPBAR);
    configuraFabNovoAluno();
    configuraLista();
    new AlertDialog
            .Builder(this)
    .setTitle("Removendo aluno")
    .setMessage("Tem certeza que quer remover o aluno?")
    .setPositiveButton("Sim", null)
    .setNegativeButton("Não", null)
    .show();
}COPIAR CÓDIGO
Agora que aprendemos a criar o dialog, a seguir vamos vinculá-lo com o processo de remoção de aluno.

@@03
Removendo aluno com o Dialog

@@04
Aplicando comportamentos no dialog

Migre o código do dialog para dentro do escopo do if que identifica o toque no menu de remover o aluno. Em seguida, como segundo parâmetro do setPositiveButton(), implemente a interface DialogInterface.OnClickListener utilizando a técnica de classe anônima.
Então migre todo o código que remove o aluno da lista para dentro do método de clique no listener do botão positivo.

Nessa migração, muito provavelmente vai ter um problema de compilação, pois a referência de MenuItem precisa ser final. Apenas aplique o final que volta a compilar.
Após realizar todas as mudanças, teste o App e veja se ao remover o aluno aparece primeiro o dialog e se ele remove o aluno apenas quando confirma a remoção.

Se tudo estiver certo, refatore o código extraindo todo o código do dialog para um método exclusivo.


O código de implementação fica da seguinte maneira:

ListaAlunosActivity.java:
@Override
public boolean onContextItemSelected(MenuItem item) {

    int itemId = item.getItemId();
    if (itemId == R.id.activity_lista_alunos_menu_remover) {
        confirmaRemocao(item);
    }

    return super.onContextItemSelected(item);
}

private void confirmaRemocao(final MenuItem item) {
    new AlertDialog
            .Builder(this)
            .setTitle("Removendo aluno")
            .setMessage("Tem certeza que quer remover o aluno?")
            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                }
            })
            .setNegativeButton("Não", null)
            .show();
}COPIAR CÓDIGO

@@05
Sobre a implementação de dialog

Durante a implementação da caixa de diálogo para confirmar a remoção do aluno, utilizamos a classe AlertDialog ao invés da Dialog. Por qual motivo optamos por essa decisão?

Para facilitar o processo de criação de um dialog personalizado.
 
Exato! O objetivo de usar uma classe específica para Dialog é para facilitar a criação. No caso do AlertDialog, temos acesso ao Builder que permite, por exemplo, adicionar um título ou mensagem de forma encadeada durante a criação.
Alternativa correta
Porque a classe Dialog não permite configurar um visual personalizado.
 
Somos capazes de configurar o visual da caixa de diálogo em qualquer implementação de Dialog, a diferença é que na classe Dialog não temos a mesma facilidade assim que temos na AlertDialog ou outras classes específicas.
Alternativa correta
A classe AlertDialog é mais performática que a Dialog.
 
Não há uma diferença considerável em performance em relação às duas possíveis implementações.
Alternativa correta
Porque a classe Dialog é abstrata e exige a implementação de métodos abstratos.
 
A classe Dialog não é abstrata, é apenas uma classe base para manter comportamentos comuns em qualquer Dialog.

@@06
Para saber mais - Outros Dialogs

Além do AlertDialog existem outras caixas de diálogo comum em Apps Android, como é o caso da DatePickerDialog que permite o usuário escolher uma data ou o TimePickerDialog que permite escolher a hora.
Para mais detalhes de possibilidades com dialogs, consulte a documentação.

https://developer.android.com/reference/android/app/DatePickerDialog

https://developer.android.com/reference/android/app/TimePickerDialog

https://developer.android.com/guide/topics/ui/dialogs

@@07
O que aprendemos?

Nesta aula, aprendemos a:
Necessidade de caixa de diálogo para confirmação;
Implementação de dialog com AlertDialog.

#### 15/09/2023

@@01
Inspecionando o projeto

Quanto mais features adicionamos ao nosso projeto, mais benéfico é ao nosso usuário. Afinal são mais opções de interação com o aplicativo, tornando-o mais atraente.
Mas quanto mais recursos existem, maior é a quantidade de códigos, análises e manutenções necessárias.

IntelliJ IDEA é a base que foi integrada ao Android Studio, e que analisa tanto o código fonte quanto as peculiaridades do Android Framework através de uma técnica disponível que facilita nosso processo visando uma maior qualidade do aplicativo: O Inspetor de Código.

Para utilizar essa ferramenta e acessar qualquer comportamento dessa base, usamos o atalho "Ctrl + Shift + A", também conhecido como find action, apresentado aqui como "Enter action" ou "option name".

Nessa busca, podemos realizar diversas funções como limpa o projeto, fazer rebuild, buscar arquivos entre outras. Temos um curso específico na Alura que apresenta as funcionalidades da ferramenta que vale a pena conferir.

Aqui, escrevemos "Inspect Code" no campo de busca e selecionamos a primeira opção.

Na caixa de diálogo, escolhemos qual o escopo que será inspecionado. O padrão é a inspeção geral do projeto, que é recomendada para iniciantes com um projeto mais simples, como é o nosso caso.

Clicamos em "OK" e observamos a ferramenta em ação. Ao terminar, uma aba de nome "Inspection Results" se abre e podemos ver três tópicos: Android que representa todas as melhorias para o sistema, Java que analisa possíveis reparos para os códigos, e Spelling que notifica erros ortográficos.

Focamos aqui nos dois primeiros tópicos, pois há uma atividade nesse curso que demonstra como inspecionar o Spelling.

Clicando em Android, vemos várias opções. Lint é uma ferramenta específica para o Android que atende os aspectos comuns nos aplicativos desse sistema.

Na documentação do Guia do Usuário do Android Studio há uma explicação mais completa sobre suas funções, e aqui focaremos nos pontos de atuação do Lint: Correctness, Usability, Security, Accessibility, Performance e I18n (Internationalization).

Voltando aos resultados da inspeção, podemos ver que a ferramenta indicou questões de Internationalization, Security e Usability.

Em seguida, focaremos na resolução dos detalhes apresentados.

@@02
Para saber mais - Resultados do inspetor de código

Caso você precise do projeto com todas as alterações realizadas na aula passada, você pode baixá-lo por meio deste link.
Durante a aula foram apresentados alguns tópicos como resultado do inspetor de código. Porém, é muito comum que o resultado varie com base na implementação, portanto, se no seu projeto foram apresentados resultados diferentes, a princípio isso não indica um grande problema.

Um exemplo curioso está na implementação do adapter personalizado. Caso o código de inflar o layout esteja diretamente dentro do getView() ele alarma sobre o problema de performance.

Porém, se for mantido dentro de um método (assim como fizemos no criaView()) esse problema não é apontado. A princípio parece uma solução, mas apenas encapsulamos o código sem resolver o real problema.

Caso surja esse problema (em específico sobre o uso do ViewHolder) e você tenha interesse na solução, temos um post no blog da Alura explicando o problema e como pode ser solucionado.

É muito importante notar que o resultado de inspeção depende também da versão do Android Studio ou SDK do Android, portanto, não foque apenas nos tópicos apresentados durante o curso, foque em como você pode usar o inspetor e como você pode resolver tópicos de uma maneira genérica.

https://github.com/alura-cursos/fundamentos-android-parte-3/archive/aula-3.zip

http://blog.alura.com.br/utilizando-o-padrao-viewholder/?_gl=1*sji0ip*_ga*MTgwMzIzMjk2Ni4xNjg4ODE5OTcz*_ga_1EPWSW3PCS*MTY5NDgwNzgyNi40MS4xLjE2OTQ4MDkwMzYuMC4wLjA.*_fplc*Z1BENWh1NlRXZURkUGd0SSUyQlZkc0VJYkIzMm4yT3V3bVhYN1U1b29uZVFRcklvaHh5YXdXUmlZdTBNY0trY0lrdSUyRk43UWszRURqTFFVTTJ4TU14SUdUUWpVcURKdWxZSlFvU2Vldm9KMnolMkJkeGNQOGJMclhZSTJYciUyRmFyVGclM0QlM0Q.

@@03
Melhorando o projeto com o inspetor

Nessa etapa, resolveremos o tópico de Segurança apresentado no Inspetor de Código.
Utilizaremos a mesma abordagem da questão "Hardcodedtext" nos arquivos apresentados.

Clicando em "Security" e depois em "AllowBackup/FullBackupContent Problems", podemos ver as informações sobre essa técnica habilitada por padrão que permite ao usuário copiar os dados contidos no aplicativo. Isso é possível através da ferramenta chamada debug que vasculha o aplicativo.

Aqui, usamos a adb backup e adb restore para acessar nossos dispositivos e recuperar os dados.

A partir da API 23 - nosso Android 6 ou Android Nougat - quando habilitamos o AllowBackup o sistema realiza um autobackup. Ou seja, os dados são salvos automaticamente e resgatados quando o aplicativo é reinstalado.

Para isso, existem algumas recomendações apresentadas justamente pelo Lint no feedback.

Podemos criar o arquivo fullBackupContent para definir como será feito o autobackup de segurança ou denominar essa parte como falsa.

Para exemplificar esta segunda resolução, clicamos em AndroidManifest.xml e vamos direto ao arquivo novamente, trocando "true" por "false" na sentença em evidência.

Executamos o Inspetor novamente para ver que este tópico desapareceu, já que o backup não acontece mais automaticamente.

Outra forma de resolver é, retornando ao arquivo com alerta, selecionar a opção Supress para ignorar conscientemente a abordagem do Inspetor, adicionando ignore="AllowBackup" à esta parte do nosso código.

Agora, lidaremos com as questões de Usability apresentadas.

O tópico "Missing support for Firebas App Indexing" indica a técnica que torna nosso aplicativo indexável pelo Google, melhorando a experiência do usuário. Como nosso projeto ainda não foi publicado, suprimiremos esta abordagem também da mesma forma.

@@04
Resolvendo o tópico de internacionalização

Rode o inspetor de código para todo o projeto e aguarde a apresentação do resultado de inspeção.
Muito provavelmente o tópico Internationalization foi apontado no resultado do inspetor de código.

O problema está relacionado no uso de Hardcoded text. Para resolver, migre as strings soltas para o arquivo strings.xml do diretório res.

Você pode usar o atalho Alt + Enter para que o Android Studio apresente a opção para extrair a String.
Após extrair as strings de todos os arquivos apontados, rode o inspetor novamente e veja se o tópico de internacionalização é resolvido

O tópico de internacionalização não deve aparecer mais. Considerando que as mudanças são feitas em vários arquivos, decidi apresentar a resposta neste commit que mostra detalhadamente as mudanças.

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/e430724e4fee317c0a689b27301eeaa08c4ef16b

@@05
Para saber mais - Traduzindo o App

Durante a resolução do tópico de internacionalização, aprendemos que a extração de Hardcoded text para resources de string permite que o App seja traduzido para outras linguagens. Porém, essa tradução não é feita de maneira automática!
Para que isso seja possível, é necessário realizar uma configuração a mais de acordo com as linguagens que o App dará suporte. Caso tenha interesse em implementar essa feature para o App, confira as orientações apresentadas na documentação.

https://developer.android.com/studio/write/translations-editor

@@06
Suprimindo problemas

Nessa etapa, resolveremos o tópico de Segurança apresentado no Inspetor de Código.
Utilizaremos a mesma abordagem da questão "Hardcodedtext" nos arquivos apresentados.

Clicando em "Security" e depois em "AllowBackup/FullBackupContent Problems", podemos ver as informações sobre essa técnica habilitada por padrão que permite ao usuário copiar os dados contidos no aplicativo. Isso é possível através da ferramenta chamada debug que vasculha o aplicativo.

Aqui, usamos a adb backup e adb restore para acessar nossos dispositivos e recuperar os dados.

A partir da API 23 - nosso Android 6 ou Android Nougat - quando habilitamos o AllowBackup o sistema realiza um autobackup. Ou seja, os dados são salvos automaticamente e resgatados quando o aplicativo é reinstalado.

Para isso, existem algumas recomendações apresentadas justamente pelo Lint no feedback.

Podemos criar o arquivo fullBackupContent para definir como será feito o autobackup de segurança ou denominar essa parte como falsa.

Para exemplificar esta segunda resolução, clicamos em AndroidManifest.xml e vamos direto ao arquivo novamente, trocando "true" por "false" na sentença em evidência.

Executamos o Inspetor novamente para ver que este tópico desapareceu, já que o backup não acontece mais automaticamente.

Outra forma de resolver é, retornando ao arquivo com alerta, selecionar a opção Supress para ignorar conscientemente a abordagem do Inspetor, adicionando ignore="AllowBackup" à esta parte do nosso código.

Agora, lidaremos com as questões de Usability apresentadas.

O tópico "Missing support for Firebas App Indexing" indica a técnica que torna nosso aplicativo indexável pelo Google, melhorando a experiência do usuário. Como nosso projeto ainda não foi publicado, suprimiremos esta abordagem também da mesma forma.

@@07
Solucionando a inspeção de usabilidade

No tópico de usabilidade, o Inspetor alarmou o uso do Autofill, um framework que permite o preenchimento automático de informações e foi introduzido na API 26, conhecida como Android 8 ou Android Oreo.
Temos então algum tipo de editor de texto dentro do aplicativo que não deu suporte à esta técnica.

Clicando em activity_formulario_aluno.xml, analisamos cada situação para dar a solução desejada de acordo com as opções recomendadas no feedback. Podemos não dar importância ao autopreenchimento, configurar este comportamento ou suprimir.

Dado que nosso aplicativo possui formulários genéricos para serem preenchidos por dados distintos e não por informações do próprio usuário, não faz sentido aplicar esta técnica. Portanto, selecionamos a primeira recomendação deimportantForAutofill="no".

Vamos executar o Inspetor novamente.

Percebemos uma nova abordagem, o Correctness. Nesta, o tópico "Attribute unused on older versions" aparece porque estamos dando suporte a uma versão mínima e inferior à que introduz o Autofill, causando problemas. Basta entrar na configuração build.gradle (Module: app) para conferir a minSdkVersion 19.

Para facilitar nosso trabalho nesse caso, recomendamos a alternativa oferecida pelo feedback de suprimir, clicando "Supress With tools: targetApi Attribute" para ambos os alarmes apresentados deste tópico.

Executando o Inspetor mais uma vez, vemos que não há mais problemas em Android.

A seguir, nos dedicaremos às questões do código Java.

@@08
Resolvendo tópico de segurança

Resolva o tópico Security, para isso você tem as seguintes alternativas:
Suprimir o alerta para que o inspetor não indique mais o ponto de melhoria, ou então, gerar o arquivo backup_descripor.xml no diretório res/xml/. Inclusive o botão Generate full-backup-content descriptor já cria o arquivo no local certo.

Caso tenha interesse em saber mais sobre o auto backup a partir da versão 23 da API do Android, consulte a documentação.

https://developer.android.com/guide/topics/data/autobackup

Durante o vídeo foi utilizada a técnica de suprimir com o tools:ignore para o AllowBackup, dessa forma, o lint deixa de notificar esse alerta para o auto backup. O código ficou da seguinte maneira:
AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="br.com.alura.agenda">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        android:name=".AgendaApplication"
        tools:ignore="AllowBackup">
        <!-- Activities -->
    </application>

</manifest>

@@09
Resolvendo o tópico de usabilidade

Resolva o tópico Usability. Este tópico mantém 2 subtópicos:
Missing support for Firebase App Indexing;
Use Autofill.
O primeiro tópico pode ser suprimido, pois é uma feature que vale a pena para Apps publicados. Caso tenha interesse em saber mais, confira a documentação.

O segundo tópico é sobre o uso framework Autofill ou preenchimento automático.

Considerando que o nosso formulário pode receber informações distintas, a utilização do preenchimento automático não faz sentido, sendo assim, temos duas alternativas:

Suprimir o alerta;
Indicar para o autofill que os campos de textos não vão utilizar o preenchimento automático.
Para suprimir o alerta, basta apenas utilizar o tools:ignore="Autofill". Caso opte pela indicação para não usar o preenchimento automático, utilize o atributo android:importantForAutofill="no".

Para casos em que foi utilizado qualquer atributo do Autofill
Ao utilizar o android:importantForAutofill ou qualquer atributo destinado ao Autofill o inspetor alarma outro problema sobre Correctness ou correção/exatidão.

O motivo é pelo fato de usar um atributo que está disponível para versões do Android a partir da 26 (Android 8) ou mais recente, sendo que o projeto dá suporte para versões entre a 19 (Android 4.4) e 28 (Android 9).

Em outras palavras, o projeto vai funcionar da mesma maneira em todas as versões que suportamos, a diferença é que o Autofill só vai funcionar nas APIs 26 ou mais recente, por isso temos o alerta.

Para evitar esse segundo alerta, temos duas alternativas:

Suprimir atributos de uma API específica com o tools:targetApi="letra_da_versao_ou;_numero_da_api";
Criar um layout específico para a API 26.
Dentre as opções, suprimir tende ser preferível, pois evita a complexidade de manter múltiplos layouts.

Faça a modificação que preferir para todos os EditTexts, rode novamente o inspetor e veja se o tópico de usabilidade desaparece.

https://developer.android.com/studio/write/app-link-indexing

https://developer.android.com/guide/topics/text/autofill

Durante o vídeo foi escolhida a abordagem que indica o não uso do preenchimento automático, o código do layout ficou da seguinte maneira:
activity_formulario_aluno.xml:
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_height="wrap_content"
    android:layout_width="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <EditText
            android:id="@+id/activity_formulario_aluno_nome"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:hint="@string/nome"
            android:inputType="textCapWords"
            android:importantForAutofill="no"
            tools:targetApi="o" />

        <EditText
            android:id="@+id/activity_formulario_aluno_telefone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:hint="@string/telefone"
            android:inputType="phone"
            android:importantForAutofill="no"
            tools:targetApi="o" />

        <EditText
            android:id="@+id/activity_formulario_aluno_email"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:hint="@string/email"
            android:inputType="textEmailAddress"
            android:importantForAutofill="no"
            tools:targetApi="o" />

    </LinearLayout>

</ScrollView>COPIAR CÓDIGO
Agora todos os tópicos de Android foram solucionados.

@@10
Para saber mais - Possibilidades com o Autofill

Vimos que o Autofill é um framework que traz grandes benefícios para o usuário, principalmente para formulários de dados pessoais.
Se você tem interesse na utilização do mesmo, é importante notar que algumas configurações fazem diferença, como por exemplo a dica de preenchimento automático por meio do atributo android:autofillHints.

Por meio da dica, indicamos ao Autofill qual é a entrada esperada, como por exemplo, para um nome, colocamos o valor name:

<EditText
    android:id="@+id/activity_formulario_aluno_nome"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    android:autofillHints="name"
    android:hint="@string/nome"
    android:inputType="textCapWords" />COPIAR CÓDIGO
Dessa forma, o framework verifica se existe algum campo que atenda essa chave (valores possíveis para nome) e preenche ou sugere as opções disponíveis.

Caso tenha interesse em conhecer mais possibilidades do autofill no Android, consulte a documentação da classe View e procure pelas constantes AUTOFILL_HINT, como por exemplo a AUTOFILL_HINT_NAME, nela percebemos que o Constant Value tem o valor "name" que é o possível valor que indicamos para o nome do usuário.

@@11
Para saber mais - Utilização de dicionário pt-br

Nos resultados apresentados pelo inspetor de código, vimos que o tópico de Spelling foi ignorado pelo fato do código ser escrito em pt-br (Português do Brasil) e o Android Studio ter a configuração padrão em Inglês.
Caso tenha interesse configurar o suporte para outras linguagens, você pode adicionar manualmente um dicionário.

Para isso, baixe o dicionário da linguagem desejada, como por exemplo o Portuguese (BR) para pt-br. Extraia para um local fácil de acessar.

Então, por meio do Find Action (Ctrl + Shift + A) busque pela opção Dictionaries. Então, logo abaixo da seção Custom Dictionaries clique no botão positivo verde e busque o arquivo que tenha a extensão .dic de acordo com a linguagem que baixou. (pt-br está como br.dic).

Clique em Ok, confira se o dicionário aparece na seção Custom Dictionaries:

No meu caso o arquivo está em /home/alexf/Downloads/br.dic. Ao rodar o inspetor, além de dar suporte para Inglês, o Spelling vai verificar também se a palavra se encaixa em pt-br.

http://www.winedt.org/dictASCII.html

http://www.winedt.org/dictASCII/br.zip

@@12
O que aprendemos?

Nesta aula, aprendemos a:
Utilizar o inspetor de código do Android Studio;
Como funciona a inspeção do lint;
Resolver tópicos do Android;
Suprimir alertas.

#### 17/09/2023

@05-Refatorando o código Java

@@01
Resolvendo inspeção de código Java

Ao clicar em "Java" no Inspetor de Código, aparecem os dois subtópicos com problemas.
O "Declaration access can be weaker" indica que campos, métodos ou classes que estão públicos poderiam ser restritos e indicados como protected ou private, evitando acesso desnecessário.

É importante analisar cada questão Java antes de tomar a decisão sugerida. No caso de AgendaApplication, se aceitarmos a sugestão de "Make class package-private", aparecerá novamente um problema de Android ao refazer a inspeção. Portanto, vamos apenas suprimir esta classe.

Em ConstantesActivities já não há a necessidade de acesso público, então vamos seguir a orientação de "Make interface package-private". A constante ListaAlunosActivity também pode ser privada. Repetimos a operação.

Executaremos o Inspetor novamente e atestar as resoluções. Um novo subtópico aparece: "Java language level migration aids".

Mas primeiro, analisaremos os "Imports" que apresentam erros.

Neste caso, podemos remover todas as declarações da mesma forma que o atalho de otimização "Ctrl + Alt + O" realiza, clicando em "Delete unnecessary import". Repetiremos a operação após a execução do Inspetor acusar novas questões de "Imports".

Retornando ao "Java language level migration aids", vemos que as classes anônimas que declaramos podem ser substituídas por expressão lambda. Para entender melhor sobre esta técnica, recomendamos o curso de Java 8.

Clicamos em "Replace with lambda" para resumir a chamada tornando-a mais direta com suas peculiaridades.

Por padrão, quando estamos em um projeto Android, damos suporte ao Java 7 por enquanto. Ou seja, quando fazemos a migração desta maneira, nosso código pára de compilar.

A seguir, veremos como utilizar o Java 8 no Android.

@@02
Resolvendo o tópico de Java

Caso você precise do projeto com todas as alterações realizadas na aula passada, você pode baixá-lo por meio deste link.
Resolva o tópico Java que tem o objetivo de refatorar o código fonte.

Dependendo de como você desenvolveu o seu projeto, talvez apareçam alertas de Java que diferem com os que foram visto em aula, como também, existe a situação que não aparece nenhum alerta.
Na aula tivemos os seguintes tópicos:

Declaration redundancy;
Imports.
Na declaration redundancy, temos o subtópico Declaration access can be weaker que indica que o membro identificado pode diminuir o modificador de acesso.

No geral, todas as sugestões podem ser aceitas, porém, no caso o alerta para a classe da Application apareça, suprima o alerta, pois o Android Framework exige a declaração de uma classe pública.

No imports, aceite todas as sugestões, pois ele remove todos os imports que não estão sendo utilizados.

Após resolver todos os tópicos, execute o inspetor novamente e veja se os 2 tópicos foram solucionados.

https://github.com/alura-cursos/fundamentos-android-parte-3/archive/aula-4.zip

Considerando que houveram muitas mudanças, confira detalhadamente o que mudou por meio deste commit.
É válido notar que neste commit é apresentada uma modificação no listener do dialog para usar a expressão lambda introduzida no Java 8.

Você não precisa adicionar essa modificação! Principalmente se o seu inspetor de código nem fez alarme deste detalhe.

De qualquer forma, a seguir veremos como é possível resolver esse detalhe do Java 8.

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/4897317a347435344b43633f703eb18bf96b1dac

@@03
Utilizando o Java 8 no Android

A equipe de desenvolvedores do Android disponibiliza uma técnica capaz de permitir que utilizemos alguns recursos do Java 8 mesmo tendo as limitações do uso de Java 7.
Inclusive, há uma página dedicada a explicar esse tipo de abordagem no guia do usuário que vale a pena conferir. Vamos entender melhor como utilizar esta ferramenta a partir do desugar.

Genericamente, nosso código-fonte apresenta a extensão padrão .java compilada pelo javac que gera arquivos .class e .dex.

Este último é utilizado para projetos em Android que geram .apk. Ou seja, capazes de serem executados em seus próprios aplicativos.

É o dex que apresenta restrições que exigem o uso exclusivo do Java 7 para ser gerado, sendo incompatível com as features mais atuais.

É justamente o desugar que possibilita o uso dos novos recursos, transformando os arquivos .class em dex compatíveis através do processo de desugarate, atuando como pós-compilador de .java.

Para isso, é necessária a adição do seguinte script em android no arquivo de build.gradle (app), desta forma:

compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}COPIAR CÓDIGO
Quando o fazemos, o sistema identifica a modificação e sugere a sincronização. Aceitamos clicando em "Sync Now" fazendo com que o código continue a compilar normalmente.

Voltando a executar o Inspetor de Código, as questões de expressão lambda mostradas anteriormente são resolvidas.

Esta é uma abordagem possível para a questão de Java apresentada.

Também podemos manter a classe anônima suprimindo a ação ou ainda eliminar totalmente essa inspeção selecionando "Disable inspection" nos tópicos.

Caso queira habilitar novamente, basta clicar no botão de ação do Inspetor chamado "Edit Settings", buscar por "lambda" na caixa de diálogo, selecionar a ação desejada na lista, e marcá-la positivamente.

Todavia, recomendamos que use esta expressão a fim de simplificar seu código.

@@04
Suportando o Java 8 no projeto Android

Projetos criados pelo AS 4.1 já mantém a configuração do Java 8, portanto, não há necessidade de ajustar o arquivo de build. Este exercício é opcional, pois talvez o seu inspetor de código não tenha alarmado sobre o uso da expressão lambda para substituir a implementação de classe anônima.
Adicione o suporte das features do Java 8 adicionando o desugar no projeto. Para isso, dentro do script android contido no arquivo build.gradle do módulo app, adicione o seguinte script:

compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}COPIAR CÓDIGO
Então sincronize o Gradle com o projeto clicando na opção Sync Now que aparece na parte superior à direita todas as vezes que o arquivo de build é modificado.

Após finalizar a sincronização, aceite as sugestões de substituição das classes anônimas para expressão lambda. Rode novamente o inspetor e veja se o tópico de Java é resolvido.

Aproveite também e rode o App e confira se tudo funciona como o esperado.

O resultado do inspetor não deve apresentar mais o tópico de Java, como também, o App deve funcionar normalmente.
Porém, mantemos as seguintes modificações no projeto com base neste commit.

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/2af2e5a6856b2a8f1e9c043592a84d662ab40b86

@@05
Para saber mais - Features do Java 8 no Android

Como eu havia comentado, o suporte do Java 8 no Android permite o uso de algumas features, ou seja, é muito importante ter consciência das limitações ao considerar essa alternativa.
Para isso, confira o post que publiquei no blog da Alura que mostra os pontos que precisamos ficar atentos, ou então, consulte a documentação.

http://blog.alura.com.br/utilizando-features-do-java-8-no-android/?_gl=1*10b91or*_ga*MTgwMzIzMjk2Ni4xNjg4ODE5OTcz*_ga_1EPWSW3PCS*MTY5NDk3OTAwMi40Mi4xLjE2OTQ5ODA1ODguMC4wLjA.*_fplc*WWZvR2kyN1FJaDAzdmUxRzYlMkZDMFZQZXdqJTJGbnUxMnpnZFNIYiUyQkVOUHVIeVZoVlNqZEpPT1JKbWkyOFFNcW1xYVJnOWprNVJLNnc1bGVpaTNyOEVtaCUyRlZLWDl2V29MbiUyQnJvSTJLczE1QjB0T1Q1VkkzY2F4blJyb3psaWJkdyUzRCUzRA..

https://developer.android.com/studio/write/java8-support

@@06
Delegando responsabilidade

Um último passo no processo de refatoração diz respeito à Activity. Esta possui diversos vínculos para o aplicativo funcionar como esperado, fazendo com que aumente conforme elaboramos as features do nosso projeto. Por isso devemos utilizar técnicas que deleguem responsabilidades à outras classes e simplifiquem nosso código.
Primeiro, vamos observar os membros que não necessariamente fazem uso dos métodos da Activity e podem ser migrados. Por exemplo, confirmaRemocao não possui uma chamada específica e podemos aplicar a técnica criando uma nova classe no pacote de ui.

Como não há um padrão estabelecido, a chamamos de ListaAlunosView. Ela receberá o bloco de código recortado do exemplo dado.

No momento de colar o comportamento, uma caixa de diálogo "Select Classes to Import" indica algumas dependências para serem importadas. Damos "OK" para depois resolver as questões de compilação que se apresentarão conforme avançamos, como a referência context, adapter e remove().

De volta Activity, podemos migrar atualizaAlunos(), remove() e configuraAdapter().

Para conseguir conceder acesso aos métodos migrados, devemos deixá-los como públicos na nova classe e criar uma instância na anterior.

Vamos ao início da criação da Activity para inserir desta forma:

public class ListaAlunosActivity extends AppCompactActivity {

    private static final String TITULO_APPBAR = "Lista de alunos";
    private final AlunoDAO dao = new AlunoDAO();
    private ListaAlunosAdapter adapter;
    private final ListaAlunosView listaAlunosView = new ListaAlunosView();
    // código omitido
}COPIAR CÓDIGO
Realizamos a inserção da instância nos demais comportamentos migrados.

Notamos também que não precisamos mais do adapter e do dao na Activity, podendo ambos serem eliminados desta. Otimizando os imports pelo atalho "Ctrl + Alt + O", diminuímos ainda mais as linhas de códigos.

A seguir, resolveremos os detalhes de compilação resultantes da migração em ListaAlunosView.

@@07
Migrando código da Activity

Delegue a responsabilidade de alguns comportamentos da ListaAlunosActivity para uma outra classe.
Para isso, crie a classe ListaAlunosView no pacote ui e envie todos os comportamentos que não façam uso de métodos diretamente da Activity. Na aula migramos os seguintes comportamentos:

confirmaRemocao();
atualizaAlunos();
remove();
configuraAdapter().
É importante ressaltar que esse não é um padrão adotado pela comunidade de desenvolvedores Android, é apenas uma boa prática de POO (Programação Orientada a Objetos) com o objetivo de melhorar a legibilidade do código e manutenção.
Após migrar, torne todos os métodos públicos para que sejam acessíveis na Activity, então, logo depois de setar a view no onCreate() da ListaAlunosActivity, faça a instância da classe ListaAlunosView e atribua para um atributo da classe.

Utilize o novo atributo para chamar os métodos que foram migrados e não estão mais compilando. Após realizar essa chamada, verifique apenas se o código na Activity volta a compilar.

Não é necessário rodar o App, pois existe mais uma etapa a ser solucionada.

Considerando que essa migração tiveram algumas mudanças pontuais no código, confira as alterações por meio deste commit.

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/d067c91b9c5f7e0f65eeb5a83d2be0bd31bfdd63

@@08
Resolvendo os problemas de compilação

Depois de migrar os comportamentos, resolveremos os problemas de compilação.
Em ListaAlunosView.java, vamos utilizar a mesma técnica usada na personalização do adapter.

Substitua this por context no AlertDialog, e use o atalho "Alt + Enter" para selecionar a opção "Create field 'context' in 'ListaAlunosView'" e criar um atributo que dá referência ao contexto.

No trecho gerado, utilize o atalho novamente e selecione "Add constructor parameters" para abrir a caixa de diálogo "Change Signature".

Cada membro do projeto que utilizar a nova classe deve ser refatorado para enviar o contexto, com conversão automática do Android Studio. Para isso, continue e clique em "Refactor" gerando:

public class ListaAlunosView {

    private Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
}COPIAR CÓDIGO
Agora precisamos da referência de Adapter que faz a inicialização no configuraAdapter. Repetimos a operação realizada anteriormente.

A mesma coisa deve ser feita com dao. Ainda, o context pode ser final por ser um atributo que não é modificado, finalizando dessa forma:

public class ListaAlunosView {

    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListAlunosAdapter(this.context);
        this.dao = new AlunoDAO();
    }
    // código omitido    
}COPIAR CÓDIGO
Ao passar pelo código, há um destaque no modificador de acesso indicando que está atrelado ao Inspetor de Código, e sugere a alteração de público para privado por meio do atalho "Alt + Enter".

De volta ao Activity, reparamos que o contexto continua apresentando problema. Para resolver, substitua por this.

Execute o aplicativo para testar as ações.

Portanto, o projeto se torna mais eficiente quando a Activity possui somente os comportamentos que lhe cabem, delegando funções às outras classes.

@@09
Finalizando a migração dos métodos

Altere o código da classe ListaAlunosView com o objetivo de compilar o código e rodar o projeto sem nenhum problema.
Para isso, primeiro resolva as dependências de cada um dos membros, como por exemplo, a referência de Context para o Dialog, o adapter e o DAO. Ambos podem serão atributos de classe para que sejam acessíveis por todos os membros.

Em específico o Context é recebido via construtor por ser uma entidade do Android Framework. Ao aplicar essa modificação, lembre-se de enviar o Context como argumento da instância de ListaAlunosView na ListaAlunosActivity.

Ao aplicar todas as modificações, execute novamente o App e veja se tudo funciona da maneira esperada.

O App deve funcionar da mesma maneira, a diferença é que agora conseguimos delegar algumas responsabilidades que não precisavam ficar na Activity.
Para verificar as modificações com precisão, veja o commit que mostra o código com as alterações.

https://github.com/alura-cursos/fundamentos-android-parte-3/commit/e62ac72732a7a9e7416e5413a79f4575d34940c8

@@10
Migrando projeto para AndroidX

Desde sua criação, o Android Framework disponibiliza o Support Library como uma solução capaz de dar suporte às APIs mínimas configuradas no nosso projeto, viabilizando alguns recursos de versões mais atuais.
Entretanto, está ocorrendo um processo de migração para a biblioteca do AndroidX. Nesta etapa, vamos abordar os motivos desta migração, como realizá-la e seus impactos.

Algumas questões importantes presentes no Support Library são: a nomeação de seus pacotes pela versão correspondente em diante que pode confundir a consulta e o fato de estar bastante interligado à versão do SDK, engessando seu uso.

A própria documentação apresenta uma nota explicativa sobre a migração que indica as soluções que o AndroidX possui, inclusive para as questões apresentadas.

Os pacotes até a API 27 estão disponíveis no repositório da Google, enquanto projetos que utilizam as versões mais atuais já devem obter suporte da nova biblioteca, evitando diversos problemas que encaramos no desenvolvimento do nosso aplicativo.

De volta ao menu de abertura do Android Studio atualizado para a versão 3.3, clique em "Open an existing Android Studio project" e busque nosso projeto "Agenda". Ao abrir, uma caixa de diálogo alerta sobre a atualização do Gradle Plugin que deve ser feita. Clique em "Update" para realizar a migração automaticamente.

Repare que um download está sendo feito para a sincronização da ferramenta de Build. Terminado este, o primeiro passo é a configuração para o Android Support Library e a questão do versionamento que depende do SDK.

Indo ao "Grade Scripts", selecione "build.gradle (Module:app)". Clique em "Ctrl + Shift + F12" para expandir a área dos códigos.

Por exemplo, se alterarmos de "28" para "27" em compileSdkVersion e targetSdkVersion, observamos que em dependencies o sistema indica a necessidade de utilizar um Support Library compatível à versão que se pretende dar suporte, sendo necessária a alteração nessas sequências também. É esse tipo de situação que no AndroidX propõe evitar.

Então, vamos realizar a migração nos arquivos de build.

Há um recurso próprio do Android Studio que auxilia nesse processo. Use o atalho "Ctrl + Shift + A" para inserir a ação "Migrate to AndroidX". Ao confirmar, uma caixa de diálogo recomenda um backup do projeto antes de migrar. Concorde e prossiga para salvar na pasta "projeto", antes de "Agenda".

Na sequência, o sistema apresenta uma preview da refatoração para o AndroidX. Caso queira realizar alterações mais para frente, clique com o botão direito do mouse nos trechos em destaque e selecione "exclude". No nosso caso, seguiremos apenas clicando em "Do Refactor".

Finalizados os downloads, é importante observar os destaques apresentados das versões das bibliotecas que estão sendo utilizadas.

O sistema sugere o uso de ferramentas alphas e betas em fase de testes para projetos em estudo. Porém, é mais garantido que usemos aquelas já em release para produção, evitando erros.

Para isso, removemos os trechos -beta01' e -alpha4' dos destaques em app. O Android Studio busca a disponibilidade e atualização das versões ao sincronizar novamente e sugere algumas alterações. Vamos realizá-las.

Sincronize outra vez.

Observamos mudanças em outros arquivos como o caso do gradle.properties, o qual faz com que o AndroidX seja executado através de duas importantes instruções: android.enableJetifier=true e android.useAndroidX=true.

Vamos executar o aplicativo no emulador para verificar seu funcionamento.

Agora não temos mais uma biblioteca que depende do Android SDK, podendo utilizar recursos de diversas versões graças à migração. Para obter mais informações sobre o mapeamento desta, vá até a página "Android Jetpack" no portal de desenvolvedores Android.

@@11
O que aprendemos?

Nesta aula, aprendemos a:
Resolver o tópico Java;
Adicionar o suporte as features do Java 8 no projeto Android;
Refatorar a Activity delegando responsabilidade.

@@12
Projeto final

Caso tiver alguma dúvida ou quiser consultar o projeto final, incluíndo o desafio, você pode baixá-lo a partir deste link.

https://github.com/alura-cursos/fundamentos-android-parte-3/archive/aula-5.zip

@@13
Conclusão

Finalizamos o curso sobre os Fundamentos de Android e você tem a base necessária para criar seu próprio aplicativo.
Vamos rever o que foi passado e entender os próximos passos possíveis.

Demos continuidade ao projeto de Agenda e aplicamos um layout personalizado nosAdapterView e ListView com a implementação do BaseAdapter.

Aprendemos sobre a entidade estável Application e seus recursos para execução de comportamentos uma única vez sem comprometimentos com mudanças comuns, diferente da Activity.

Implementamos o dialog e a classe AlertDialog que geram caixas de diálogos como a que confirma a remoção de itens da lista, aumentando a interação com o usuário. Essa técnica pode ser utilizada para qualquer outra mensagem relevante.

Após nos dedicarmos bastante à visualidade, focamos também na qualidade do nosso projeto por meio do Inspetor de Código. Aprendemos que o IntelliJ IDEA nos fornece uma ferramenta de inspeção integrada ao Android Studio para resolver diversas questões apresentadas.

Todavia, não é suficiente para toda a refatoração necessária. Para tanto, delegamos responsabilidades da Activity para outras classes como a ListaAlunosView.java, deixando-a mais simples e eficiente.

Esses conceitos valem também para a linguagem Kotlin. Caso queira se aprofundar, sugerimos outros cursos aqui da Alura.

Com essa experiência, esperamos que você possa elaborar seus próprios dispositivos Android da maneira que preferir. Sugerimos que realize as atividades a seguir e deixe seu feedback.

@@14
Próximos passos
PRÓXIMA ATIVIDADE

A proposta do curso é apresentar o conteúdo essencial para qualquer tipo de projeto Android. Porém, visando a evolução como desenvolvedor ou desenvolvedora Android, abaixo vou deixar uma lista com os próximos passos sugeridos como próximos passos:
Criação de layouts com ConstraintLayout: neste curso aprendemos como podemos criar layouts mais complexos com o ConstraintLayout, uma ViewGroup muito poderosa capaz de flexibilizar a construção do layout via editor visual ou XML. Além disso, o ConstraintLayout melhora a performance na renderização de layouts complexos.
Listas flexíveis e performáticas com RecyclerView: neste curso o foco é apresentar uma alternativa mais sofisticada de listagem no mundo Android, o RecyclerView. Por meio desta biblioteca somos capazes de criar listas com uma carga enorme de dados de uma maneira performática e flexível.
Persistência de dados com Room: neste curso aprendemos como é possível implementar um CRUD de maneira persistence no App Android por meio de banco de dados interno, o SQLite. Porém, ao invés de usar a API nativa, utilizamos a abordagem da biblioteca Room que facilita a forma como trabalhamos com o SQLite.
Desenvolvimento Android com Kotlin: neste curso criamos um novo projeto Android com Kotlin baseando-se em um projeto Java com o objetivo de apresentar as novidades e diferenças da linguagem em relação ao Java. No geral, a proposta desta linguagem é facilitar a implementação do projeto, reduzindo a verbosidade presente no Java.
Testes automatizados e TDD: neste curso focamos em como o projeto pode ser testado de maneira automática em relação à regra de negócio. Por meio desta técnica além de melhorar a qualidade do projeto em geral, evitamos bugs inesperados.
Além desses cursos, temos muitos outros cursos de Android na Alura. O principal motivo por sugerir esses é pelo fato de que eles exigem apenas o conteúdo fundamental, portanto, os demais, muito provavelmente vão exigir conhecimentos de um desses cursos :)

Se tiver dúvida sobre orientações de próximos cursos, fique à vontade e entre em contato com a gente.

https://cursos.alura.com.br/course/layout-android-1

https://cursos.alura.com.br/course/recyclerview-listas-flexiveis-e-performaticas

https://cursos.alura.com.br/course/android-room?preRequirementFrom=android-room-operacoes-assincronas

https://cursos.alura.com.br/course/android-com-kotlin-parte-1

https://cursos.alura.com.br/course/android-testes-automatizados-tdd

https://cursos.alura.com.br/category/mobile#android