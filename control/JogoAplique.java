package control;

import edugraf.jadix.Aplique;
import edugraf.jadix.fachada.TiposDeComponentesDix;

public class JogoAplique extends Aplique {

	@Override
	public void iniciar() {
		try {
			Main.main(null);
		} catch (Exception exception) {
			obterPaginaDix()
					.criarComponente(TiposDeComponentesDix.ETIQUETA, "colalsl")
					.fixarTexto(exception.getMessage()).fixarAltura(30)
					.fixarLargura(100).fixarTopo(20).fixarEsquerda(10);
		}
		
		obterPaginaDix()
		.criarComponente(TiposDeComponentesDix.ETIQUETA, "sscolalsl")
		.fixarTexto("Agua aa").fixarAltura(30)
		.fixarLargura(100).fixarTopo(20).fixarEsquerda(10);
	}
}