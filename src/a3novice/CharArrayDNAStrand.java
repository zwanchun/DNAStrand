package a3novice;

public class CharArrayDNAStrand implements DNAStrand{
	
	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		
		if(base_array==null) throw new RuntimeException("Illegal");
		for (int i = 0; i < base_array.length; i++) {// test base array characters
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
		/* test if index out of range */
		if(idx<0 || idx>=this.bases.length) throw new RuntimeException("Index out of range.");
		else return this.bases[idx];
	}

	public int getLength() {
		
		return this.bases.length;
	}

	public DNAStrand extract(int start, int end) {
		
		if(start<0||start>end||end>=this.bases.length) throw new RuntimeException("Start or end out of range.");
		else{
			String str=new String(this.bases);//create a string with same characters in bases
			return new CharArrayDNAStrand(str.substring(start,end+1).toCharArray());
		}
	}

	
	public DNAStrand join(DNAStrand tail) {
		
		if (tail == null)
			throw new RuntimeException("Illegal");
		for (int i = 0; i < tail.getLength(); i++) {
			if (tail.getBaseAt(i) != 'C' && tail.getBaseAt(i) != 'G'
					&& tail.getBaseAt(i) != 'T' && tail.getBaseAt(i) != 'A') {
				throw new RuntimeException("Not a DNA Strand");
			}
		}

		char[] co_strand = new char[this.getLength()+tail.getLength()];//using array to store characters
		for (int i = 0; i < this.getLength(); i++) {//traverse the bases of tail and store characters in co_strand
			co_strand[i]=this.bases[i];
		}
		for (int i = this.getLength(); i < this.getLength()+tail.getLength(); i++) {//traverse the bases of tail and store characters in co_strand
			co_strand[i]=tail.getBaseAt(i-this.getLength());
		}
		return new CharArrayDNAStrand(co_strand);

	}

	
}
