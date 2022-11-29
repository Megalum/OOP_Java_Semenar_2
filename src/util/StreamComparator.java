package util;

import data.Flow;

public interface StreamComparator {
    public boolean comparison(Flow flowFirst, Flow flowSecond);
}
