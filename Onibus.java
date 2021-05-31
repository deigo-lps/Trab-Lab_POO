// modelo, ano de fabricação, marca, quilometragem, localização dos assentos(matriz, 0 vazio 1 ocupado).
public class Onibus{
  private String modelo;
  private int anoFabricacao;
  private String marca;
  private int quilometragem;
  private int[][] assentos;/*=new int[4][12];*/
  
	public Onibus(String modelo, int anoFabricacao, String marca, int quilometragem, int[][] assentos){
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.marca = marca;
		this.quilometragem = quilometragem;
    this.assentos=assentos;
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
  public void resetAssentos(){
    for(int i=0;i<assentos.length;i++){
      for(int j=0;j<assentos[i].length;j++){
        assentos[i][j]=0;
      }
    }
  }
  public void getAssentos(){
    for(int i=0;i<assentos.length;i++){
      System.out.printf("\n");
      for(int j=0;j<assentos[i].length;j++){
        System.out.printf("%d ",assentos[i][j]);
      }
    }
    System.out.println();
  }
  // public void getAssentosDisp(){
  //   for(int i=0;i<assentos.length;i++){
  //     for(int j=0;j<assentos[i].length;j++){
  //       if(assentos[i][j]==0)
  //         System.out.printf("Linha %d, Coluna %d\n",i+1,j+1);
  //     }
  //   }
  // }
  public void setAssento(int i,int j,int estado){
    if(i>assentos.length||j>assentos[i-1].length || estado<0 || estado>1){
      System.out.println("Opcao invalida.");
    }
    else
      this.assentos[i-1][j-1]=estado;
  }
}