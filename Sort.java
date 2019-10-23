/*
 * Copyright (C) 2019 jucktangi.
 */

import java.io.*;
import java.lang.*;

public class Sort
{
	public static void main(String[] args)throws IOException
	{
		int ch = 0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println(
					"\n\n\n1.Bubble Sort\n"
					+ "2.Selection Sort\n"
					+ "3.Insertion Sort.\n"
					+ "4.Quick Sort.\n"
					+ "5.Merge Sort.\n"
					+ "6.Exit.");
			ch=Integer.parseInt(br.readLine());
			if(ch==6)
				return;
			System.out.println("Enter n");
			int n=Integer.parseInt(br.readLine());
			int item[]=new int[n];
			for(int i=0;i<n;i++)
			{
				item[i]=Integer.parseInt(br.readLine());
			}
			switch(ch)
			{
				case 1:
					BinarySort(item,n);
					print(item,n);
					break;
				case 2:
					SelectionSort(item,n);
					print(item,n);
					break;
				case 3:
					InsertionSort(item,n);
					print(item,n);
					break;
				case 4:
					int start=0;
					int end=n-1;
					QuickSort(item,start,end);
					print(item,n);
					break;
				case 5:
					MergeSort(item,n);
					print(item,n);	
					break;
				default:
					System.out.println("You selected wrong number. Please try again.\n");
					break;
			}
			
		}
		while(ch!=6);
	}
	public static void BinarySort(int[] item,int n)
	{
		int temp = 0;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(item[j]>item[j+1])
				{
					temp=item[j];
					item[j]=item[j+1];
					item[j+1]=temp;
				}
			//System.out.print(a[j]);
			}
			//System.out.println();
			
		}
		//print(a,n);
	}
	public static void SelectionSort(int[] item, int n)
	{
		for (int i=0;i<n-1;i++)
		{
			int imin=i;
			int temp;
			for(int j=i+1;j<n;j++)
			{
				if(item[j]<item[imin])
					imin=j;
			}
			temp=item[i];
			item[i]=item[imin];
			item[imin]=temp;
		}
		//print(a,n);
	}
	public static void InsertionSort(int[] item,int n)
	{
		for(int i=1;i<n;i++)
		{
			int val=item[i];
			int hole=i;
			while(hole>0&&item[hole-1]>val)
			{
				item[hole]=item[hole-1];
				hole=hole-1;
			}
			item[hole]=val;
		}
		//print(a,n);
	}
	public static void MergeSort(int[] item,int n)
	{
		
		if(n<=1)
			return;
		int mid=n/2;
		int left[]=new int[mid];
		int right[]=new int[n-mid];
		for(int i=0;i<mid;i++)
			left[i]=item[i];
		for(int i=mid;i<n;i++)
			right[i-mid]=item[i];
		MergeSort(left,mid);
		MergeSort(right,n-mid);
		Merge(left,right,item);
		
	}
	public static void Merge(int[] left,int[] right,int[] item)
	{
		int sizeLeft=left.length;
		int sizeRight=right.length;
		int i,j,k;
		i=j=k=0;
		while(i<sizeLeft&&j<sizeRight)
		{
			if(left[i]<=right[j])
			{
				item[k]=left[i];
				i++;
				k++;
			}
			else
			{
				item[k]=right[j];
				j++;
				k++;
			}
		}
		while(i<sizeLeft)
		{
			item[k]=left[i];
			i++;
			k++;
		}
		while(j<sizeRight)
		{
			item[k]=right[j];
			j++;
			k++;
		}
	}
	public static void QuickSort(int a[],int start,int end)
	{
		if(start<end)
		{
			int pIndex=QuickPartition(a,start,end);
			QuickSort(a,start,pIndex-1);
			QuickSort(a,pIndex+1,end);
		}
		else
			return;
		
	}
	public static int QuickPartition(int[] item,int start,int end)
	{
		int temp = 0;
		int pivot=item[end];
		int pIndex=start;
		for(int i=start;i<end;i++)
		{
			if(item[i]<=pivot)
			{
				//swap a[i],apindex
				temp=item[i];
				item[i]=item[pIndex];
				item[pIndex]=temp;
				pIndex++;
			}
		}
		temp=item[pIndex];
		item[pIndex]=item[end];
		item[end]=temp;
		return pIndex;
	}
	public static void print(int a[],int n)
	{
		System.out.println();
		for(int i=0;i<n;i++)
			System.out.print(a[i]+"\t");
	}
}