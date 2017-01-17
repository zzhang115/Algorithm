package Leetcode;

import List.SingleList;
import List.SingleNode;
import S.s;

public class chapter2
{
	public static void main(String args[]) throws Exception
	{
		new test2_2(4, 4);
	}
}
class SingleListOperationTest
{
	public SingleListOperationTest()throws Exception
	{
		SingleList list=new SingleList();
		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");
		list.add(3, "d");
		list.add(4, "e");
		for(int i=0;i<list.size();i++)
		{
			try
			{
				s.so(list.getNodeData(i)+" ");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		s.sop("");
		list.add(0, "f");
//		list.delete(4);
		for(int i=0;i<list.size();i++)
		{
			try
			{
				s.so(list.getNodeData(i)+" ");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
class test2_2
{
	public test2_2(int m, int n)
	{
		SingleList list=new SingleList();
		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");
		list.add(3, "d");
		list.add(4, "e");
		list.add(5, "f");
		for(int i=0;i<list.size();i++)
		{
			try
			{
				s.so(list.getNodeData(i)+" ");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		s.sop("");
		if(m<n)
		{
			SingleNode current=(SingleNode) list.getNode(m-1);
			SingleNode one=current.next;
			SingleNode two=one.next;
			SingleNode mid = null;
			while(m<n)
			{
				mid=two.next;
				two.next=one;
				one=two;
				two=mid;
				m++;
			}
			SingleNode start=current.next;
			start.next=mid;
			current.next=one;
		}
		for(int i=0;i<list.size();i++)
		{
			try
			{
				s.so(list.getNodeData(i)+" ");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}