package elementosSistema;

public class Comando {
		private EnderecoComando endereco;

		private String Id;
		private int Ordem;
		public Comando(){			
		}
		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		public int getOrdem() {
			return Ordem;
		}

		public void setOrdem(int ordem) {
			Ordem = ordem;
		}
		
		public EnderecoComando getEndereco() {
			return endereco;
		}
		public void setEndereco(EnderecoComando endereco) {
			this.endereco = endereco;
		}
		
		

}
