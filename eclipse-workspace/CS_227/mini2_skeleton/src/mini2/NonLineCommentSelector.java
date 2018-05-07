package mini2;

import api.Selector;

/**
 * Selector whose <code>select</code> method returns false for strings whose first non-whitespace
 * text is "//", and true for all other strings.
 */
public class NonLineCommentSelector implements Selector
{
    @Override
    public boolean select(String s) {
    	if (s.trim().length()==0)
    	{
    		return true;
    	}
    	else if (s.trim().length()>2)
    	{
    		s=s.trim();
    		if (s.substring(0, 2).equals("//"))
    		{
    			return false;
    		}
    		else
    		{
    			return true;
    		}
    	}
    	else
    	{
    		return true;
    	}
    	
    }
    // TODO
}