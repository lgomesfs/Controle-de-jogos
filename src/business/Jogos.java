package business;

public class Jogos {
	private String name;
	private String desenvolvedora;
	private String plataforma;
	private double nota;
	
	public Jogos(String name, String desenvolvedora, String plataforma, double nota) {
		this.name = name;
		this.desenvolvedora = desenvolvedora;
		this.plataforma = plataforma;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nome: "+name+"\nDesenvolvedora: "+desenvolvedora+
				"\nPlataforma: "+plataforma+"\nNota: "+String.format("%.2f", nota);
	}
	
	
}
