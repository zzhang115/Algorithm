package List;

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
		current=head.next;
		while(i<index && current!=null)
		{
			current=current.next;
			i++;
		}
	}
	public void add(int index, int data)
	{
		if(size<index || index<0)
			{s.sop("parameter is invalid!");return;}
		indexAdjust(index-1);
		current.next=new SingleNode(data, current.next);
		size++;
	}
	public Object getNode(int index)
	{
		indexAdjust(index);
		return current.getData();
	}
}
