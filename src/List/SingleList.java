package List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import S.s;

public class SingleList
{
	public int size;
	public SingleNode head;
	public SingleNode current;
	public SingleList()
	{
		size=0;
		current=head=new SingleNode(null);
		
	}
	public void indexAdjust(int index)
	{
		if(size<index || index<0)
			{s.sop("parameter is invalid!");return;}
		int i=0;
		while(i<index && current!=null)
		{
			current=current.getNext();
			i++;
		}
	}
	public void add(int index, int data)
	{
		
		SingleNode node=new SingleNode(data, null);
		size++;
	}
}
