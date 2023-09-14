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
PRÓXIMA ATIVIDADE

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
PRÓXIMA ATIVIDADE

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
PRÓXIMA ATIVIDADE

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
PRÓXIMA ATIVIDADE

Além do AlertDialog existem outras caixas de diálogo comum em Apps Android, como é o caso da DatePickerDialog que permite o usuário escolher uma data ou o TimePickerDialog que permite escolher a hora.
Para mais detalhes de possibilidades com dialogs, consulte a documentação.

https://developer.android.com/reference/android/app/DatePickerDialog

https://developer.android.com/reference/android/app/TimePickerDialog

https://developer.android.com/guide/topics/ui/dialogs

@@07
O que aprendemos?
PRÓXIMA ATIVIDADE

Nesta aula, aprendemos a:
Necessidade de caixa de diálogo para confirmação;
Implementação de dialog com AlertDialog.