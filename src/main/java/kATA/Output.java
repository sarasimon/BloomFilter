package kATA;

public abstract class Output {

	public abstract void enterWordReaderMessage();

	public void lookForWordMessage()
	{
		System.out.println("Enter word you are looking for: ");
	}

	public void wordFoundMessage() {
		System.out.println("This word might be in the dictionary ");
	}

	public void wordNotFoundMessage() {
		System.out.println("Word not found! ");
	}
}
