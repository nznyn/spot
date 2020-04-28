import java.util.*;
import java.lang.*;
import java.io.*;

class Spotify
{
  public static void main(String[] args) {

    String s = "If you want to jumpstart the process of talking to us about this role, here’s a little challenge: write a program that outputs the largest unique set of characters that can be removed from this paragraph without letting its length drop below 50. For example: [‘H’, ‘i’, ‘!’, ‘ ’]";

    splitter(s);
  }

  public static void splitter(String str){

    Map<Character, Integer> u_char = new HashMap();
    char[] chrs = str.toCharArray();

    List<Character> char_list = new ArrayList();

    for(int i = 0; i < chrs.length; i++){
      u_char.put(chrs[i], u_char.getOrDefault(chrs[i], 0) + 1);
      char_list.add(chrs[i]);
    }

    List<Integer> occur = new ArrayList();
    Map<Integer, Character> removal = new HashMap();
    int total = 0;
    for(Map.Entry<Character, Integer> entry : u_char.entrySet()){
        total += entry.getValue();
        occur.add(entry.getValue());
        removal.put(entry.getValue(), entry.getKey());
    }
    Collections.sort(occur);

    int index = 0;
    while(total > 0){
        int num = occur.get(index);
        
        if(total - num >= 50){
            total = total - num;
        }else
            break;
        
        index++;
    }
    
    Set<Character> leftovers = new HashSet();
    for(int i = index; i < occur.size(); i++){
        leftovers.add(removal.get(occur.get(i)));
    }
    
    for(Character c : leftovers) u_char.remove(c);

    for(Map.Entry<Character, Integer> entry : u_char.entrySet()){
        System.out.println(entry.getKey());
    }
  }
}
