public class Node<T>
{
    protected T data;
    protected Node next;

    public Node(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return this.data;
    }

    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}