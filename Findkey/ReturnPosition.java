package com.google.eshop.patice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
//本代码还是可以优化的,如果索引值小于数组的值,则可以直接跳出(因为传入的数组是经过排序的)
public class ReturnPosition {
	private int key;//索引值

	ReturnPosition(int a) {
		key = a;
	}

	public void Position(int a[]) {
		int j=0;//记录答案个数
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();//以键值对的形式存储数组
		for (int i = 0; i < a.length; ++i) {
			map.put(a[i], i);
		}
		Set<Integer> set = new TreeSet<Integer>();//以TreeSet形式存储 去除重复值
		int OldSize;
		for (int i = 0; i < a.length; ++i) {
			//判断是否存在这两个值 a[i]肯定是存在的 所以只用判断 a[i]所对应的值是否存在
			if (map.get(key - a[i]) != null) {
				OldSize = set.size();//存入原set的长度
				set.add(map.get(key - a[i]));
				set.add(map.get(a[i]));
				//判断原长度是否等于现在的长度如果不相等说明不是重复值 要输出结果  和 a[i]和其对应的值的位置不能是一个值
				if (OldSize != set.size()&&map.get(a[i])!=map.get(key-a[i])) {
					System.out.println("第"+(++j)+"组解为:"+(map.get(key - a[i])+1) + " " + (map.get(a[i])+1));
				}
			}
		}

	}

}
