package maven.demo;

public class Usuario {
	public class usuario {
	    private int codigo;
	    private String login;
	    private String senha;
	    private char sexo;

	    public Usuario() {
	        this.codigo = -1;
	        this.login = "";
	        this.senha = "";
	        this.sexo = '*'; // Assumindo que ' ' representa um valor não definido
	    }

	    public Usuario(int codigo, String login, String senha, char sexo) {
	        // Adicionar validação aqui para verificar os parâmetros
	        this.codigo = codigo;
	        this.login = login;
	        // Criptografar a senha antes de armazená-la
	        this.senha = criptografarSenha(senha);
	        this.sexo = sexo;
	    }

	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	         this.login = codigo;
	    }
	    
	    public int getLogin() {
	        return Login;
	    }

	    public void setLogin(String Login) {
	         this.login = Login;
	    }
	    
	    public int getSenha() {
	        return Senha;
	    }
	    
	    public void setSenha(String Senha) {
	         this.login = Senha;
	    }

	    public int getSexo() {
	        return Sexo;
	    }
	    
	    public void setSexo(char sexo) {
	         this.login = Sexo;
	    }
	    public String toString () {
	    	return "Usuario" [codigo=" + codigo +"login=" + login +", senha=" + senha +", sexo=" + sexo +"]";"
	    }
	    
	    
	    
	    
	}
}
