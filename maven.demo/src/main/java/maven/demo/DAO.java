package maven.demo;

public class DAO {
	
	    private Connection conexao;

	    public DAO() {
	        conexao = null;
	    }

	    public boolean conectar() {
	        try {
	            // Configurações de conexão (pode ser carregado de um arquivo de propriedades)
	        	String driverName = "org.postgresql.Driver";
	            String url = "jdbc:postgresql://localhost:5432/teste";
	            String user = "postgresql";
	            String password = "Pitaya123@";
	            String mydatabase = "teste";
	            int porta = 5432;
	            // Carregar o driver
	            Class.forName("org.postgresql.Driver");

	            try {
	                Class.forName(driverName);
	                conexao = DriverManager.getConnection(url, username, password);
	                status = (conexao != null);
	                System.out.println("Conexão efetuada com o postgres!");
	            } catch (ClassNotFoundException e) {
	                System.err.println("Conexão NÃO efetuada com o postgres ... Driver não encontrado " + e.getMessage());
	            } catch (SQLException e) {
	                System.err.println("Conexão NÃO efetuada com o postgres ... " + e.getMessage());
	            }
	            return status;
	        }

