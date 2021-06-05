// A partir dos dados cadastrados, você deverá implementar o sistema de compra de passagens.
// O passageiro escolherá a origem e destino (ex: São José do Rio Preto, Brasília), o sistema
// deverá informar os horários, as rotas, o nome do motorista, os valores da passagem e os
// assentos disponíveis. O passageiro selecionará a opção preferível e a compra será efetivada.
// O assento escolhido pelo passageiro não ficará mais disponível para comprar.
import java.util.*;
public class Principal extends Metodos{
  public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    // System.out.printf("Dia: ");
    // int dia=scan.nextInt();
    // System.out.printf("Mes: ");
    // int mes=scan.nextInt();
    // System.out.printf("Ano:");
    // int ano=scan.nextInt();
    // System.out.printf("Hora: ");
    // int hora=scan.nextInt();
    // System.out.printf("Minuto: ");
    // int minuto=scan.nextInt();
    // DataHora data=new DataHora(dia,mes,ano,hora,minuto);
    // data.printDataHora();
    
    // Onibus onibus=new Onibus("modelo",2021,"benz",25,new int[4][12]);
    // onibus.resetAssentos();
    // onibus.setAssento(4,12,2);
    // onibus.getAssentos();
    // onibus.motorista.printMotorista();
    
    // Rotas rota=new Rotas("Rio Preto","Cedral?","Nsei1","Nsei2","Nsei3",new DataHora(28,04,2021,22,30),new DataHora(29,04,2021,10,50));
    // rota.printRota();
    
    ArrayList<Motorista> motoristas = new ArrayList<>();
    ArrayList<Onibus> onibus = new ArrayList<>();
    ArrayList<Rotas> rotas = new ArrayList<>();
    int op;
    System.out.printf("Configuração Inicial.\nTenha em mente que onibus precisam de motoristas e rotas precisam de onibus.\nSe existirem mais rotas que onibus, as rotas a mais serão disperdicadas.\n");
    do{
      System.out.printf("1 para adicionar motorista\n2 para adicionar onibus\n3 para adicionar rotas\n4 alterar/excluir\n5 para proximo passo: ");
      op=scan.nextInt();
      switch(op){
        case 1:{
          addmodMotorista(1,0,motoristas);
          // motoristas.get(0).printMotorista();
          break;
        }
        //n esquecer de fazer loop pra reseta os assentos(eu acho q precisa seila).
        case 2:{
          addmodOnibus(1,0,onibus);
          // onibus.get(0).printOnibus();
          break;
        }
        case 3:{
          addmodRota(1,0,rotas);
          // rotas.get(0).printRota();
          break;
        }
        case 4:{
          int op1,op2,aux;
          System.out.println("1 para alterar, 2 para excluir: ");
          op1=scan.nextInt();
          System.out.println("1 para motorista, 2 para onibus, 3 para rota: ");
          op2=scan.nextInt();
          switch(op2){
            case 1:{
              if(motoristas.size()==0){
                System.out.println("Sem motoristas.");
              }
              else{
                for(int i=0;i<motoristas.size();i++){
                  System.out.printf("ID: %d\n",i);
                  motoristas.get(i).printMotorista();
                  System.out.println("/-----------------/");
                }
                System.out.println("Digite o ID do motorista: ");
                aux=scan.nextInt();
                if(aux<0 || aux>motoristas.size())
                  System.out.println("ID invalido.");
                else{
                  if(op1==2){
                    motoristas.remove(aux);
                    System.out.println("Motorista apagado.");
                  }
                  else{
                    addmodMotorista(2,aux,motoristas);
                  }
                }
              }
              break;
            }
            case 2:{
              if(onibus.size()==0){
                System.out.println("Sem onibus.");
              }
              else{
                for(int i=0;i<onibus.size();i++){
                  System.out.printf("ID: %d\n",i);
                  onibus.get(i).printOnibus();
                  System.out.println("/-----------------/");
                }
                System.out.println("Digite o ID do onibus: ");
                aux=scan.nextInt();
                if(aux<0 || aux>onibus.size())
                  System.out.println("ID invalido.");
                else{
                  if(op1==2){
                    onibus.remove(aux);
                    System.out.println("Onibus apagado.");
                  }
                  else{
                    addmodOnibus(2,aux,onibus);
                  }
                }
              }
              break;
            }
            case 3:{
              if(motoristas.size()==0){
                System.out.println("Sem motoristas.");
              }
              else{
                for(int i=0;i<rotas.size();i++){
                  System.out.printf("ID: %d\n",i);
                  rotas.get(i).printRota();
                  System.out.println("/-----------------/");
                }
                System.out.println("Digite o ID da rota: ");
                aux=scan.nextInt();
                if(aux<0 || aux>rotas.size())
                  System.out.println("ID invalido.");
                else{
                  if(op1==2){
                    rotas.remove(aux);
                    System.out.println("Rota apagada.");
                  }
                  else{
                    addmodRota(2,aux,rotas);
                  }
                }
              }
              break;
            }
          }
          break;
        }
        case 5: 
          // if(motoristas.size()==0 || onibus.size()==0 || rotas.size()==0){
          //   System.out.println("Crie pelomenos um de cada.");
          //   op=6;
          // }
          break;
      }
    }while(op!=5);
    System.out.println("Configuração Final.");
    int i=0;
    int motorista;
    int com_motorista;
    while(i<onibus.size()){
      com_motorista=0;
      System.out.println("\nDigite o ID do motorista que deseja para o Onibus: ");
      onibus.get(i).printOnibus();
      System.out.println("/---------------/");
      System.out.println("Motoristas:");
      for(int k=0;k<motoristas.size();k++){
        if(motoristas.get(k).getTemOnibus()){
          continue;
        }
        else{
          com_motorista++;
          System.out.printf("ID: %d\n",k);
          motoristas.get(k).printMotorista();
          System.out.println();
        }
      }
      if(com_motorista==0){
        System.out.println("Sem motoristas disponíveis. Cancelando.");
        break;
      }
      motorista=scan.nextInt();
      while(true){
        if(motorista<0 || motorista+1>motoristas.size() || motoristas.get(motorista).getTemOnibus()){
          System.out.println("Motorista invalido. tente novamente: ");
          motorista=scan.nextInt();
        }
        else
          break;
      }
      motoristas.get(motorista).setTemOnibus(true);
      onibus.get(i).setMotorista(motoristas.get(motorista));
      System.out.println("Motorista escolhido.\n");
      i++;
    }
    i=0;
    int com_onibus;
    while(i<rotas.size()){
      com_onibus=0;
      System.out.println("\nDigite o ID do onibus que deseja para a rota: ");
      rotas.get(i).printRota();
      System.out.println("/---------------/");
      System.out.println("Onibus:");
      for(int k=0;k<onibus.size();k++){
        //se ja tiver rota ou não tiver motorista.
        if(onibus.get(k).getTemRota() || onibus.get(k).motorista.getNome().equals("")){
          continue;
        }
        else{
          com_onibus++;
          System.out.printf("ID: %d\n",k);
          onibus.get(k).printOnibus();
          System.out.println();
        }
      }
      if(com_onibus==0){
        System.out.println("Sem onibus disponíveis. Cancelando.");
        break;
      }
      int onibu=scan.nextInt();
      while(true){
        if(onibu<0 || onibu+1>onibus.size() || onibus.get(onibu).getTemRota() || onibus.get(onibu).motorista.getNome().equals("")){
          System.out.println("Onibus invalido. tente novamente: ");
          onibu=scan.nextInt();
        }
        else
          break;
      }
      onibus.get(onibu).setTemRota(true);
      rotas.get(i).setOnibus(onibus.get(onibu));
      System.out.println("Onibus escolhido.\n");
      i++;
    }
    //criando array de rotas com onibus, se n tiver onibus n tem pq comprar passagem pra ela. tem nem  como na vdd, pq n vo deixa e é isso.
    ArrayList<Rotas> rotas_disponíveis = new ArrayList<>();
    for(i=0;i<rotas.size();i++){
      if(!rotas.get(i).onibus.getModelo().equals(""))
        rotas_disponíveis.add(rotas.get(i));
    }
    ArrayList<Passageiros> passageiros = new ArrayList<>();
    /*daqui pra baixo é a parte do usuario. Faz um menu com opção de criar ou logar.
    se o cara escolher criar, só pedir tudo do construtor de passageiro e tacar nele.
    scanf fitas do construtor
    passageiros.add(new Passageiro(fitas do construtor))
    nisso dps q criou, (verificar se o login ja existe, se existir n deixa cria)
    ja taca pra tela que tacaria se tivesse logado.
    Se ele escolher logar, só pedir o login, procurar na lista de passageiros algum q tenha 
    aquele login, se achar pedir a senha e usar o método de verificar senha q eu fiz e pocas
    
    dps de logar/criar, vai pro menu do passageiro(salva o indice dele em alguma variavel.).
    Tem 2 opções, ver rota e comprar passagem.
    se pedir pra ver rota só printar a rota com passageiros.get(indice).rota.printRota()
    no caso verificar se ele tem uma rota antes. if(passageiros.get(i).rota.getOrigem().equals("")) print("Voce não tem rota.")
    Se pedir pra comprar,
    if(!passageiros.get(i).rota.getOrigem().equals("")) print("voce ja tem uma rota.") e cancela.
    se não,
    Pede pra ele digitar origem e destino.
    procura na lista de rotas pra ver se alguma delas tem a origem, se achar, ve se tem o destino/parada.
    printa as que tiverem a origem e destino(tem método pra printar)
    com ID sendo o indice delas na lista
    e pede pro usuario escolher pelo id.
    (o id printa separado pq n ta no metodo).
    
    no que ele escolher a rota, printa a matriz de posições do busão da rota(tem método pra isso)
    rotas.get(ID).onibus.getAssentos();
    e pede a linha e coluna que ele quer.
    
    dps só marca como ocupado rotas.get(ID).onibus.setAssento(linha,coluna,1) 
    da um passageiros.get(i).setRota(rotas.get(ID))
    e cabo.*/
  }
}