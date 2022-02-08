import java.util.*;

public class Parser {
    
  public static int parseInt(String numStr) {

    Map<String,Integer> numDic = new HashMap<>();
    System.out.println(numStr);
  
    numDic.put("zero",0);       numDic.put("thirteen",13);
    numDic.put("one",1);        numDic.put("fourteen",14);
    numDic.put("two",2);        numDic.put("fifteen",15);
    numDic.put("three",3);      numDic.put("sixteen",16);
    numDic.put("four",4);       numDic.put("seventeen",17);
    numDic.put("five",5);       numDic.put("eighteen", 18);
    numDic.put("six",6);        numDic.put("nineteen", 19);
    numDic.put("seven",7);;     numDic.put("twenty",20);
    numDic.put("eight",8);      numDic.put("thirty",30);
    numDic.put("nine",9);       numDic.put("forty",40);
    numDic.put("ten",10);       numDic.put("fifty",50);
    numDic.put("eleven",11);    numDic.put("sixty",60);
    numDic.put("twelve",12);    numDic.put("seventy",70);
                                numDic.put("eighty",80);
                                numDic.put("ninety",90);
    
    if (numStr.contains("million")){return 1000000;}
            
    numStr = numStr.replaceAll(" and","");
    int before = 0;

    if (numStr.contains("thousand")){
      String[] arrBefore = numStr.replaceFirst("thousand.*","").split(" |-");
      numStr = numStr.replaceAll(".*(thousand )|.*(thousand)","");
      before = parseHudred(arrBefore,numDic) * 1000;
    }

    String[] arr = numStr.split(" |-");

    return parseHudred(arr,numDic) + before;
  }

  public static int parseHudred(String[] numStr,Map<String,Integer> numDic) {
    int result = 0;
    if (numStr.length > 1 && numStr[1].equals("hundred")){
      result = numDic.get(numStr[0]) * 100; 
      numStr[1] = ""; numStr[0] = "";
    }
    for (int i = 0; i < numStr.length; i++){
      String num = numStr[i];
      if (numDic.keySet().contains(num))
        result = result + numDic.get(num);
    }
    return result;
  }
}