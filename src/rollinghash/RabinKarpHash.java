package rollinghash;

public class RabinKarpHash {
	
	// myn is the length in characters of the blocks you want to hash
	public RabinKarpHash(int myn) {
		n = myn;
		BtoN = 1;
	    for (int i=0; i < n ; ++i) {
		      BtoN *= B;
	    }
	}
	
	// add new character  (useful to initiate the hasher)
	// return 32 bits (not even universal)
	public int eat(char c) {
		hashvalue = B*hashvalue + hasher.hashvalues[c];
		return hashvalue;
	}
	
	// remove old character and add new one
	// return 32 bits (not even universal)
	public int update(char outchar, char inchar) {
		hashvalue = B*hashvalue +hasher.hashvalues[inchar] - BtoN * hasher.hashvalues[outchar];
		return hashvalue;
	}

	// this is purely for testing purposes
	public static int nonRollingHash(CharSequence s) {
		int value = 0;
		for(int i = 0; i<s.length();++i) {
			char c = s.charAt(i);
			int z = hasher.hashvalues[c];
			value = B*value + z;
		}
		return value;
	}
	public int hashvalue;
	int n;
	int BtoN;
	static CharacterHash hasher = CharacterHash.getInstance();
	final static int B = 31;

}
