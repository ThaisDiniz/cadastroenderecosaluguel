package vo;

/**
 * 
 * @author thata
 *
 */

public class ConsumerCredentials {
	
	private String chave;
	private String valor;
	
		
	/**
	 * @param chave
	 * @param valor
	 */
	public ConsumerCredentials(String chave, String valor) {
		super();
		this.chave = chave;
		this.valor = valor;
	}
	/**
	 * @return the chave
	 */
	public String getChave() {
		return chave;
	}
	/**
	 * @param chave the chave to set
	 */
	public void setChave(String chave) {
		this.chave = chave;
	}
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
