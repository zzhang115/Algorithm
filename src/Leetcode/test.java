package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import S.s;
import Sort.QuickSort;

public class test 
{
	public static void main(String[] args) 
	{
		new test1_12();
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
//	test1_5.getMedianofTwoArray();
	public static void getMedianofTwoArray()
	{
//		int arrayA[]={6,9,10,15,20,30,31};
//		int arrayB[]={5,40};
//		int arrayA[]={6,9,15,20,21,30};
//		int arrayB[]={5,7,8,10,11};
//		int arrayA[]={1,2,3,4,5,6,7};
//		int arrayB[]={2,4,6,8,10,12,14};
		int arrayA[]={6,9,15,20,30};
		int arrayB[]={5,7,12,17,21};
//		int arrayB[]={5,7,15,20,31};
//		int arrayA[]={6,9,15,20,30};
		int len=arrayA.length+arrayB.length;
		if(len%2==1)
			s.sop(newsolution(arrayA, arrayB, 0, arrayA.length, 0, arrayB.length, (len/2)+1));
		else
			s.sop((newsolution(arrayA, arrayB, 0,arrayA.length, 0, arrayB.length, (len/2))+newsolution(arrayA, arrayB, 0,arrayA.length, 0, arrayB.length, (len/2)+1))/2);
	}
	public static double newsolution(int arrayA[], int arrayB[], int astart, int aend, int bstart, int bend, int k)
	{
//		s.sop("first("+astart+","+aend+","+bstart+","+bend+","+k+")");
		int lena=(aend-astart)+1;
		int lenb=(bend-bstart)+1;
		if(lena>lenb)
			return newsolution(arrayB, arrayA, bstart, bend, astart,aend, k);
		if(lena<=0)
			return arrayB[k-1];
		if(k==1)
			return arrayA[astart]>arrayB[bstart]? arrayB[bstart] : arrayA[astart];
		
		int pa=k/2>lena? lena : k/2;
		int pb=k-pa;
		if(arrayA[astart+pa-1]==arrayB[bstart+pb-1])
			return arrayA[astart+pa-1];
		if(arrayA[astart+pa-1]>arrayB[bstart+pb-1])
			return newsolution(arrayA, arrayB, astart, aend, bstart+pb, bend, k-pb);
		else
			return newsolution(arrayA, arrayB, astart+pa, aend, bstart, bend, k-pa);
	}
}
class test1_5_Solution 
{
//	new test1_5_Solution();
	public test1_5_Solution()
	{
		int arrayA[]={6,9,10,15,20,30,31};
		int arrayB[]={5,40};
//		int arrayA[]={6,9,15,20,21,30};
//		int arrayB[]={5,7,8,10,11};
//		int arrayA[]={2,3,15,16,30,50,51,56};
//		int arrayB[]={5,7,8,21,25,49,50};
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
    //findMedianCore this method mainly to find the kth number in this array
	public double findMedianCore(int[] A,int[] B,int astart,int aend,int bstart,int bend,int k)
	{ 
	  s.sop("***************");
	  int lena=aend-astart+1; 
	  int lenb=bend-bstart+1; 
	  s.sop("first("+astart+","+aend+","+bstart+","+bend+","+k+")");
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
	  s.sop("astart="+astart);
	  s.sop("bstart"+bstart);
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
class test1_6
{//		new test1_6();
	public test1_6()
	{
		int max=1;
		int count,difference=0;
		boolean ifExist=true;
		int array[]={11,200,195,196,100,198,9,-1,5,7,6,197,199,200,206,205,8,10,3,4,1,201,2,202,203,204};
		boolean ifVisited[]=new boolean[array.length];
		for(int num=0;num<ifVisited.length;num++)
			ifVisited[num]=false;                        
		for(int i=0;i<array.length;i++)
		{
			if(ifVisited[i])
				continue;
			count=1;
			while(ifExist)
			{
				ifExist=false;
				difference++;
				for(int j=0;j<array.length;j++)
				{
					if(ifVisited[j])
						continue;
//					s.sop(array[j]+"now "+array[i]+"+"+difference);
					if(array[j]==(array[i]+difference))
					{
						s.sop("+ "+array[j]);
						ifExist=true;
						count++;
						s.sop(count);
						ifVisited[j]=true;
						break;
					}
				}
			}
			ifExist=true;
			difference=0;
			while(ifExist)
			{
				ifExist=false;
				difference--;
				for(int j=0;j<array.length;j++)
				{
					if(ifVisited[j])
						continue;
					if(array[j]==(array[i]+difference))
					{
						s.sop("- "+array[j]);
						ifExist=true;
						count++;
						s.sop(count);
						ifVisited[j]=true;
						break;
					}
				}
			}
			ifVisited[i]=true;
			ifExist=true;
			difference=0;
			if(count>max)max=count;	
		}
		s.sop(max);
	}
//	test1_6.test1_6_newVersion();
	public static void test1_6_newVersion()
	{
		int max=1;
		int count;
		int array[]={11,200,195,196,100,198,9,-1,5,7,6,197,199,200,206,205,8,10,3,4,1,201,2,202,203,204};
//		s.sop(longestConsecutive(array));
		boolean ifVisited[]=new boolean[array.length];
		for(int num=0;num<ifVisited.length;num++)
			ifVisited[num]=false;                   
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0;i<array.length;i++)
			set.add(array[i]);
		Iterator<Integer> iterator= set.iterator();
		while(iterator.hasNext())
		{
			int element=iterator.next();
			int element2=element;
			count=1;
			set.remove(element);// I haven't figure out what reason can lead this iterator struggle with dead circle
			while(set.contains(++element))
			{
				count++;
				set.remove(element);
				s.sop(count);
			}
			while(set.contains(--element2))
			{
				count++;
				set.remove(element2);
				s.sop(count);
			}
			if(count>max)max=count;	
			iterator=set.iterator(); // this point must be careful, reset the iterator, must be that
		}
		s.sop(max);
	}
}
class test1_7
{
//	new test1_7();
	public test1_7()
	{
		int array[]={-1,1,5,1,0,-4,2,-5,2,-7,3,8};
		array=new QuickSort(array).getSortedArray();
		ArrayList<String> arraylist=new ArrayList<String>();
		for(int i=0;i<array.length;i++)
		{
			if(array[i]>=0)break;
			int num,p,q;
			if(i>0 && array[i]==array[i-1])
				continue;
			num=array[i];
			p=i+1;
			q=array.length-1;
			while(p<q)
			{
				s.sop(p+" "+q);
//				if(array[p]==array[p+1])//get rid of duplicate elements
//				{
//					p++;
//					continue;
//				}
//				if(array[q-1]==array[q])
//				{
//					q--;
//					continue;
//				}				
				if((-num)>(array[p]+array[q]))
					p++;
				else if((-num)<(array[p]+array[q]))
					q--;
				else if((array[p]+array[q]+num)==0)
				{
					arraylist.add(num+" "+array[p]+" "+array[q]);
					p++;
					q--;
				}

			}
		}
		for(String str:arraylist)
			s.sop(str);
	}
}
class test1_8
{
//	new test1_8(5);
	public test1_8(int givenNum)
	{
		int minDifference=65535;
//		int array[]={-1,1,5,1,0,-4,2,-5,2,-7,3,-3,8};
		int array[]={-1,1,25,1,0,-40,26,-105,2,-7,23,-30,8};
		array=new QuickSort(array).getSortedArray();
		ArrayList<String> arraylist=new ArrayList<String>();
		for(int i=0;i<array.length;i++)
		{
			int num,p,q,difference;
			if(i>0 && array[i]==array[i-1])
				continue;
			num=array[i];
			p=i+1;
			q=array.length-1;
			while(p<q)
			{
				s.sop(num+" "+array[p]+" "+array[q]);
//				if(array[p]==array[p+1])//get rid of duplicate elements
//				{
//					p++;
//					continue;
//				}
//				if(array[q-1]==array[q])
//				{
//					q--;
//					continue;
//				}	
				difference=s.abs(givenNum-(array[p]+array[q]+num));
				s.sop("difference= "+difference);
				if(givenNum>(array[p]+array[q]+num))
				{
					if(difference<minDifference)
					{
						minDifference=difference;
						if(!arraylist.isEmpty())
							arraylist.remove(arraylist.size()-1);
						arraylist.add(num+" "+array[p]+" "+array[q]);
					}
					p++;
				}
				else if(givenNum<(array[p]+array[q]+num))
				{
					if(difference<minDifference)
					{
						minDifference=difference;
						if(!arraylist.isEmpty())
							arraylist.remove(arraylist.size()-1);
						arraylist.add(num+" "+array[p]+" "+array[q]);
					}
					q--;
				}
				else if(givenNum==(array[p]+array[q]+num))
				{					
					if(minDifference!=0)
						arraylist.clear();
					if(difference<minDifference)
						minDifference=difference;
					arraylist.add(num+" "+array[p]+" "+array[q]);
					p++;
					q--;
				}

			}
		}
		for(String str:arraylist)
			s.sop("final: "+str);
	}
}
class test1_12
{
	public test1_12()
	{
		int i,j,k,temp;
		int array[]={1,6,5,7,6,5,4,3,2,1};
//		int array[]={1,2,3};
		for(i=array.length-1;i>0;i--)
		{
			if(array[i-1]<array[i])
				break;
		}
		if(i!=0)
		{
			for(j=array.length-1;j>=i;j--)
			{
				if(array[j]>array[i-1])
					break;
			}
			temp=array[i-1];
			array[i-1]=array[j];
			array[j]=temp;
		}
		k=array.length-1;
		if((k-i+1)%2==0)
			while((k-i)>=1)
			{
				temp=array[i];
				array[i]=array[k];
				array[k]=temp;
				i++;k--;
			}
		else
			while((k-i)>=2)
			{
				temp=array[i];
				array[i]=array[k];
				array[k]=temp;
				i++;k--;
			}
		for(int x=0;x<array.length;x++)
		{
			s.so(array[x]+" ");
		}
		
	}
}