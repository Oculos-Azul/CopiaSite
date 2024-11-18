package site;

import arquivo.Arquivo;

public class Principal {
	public static void main(String[] args) {
		String enderecoUrl = "https://pt.wikipedia.org/wiki/Wikip%C3%A9dia:P%C3%A1gina_principal";
		String arquivoNome = "./src/main/evidencias/copia.txt";
		Arquivo arquivo = new Arquivo(arquivoNome, enderecoUrl);

		System.out.println("Diretório de trabalho atual: " + System.getProperty("user.dir"));

		arquivo.CriarArquivo();
		arquivo.Escrever();

	}
}
