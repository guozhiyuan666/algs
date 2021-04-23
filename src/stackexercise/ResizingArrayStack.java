package stackexercise;
public class ResizingArrayStack <Item>
{
    private int N;
    Item[] a = (Item[])new Object[1]; //?
    private void resize(int max)
    {
        Item[] temp = (Item[])new Object[max];
        for(int i = 0; i < N; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item)
    {
        if(N == a.length)
        {
            resize(a.length * 2);
        }
        a[N++] = item;
    }
    public Item pop()
    {   if(N != 0)
        {
            Item item = a[--N];
            a[N] = null;
            if(N > 0 && N == a.length / 4) {
                resize(a.length / 2);
            }
            return item;
        }else {
            return null;
        }

    }
    public int size()
    {
        return N;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }

}

