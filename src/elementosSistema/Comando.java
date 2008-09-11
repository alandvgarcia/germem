package elementosSistema;

public class Comando {
		private EnderecoComando endereco = new EnderecoComando();
		private String Id;
		private Boolean jaLido;
		
	
		
		public static Comando comandoNulo(){
			Comando comando = new Comando();
			comando.Id="Nulo";
			comando.jaLido = true;
			comando.endereco.idPagina = "-1";
			comando.endereco.idProcedimento = "-1";
			comando.endereco.ordem = "-1";	
			return comando;
		}
		public Comando(){		
			this.jaLido = false;
		}
		
		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		
		public EnderecoComando getEndereco() {
			return endereco;
		}
		public void setEndereco(EnderecoComando endereco) {
			this.endereco = endereco;
		}
		
		public Boolean getJaLido() {
			return jaLido;
		}

		public void setJaLido(Boolean jaLido) {
			this.jaLido = jaLido;
		}	

}
