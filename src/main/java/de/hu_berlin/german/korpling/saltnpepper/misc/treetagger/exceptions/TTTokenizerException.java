package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.exceptions;

public class TTTokenizerException extends TreetaggerException
{
	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 6230817240391210746L;
	public TTTokenizerException()
	{ super(); }
	
    public TTTokenizerException(String s)
    { super(s); }
    
	public TTTokenizerException(String s, Throwable ex)
	{super(s, ex); }
}
