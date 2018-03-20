package com.google.eshop.patice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ReturnPosition {
	private int key;

	ReturnPosition(int a) {
		key = a;
	}

	public void Position(int a[]) {
		int j=0;//记录答案个数
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; ++i) {
			map.put(a[i], i);
		}
		Set<Integer> set = new TreeSet<Integer>();
		int OldSize;
		for (int i = 0; i < a.length; ++i) {
			if (map.get(key - a[i]) != null) {
				OldSize = set.size();
				set.add(map.get(key - a[i]));
				set.add(map.get(a[i]));
				if (OldSize != set.size()&&map.get(a[i])!=map.get(key-a[i])) {
					System.out.println("第"+(++j)+"组解为:"+(map.get(key - a[i])+1) + " " + (map.get(a[i])+1));
				}
			}
		}

	}

}
