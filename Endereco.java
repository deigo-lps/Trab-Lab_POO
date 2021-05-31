public class Endereco{
  private String rua;
  private int numero;
  private String bairro;
  private String cep;
  private String cidade;
  private String estado;
  
  public Endereco(){
    this("",0,"","","","");
  }
  
  public Endereco(String rua,int numero,String bairro,String cep,String cidade,String estado){
    this.rua=rua;
    this.numero=numero;
    this.bairro=bairro;
    this.cep=cep;
    this.cidade=cidade;
    this.estado=estado;
  }
  
  public void printEndereco(){
    System.out.printf("Rua %s %d, %s. CEP:%s, %s %s\n",rua,numero,bairro,cep,cidade,estado);
  }

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}