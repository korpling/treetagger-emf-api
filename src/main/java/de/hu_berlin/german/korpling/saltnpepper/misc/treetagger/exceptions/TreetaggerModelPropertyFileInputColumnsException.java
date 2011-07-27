package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions;

public class TreetaggerModelPropertyFileInputColumnsException extends TreetaggerModelPropertyFileException {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -7623804990096902481L;

	public TreetaggerModelPropertyFileInputColumnsException()
	{ super(); }
	
    public TreetaggerModelPropertyFileInputColumnsException(String s)
    { super(s); }
    
	public TreetaggerModelPropertyFileInputColumnsException(String s, Throwable ex)
	{
		super(s + " Nested Exception is: "+ ex.getMessage()+ ".", ex); 
	}
	
}
