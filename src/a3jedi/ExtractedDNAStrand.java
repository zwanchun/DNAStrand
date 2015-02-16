package a3jedi;

public class ExtractedDNAStrand implements DNAStrand{
	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;
	
	public ExtractedDNAStrand(DNAStrand source_strand, int start, int end, String name) {
		/* Your code here. */
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
		/* Your code here. */
		this(source_strand,start,end,"Unnamed");
	}

	public String getName() {
		/* Your code here. */
		return this.name;
	}

	public void setName(String name) {
		/* Your code here. */
		if(name==null) this.name="Unnamed";
		else this.name=name;
	}

	public char getBaseAt(int idx) {
		/* Your code here. */
		if(idx<0||idx>=this.getLength()) throw new RuntimeException("Index out of range");
		else return this.source_strand.getBaseAt(idx+start);
	}

	public int getLength() {
		/* Your code here. */
		return this.end-this.start+1;
	}

	public DNAStrand extract(int start, int end) {
		/* Your code here. */
		return new ExtractedDNAStrand(this,start,end);
	}

	public DNAStrand join(DNAStrand tail) {
		/* Your code here. */
		if(tail==null) throw new RuntimeException("Illegal");
		StringBuffer join_strand=new StringBuffer();
		for(int i=start;i<=end;i++){//the extracted source strand
			join_strand.append(this.source_strand.getBaseAt(i));
		}
		for(int i=0;i<tail.getLength();i++){//tail strand
			join_strand.append(tail.getBaseAt(i));
		}
		return new StringDNAStrand(join_strand.toString());
	}


	public int findSubstrand(DNAStrand substrand) {
		if (substrand == null)
			throw new RuntimeException("Illegal");
		int index = -1;
		for (int i = 0; i <= (this.getLength() - substrand.getLength()); i++) {
			if (this.getBaseAt(i) == substrand.getBaseAt(0)) {
				index = i;
				for (int j = 1, k = i + 1; j < substrand.getLength(); j++, k++) {
					if (this.getBaseAt(k) != substrand.getBaseAt(j)) {
						index = -1;
						break;
					}

				}
				if (index != -1)
					return index;
			}

		}
		return index;
		
		
	}


	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		if (substrand == null)
			throw new RuntimeException("Illegal");
		if (search_start_position < 0
				|| search_start_position >= this.getLength())
			throw new RuntimeException("Search start position out of range.");
		int index=-1;
		for(int i=search_start_position;i<=(this.getLength()-substrand.getLength());i++){
			if(this.getBaseAt(i)==substrand.getBaseAt(0)){
				index=i;
				for(int j=1,k=i+1;j<substrand.getLength();j++,k++){
					if(this.getBaseAt(k)!=substrand.getBaseAt(j)){
						index=-1;
						break;
					}
					
				}
				if(index!=-1) return index;
			}
			
		}
		return index;
				
		
	}


	

}
