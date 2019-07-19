package com.junit.demo.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

public class test8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int j=1;int i=10;
		do {
			if(j++ < --i){
				System.out.println(j+"=="+i);
			}
			System.out.println(j+"=="+i);
		} while (j<5);
		
		Map m = Maps.newHashMap();
		m.put(1, "aaa");
		m.put(null, "aab");
		m.put(null, "aab1");
		
		System.out.println(m.get(null));
		System.out.println();
		Maps.newConcurrentMap();
	}

}
