// documento de identidade, nome, data de nascimento, endereço e
// profissão.
public class Passageiros{
  private String documento;
  private String nome;
  private DataHora data_nascimento;
  private Endereco endereco;
  private String profissao;

	public Passageiros(String documento, String nome, DataHora data_nascimento, Endereco endereco, String profissao) {
		this.documento = documento;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.endereco = endereco;
		this.profissao = profissao;
	}
  
  public void printPassageiro(){
    System.out.printf("Nome:%s\nIdentidade:%s\nData de Nascimento: ",nome,documento);
    data_nascimento.printDataHora();
    System.out.printf("Endereco: ");
    endereco.printEndereco();
    System.out.printf("Profissao: %s\n",profissao);
  }

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public DataHora getData_nascimento() {
		return data_nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData_nascimento(DataHora data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}