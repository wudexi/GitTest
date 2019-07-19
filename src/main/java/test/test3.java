package test;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = Lists.newArrayList();
		int j=0; 
		for(int i=0;i<100;i++){
			j++; 
		}
		System.out.println(j); 
		
		list.add(1);
		list.add(2);
//		list.add(1, 3);
		list.set(1, 30);
		Iterator it =  list.iterator();
//		while (it.hasNext()) {
//			int num = (int) it.next();
//			if(num == 2){
//				it.remove();
//			}
//		}
		
		System.out.println(3*0.1);
		System.out.println(3*0.1==0.3);
	}

}
