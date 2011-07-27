package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions;

public class TreetaggerModelPropertyFileException extends TreetaggerModelException {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 3513337071375145970L;

	public TreetaggerModelPropertyFileException()
	{ super(); }
	
    public TreetaggerModelPropertyFileException(String s)
    { super(s); }
    
	public TreetaggerModelPropertyFileException(String s, Throwable ex)
	{
		super(s + " Nested Exception is: "+ ex.getMessage()+ ".", ex); 
	}
	
}
