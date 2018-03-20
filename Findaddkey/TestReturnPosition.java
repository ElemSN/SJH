package com.google.eshop.patice;

import java.util.Arrays;
import java.util.Scanner;

public class TestReturnPosition {

	public static void main(String[] args) {
		int key,n;
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入索引值:");
		key=scanner.nextInt();
		System.out.print("请输入数组长度:");
		n=scanner.nextInt();
		int[] a=new int[n];
		System.out.print("请输入数组值:");
		for(int i=0;i<a.length;++i) {
			a[i]=scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(a);
		ReturnPosition RP=new ReturnPosition(key);
		RP.Position(a);
	}
}
