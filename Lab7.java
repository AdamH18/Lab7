public class Lab7{
  public static String teachMe(String word){
    return word.charAt(0) + " is for " + word;
  }
  
  //The first terrible attempt
//  public static String pigLatin(String sentence){
//    int spaces = sentence.indexOf(" "), prev = 0, i = 0, wordStart;
//    String newWord = "";
//    while(spaces > -1){
//      //101, 105, 111, 117, 125, 141, 145, 151, 157, 165
//      wordStart = i;
//      while(sentence.charAt(i) != 101 && sentence.charAt(i) != 105 && 
//            sentence.charAt(i) != 111 && sentence.charAt(i) != 117 && 
//            sentence.charAt(i) != 125 && sentence.charAt(i) != 141 && 
//            sentence.charAt(i) != 145 && sentence.charAt(i) != 151 && 
//            sentence.charAt(i) != 157 && sentence.charAt(i) != 165 && 
//            i < spaces){
//        newWord += sentence.charAt(i);
//        System.out.println("" + i + spaces);
//        i++;
//      }
//      newWord = sentence.substring(i, spaces) + newWord + "ay";
//      sentence = sentence.substring(0, wordStart) + newWord + "@" + sentence.substring(spaces + 1);
//      newWord = "";
//      i += 4;
//      spaces = sentence.indexOf(" ");
//      System.out.println(sentence);
//    }
//    return sentence;
//  }
  
  
  //This does what is described in the prompt where if the word starts with a vowel, it ends in -way.
  //Some of your examples don't do this.
  public static String findWord(String sentence){
    String word = "";
    int wordSize = sentence.indexOf(" ");
    if(wordSize == -1)
      wordSize = sentence.indexOf(".");
    for(int i = 0; i < wordSize; i++)
      word += sentence.charAt(i);
    return word;
  }
  
  public static String convertWord(String sentence){
    boolean vowCheck = true, isVow = true;
    int ind = 1, end;
    String word = findWord(sentence);
    if(word.charAt(0) == 65 || word.charAt(0) == 69 || 
       word.charAt(0) == 73 || word.charAt(0) == 79 || 
       word.charAt(0) == 85 || word.charAt(0) == 97 || 
       word.charAt(0) == 101 || word.charAt(0) == 105 || 
       word.charAt(0) == 111 || word.charAt(0) == 117){
      word += "way";
      end = 3;
    }
    else{
      while(vowCheck){
        if(word.charAt(ind) == 65 || word.charAt(ind) == 69 || 
           word.charAt(ind) == 73 || word.charAt(ind) == 79 || 
           word.charAt(ind) == 85 || word.charAt(ind) == 97 || 
           word.charAt(ind) == 101 || word.charAt(ind) == 105 || 
           word.charAt(ind) == 111 || word.charAt(ind) == 117){
          vowCheck = false;
        }
        else{
          ind++;
          if(ind == word.length() - 1)
            isVow = false;
          break;
        }
      }
      if(isVow)
        word = word.substring(ind) + word.substring(0, ind) + "ay";
      end = 2;
    }
    return word + end;
  }
  
  public static String pigLatin(String sentence){
    String newWord, newSentence = ""; 
    int vowel;
    while(sentence.length() > 0){
      newWord = convertWord(sentence);
      vowel = Character.getNumericValue(newWord.charAt(newWord.length() - 1));
      newWord = newWord.substring(0, newWord.length() - 1);
      newSentence += newWord;
      sentence = sentence.substring(newWord.length() - vowel + 1);
      if(sentence.length() > 0)
        newSentence += " ";
    }
    return newSentence + ".";
  }
}














