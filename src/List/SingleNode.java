package List;

public class SingleNode
{
	public SingleNode next=null;
	public Object data;
	//especially for head node
	public SingleNode(SingleNode next)
	{
		this.next=next;
	}
	public SingleNode(Object data, SingleNode next)
	{
		this.data=data;
		this.next=next;
	}
	public Object getData()
	{
		return this.data;
	}
}
