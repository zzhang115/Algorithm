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
		if(size-1<index || index<-1)
			{s.sop("parameter is invalid!");return;}
		if(index==-1)return;
		int i=0;
		current=head.next;
		while(i<index && current!=null)
		{
			current=current.next;
			i++;
		}
	}
	public void add(int index, Object data)
	{
		if(size<index || index<0)
			{s.sop("parameter is invalid!");return;}
		indexAdjust(index-1);
//		s.sop(current.next);
		current.next=new SingleNode(data, current.next);
		size++;
	}
	public Object getNode(int index)
	{
        if(index <-1 || index >size-1)
        {
            s.sop("parameter is invalid");
        }
		indexAdjust(index);
		return current.getData();
	}
	public int size()
	{
		return this.size;
	}
}
