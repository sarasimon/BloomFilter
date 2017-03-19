package kATA;

public class ByteArrayWrapper {

    byte[] byteArray;
    int itsSize;

    public ByteArrayWrapper(int size)
    {
        byteArray = new byte[size];
        itsSize = size;
    }

    public void setByteTo1(long index)
    {
        if(indexInBounds(index))
            byteArray[(int)index] = 1;
    }

    public boolean isByteSetTo0(long index) {
        return getByte(index) == 0;
    }

    public boolean isByteSetTo1(long index) {
        return getByte(index) == 1;
    }

    private int getByte(long index)
    {
        if(indexInBounds(index))
            return byteArray[(int)index];
        return 0;
    }

    private boolean indexInBounds(long index)
    {
        return index < itsSize;
    }


}
