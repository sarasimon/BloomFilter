package kATA;

import java.beans.PropertyChangeEvent;

public class ByteArrayDictionary extends Dictionary{

    ByteArrayWrapper byteArrayWrapper;
    int byteArraySize;
    int itsCellsFilled;
    int hashValuesPerWord = 2;

    public int cellsFilled()
    {
        return itsCellsFilled;
    }

    public ByteArrayDictionary()
    {
        itsCellsFilled = 0;
        byteArraySize = 1000;
        byteArrayWrapper = new ByteArrayWrapper(byteArraySize);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        addHashValues((String) evt.getNewValue());
    }

    public void addHashValues(String word) {
        for (long hashOfWord : hashValuesOf(word)) {
            if (byteArrayWrapper.isByteSetTo0(hashOfWord))
                byteArrayWrapper.setByteTo1(hashOfWord);
            itsCellsFilled++;
        }
    }

    public long[] hashValuesOf(String word) {
        long[] nHashValues = new long[hashValuesPerWord];
        MurmurHash murmurHash = MurmurHash.Singleton();

        for (int i = 0; i < hashValuesPerWord; i++) {
            nHashValues[i] = murmurHash.nthHash(word, i, byteArraySize);
        }
        return nHashValues;
    }

    public boolean existHashValues(String word) {
        for (long hashOfWord : hashValuesOf(word)) {
            if (byteArrayWrapper.isByteSetTo1(hashOfWord))
                return true;
        }
        return false;
    }
}
