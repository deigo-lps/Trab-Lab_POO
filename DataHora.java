//marromeno pronto.
import java.util.Scanner;
public class DataHora{
  private int dia;
  private int mes;
  private int ano;
  private int hora;
  private int minuto;
  
  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAno() {
    return ano;
  }

  public int getHora() {
    return hora;
  }

  public int getMinuto() {
    return minuto;
  }

  public boolean setDia(int dia) {
    if(dia<1 || dia>31){
      System.out.println("Dia invalido. Tente novamente.");
      return false;
    }
    this.dia = dia;
    return true;
  }

  public boolean setMes(int mes) {
    if(mes<1 || mes>12){
      System.out.println("Mes invalido. Tente novamente.");
      return false;
    }
    this.mes = mes;
    return true;
  }

  public boolean setAno(int ano) {
    if(ano<1800){
      System.out.println("Ano invalido. Tente novamente.");
      return false;
    }
    this.ano = ano;
    return true;
  }

  public boolean setHora(int hora) {
    if(hora<0 || hora>23){
      System.out.println("Hora invalida. Tente novamente.");
      return false;
    }
    this.hora = hora;
    return true;
  }

  public boolean setMinuto(int minuto) {
    if(minuto<0 || minuto>59){
      System.out.println("Minuto invalido. Tente novamente.");
      return false;
    }
    this.minuto = minuto;
    return true;
  }
  public DataHora(){
    this(1,1,2000,1,1);
  }
  public DataHora(int dia,int mes,int ano){
    this(dia,mes,ano,1,1);
  }
  //melhorar
  public DataHora(int dia,int mes,int ano,int hora,int minuto){
    Scanner scan=new Scanner(System.in);
    while(true){
      if(!(setDia(dia) && setMes(mes) && setAno(ano) && setHora(hora) && setMinuto(minuto))){
        System.out.printf("Dia: ");
        dia=scan.nextInt();
        System.out.printf("Mes: ");
        mes=scan.nextInt();
        System.out.printf("Ano: ");
        ano=scan.nextInt();
        System.out.printf("Hora: ");
        hora=scan.nextInt();
        System.out.printf("Minuto: ");
        minuto=scan.nextInt();
      }
      else{
        // scan.close();
        break;
      }
    }
  }
  public void printDataHora(){
    System.out.printf("%d:%d %d/%d/%d\n",hora,minuto,dia,mes,ano);
  }
}