package a3jedi;

public class JoinedDNAStrand implements DNAStrand{
	
	private DNAStrand head;
	private DNAStrand tail;
	private String name;
	
	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		/* Your code here. */
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
		/* Your code here. */
		this(head,tail,"Unnamed");
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

		if (idx < 0 || idx >= this.getLength())
			throw new RuntimeException("Index out of range.");
		else if (idx < this.head.getLength()) {//if the character in head strand
			return this.head.getBaseAt(idx);
		} else
			return this.tail.getBaseAt(idx - this.head.getLength());//if the character in tail strand
	}

	public int getLength() {
		/* Your code here. */
		return this.head.getLength()+this.tail.getLength();
	}

	public DNAStrand extract(int start, int end) {
		/* Your code here. */
		StringBuffer extract_str=new StringBuffer();
		if (start < 0 || start > end || end >= this.getLength())
			throw new RuntimeException("Start or end out of range.");
		else{
			for(int i=start;i<=end;i++){
				extract_str.append(this.getBaseAt(i));
			}
		}
	
//		else if(start<this.head.getLength()&&end<this.head.getLength()){//start and end both in head
//			for(int i=start;i<=end;i++){
//				extract_str.append(this.head.getBaseAt(i));
//			}
//		}
//		else if(start>=this.head.getLength()){//start and end both in tail
//			for(int i=start;i<=end;i++){
//				extract_str.append(this.tail.getBaseAt(i-this.head.getLength()));
//			}
//			
//		}
//		else{//start in head and end in tail
//			for(int i=start;i<this.head.getLength();i++){
//				extract_str.append(this.head.getBaseAt(i));
//			}
//			for(int i=this.head.getLength();i<=end;i++){
//				extract_str.append(this.tail.getBaseAt(i-this.head.getLength()));
//			}
//		}
		return new StringDNAStrand(extract_str.toString());
		
	}

	public DNAStrand join(DNAStrand tail) {
		/* Your code here. */
		return new JoinedDNAStrand(this,tail);
	}



	public int findSubstrand(DNAStrand substrand) {
		if (substrand == null)
			throw new RuntimeException("Illegal");
		int index=-1;
		for(int i=0;i<=(this.getLength()-substrand.getLength());i++){
			if(this.getBaseAt(i)==substrand.getBaseAt(0)){
				index=i;
				for(int j=1,k=i+1;j<substrand.getLength();j++,k++){//traverse the substrand and corresponding characters in source
					if(this.getBaseAt(k)!=substrand.getBaseAt(j)){
						index=-1;
						break;
					}
					
				}
				if(index!=-1) return index;//find the first index and return
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
		for(int i=search_start_position;i<=(this.getLength()-substrand.getLength());i++){//traverse from the start position
			if(this.getBaseAt(i)==substrand.getBaseAt(0)){
				index=i;
				for(int j=1,k=i+1;j<substrand.getLength();j++,k++){
					
					if(this.getBaseAt(k)!=substrand.getBaseAt(j)){
						index=-1;
						break;
					}
					
				}
				if(index!=-1) return index;//find the first index and return
			}
			
		}
		return index;
				
		
	}






}
