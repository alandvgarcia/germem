package misc;


/* Importando alguns pacotes necessarios */
import java.util.BitSet;
import java.util.Arrays;


public class Bits{
	
	private static final int lengthBitSet = 8;
	

	public static int bitSetToInt(BitSet bits) {
		
		    int size = bits.length();
		    if (bits == null) return 0;
		    if (bits.isEmpty()) return 0;
		 
		 	if (size <= 0) throw new IllegalArgumentException("\"size\" nao pode ser menor ou igual a zero.");
		 	 	        
		 	char[] binary = new char[size];
		 	Arrays.fill(binary, '0');
		 		 	        
		 	for (int i = 0, nbit = (size - 1); i < size; i++, nbit--)
		 		if (bits.get(nbit))	binary[i] = '1';
  	 	    return Integer.parseInt( new String(binary), 2);
  }
	
  public static void printBitSet(BitSet b) {
    
		    String bbits = new String();
		    for(int j = b.length()- 1; j >= 0 ; j--)
		      bbits += (b.get(j) ? "1" : "0");
		    System.out.println("bits: "+ bbits );
		    
  }
  
  public static String bitSetToString(BitSet b, int numBits ) {
	    
	    String bbits = new String();
	    
	    if( b.length() - 1 < numBits ){
	    	return bbits.concat("0000");
	    }
	    else{
	    	//int _lengthBitSet = (lengthBitSet == 0) ? 1 : lengthBitSet; 
	    	int j = lengthBitSet - 1;
	    	while( j > lengthBitSet - (numBits+1) && j >= 0  ){
	    		bbits += (b.get(j) ? "1" : "0");
	    		j--;
	    	}
	    }
	    		
	    //	for(int j = _lengthBitSet - 1; j > _lengthBitSet - (numBits+1) ; )
	  	      
	    return bbits;
	    
  }
  
  /**
   * Método de conversão de valores inteiros em binários ( BitSet ).
   * @param value O valor inteiro a ser convertido para binario. 
   * @return Um objeto da classe BitSet (o valor em binário). 
   */
  public static BitSet intToBitSet( int value ) {
	 	   char[] binary = Integer.toBinaryString(value).toCharArray();
	 	   
	 	   BitSet bits = new BitSet(binary.length);
	 	
	 	   for (int i = binary.length - 1, nbit = 0; i >= 0; i--, nbit++)
	 	          if (binary[i] == '1') bits.set( nbit );

	 	   return bits;
  }
  
}
  
