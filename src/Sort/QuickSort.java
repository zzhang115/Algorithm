package Sort;

import S.s;

public class QuickSort 
{
//		int arrayA[]={6,10,20,9,31,31,30,15,40,1,9,36,1,11,36,2,50,21};
//		QuickSort sort=new QuickSort(arrayA);
//		sort.getSortedArray();
		private int array[];
		public QuickSort(int array[])
		{
			this.array=array;
			Sort(0, array.length-1);
		}
		public void Sort(int start, int end)
		{
			if(start>=end)return;
			int pivot;
			pivot=Partition(start, end);
			Sort(start, pivot-1);
			Sort(pivot+1, end);

		}
		public int Partition(int start, int end)
		{
			int i=start,j=start,temp=0;
			while(j<end)
			{
				if(array[i]>=array[end] && array[j]<array[end])
				{
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
					i++;
				}
				else if(array[i]<array[end])
					i++;
				j++;
			}
			temp=array[end];
			array[end]=array[i];
			array[i]=temp;
//			for(int index=0;index<array.length;index++)
//				s.so(array[index]+" ");
//			s.sop("");
			return i;
		}
		public int[] getSortedArray()
		{		
			for(int i=0;i<array.length;i++)
				s.so(array[i]+" ");
			s.sop("");
			return this.array;
		}
}
