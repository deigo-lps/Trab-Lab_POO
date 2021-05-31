// A partir dos dados cadastrados, você deverá implementar o sistema de compra de passagens.
// O passageiro escolherá a origem e destino (ex: São José do Rio Preto, Brasília), o sistema
// deverá informar os horários, as rotas, o nome do motorista, os valores da passagem e os
// assentos disponíveis. O passageiro selecionará a opção preferível e a compra será efetivada.
// O assento escolhido pelo passageiro não ficará mais disponível para comprar.
import java.util.*;
public class Principal{
  public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
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
    
    Onibus onibus=new Onibus("modelo",2021,"benz",25,new int[4][12]);
    onibus.resetAssentos();
    onibus.setAssento(4,12,2);
    onibus.getAssentos();
    onibus.motorista.printMotorista();
    
    // Rotas rota=new Rotas("Rio Preto","Cedral?","Nsei1","Nsei2","Nsei3",new DataHora(28,04,2021,22,30),new DataHora(29,04,2021,10,50));
    // rota.printRota();
    
    // ArrayList<Motorista> motoristas = new ArrayList<>();
    // ArrayList<Onibus> onibus = new ArrayList<>();
    // ArrayList<Passageiros> passageiros = new ArrayList<>();
    // ArrayList<Rotas> rotas = new ArrayList<>();
  }
}