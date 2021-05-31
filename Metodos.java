import java.util.*;
public class Metodos{
  public static void addmodMotorista(int op,int id,ArrayList<Motorista> motoristas){
    Scanner scan=new Scanner(System.in);
    System.out.printf("Digite a CNH: ");
    String cnh=scan.next();
    System.out.printf("Digite o nome do motorista: ");
    scan.nextLine();
    String nome=scan.nextLine();
    System.out.printf("Digite dia mes e ano de admissao separando por espaço: ");
    DataHora admissao=new DataHora(scan.nextInt(),scan.nextInt(),scan.nextInt());
    if(op==1)
      motoristas.add(new Motorista(cnh,admissao,nome));
    else if (op==2){
      motoristas.get(id).setMotorista(cnh,admissao,nome);
      System.out.println("Motorista modificado.");
    }
  }
  public static void addmodOnibus(int op,int id,ArrayList<Onibus> onibus){
    Scanner scan=new Scanner(System.in);
    System.out.printf("Digite o modelo: ");
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
    if(op==1)
      onibus.add(new Onibus(modelo,ano,marca,km,new int[linha][coluna]));
    else if (op==2){
      onibus.get(id).setOnibus(modelo,ano,marca,km,new int[linha][coluna]);
      System.out.println("Onibus modificado.");
    }
  }
  
}