// número da CNH, data de admissão (tempo de trabalho na empresa) e
// nome.
public class Motorista{
  private String CNH;
  private DataHora data_admissao;
  private String nome;
  
  public Motorista(){
    this("",new DataHora(),"");
  }

	public Motorista(String CNH, DataHora data_admissao, String nome) {
		this.CNH = CNH;
		this.data_admissao = data_admissao;
		this.nome = nome;
	}
  public void printMotorista(){
    System.out.printf("Nome: %s\nCNH: %s\nData de Admissao: ",nome,CNH);
    data_admissao.printDataHora();
  }

	public String getCNH() {
		return CNH;
	}

	public DataHora getData_admissao() {
		return data_admissao;
	}

	public String getNome() {
		return nome;
	}

	public void setCNH(String CNH) {
		this.CNH = CNH;
	}

	public void setData_admissao(DataHora data_admissao) {
		this.data_admissao = data_admissao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
  
  public void setMotorista(String CNH,DataHora data_admissao,String nome){
    setNome(nome);
    setCNH(CNH);
    setData_admissao(data_admissao);
  }
}