package arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Classe para fazer a criação e escrita do contéudo html do site desejado
 */
public class Arquivo {
	private String nome;
	private String url;

	/**
	 * Construtor da class Arquivo aonde se passa o nome e url, serão necessãrios
	 * para criar o arquivo e pegar o contéudo html do site
	 * 
	 * @param nome Nome na verdade é o tanto o caminho quanto o nome do arquivo
	 * @param url  É o a url do site que se deseja o contéudo
	 */
	public Arquivo(String nome, String url) {
		this.nome = nome;
		this.url = url;
	}

	/**
	 * Cria o arquivo com base no caminho e nome dentro da variável nome, também
	 * trata as exceções necessárias
	 * 
	 * @return retorna true para o arquivo criado e false caso o arquivo já exista
	 *         ou dê IOException
	 */
	public boolean CriarArquivo() {
		File arquivoNovo = new File(nome);

		try {
			if (arquivoNovo.createNewFile()) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Escreve no arquivo com o endereço guardado na variável nome o contéudo que é
	 * lido no site com o endereço na variável url
	 * 
	 * @return Retorna true se a leitura e escrita forem concluídas e false para
	 *         exceptions do tipo: MalformedURLException, URISyntaxException e
	 *         IOException
	 */
	public boolean Escrever() {
		try {
			URI endereco = new URI(url);

			BufferedReader ler = new BufferedReader(new InputStreamReader(endereco.toURL().openStream()));

			BufferedWriter escrever = new BufferedWriter(new FileWriter(nome));
			String line;
			while ((line = ler.readLine()) != null) {
				escrever.write(line);
				escrever.newLine();
			}

			ler.close();
			escrever.close();
			return true;
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
