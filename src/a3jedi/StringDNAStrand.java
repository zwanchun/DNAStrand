package a3jedi;

public class StringDNAStrand implements DNAStrand{
	
	private String bases;
	private String name;
	
	public StringDNAStrand(String base_string, String name) {	
		
		if(base_string==null) throw new RuntimeException("Illegal");
		for (int i = 0; i < base_string.length(); i++) {
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
		
		this(strand_string,"Unnamed");
	}
	
	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
		
		if(name==null) this.name="Unnamed";
		else this.name=name;
	}

	public char getBaseAt(int idx) {
		
		if (idx < 0 || idx >= this.bases.length())
			throw new RuntimeException("Index out of range.");
		return this.bases.charAt(idx);
	}

	public int getLength() {
		
		return this.bases.length();
	}

	public DNAStrand extract(int start, int end) {
		
		return new ExtractedDNAStrand(this,start,end);
//		

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
		return this.bases.indexOf(substr.toString());
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
		return this.bases.indexOf(substr.toString(),search_start_position);
	}

	

}
