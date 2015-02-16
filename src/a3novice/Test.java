package a3novice;

public class Test {

	public static void main(String[] args) {
//		StringDNAStrand str1=new StringDNAStrand("CTGAD");//test other characters
//		System.out.println(str1.getLength());
		
		StringDNAStrand str1=new StringDNAStrand("CTGAAAAGTAAA",null);
		System.out.println(str1.getName());
		str1.setName("xx");
		System.out.println(str1.getName());
		str1.setName(null);
		System.out.println(str1.getName());
		str1=new StringDNAStrand("CTGAAAAGTAAA");
		System.out.println(str1.getName());
		
		System.out.println(str1.getBaseAt(0));
//		System.out.println(str1.getBaseAt(-1));//out of range
		System.out.println(str1.getBaseAt(11));
//		System.out.println(str1.getBaseAt(12));//out of range
		System.out.println(str1.getLength());
		
//		DNAStrand str2=str1.extract(-1, 0);
//		DNAStrand str2=str1.extract(3, 0);
//		DNAStrand str2=str1.extract(3, 12);
		DNAStrand str2=str1.extract(3, 6);
		
//		DNAStrand str3=str2.join(null);
//		DNAStrand str3=str2.join(new StringDNAStrand("cvdbf"));
		DNAStrand str3=str2.join(new StringDNAStrand("CTGA"));
		System.out.println(str3.getLength());
 		System.out.println("String Test Ends");
		
		
 		char[] arr1={'C','T','G','A','D'};
 		char[] arr2={'C','T','G','A','A','A','A','G','T','A','A','A'};
//		CharArrayDNAStrand str4=new CharArrayDNAStrand(arr1);//test other characters
//		System.out.println(str4.getLength());
 		CharArrayDNAStrand str4=new CharArrayDNAStrand(arr2,null);
 		System.out.println(str4.getName());
		str4.setName("xx");
		System.out.println(str4.getName());
		str4.setName(null);
		System.out.println(str4.getName());
		str4=new CharArrayDNAStrand(arr2);
		System.out.println(str4.getName());
		
		System.out.println(str4.getBaseAt(0));
//	    System.out.println(str4.getBaseAt(-1));//out of range
		System.out.println(str4.getBaseAt(11));
//		System.out.println(str4.getBaseAt(12));//out of range
		System.out.println(str4.getLength());
		
//		DNAStrand str5=str4.extract(-1, 0);
//		DNAStrand str5=str4.extract(3, 0);
//		DNAStrand str5=str4.extract(3, 12);
		DNAStrand str5=str4.extract(3, 6);
		
//		DNAStrand str6=str5.join(null);
//		DNAStrand str6=str5.join(new StringDNAStrand("cvdbf"));
//		DNAStrand str6=str5.join(new StringDNAStrand("CGTA"));
		DNAStrand str6=str5.join(new CharArrayDNAStrand(arr2));
		System.out.println(str6.getName());
		
		
		
 	
		
		

	}

}
