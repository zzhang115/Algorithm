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
		if(index==0)
			current=head;
		indexAdjust(index-1);
		SingleNode newnode=new SingleNode(data, current.next);
		SingleNode end;
		end=current.next;
		current.next=newnode;
		newnode.next=end;
		size++;
	}
	public void delete(int index)
	{
		s.sop("current "+current.getData());
		if(index > size-1 || index<0)
			{s.sop("parameter is invalid!");return;}
		if(index==0)
			current=head;
		indexAdjust(index-1);
		SingleNode mid,end;
		mid=current.next;
		end=mid.next;
		current.next=end;
		size--;
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
