import java.util.*;
public class Metodos{
  //op==1 adiciona um motorista novo com as informações.
  //op==2 modifica um ja existente com as informações.
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
      //se mudar os assentos e acabar tirando uma posição ocupada daria problema se fosse sistema real,
      //então não da pra modificar assentos.
      onibus.get(id).setOnibus(modelo,ano,marca,km);
      System.out.println("Onibus modificado.");
    }
  }
  public static void addmodRota(int op,int id,ArrayList<Rotas> rotas){
    Scanner scan=new Scanner(System.in);
    System.out.println("Se não for ter alguma parada preencha com ponto.");
    System.out.printf("Digite a origem: ");
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
    if(op==1)
      rotas.add(new Rotas(origem,destino,p1,p2,p3,saida,chegada));
    else if (op==2){
      rotas.get(id).setRota(origem,destino,p1,p2,p3,saida,chegada);
      System.out.println("Rota modificada.");
    }
  }
  
}