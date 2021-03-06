// modelo, ano de fabricação, marca, quilometragem, localização dos assentos(matriz, 0 vazio 1 ocupado).
public class Onibus{
  private String modelo;
  private int anoFabricacao;
  private String marca;
  private int quilometragem;
  private int[][] assentos;/*=new int[4][12];*/
  public Motorista motorista;
  private boolean temRota;
  
  public Onibus(){
    this("",0,"",0,new int[0][0]);
  }
  
  public Onibus(String modelo, int anoFabricacao, String marca, int quilometragem, int[][] assentos){
    this.modelo = modelo;
    this.anoFabricacao = anoFabricacao;
    this.marca = marca;
    this.quilometragem = quilometragem;
    this.assentos=assentos;
    this.motorista=new Motorista();
  }
  
  public boolean getTemRota(){
    return temRota;
  }
  
  public void setTemRota(boolean temRota){
    this.temRota=temRota;
  }
  
  public void printOnibus(){
    System.out.printf("Modelo: %s\nAno de Fabricacao: %d\nMarca: %s\nQuilometragem: %d\n",modelo,anoFabricacao,marca,quilometragem);
  }
  public String getModelo(){
    return modelo;
  }
  public int getAnoFab(){
    return anoFabricacao;
  }
  public String getMarca(){
    return marca;
  }
  public int getQuilometragem(){
    return quilometragem;
  }
  public void setModelo(String modelo){
    this.modelo=modelo;
  }
  public void setAnoFab(int anoFabricacao){
    this.anoFabricacao=anoFabricacao;
  }
  public void setMarca(String marca){
    this.marca=marca;
  }
  public void setQuilometragem(int quilometragem){
    this.quilometragem=quilometragem;
  }
  public void setMotorista(Motorista motorista){
    this.motorista=motorista;
  }
  //passa as posiçoes para livres.
  public void resetAssentos(){
    for(int i=0;i<assentos.length;i++){
      for(int j=0;j<assentos[i].length;j++){
        assentos[i][j]=0;
      }
    }
  }
  //printa a matriz de assentos.
  public void getAssentos(){
    for(int i=0;i<assentos.length;i++){
      System.out.printf("\n");
      for(int j=0;j<assentos[i].length;j++){
        System.out.printf("%d ",assentos[i][j]);
      }
    }
    System.out.println();
  }
  //retorna se tem assentos livres.
  public boolean temAssento(){
    boolean tem=false;
    for(int i=0;i<assentos.length;i++){
      for(int j=0;j<assentos[i].length;j++){
        if(assentos[i][j]==0)
          tem=true;
      }
    }
    return tem;
  }
  //marca um assento como ocupado.
  //faz verificações antes.
  //retorna se marcou como ocupado ou não.
  public boolean setAssento(int i,int j){
    boolean deu_certo=false;
    if(i>assentos.length||j>assentos[i-1].length || assentos[i-1][j-1]==1)
      System.out.println("Opcao invalida.");
    else{
      this.assentos[i-1][j-1]=1;
      deu_certo=true;
    }
    return deu_certo;
  }
  public void setOnibus(String modelo, int anoFabricacao, String marca, int quilometragem){
    setModelo(modelo);
    setAnoFab(anoFabricacao);
    setMarca(marca);
    setQuilometragem(quilometragem);
  }
}