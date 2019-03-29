// ArrayList class

public class ArrayList<T> implements List<T>
{
    private T[] arr;
    private int size;
    private int max_size;

    public ArrayList()
    {
        this.size = 0;
        this.max_size = 10;
        arr = (T[]) new Object[10]; // as per assignment specification
    }

    public void add(T item)
    {
        if (size == max_size)
        {
            growArr();
            max_size *= 2;
        }
        
        arr[size] = item;
        size++;
    }

    public void add(int pos, T item)
    {
        if (size == max_size)
        {
            growArr();
            max_size *= 2;
        }

        for (int i = size; i > pos; i--)
        {
            arr[i] = arr[i - 1];
        }

        arr[pos] = item;
        size++;
    }

    public T get(int pos)
    {
        if(pos < 0 || pos > size)
        {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }

        T data = arr[pos];
        return data;
    }

    public T remove(int pos)
    {
        if (pos < 0)
        {
            throw new ArrayIndexOutOfBoundsException("out of bounds");
        }

        T removed = arr[pos];

        for (int i = pos + 1; i < size; i++)
        {
            arr[i - 1] = arr[i];
        }
        
        size--;
        return removed;
    }

    public int size()
    {
        return this.size;
    }

    public void growArr()
    {
        T[] temp = (T[]) new Object[arr.length * 2];

        for(int i = 0; i < size; i++)
        {
            temp[i] = arr[i];
        }

        arr = temp;
    }
}