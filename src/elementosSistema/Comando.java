package elementosSistema;

public class Comando {
		private EnderecoComando endereco = new EnderecoComando();
		private String Id;
		public Comando(){			
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

}
