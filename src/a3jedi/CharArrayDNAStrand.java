package a3jedi;

public class CharArrayDNAStrand implements DNAStrand{
	
	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		
		if(base_array==null) throw new RuntimeException("Illegal");
		for (int i = 0; i < base_array.length; i++) {
			if (base_array[i] != 'C' && base_array[i] != 'G'
					&& base_array[i] != 'T' && base_array[i] != 'A')
				throw new RuntimeException("Not a DNA Strand");
		}
		if (name == null)
			this.name = "Unnamed";
		else
			this.name = name;
		this.bases = base_array;
	}
	
	public CharArrayDNAStrand(char[] base_array) {
		
		this(base_array,"Unnamed");
		
	}
	
	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
		
		if(name==null) this.name="Unnamed";
		else this.name=name;
	}

	public char getBaseAt(int idx) {
		
		if(idx<0 || idx>=this.bases.length) throw new RuntimeException("Index out of range.");
		else return this.bases[idx];
	}

	public int getLength() {
		
		return this.bases.length;
	}

	public DNAStrand extract(int start, int end) {
		
		return new ExtractedDNAStrand(this,start,end);
	
	}

	public DNAStrand join(DNAStrand tail) {
		
		return new JoinedDNAStrand(this,tail);

	}


	public int findSubstrand(DNAStrand substrand) {
		if (substrand == null)
			throw new RuntimeException("Illegal");
		StringBuffer substr=new StringBuffer();
		for(int i=0;i<substrand.getLength();i++){
			substr.append(substrand.getBaseAt(i));
		}
		String base_str=new String(this.bases);
		return base_str.indexOf(substr.toString());
		
	}

	
	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if (substrand == null)
			throw new RuntimeException("Illegal");
		if (search_start_position < 0
				|| search_start_position >= this.getLength())
			throw new RuntimeException("Search start position out of range.");
		StringBuffer substr=new StringBuffer();
		for(int i=0;i<substrand.getLength();i++){
			substr.append(substrand.getBaseAt(i));
		}
		String base_str=new String(this.bases);
		return base_str.indexOf(substr.toString(),search_start_position);
		
	}



	
}
