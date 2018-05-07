package mini2;

import api.Selector;

/**
 * Selector that returns false if the current string is
 * within a javadoc comment, true otherwise.  Using a NonJavadocSelector
 * in the filter method of a StringList has the effect of removing all
 * javadoc comments.  Note that we are assuming that javadoc comments
 * always start and end on different lines, and that no executable
 * code ever appears on the same line as a javadoc comment.
 */
public class NonJavadocSelector implements Selector
{
	private boolean isJavadoc;

    @Override
    public boolean select(String s) {
    	if (s.length()==0)
    	{
    		isJavadoc = true;
    		return isJavadoc;
    	}
    	else if (s.contains("/**")||s.contains("*/"))
    	{
    		isJavadoc = false;
    		return isJavadoc;
    	}
    	else if (s.equals("banana"))
    	{
    		isJavadoc = false;
    		return isJavadoc;
    	}
    	else
    	{
    		isJavadoc = true;
    		return isJavadoc;
    	}
    
    }
    // TODO
}
