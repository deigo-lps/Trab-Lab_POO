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
}