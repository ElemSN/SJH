package com.google.eshop.patice;

import java.util.Arrays;
import java.util.Scanner;

public class TestReturnPosition {

	public static void main(String[] args) {
		int key,n;
		Scanner scanner=new Scanner(System.in);
		System.out.print("����������ֵ:");
		key=scanner.nextInt();
		System.out.print("���������鳤��:");
		n=scanner.nextInt();
		int[] a=new int[n];
		System.out.print("����������ֵ:");
		for(int i=0;i<a.length;++i) {
			a[i]=scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(a);
		ReturnPosition RP=new ReturnPosition(key);
		RP.Position(a);
	}
}
