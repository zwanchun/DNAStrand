package a3jedi;

public class Test {

	public static void main(String[] args) {
		
	
	
		char[] arr={'C','G','T','A'};	
		DNAStrand str2=new CharArrayDNAStrand(arr);
		DNAStrand str1=new StringDNAStrand("CGTCGTCGTCGTCGT");
		int index=str1.findSubstrand(str2);
		System.out.println(index);
		index=str1.findSubstrand(str2,3);
		System.out.println(index);
		
		DNAStrand str3=new JoinedDNAStrand(str1,str2);
		index=str3.findSubstrand(new StringDNAStrand("GTAC"));
		System.out.println(index);
		index=str3.findSubstrand(new StringDNAStrand("AAACGT"),6);
		System.out.println(index);
		
		DNAStrand str4=new ExtractedDNAStrand(str1,1,5);
		index=str4.findSubstrand(new StringDNAStrand("CGTA"));
		System.out.println(index);
		
//		DNAStrand str3=new JoinedDNAStrand(str1,str2);
//		System.out.println(str3.getLength());
//		for(int i=0;i<str3.getLength();i++){
//			System.out.println(str3.getBaseAt(i));
//		}
//		DNAStrand str4=str3.extract(1, 3);
//		DNAStrand str5=str3.extract(7, 9);
//		DNAStrand str6=str3.extract(2, 10);
//		DNAStrand str7=str1.join(str1);
//		
//		System.out.println("Joined test over");
//		
//		DNAStrand str8=new ExtractedDNAStrand(str1,2,5);
//		System.out.println(str8.getLength());
//		System.out.println(str8.getBaseAt(4));
//		DNAStrand str9=str1.extract(2,5);
//		for(int i=0;i<str9.getLength();i++){
//			System.out.println(str9.getBaseAt(i));
//		}
		
		

	}

}
