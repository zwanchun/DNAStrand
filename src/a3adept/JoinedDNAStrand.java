package a3adept;

public class JoinedDNAStrand implements DNAStrand{
	
	private DNAStrand head;
	private DNAStrand tail;
	private String name;
	
	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		
		if (head == null || tail == null)
			throw new RuntimeException("Illegal");
		for (int i = 0; i < head.getLength(); i++) {
			if (head.getBaseAt(i) != 'C' && head.getBaseAt(i) != 'G'
					&& head.getBaseAt(i) != 'T' && head.getBaseAt(i) != 'A') {
				throw new RuntimeException("Not a DNA Strand");
			}
		}
		for (int i = 0; i < tail.getLength(); i++) {
			if (tail.getBaseAt(i) != 'C' && tail.getBaseAt(i) != 'G'
					&& tail.getBaseAt(i) != 'T' && tail.getBaseAt(i) != 'A') {
				throw new RuntimeException("Not a DNA Strand");
			}
		}
		if (name == null)
			this.name = "Unnamed";
		else
			this.name = name;
		this.head = head;
		this.tail = tail;
	}

	
	public JoinedDNAStrand(DNAStrand head, DNAStrand tail) {
		
		this(head,tail,"Unnamed");
	}

	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
		
		if(name==null) this.name="Unnamed";
		else this.name=name;
	}

	public char getBaseAt(int idx) {

		if (idx < 0 || idx >= this.getLength())
			throw new RuntimeException("Index out of range.");
		else if (idx>=0 && idx< this.head.getLength()) {//if the character in head strand
			return this.head.getBaseAt(idx);
		} else return this.tail.getBaseAt(idx - this.head.getLength());//if the character in tail strand
	}

	public int getLength() {
	
		return this.head.getLength()+this.tail.getLength();
	}

	public DNAStrand extract(int start, int end) {
		
		
		if (start < 0 || start > end || end >= this.getLength())
			throw new RuntimeException("Start or end out of range.");
		else {
			return new ExtractedDNAStrand(this,start,end);
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
