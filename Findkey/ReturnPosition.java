package com.google.eshop.patice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
//�����뻹�ǿ����Ż���,�������ֵС�������ֵ,�����ֱ������(��Ϊ����������Ǿ��������)
public class ReturnPosition {
	private int key;//����ֵ

	ReturnPosition(int a) {
		key = a;
	}

	public void Position(int a[]) {
		int j=0;//��¼�𰸸���
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();//�Լ�ֵ�Ե���ʽ�洢����
		for (int i = 0; i < a.length; ++i) {
			map.put(a[i], i);
		}
		Set<Integer> set = new TreeSet<Integer>();//��TreeSet��ʽ�洢 ȥ���ظ�ֵ
		int OldSize;
		for (int i = 0; i < a.length; ++i) {
			//�ж��Ƿ����������ֵ a[i]�϶��Ǵ��ڵ� ����ֻ���ж� a[i]����Ӧ��ֵ�Ƿ����
			if (map.get(key - a[i]) != null) {
				OldSize = set.size();//����ԭset�ĳ���
				set.add(map.get(key - a[i]));
				set.add(map.get(a[i]));
				//�ж�ԭ�����Ƿ�������ڵĳ�����������˵�������ظ�ֵ Ҫ������  �� a[i]�����Ӧ��ֵ��λ�ò�����һ��ֵ
				if (OldSize != set.size()&&map.get(a[i])!=map.get(key-a[i])) {
					System.out.println("��"+(++j)+"���Ϊ:"+(map.get(key - a[i])+1) + " " + (map.get(a[i])+1));
				}
			}
		}

	}

}
