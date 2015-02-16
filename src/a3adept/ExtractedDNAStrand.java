package a3adept;

public class ExtractedDNAStrand implements DNAStrand{
	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;
	
	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end, String name) {
	
		if (source_strand == null)
			throw new RuntimeException("Illegal");
		for (int i = 0; i < source_strand.getLength(); i++) {
			if (source_strand.getBaseAt(i) != 'C' && source_strand.getBaseAt(i) != 'G'
					&& source_strand.getBaseAt(i) != 'T' && source_strand.getBaseAt(i) != 'A') {
				throw new RuntimeException("Not a DNA Strand");
			}
		}
		if (start < 0 || start > end || end >= source_strand.getLength())
			throw new RuntimeException("Start or end out or range.");
		if (name == null)
			this.name = "Unnamed";
		else
			this.name = name;
		this.source_strand=source_strand;
		this.start=start;
		this.end=end;
	}

	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end) {
	
		this(source_strand,start,end,"Unnamed");
	}

	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
	
		if(name==null) this.name="Unnamed";
		else this.name=name;
	}

	public char getBaseAt(int idx) {
	
		if(idx<0||idx>=this.getLength()) throw new RuntimeException("Index out of range");
		else return this.source_strand.getBaseAt(idx+start);
	}

	public int getLength() {
		
		return this.end-this.start+1;
	}

	public DNAStrand extract(int start, int end) {

		if (start < 0 || start > end || end >= getLength())
			throw new RuntimeException("Illegal");
		else {
			return new ExtractedDNAStrand(this, start, end);
		}
	}

	public DNAStrand join(DNAStrand tail) {

		if (tail == null)
			throw new RuntimeException("Illegal");
		else {
			return new JoinedDNAStrand(this,tail);
		}
	}


	

}
