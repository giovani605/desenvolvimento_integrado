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
	public static int numeroDias = 5;

	public static void main(String[] args) {

		File f = new File("dados.sql");
		try {
			PrintWriter printWriter = new PrintWriter(f);
			printWriter.write("\n");
			Random rand = new Random();
			for (int a = 1; a < numProdutos; a++) {

				byte[] by = new byte[10];
				rand.nextBytes(by);
				printWriter.println(criarProduto(getProdutoAletorio(), rand.nextInt(1000)));
			}
			int cont = 0;
			for (int a = 1; a < numClientes; a++) {

				byte[] by = new byte[10];
				rand.nextBytes(by);
				printWriter.println(criarCliente(getNomeAletorio()));
				Date date = new Date();
				for (int dias = 0; dias < numeroDias; dias++) {
					for (int b = 1; b < numPedidos; b++) {
						printWriter.println(criarPedido(a, date));
						cont++;
					}
					date.setDate(date.getDate() - 1);
				}
			}

			for (int c = 1; c < cont; c++)
				for (int d = 1; d < 10; d++)
					printWriter.println(criarPedidoDetalhe(c, d, 1, rand.nextInt(20000)));

			printWriter.flush();
			printWriter.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String criarPedidoDetalhe(int idPedido, int idProduto, int qtd, int preco) {
		if (idProduto == 0)
			idProduto = 1;
		String a = "INSERT  INTO pedidodetalhe  (NroPedido,ProdutoID,Quantidade,preco)" + " VALUES  (" + idPedido + ","
				+ idProduto + "," + qtd + "," + preco + ") ; ";
		return a;
	}

	public static String criarPedido(int idCliente, Date date) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String a = "INSERT INTO pedido  (clienteid ,data_pedido) " + "VALUES (" + idCliente + ", '" + dt.format(date)
				+ "'); \n";
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

	public static String criarProduto(String nome, int valor) {
		String a = "INSERT INTO Produto (descricao,preco) VALUES ('" + nome + "'," + valor + "); \n";
		return a;
	}

}
