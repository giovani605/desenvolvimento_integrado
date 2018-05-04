package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GeradorSql {
	public static int numClientes = 10;
	public static int numProdutos = 10;
	public static int numPedidos = 5;

	public static void main(String[] args) {

		File f = new File("dados.sql");
		try {
			PrintWriter printWriter = new PrintWriter(f);
			printWriter.write("\n");
			
			for (int a = 0; a < numProdutos ; a++) {
				Random rand = new Random();
				byte[] by = new byte[10];
				rand.nextBytes(by);
				printWriter.println(criarProduto(getProdutoAletorio(), rand.nextInt(1000)));
			}
			for (int a = 0; a < numClientes; a++) {
				Random rand = new Random();
				byte[] by = new byte[10];
				rand.nextBytes(by);
				printWriter.println(criarCliente(getNomeAletorio()));
				for (int b = 1; b < numPedidos ; b++) {
					printWriter.println(criarPedido(a));
					printWriter.println(criarPedidoDetalhe(a,rand.nextInt(numProdutos+1),1,rand.nextInt(20000)));
					
				}
			}
			
			
			
			
			printWriter.flush();
			printWriter.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String criarPedidoDetalhe(int idPedido,int idProduto,int qtd,int preco) {
		String a = "INSERT  INTO pedidodetalhe  (NroPedido,ProdutoID,Quantidade,preco)"
				+ " VALUES  ("+idPedido+","+idProduto+","+qtd+","+preco+")"; 
		return a;
	}
	
	
	public static String criarPedido(int idCliente) {
		Date data =  new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String a = "INSERT INTO pedido  (clienteid ,data_pedido) "
				+ "VALUES ("+idCliente+", '"+dt.format(data)+"'); \n"; 
		return a;
	}

	public static String getNomeAletorio() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Giovani");
		lista.add("Priscila");
		lista.add("Andre");
		lista.add("Ana");
		lista.add("Bruno");
		lista.add("Pessoa");

		Random rand = new Random();

		return lista.get(rand.nextInt(lista.size()));
	}

	public static String criarCliente(String nome) {
		String a = "INSERT INTO cliente (nome) VALUES ('" + nome + "'); \n";
		return a;
	}
	
	public static String getProdutoAletorio() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Notebook");
		lista.add("PC");
		lista.add("Smartphone");

		Random rand = new Random();

		return lista.get(rand.nextInt(lista.size()));
	}

	public static String criarProduto(String nome,int valor) {
		String a = "INSERT INTO Produto (descricao,preco) VALUES ('"+nome+"',"+valor+"); \n";
		return a;
	}
	
	
	

}
