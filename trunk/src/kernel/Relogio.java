package kernel;

import interface_pack.Interface_User;

public class Relogio{

	private int ciclos = 0;
	private Interface_User  interfaceUser;
	
	/**
	 * Construtor da classe Relogio
	 * 
	 * @param execucao - objeto InterfaceExecucao (@see {uel.so.ui#InterfaceExecucao}).
	 */
	public Relogio(Interface_User int_user){
		this.interfaceUser= int_user;
	}
	
	/**
	 * Conta um ciclo de execução
	 */
	public void tick()
	{
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		finally
		{
			ciclos++;
			//interfaceUser.getRelogio().setText(String.valueOf(ciclos));
		}
	}
	
	/**
	 * Retorna os ciclos contados pelo Relógio
	 */
	public String toString()
	{
		return String.format("%d",ciclos);
	}
}
