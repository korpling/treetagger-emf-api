package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions;

public class TreetaggerException extends java.lang.RuntimeException {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 6280817240391210746L;
	public TreetaggerException()
	{ super(); }
	
    public TreetaggerException(String s)
    { super(s); }
    
	public TreetaggerException(String s, Throwable ex)
	{super(s, ex); }
}
