package a3adept;

public class Test {

	public static void main(String[] args) {
		StringDNAStrand str1=new StringDNAStrand("CGTA","red");
		StringDNAStrand str2=new StringDNAStrand("CCGGTTAA");
		JoinedDNAStrand str3=new JoinedDNAStrand(str1,str2);
		JoinedDNAStrand str4=new JoinedDNAStrand(str1,str2);
		DNAStrand str5=str3.join(str4);
		System.out.println(str5.getName());
		for(int i=0;i<24;i++){
			System.out.println(str5.getBaseAt(i));
		}
		
		DNAStrand str6=new ExtractedDNAStrand(str2,2,6);
		System.out.println("str6");
		DNAStrand str7=str6.extract(3, 4);
		
		for(int i=0;i<str6.getLength();i++){
			System.out.println(str6.getBaseAt(i));
		}
//		DNAStrand str7=str6.join(str2);
//		DNAStrand str8=new ExtractedDNAStrand(str7,4,9);
//		System.out.println(str6.getLength());
//		System.out.println("str7:");
//		for(int i=0;i<str8.getLength();i++){
//			System.out.println(str8.getBaseAt(i));
//		}
//		
		
//		System.out.println(str1.getName());
//		System.out.println(str2.getName());
//		DNAStrand str3=str2.extract(2, 6);
//		for(int i=0;i<str3.getLength();i++){
//			System.out.println(str3.getBaseAt(i));
//		}
//		str1.setName(null);
//		System.out.println(str1.getName());
//		DNAStrand str4=str2.join(str1);
//		System.out.println(str4.getName());
//		System.out.println(str4.getLength());
//		DNAStrand str5=str4.extract(2,10);
//		System.out.println(str5.getLength());
//		
//		char[] arr={'C','T','G','A'};
//		DNAStrand str6=new CharArrayDNAStrand(arr,"red");
//		DNAStrand str7=new CharArrayDNAStrand(arr);
//		System.out.println(str6.getName());
//		System.out.println(str7.getName());
//		DNAStrand str8=str7.extract(2, 3);
//		for(int i=0;i<str8.getLength();i++){
//			System.out.println(str8.getBaseAt(i));
//		}
//		DNAStrand str9=str7.join(str6);
//		System.out.println(str9.getLength());
//		DNAStrand str10=new JoinedDNAStrand(str1,str2,"red");
//		System.out.println(str10.getLength());
//		System.out.println(str10.getName());
//		for(int i=0;i<str10.getLength();i++){
//			System.out.println(str10.getBaseAt(i));
//		}
//		DNAStrand str11=new ExtractedDNAStrand(str10,3,10);
//		System.out.println(str11.getLength());
		
		
		
		
		
//		char[] arr={'C','G','T','A'};
//		DNAStrand str1=new StringDNAStrand("CGTAAAT");
//		DNAStrand str12=new StringDNAStrand("CTGGA","red");
//		DNAStrand str13=new JoinedDNAStrand(str12,str1,"green");
//		System.out.println(str13.getLength());
//		DNAStrand str2=new CharArrayDNAStrand(arr);
//		DNAStrand str3=new JoinedDNAStrand(str1,str2);
//		System.out.println(str3.getLength());
//		System.out.println(str3.getBaseAt(10));
//		for(int i=0;i<str3.getLength();i++){
//			System.out.println(str3.getBaseAt(i));
//		}
//		System.out.println();
//		DNAStrand str4=str3.extract(1, 3);
//		for(int i=0;i<str4.getLength();i++){
//			System.out.println(str4.getBaseAt(i));
//		}
//		DNAStrand str5=str3.extract(7, 9);
//		for(int i=0;i<str5.getLength();i++){
//			System.out.println(str5.getBaseAt(i));
//		}
//		System.out.println();
//		DNAStrand str6=str3.extract(2, 10);
//		for(int i=0;i<str6.getLength();i++){
//			System.out.println(str6.getBaseAt(i));
//		}
//		DNAStrand str7=str1.join(str1);
//		
//		System.out.println("Joined test over");
//		
//		DNAStrand str8=new ExtractedDNAStrand(str1,1,5);
//		DNAStrand str11=str8.join(new StringDNAStrand("CTGA"));
//		for(int i=0;i<str11.getLength();i++){
//			System.out.println(str11.getBaseAt(i));
//		}
//		DNAStrand str10=new ExtractedDNAStrand(str8,0,2);
//		System.out.println(str10.getLength());
//		System.out.println(str8.getLength());
//		System.out.println(str8.getBaseAt(0));
//		DNAStrand str9=str8.extract(2,3);
//		for(int i=0;i<str9.getLength();i++){
//			System.out.println(str9.getBaseAt(i));
//		}
		
		

	}

}
