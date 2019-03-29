// LinkedList

public class LinkedList<T> implements List<T>
{
    private Node<T> head;
    private int size;

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public int size()
    {
        return this.size;
    }

    public void add(T item)
    {
        if (this.head == null)
        {
            Node<T> newNode = new Node(item);
            head = newNode;
        }
        else
        {
            Node<T> curr = head;
            while(curr.getNext() != null)
            {
                curr = curr.getNext();
            }

            Node<T> node = new Node(item);
            curr.setNext(node);
        }

        this.size++;
    }

    public void add(int pos, T item) // overloading to add at position
    {
        Assert.not_false(pos >= 0 && pos < size);

        if(pos == 0) // addding to head
        {
            Node<T> n = new Node(item);
            n.setNext(head);
            head = n;
            size++;
        }
        else
        {
            Node<T> n = new Node(item);
            Node prev = head;

            for (int i = 0; i < pos - 1; i++)
            {
                prev = prev.getNext();
            }
            n.setNext(prev.getNext());
            prev.next = n;
            ++size;
        }
    }

    public T remove(int pos)
    {
        Assert.not_false(pos < 0 && pos > size);
        Node<T> curr = head;

        if (pos == 0) // adding to head
        {
            head = head.getNext();
            this.size--;
            return curr.getData();
        }

        for (int i = 0; i < pos - 1; i++)
        {
            curr = curr.getNext();
        }

        Node<T> update = curr.getNext();
        curr.setNext(update.getNext());
        --size;
        return update.getData();
    }

    public T get(int pos)
    {
        Assert.not_false(pos < 0 && pos > size);
        Node<T> n = head;

        for (int i = 0; i < pos; i++)
        {
            n = n.getNext();
        }

        return n.getData();
    }
}