import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.beanutils.MappedPropertyDescriptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
 class User{
	private String 	userName;
	private int age;
	
	/*public User() {
		super();
	}*/
	public User(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + "]";
	}
}

public class Sort_jdk8 {
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean asc){
        Map<K, V> result = new LinkedHashMap<>();
        Stream<Entry<K, V>> stream = map.entrySet().stream();    
		if (asc) //升序
		{
			 //stream.sorted(Comparator.comparing(e -> e.getValue()))
			stream.sorted(Map.Entry.<K, V>comparingByValue())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		}
		else //降序
		{
			 //stream.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			stream.sorted(Map.Entry.<K, V>comparingByValue().reversed())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		}
        return result;
    }


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.list排序
//		List<Integer> list = Lists.newArrayList();
//		list.add(1);
//		list.add(4);
//		list.add(2);
//		list.sort(Comparator.naturalOrder()); // 升序
//		list.sort(Comparator.reverseOrder()); // 降序
//		list.forEach(System.out::print);
		
		//2.list排序(对象)
		List<User> list2 = Lists.newArrayList();
		list2.add(new User("张三", 22));
		list2.add(new User("李四", 19));
		list2.add(new User("王五", 21));
		list2.add(new User("王五", 21));
		list2.add(new User("张三", 22));
//		list2.sort(Comparator.comparing(User::getAge));
//		list2.sort(Comparator.comparing(User::getAge).reversed().thenComparing(User::getUserName));
		
		// 去重
		list2 = list2.stream().collect(Collectors.collectingAndThen(
		        		Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getUserName).thenComparing(User::getAge)
		        															  
		        															  )), 
		        																ArrayList::new));
		list2.sort(Comparator.comparing(User::getAge));
		System.out.println("list排序。。。");
		list2.forEach(System.out::println);
		
		
		
		
		
		// set排序
//		Set<Integer> s = Sets.newHashSet();
//		s.add(2);
//		s.add(1);
//		s.add(5);
//		s.stream().sorted(Comparator.reverseOrder());
//		s.forEach(System.out::print);
		
		// set 转为list
//		Set<User> set = Sets.newHashSet();
//		set.add(new User("张三",11));
//		set.add(new User("李四",15));
//		set.add(new User("王五",14));
//		
//		List<User> ll = set.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
//		ll.forEach(System.out::print);
		
		
		// map 根据key升序
//		Map<String,Object> map = Maps.newHashMap();
//		Map<String,Object> map = Maps.newHashMap();
//		map.put("a",2);
//		map.put("b",1);
//		map.put("c",4);
//		map.put("z",0);
//		map.put("d",3);
//		map = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
//							   .collect(Collectors.toMap(Map.Entry::getKey, 
//									   					 Map.Entry::getValue,
//									   					 (oldValue,newValue) -> oldValue,
//									   					 LinkedHashMap::new));
//		System.out.println(map);
		
		// 根据key降序
//      Map<String, Object> finalMap = new LinkedHashMap<>();
//		map.entrySet().stream().sorted(Map.Entry.<String, Object> comparingByKey().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
//		System.out.println(finalMap);
		
		// 根据 value 升序
		Map<String,Integer> map2 = Maps.newHashMap();
		map2.put("a",2);
		map2.put("b",1);
		map2.put("c",4);
		map2.put("z",0);
		map2.put("d",3);
		map2 = map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
							   		   .collect(Collectors.toMap(Map.Entry::getKey, 
							   				   					 Map.Entry::getValue,
							   				   					 (oldValue,newValue) -> oldValue,
							   				   					 LinkedHashMap::new));
//		System.out.println(map2);
		
		// map 对象类型 排序
		Map<String,User> map3 = Maps.newHashMap();
		map3.put("a",new User("张三", 24));
		map3.put("b",new User("李四", 23));
		map3.put("c",new User("王五", 25));
		map3.put("z",new User("李六", 21));
		map3.put("d",new User("张三2", 22));
		
		map3 = map3.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(User::getAge).reversed()))
		   		   					   .collect(Collectors.toMap(Map.Entry::getKey, 
		   		   							   					 Map.Entry::getValue,
		   		   							   					 (oldValue,newValue) -> oldValue,
		   		   							   					 LinkedHashMap::new));
		
		
//		System.out.println(map3);
		

	}

}
