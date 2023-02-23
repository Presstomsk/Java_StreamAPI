package helloapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;



public class Program {
	  public static void main(String[] args) {
		  
		  ArrayList<String> strs = new ArrayList<String>();		  
		  Collections.addAll(strs,"a1", "a2", "a3", "a1", "a4", "a5", "a1" ); //Дана коллекция строк {"a1, "a2", "a3", "a1", "a4", "a5, "a1"}, вернуть количество вхождений объекта «a1» с помощью streamAPI;
		  long count = strs.stream().filter(x -> x == "a1").count();		  
		  System.out.println(count);		 
		  
		  String str = "a3";
		  System.out.println(strs.stream().anyMatch(x -> x == str) ? str : "error"); //Найти элемент в коллекции равный «a3» или вывести ошибку;		  
		  
		  System.out.println(strs.stream().count() != 0 ? strs.stream().skip(strs.size() - 1).findFirst().get() : "empty"); //Вернуть последний элемент коллекции или «empty», если коллекция пуста;		  
		  
		  strs.stream().skip(1).limit(2).forEach(s->System.out.println(s));	//Вернуть два элемента начиная со второго элемента коллекции;
		  
		  Optional<Integer> sumOptElements = strs.stream().distinct().map(x -> x.length()).reduce((x,y)->x+y); //Из коллекции имен убрать все повтарения и найти среднюю длину имен;
		  if(sumOptElements.isPresent())
		  {  		  
			  System.out.println(sumOptElements.get()/strs.stream().distinct().map(x -> x.length()).count());
		  }
		  
		  List<String> list = strs.stream().sorted((x, y) -> { //Отсортировать коллекцию строк по убыванию и убрать дубликаты
		        int code1 = Integer.parseInt(x.substring(1));
		        int code2 = Integer.parseInt(y.substring(1));		        
		        return code2 - code1;}).distinct().toList();

		  System.out.println(list);
		  
		  Optional<Integer> optInt = strs.stream().map(x -> Integer.parseInt(x.substring(1))).filter(x -> x % 2 != 0).reduce((x,y)->x+y); //Вернуть сумму нечетных чисел или 0;		  
		  System.out.println(optInt.isPresent() ? optInt.get() : 0);		  
	  }
}



