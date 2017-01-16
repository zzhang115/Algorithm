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
	public SingleNode(int data, SingleNode next)
	{
		this.data=data;
		this.next=next;
	}
	public SingleNode getNext()
	{
		return this.next;
	}
	public void setNext(SingleNode node)
	{
		this.next=node;
	}
	public String display()
	{
		return this.data+" ";
	}
	
}
