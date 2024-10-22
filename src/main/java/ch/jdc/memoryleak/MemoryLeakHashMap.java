package ch.jdc.memoryleak;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakHashMap {

  public static void main(String[] args) {
    Map<Object, String> wmap = new HashMap<>();

    Object o1 = new Object();
    Object o2 = new Object();

    wmap.put(o1, "o1");
    wmap.put(o2, "o2");
    
    System.out.println("Before GC:" + wmap);

    o1 = null;
    
    System.gc(); 

    try { Thread.sleep(1000); } 
    catch (InterruptedException e) { System.out.println(e); }  

    System.out.println("After GC:" + wmap);


  }
}

