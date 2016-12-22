package Leetcode;

public class test 
{
	public static void main(String[] args) 
	{
		test1_3.searchInRotatedArray(6);
	}
}
class test1_1
{//s.sop(test1_1.removeDuplicate());
	public static int removeDuplicate()
	{
		int index=0;
		int arry[]={1,1,2,3,4,5,5,5,6};
		for(int i=0;i<arry.length;i++)
		{
			if(arry[index]!=arry[i])
				arry[++index]=arry[i];
			
		}
		for(int i=0;i<arry.length;i++)
			s.sop(arry[i]);
		return ++index;
	}
}
class test1_2
{//test1_2.removeDuplicate();
	public static void removeDuplicate()
	{
		int i=0;
		int index=0;
		int array[]={1,1,1,1,1,2,2,3,4,4,4,5,6,7,7,7,7,9};
		for(int j=1;j<array.length;j++)
		{
			if(array[i]==array[j] && index<1)
			{
				array[++i]=array[j];
				index++;
			}
			if(array[i]!=array[j])
			{
				array[++i]=array[j];
				index=0;
			}

		}
		for(int j=0;j<array.length;j++)
			s.sop(array[j]);
		s.sop("length="+(++i));
	}
}
class test1_3
{
	static int x;
	static int array[]={6,7,8,9,10,11,12,13,1,2,3,4,5,6};//{6,7,8,9,10,11,2,3,4};{4,5,6,7,0,0,1,1,2,4,4};
	public static void searchInRotatedArray(int x)
	{
		test1_3.x=x;
		s.sop(binarySearch(0, array.length-1));
	}
	public static int binarySearch(int start, int end)
	{
		int result=-1;
		s.sop(start+" "+end);
		if(start == end)
		{
			if(x==array[start])
			{
				s.sop("index= "+start);
				return start;	//from here return value will not finish this whole method directly, it just return to last recurrence
			}
			else 
				return -1;
		}
		int mid = (start + end)/2;
		if(array[start] <= array[mid])
		{
			if(array[start]<=x && x <= array[mid])
				result=binarySearch(start, mid);
			if(array[mid+1] <= x || x <= array[end])
				result=binarySearch(mid+1, end);
		}
		else if(array[mid] <= array[end])
		{
			if(array[mid] <= x && x <= array[end])
				result=binarySearch(mid, end);
			if(array[start]<=x || x <= array[mid-1])
				result=binarySearch(start, mid-1);
		}
		return result;
	}
//	public static int binarySearch(int start, int end)
//	{
//		int result=-1;
//		s.sop(start+" "+end);
//		if(start == end)
//		{
//			if(x==array[start])
//			{
//				s.sop("index= "+start);
//				return start;	//from here return value will not finish this whole method directly, it just return to last recurrence
//			}
//			else 
//				return -1;
//		}
//		int mid = (start + end)/2;
//		if(array[start] <= array[mid])
//		{
//			if(array[start]<=x || x <= array[mid])
//				result=binarySearch(start, mid);
//			if(array[mid+1] <= x || x <= array[end])
//				result=binarySearch(mid+1, end);
//		}
//		else if(array[mid] <= array[end])
//		{
//			if(array[mid] <= x || x <= array[end])
//				result=binarySearch(mid, end);
//			if(array[start]<=x || x <= array[mid-1])
//				result=binarySearch(start, mid-1);
//		}
//		return result;
//	}
}


class s
{
	public static void sop(Object o)
	{
		System.out.println(o);
	}
}

