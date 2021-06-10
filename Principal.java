// A partir dos dados cadastrados, você deverá implementar o sistema de compra de passagens.
// O passageiro escolherá a origem e destino (ex: São José do Rio Preto, Brasília), o sistema
// deverá informar os horários, as rotas, o nome do motorista, os valores da passagem e os
// assentos disponíveis. O passageiro selecionará a opção preferível e a compra será efetivada.
// O assento escolhido pelo passageiro não ficará mais disponível para comprar.
import java.util.*;
public class Principal extends Metodos{
  public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    ArrayList<Motorista> motoristas = new ArrayList<>();
    ArrayList<Onibus> onibus = new ArrayList<>();
    ArrayList<Rotas> rotas = new ArrayList<>();
    int op;
    //Configuração inicial é pra cadastrar motoristas onibus e rotas.
    System.out.printf("Configuracao Inicial.\nTenha em mente que onibus precisam de motoristas e rotas precisam de onibus.\nSe existirem mais rotas que onibus, as rotas a mais serao disperdicadas.\n");
    do{
      System.out.printf("1 para adicionar motorista\n2 para adicionar onibus\n3 para adicionar rotas\n4 alterar/excluir\n5 para proximo passo: ");
      op=scan.nextInt();
      switch(op){
        case 1:{
          addmodMotorista(1,0,motoristas);
          break;
        }
        case 2:{
          addmodOnibus(1,0,onibus);
          break;
        }
        case 3:{
          addmodRota(1,0,rotas);
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
          if(motoristas.size()==0 || onibus.size()==0 || rotas.size()==0){
            System.out.println("Crie pelomenos um de cada.");
            op=6;
          }
          break;
      }
    }while(op!=5);
    //final é para dar motoristas aos onibus e onibus as rotas.
    System.out.println("Configuracao Final.");
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
        //printa só os que não tem onibus.
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
        System.out.println("Sem motoristas disponiveis. Cancelando.");
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
        //printa se não tiver rota e tiver motorista.
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
        System.out.println("Sem onibus disponiveis. Cancelando.");
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
    //criando array de rotas com onibus.
    ArrayList<Rotas> rotas_disponiveis = new ArrayList<>();
    for(i=0;i<rotas.size();i++){
      if(!rotas.get(i).onibus.getModelo().equals(""))
        rotas_disponiveis.add(rotas.get(i));
    }
    ArrayList<Passageiros> passageiros = new ArrayList<>();
    int escolha;
    int passageiro_logado;
    do{
      //indice do passageiro logado.
      passageiro_logado=-1;
      System.out.println("Digite uma opcao:\n");
      System.out.println("1 - Criar usuario\n");
      System.out.println("2 - Logar\n");
      System.out.printf("3 - Sair: \n");

      escolha = scan.nextInt();
      switch(escolha){
        case 1:{
          System.out.printf("Digite o nome: ");
          scan.nextLine();
          String nome=scan.nextLine();
          System.out.printf("Digite o documento: ");
          String documento=scan.nextLine();
          System.out.printf("Digite a profissao: ");
          String profissao=scan.nextLine();
          String login;
          //pede login até ser valido.
          while(true){
            boolean login_repetido=false;
            System.out.printf("Digite o login: ");
            login=scan.nextLine();
            for(i=0;i<passageiros.size();i++){
              if(passageiros.get(i).getLogin().equals(login)){
                login_repetido=true;
                break;
              }
            }
            if(login_repetido)
              System.out.println("Login ja existente. tente novamente.");
            else
              break;
          }
          System.out.printf("Digite a senha: ");
          String senha=scan.nextLine();
          System.out.printf("Digite sua rua: ");
          String rua=scan.nextLine();
          System.out.printf("Digite o numero da sua casa: ");
          int numero=scan.nextInt();
          System.out.printf("Digite seu bairro: ");
          scan.nextLine();
          String bairro=scan.nextLine();
          System.out.printf("Digite o cep: ");
          String cep=scan.nextLine();
          System.out.printf("Digite sua cidade: ");
          String cidade=scan.nextLine();
          System.out.printf("Digite seu estado: ");
          String estado=scan.nextLine();
          System.out.printf("Digite sua data de nascimento separando por espaco: ");
          //indice do passageiro criado vai ser o tamanho da lista antes de adicionar ele.
          passageiro_logado=passageiros.size();
          passageiros.add(new Passageiros(documento,nome,new DataHora(scan.nextInt(),scan.nextInt(),scan.nextInt()),new Endereco(rua,numero,bairro,cep,cidade,estado),profissao,login,senha));
          System.out.println("Passageiro criado.");
          break;
        }
        case 2:{
          int k;
          String login, senha;
          System.out.printf("Digite o login do passageiro: ");
          scan.nextLine();
          login = scan.nextLine();
          System.out.printf("Digite a senha do passageiro: ");
          senha = scan.nextLine();
          for(k=0;k<passageiros.size();k++){
            if(passageiros.get(k).getLogin().equals(login) && passageiros.get(k).validaLogin(senha)){
              passageiro_logado=k;
              break;
            }
          }
          break;
        }
      }
      //se não logou
      if(passageiro_logado==-1 && escolha!=3)
        System.out.println("Login ou senha incorretos.");
      else{
        int escolha2;
        do{
          System.out.println("\nMenu de passageiro");
          System.out.println("\n1 - Ver Rota");
          System.out.println("2 - Comprar passagem");
          System.out.println("3 - Logout");
          System.out.printf("\nDigite uma das opcoes: ");
          escolha2 = scan.nextInt();
          switch(escolha2){
            case 1:{
              //se não tiver rota.
              if(passageiros.get(passageiro_logado).rota.getOrigem().equals(""))
                System.out.println("Voce nao tem rota.");
              else{
                passageiros.get(passageiro_logado).rota.printRota();
                System.out.println("Linha: "+passageiros.get(passageiro_logado).getLinha());
                System.out.println("Coluna: "+passageiros.get(passageiro_logado).getColuna());
              }
              break;
            }
            case 2:{
              //se ja tiver rota.
              if(!passageiros.get(passageiro_logado).rota.getOrigem().equals(""))
                System.out.println("voce ja tem uma rota.");
              else{
                System.out.printf("Digite a origem: ");
                scan.nextLine();
                String origem = scan.nextLine();
                System.out.printf("Digite o destino: ");
                String destino = scan.nextLine();
                boolean tem_rotas=false;
                System.out.println("Rotas Disponiveis: ");
                //printa se tem a origem e destino/parada, e se o onibus não estiver lotado.
                for(int x = 0; x < rotas.size(); x++){
                  if(rotas_disponiveis.get(x).getOrigem().equals(origem) &&
                  (rotas_disponiveis.get(x).getDestino().equals(destino) ||
                  rotas_disponiveis.get(x).getParada1().equals(destino) ||
                  rotas_disponiveis.get(x).getParada2().equals(destino) ||
                  rotas_disponiveis.get(x).getParada3().equals(destino)) && rotas_disponiveis.get(x).onibus.temAssento()){
                    System.out.println("ID: "+x);
                    rotas_disponiveis.get(x).printRota();
                    System.out.println("/-------------------/");
                    tem_rotas=true;
                  }
                }
                if(tem_rotas){
                  System.out.printf("\nDigite o ID da rota desejada: ");
                  int id = scan.nextInt();
                  if(id>=rotas_disponiveis.size()||id<0||!rotas_disponiveis.get(id).onibus.temAssento())
                    System.out.println("Rota invalida.");
                  else{
                    rotas_disponiveis.get(id).onibus.getAssentos();
                    System.out.printf("Digite a linha que deseja: ");
                    int linha=scan.nextInt();
                    System.out.printf("Digite a coluna que deseja: ");
                    int coluna=scan.nextInt();
                    if(rotas.get(id).onibus.setAssento(linha,coluna)){
                      passageiros.get(passageiro_logado).setRota(rotas.get(id));
                      passageiros.get(passageiro_logado).setLinhaColuna(linha,coluna);
                    }
                  }
                }
                else{
                  System.out.println("Nao exitem rotas disponiveis.");
                }
              }
              break;
            }
            default:break;
          }
        }while(escolha2!=3);
      }
    }while(escolha!=3);
  }
}