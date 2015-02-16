package a3novice;

public class StringDNAStrand implements DNAStrand{
	
	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {

		if (base_string == null)
			throw new RuntimeException("Illegal");
		for (int i = 0; i < base_string.length(); i++) {// test base string
														// characters
			if (base_string.charAt(i) != 'C' && base_string.charAt(i) != 'G'
					&& base_string.charAt(i) != 'T'
					&& base_string.charAt(i) != 'A') {
				throw new RuntimeException("Not a DNA Strand");
			}
		}
		if (name == null)
			this.name = "Unnamed";
		else
			this.name = name;
		this.bases = base_string;

	}

	
	public StringDNAStrand(String strand_string) {

		this(strand_string, "Unnamed");
	}
	
	
	public String getName() {

		return this.name;
	}

	
	public void setName(String name) {

		if (name == null)//test if name==null
			this.name = "Unnamed";
		else
			this.name = name;
	}

	
	public char getBaseAt(int idx) {

		if (idx < 0 || idx >= this.bases.length())//test if index out of range
			throw new RuntimeException("Index out of range.");
		return this.bases.charAt(idx);
	}

	
	public int getLength() {
		return this.bases.length();
	}

	
	public DNAStrand extract(int start, int end) {

		if (start < 0 || start > end || end >= this.bases.length())
			throw new RuntimeException("Start or end out of range.");
		return new StringDNAStrand(this.bases.substring(start, end + 1));//including the end point

	}

	
	public DNAStrand join(DNAStrand tail) {
		
		if (tail == null)
			throw new RuntimeException("Illegal");
		for (int i = 0; i < tail.getLength(); i++) {//test bases characters
			if (tail.getBaseAt(i) != 'C' && tail.getBaseAt(i) != 'G'
					&& tail.getBaseAt(i) != 'T' && tail.getBaseAt(i) != 'A') {
				throw new RuntimeException("Not a DNA Strand");
			}
		}

		StringBuffer co_strand = new StringBuffer(this.bases);//using stringbuffer to store characters
		for (int i = 0; i < tail.getLength(); i++) {//traverse the bases of tail and store characters in co_strand
			co_strand.append(tail.getBaseAt(i));
			
		}
		return new StringDNAStrand(co_strand.toString());

	}

	

}
