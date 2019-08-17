package test;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.test.clone.Sudent;

public class HasCodeTest {

	public static void main(String[] args) {
		
		Set s = Sets.newConcurrentHashSet();
		s.add(new Sudent("张三", 11));
		s.add(new Sudent("张三", 11));
		s.add(new Sudent("李四", 12));
		System.out.println(s.toString());
		
		
		Map map = Maps.newConcurrentMap();
		map.put(new Sudent("张三", 11), "张三");
		map.put(new Sudent("张三", 11), "张三1");
		map.put(new Sudent("李四", 12), "李四");
		System.out.println(map.toString());
		System.out.println(map.get(new Sudent("张三", 11)).hashCode());
	}

}
