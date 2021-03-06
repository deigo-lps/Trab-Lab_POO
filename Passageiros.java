// documento de identidade, nome, data de nascimento, endereço e
// profissão.
public class Passageiros{
  private String documento;
  private String nome;
  private DataHora data_nascimento;
  private Endereco endereco;
  private String profissao;
  private String login;
  private String senha;
  private int linha;
  private int coluna;
  public Rotas rota;
  
  public Passageiros(){
    this("","",new DataHora(),new Endereco(),"","","");
  }

  public Passageiros(String documento, String nome, DataHora data_nascimento, Endereco endereco, String profissao,String login,String senha) {
    this.documento = documento;
    this.nome = nome;
    this.data_nascimento = data_nascimento;
    this.endereco = endereco;
    this.profissao = profissao;
    this.rota=new Rotas();
    this.login=login;
    this.senha=senha;
  }
  
  public boolean validaLogin(String senha){
    if(this.senha.equals(senha))
      return true;
    else
      return false;
  }
  
  public void printPassageiro(){
    System.out.printf("Nome:%s\nIdentidade:%s\nData de Nascimento: ",nome,documento);
    data_nascimento.printDataHora();
    System.out.printf("Endereco: ");
    endereco.printEndereco();
    System.out.printf("Profissao: %s\n",profissao);
  }
  public int getLinha(){
    return linha;
  }
  
  public int getColuna(){
    return coluna;
  }
  
  public String getLogin(){
    return login;
  }
  public String getSenha(){
    return senha;
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
  
  public void setLinha(int linha){
    this.linha=linha;
  }
  
  public void setColuna(int coluna){
    this.coluna=coluna;
  }
  
  public void setLinhaColuna(int linha,int coluna){
    setLinha(linha);
    setColuna(coluna);
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
  public void setRota(Rotas rota){
    this.rota=rota;
  }
}