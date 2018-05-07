package mini2;

import api.Combiner;

/**
 * Adds the length of the given string to the accumulator
 * and returns the result.
 */
public class LengthCombiner implements Combiner<Integer>
{
    @Override
    public Integer combine(Integer obj, String s) {
        obj = obj + s.length();
        return obj;
    }
}
