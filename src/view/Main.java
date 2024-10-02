package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import business.Jogos;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o nome do arquivo com a extensão ou o caminho com o nome: ");
		String arquivo = sc.nextLine();

		File file = new File(arquivo);

		verificar(file);

		int op = 0;

		while (op != 4) {

			System.out.println("Digite a opção que deseja realizar:");
			System.out.println("1-Escrever;");
			System.out.println("2-Ler;");
			System.out.println("3-Deletar;");
			System.out.println("4-Sair.");

			op = sc.nextInt();

			sc.nextLine();

			switch (op) {

			case 1:

				escrever(file);

				break;

			case 2:
								
				ler(file);

				break;

			case 3:

				System.out.println("Excluindo o arquivo...");
				file.delete();

				break;

			default:

				System.out.println("Opção inexistente...");

				break;

			}
		}
		sc.close();

	}

	static void verificar(File file) {

		if (file.exists()) {

			System.out.println("O arquivo existe.");
		} else {
			try {

				System.out.println("O arquivo não existe.");
				System.out.println("Criando o arquivo...");

				file.createNewFile();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	static void escrever(File file) {

		Scanner sc = new Scanner(System.in);

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			Jogos jogo;

			System.out.print("Digite o nome do jogo: ");
			String nome = sc.nextLine();
			System.out.print("Digite a distribuidora do jogo: ");
			String distribuidora = sc.nextLine();
			System.out.print("Digite a plataforma que jogou: ");
			String plataforma = sc.nextLine();
			System.out.print("Digite a sua nota do jogo: ");
			double nota = sc.nextDouble();
			sc.nextLine();

			jogo = new Jogos(nome, distribuidora, plataforma, nota);
			writer.write(jogo.toString() + "\n\n");
			writer.flush();
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		sc.close();
	}

	static void ler(File file) {

		try {

			FileReader reader = new FileReader(file);

			int dado = 0;

			while (dado != -1) {

				dado = reader.read();
				System.out.print((char) dado);

			}

			reader.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
