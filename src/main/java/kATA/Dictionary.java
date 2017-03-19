package kATA;

public abstract class Dictionary implements WordReaderListener{

	abstract boolean existHashValues(String word);

	public abstract void addHashValues(String word);
}
