package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void regular()
	{
		List<String> names = new ArrayList<String>();
		names.add("Anusha");
		names.add("Bikan");
		names.add("Miksa");
		names.add("Axan");
		names.add("Lipjah");
		int count = 0;
		
		for(int i=0; i<names.size(); i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);	
	}
	
	@Test
	public void streamFilter() {
		List<String> names = new ArrayList<String>();
		names.add("Anusha");
		names.add("Bikan");
		names.add("Miksa");
		names.add("Axan");
		names.add("Lipjah");
		//there is no life for intermediate op if there is no terminal op
		//terminal operation will execute only if inter op(filter) returns true
		//we can create streams
		
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d = Stream.of("Anusha", "Nikan", "Miksa", "Axan", "Lipjah").filter(s->
		{
			s.startsWith("A");//if the action is more than one line then better to keep in a scope
			return true;
		}).count();
		System.out.println(d);
		
		
		//count the length of strings having length greater than 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.print(s+"\t"));
		System.out.println("\n");
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s+"\n"));
	}
	
	@Test
	public void streamMap()
	{
		List<String> names = new ArrayList<String>();
		names.add("Anura");
		names.add("Chety");
		names.add("Axan");
		
		//print names which have last letter as "a" as uppercase
		Stream.of("Anusha","Nikan","Miksa","Axan","Lipjah").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s+"\t"));
		System.out.println("\n");
		
		//print names which have first letter as "a" with uppercase and sorted
		List<String> names1 = Arrays.asList("Anusha","Nikan","Miksa","Axan","Aipjah") ;
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s +"\t"));
		System.out.println("\n");
		
		//Merging 2 different lists
		Stream<String> newStream  = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s+"\t"));
		//System.out.println("\n");
		
		//using flag
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Axan"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect()
	{
		List<String> ls = Stream.of("Anusha","Nikan","Miksa","Axan","Aipjah").filter(s->s.endsWith("a"))
				.map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,8,6);
		values.stream().distinct().forEach(s->System.out.println(s+"\t"));
		
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
