/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.misc.treetagger.tokenizer;

/**
 * Contains the text overlaped by a token and its range in the origin text by a left and a 
 * right position.
 * @author Florian Zipser
 *
 */
public class Token
{
	public String text=null;
	public Integer start= null;
	public Integer end= null;
	
	public Token()
	{}
	
	public Token(String text, Integer start, Integer end)
	{
		this.text= text;
		this.start= start;
		this.end= end;
	}
	
	public String toString()
	{
		String retVal= "";
		retVal=text;
		return(retVal);
	}
	/**
	 * Two Token objects a and b are equal if a.text.equals(b.text) && a.left==b.left && a.right==b.right.  
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this== obj)
			return(true);
		else
		{
			if (!(obj instanceof Token))
				return(false);
			else
			{
				Token other= (Token) obj;
				if (this.text!= null)
				{
					if (!this.text.equals(other.text))
						return(false);
				}
				else
				{
					if (other.text!= null)
						return(false);
				}
				if (this.start.hashCode()!= other.start.hashCode())
					return(false);
				if (this.end.hashCode()!= other.end.hashCode())
					return(false);
			}
		}
		return(true);
	}
}
