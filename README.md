## Rolling hash functions in Java
Daniel Lemire

License: Apache 2.0

## What is this?

This is a set of Java classes implementing various recursive n-gram hashing techniques, also called rolling hashing (http://en.wikipedia.org/wiki/Rolling_hash), including:

* Randomized Karp-Rabin (sometimes called Rabin-Karp)
* Hashing by Cyclic Polynomials (also known as Buzhash)


## Code sample

```
String s = "some string";
int n = 3; //hash all sequences of 3 characters
CyclicHash ch = new CyclicHash(n);
int k = 0;
for(; k<n;++k) {
  ch.eat(s.charAt(k));
}
int rollinghash = ch.eat(s.charAt(k)); // the first or last 32-(n-1) bits are 
// do something with the hash value
for(;k<s.length();++k) {
  rollinghash = ch.update(s.charAt(k-n), s.charAt(k));
  // do something with the hash value
}
```

## Reference 

Daniel Lemire, Owen Kaser: Recursive n-gram hashing is pairwise independent, at best, Computer Speech & Language, Volume 24, Issue 4, October 2010, Pages 698-710 http://arxiv.org/abs/0705.4676
