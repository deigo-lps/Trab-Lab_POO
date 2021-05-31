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
    ArrayList<Passageiros> passageiros = new ArrayList<>();
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
          System.out.printf("Digite o modelo: ");
          scan.nextLine();
          String modelo=scan.nextLine();
          System.out.printf("Digite o ano de fabricacao: ");
          int ano=scan.nextInt();
          System.out.printf("Digite a marca: ");
          scan.nextLine();
          String marca=scan.nextLine();
          System.out.printf("Digite a quilometragem: ");
          int km=scan.nextInt();
          System.out.printf("Digite numero de linhas e colunas de assentos separando por espaco: ");
          int linha=scan.nextInt();
          int coluna=scan.nextInt();
          onibus.add(new Onibus(modelo,ano,marca,km,new int[linha][coluna]));
          // onibus.get(0).printOnibus();
        }
        case 3:{
          System.out.println("Se não for ter alguma parada preencha com ponto.");
          System.out.printf("Digite a origem: ");
          scan.nextLine();
          String origem=scan.nextLine();
          System.out.printf("Digite o destino: ");
          String destino=scan.nextLine();
          System.out.printf("Digite a parada 1: ");
          String p1=scan.nextLine();
          System.out.printf("Digite a parada 2: ");
          String p2=scan.nextLine();
          System.out.printf("Digite a parada 3: ");
          String p3=scan.nextLine();
          System.out.printf("Digite dia mes ano hora e minuto de saida separando por espaco: ");
          DataHora saida=new DataHora(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
          System.out.printf("Digite dia mes ano hora e minuto de chegada separando por espaco: ");
          DataHora chegada=new DataHora(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
          rotas.add(new Rotas(origem,destino,p1,p2,p3,saida,chegada));
          // rotas.get(0).printRota();
          break;
        }
        case 4:{
          int op1,op2,aux;
          System.out.println("1 para alterar, 2 para excluir: ");
          op1=scan.nextInt();
          System.out.println("1 para motorista, 2 para onibus, 3 para rota: ");
          op2=scan.nextInt();
          if(op2==1){
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
        case 5: 
          if(motoristas.size()==0 || onibus.size()==0 || rotas.size()==0){
            System.out.println("Crie pelomenos um de cada.");
            op=6;
          }
          break;
      }
    }while(op!=4);
  }
}