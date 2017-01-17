package Leetcode;

import List.SingleList;
import S.s;

public class chaper2
{
	public static void main(String args[]) throws Exception
	{
		new test2_1();
	}
}
class test2_1
{
	public test2_1() throws Exception
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
				s.so(list.getNode(i)+" ");
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
				s.so(list.getNode(i)+" ");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}