package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions;

public class TreetaggerModelException extends RuntimeException {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -1919048874244922109L;

	public TreetaggerModelException()
	{ super(); }
	
    public TreetaggerModelException(String s)
    { super(s); }
    
	public TreetaggerModelException(String s, Throwable ex)
	{
		super(s + " Nested Exception is: "+ ex.getMessage()+ ".", ex); 
	}
	
}
