package rollinghash;

import java.util.Random;

public class Unit {
	public static boolean testCyclic(String s, int n) {
		System.out.println("Testing cyclic n = "+n);
		CyclicHash ch = new CyclicHash(n);
		int k = 0;
		if(n>=s.length()) return false;
		for(; k<n-1;++k) {
			ch.eat(s.charAt(k));
		}
		int rollinghash = ch.eat(s.charAt(k));
		++k;
		int longhash = CyclicHash.nonRollingHash(s.subSequence(k-n,k));
		
		if(rollinghash != longhash) {
			System.out.println("test failed! "+rollinghash+ " "+longhash);
			return false;
		} 
		for(;k<s.length();++k) {
			rollinghash = ch.update(s.charAt(k-n), s.charAt(k));
			longhash = CyclicHash.nonRollingHash(s.subSequence(k-n+1,k+1));
			if(rollinghash != longhash) {
				System.out.println("test failed! "+k+" "+rollinghash+ " "+longhash);
				return false;
			}
		}
		System.out.println("Ok!");
		return true;
	}
	public static boolean testRabinKarp(String s, int n) {
		System.out.println("Testing RabinKarpHash n = "+n);
		RabinKarpHash ch = new RabinKarpHash(n);
		int k = 0;
		if(n>=s.length()) return false;
		for(; k<n-1;++k) {
			ch.eat(s.charAt(k));
		}
		int rollinghash = ch.eat(s.charAt(k));
		++k;
		int longhash = RabinKarpHash.nonRollingHash(s.subSequence(k-n,k));
		
		if(rollinghash != longhash) {
			System.out.println("test failed! "+rollinghash+ " "+longhash);
			return false;
		} 
		for(;k<s.length();++k) {
			rollinghash = ch.update(s.charAt(k-n), s.charAt(k));
			longhash = RabinKarpHash.nonRollingHash(s.subSequence(k-n+1,k+1));
			if(rollinghash != longhash) {
				System.out.println("test failed! "+k+" "+rollinghash+ " "+longhash);
				return false;
			}
		}
		System.out.println("Ok!");
		return true;
	}
	
	public static void main(String[] s) {
		boolean ok = true;
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		for(int k = 0; k<1000000; ++k)
			sb.append((char)r.nextInt());
		String tests = sb.toString();
		for(int n = 1;n<10;++n)
 		  if(!testCyclic(tests,n)) ok=false;
		for(int n = 1;n<10;++n)
		  if(!testRabinKarp(tests,n)) ok = false;
		if(!ok) System.out.println("The code did not pass the unit tests.");
		else System.out.println("The code is probably ok.");
	}

}
