package Leetcode;

public class test 
{
	public static void main(String[] args) 
	{
		new Solution();
//		test1_5.getMedianofTwoArray();
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
class test1_3 //for array has no duplicate element
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
				return start;	//from here return value will not finish this whole method directly, it just return to last recurrence
			else 
				return -1;
		}
		int mid = (start + end)/2;
		if(array[start] <= array[mid])
		{
			if(array[start]<=x && x <= array[mid])
				result=binarySearch(start, mid);
			else
				result=binarySearch(mid+1, end);
		}
		else if(array[mid] <= array[end])
		{
			if(array[mid] <= x && x <= array[end])
				result=binarySearch(mid, end);
			else
				result=binarySearch(start, mid-1);
		}
		return result;
	}
}
class test1_4
{
//	test1_4.searchInRotatedArray(6);
	static int x;
	static int array[]={6,7,8,9,10,11,12,13,1,2,3,4,5,6};//{6,7,8,9,10,11,2,3,4};{4,5,6,7,0,0,1,1,2,4,4};
	public static void searchInRotatedArray(int x)
	{
		test1_4.x=x;
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
			if(array[mid+1] <= x || x <= array[end])   //especially for array like 666666677891234,   find 3 in (67012)|3456
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
}
class test1_5
{
	public static void getMedianofTwoArray()
	{
//		int arrayA[]={1,2,3,4,5,6,7};
//		int arrayB[]={2,4,6,8,10,12,14};
		int arrayA[]={6,9,15,20,30};
		int arrayB[]={5,7,12,17,21};
		Array A=new Array(0, arrayA.length-1, arrayA);//static method cannot visit  dynamic class
		Array B=new Array(0, arrayB.length-1, arrayB);
		while(A.getMedian()!=B.getMedian())
		{
			s.sop("A: "+A.getMedian()+" B: "+B.getMedian());
			if(A.getMedian()<B.getMedian())
			{
				A.startIndex=A.medianIndex;
				B.endIndex=B.medianIndex;
			}
			else
			{
				B.startIndex=B.medianIndex;
				A.endIndex=A.medianIndex;
			}
		}
		s.sop(A.getMedian());
		s.sop(B.getMedian());
	}
	private static class Array
	{
		public int startIndex;
		public int endIndex;
		public int medianIndex;
		public int median;
		public int array[];
		public Array(int startIndex, int endIndex, int array[])
		{
			this.startIndex=startIndex;
			this.endIndex=endIndex;
			this.array=array;
		}
		public int getMedian()
		{
			if((startIndex+endIndex)%2==1)
				median=(array[(startIndex+endIndex)/2]+array[(startIndex+endIndex)/2+1])/2;
			else
				median=array[(startIndex+endIndex)/2];
			medianIndex=(startIndex+endIndex)/2;
			return median;
		}
	}
}
class Solution {
	public Solution()
	{
//		int arrayA[]={6,9,15,20,30};
//		int arrayB[]={5,7};
		int arrayA[]={6,9,15,20,21,30};
		int arrayB[]={5,7,8,10,11};
		s.sop(findMedianSortedArrays(arrayA, arrayB));
	}

    public double findMedianSortedArrays(int A[], int B[]) 
    {  
       int lena=A.length; 
       int lenb=B.length; 
       int len=lena+lenb; 
       if(len%2==0)
       { 
       return  (findMedianCore(A,B,0,lena-1,0,lenb-1,len/2)+ 
         findMedianCore(A,B,0,lena-1,0,lenb-1,len/2+1))/2; 
       }else
       { 
        return findMedianCore(A,B,0,lena-1,0,lenb-1,len/2+1); 
       } 
    } 
	public double findMedianCore(int[] A,int[] B,int astart,int aend,int bstart,int bend,int k)
	{ 
	  s.sop("***************");
	  int lena=aend-astart+1; 
	  int lenb=bend-bstart+1; 
	  s.sop("k="+k);
	  s.sop("lena="+lena);
	  s.sop("lenb="+lenb);
	// the length of a is always smaller than the length of b 
	  if(lena>lenb)
	  { 
		  return findMedianCore(B,A,bstart,bend,astart,aend,k); 
	  } 
	  if(lena<=0)
	  { 
		  return B[bstart+k-1]; 
	  } 
	  if(k==1)
	  { 
		  return A[astart]>B[bstart]?B[bstart]:A[astart]; 
	  } 
	  int pa=k/2>lena?lena:k/2; 
	  int pb=k-pa;
	  s.sop("pa="+pa);
	  s.sop("pb="+pb);
	  s.sop("astart+pa-1="+(astart+pa-1));s.sop("A[astart+pa-1]="+(A[astart+pa-1]));
	  s.sop("bstart+pb-1="+(bstart+pb-1));s.sop("B[bstart+pb-1]="+(B[bstart+pb-1]));
	  if(A[astart+pa-1]==B[bstart+pb-1])
	  { 
		  return A[astart+pa-1]; 
	  }
	  else if(A[astart+pa-1]>B[bstart+pb-1])
	  { 
		  s.sop("findMedian>Core("+astart+","+aend+","+(bstart+pb)+","+bend+","+(k-pb)+")");
		  return findMedianCore(A,B,astart,aend,bstart+pb,bend,k-pb); 
	  }
	  else
	  { 
		  s.sop("findMedian<Core("+(astart+pa)+","+aend+","+bstart+","+bend+","+(k-pa)+")");
		  return findMedianCore(A,B,astart+pa,aend,bstart,bend,k-pa); 
	  } 
	 } 
} 
class s
{
	public static void sop(Object o)
	{
		System.out.println(o);
	}
}
