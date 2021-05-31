// a empresa trabalha com rotas com até 5 cidades diferentes (origem, destino e
// 3 paradas), horário de saída e horário de chegada.
public class Rotas{
  private String origem;
  private String destino;
  private String parada1;
  private String parada2;
  private String parada3;
  private DataHora saida;
  private DataHora chegada;
  public Onibus onibus;
  
  public Rotas(){
    this("","","","","",new DataHora(),new DataHora());
  }

	public Rotas(String origem, String destino, String parada1, String parada2, String parada3, DataHora saida, DataHora chegada) {
		this.origem = origem;
		this.destino = destino;
		this.parada1 = parada1;
		this.parada2 = parada2;
		this.parada3 = parada3;
		this.saida = saida;
		this.chegada = chegada;
    this.onibus=new Onibus();
	}
  public void printRota(){
    System.out.printf("Origem: %s\nDestino: %s\nParada1: %s\nParada2: %s\nParada3: %s\nSaida: ",origem,destino,parada1,parada2,parada3);
    saida.printDataHora();
    System.out.printf("Chegada: ");
    chegada.printDataHora();
  }

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public String getParada1() {
		return parada1;
	}

	public String getParada2() {
		return parada2;
	}

	public String getParada3() {
		return parada3;
	}

	public DataHora getSaida() {
		return saida;
	}

	public DataHora getChegada() {
		return chegada;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setParada1(String parada1) {
		this.parada1 = parada1;
	}

	public void setParada2(String parada2) {
		this.parada2 = parada2;
	}

	public void setParada3(String parada3) {
		this.parada3 = parada3;
	}

	public void setSaida(DataHora saida) {
		this.saida = saida;
	}

	public void setChegada(DataHora chegada) {
		this.chegada = chegada;
	}
  public void setOnibus(Onibus onibus){
    this.onibus=onibus;
  }
}