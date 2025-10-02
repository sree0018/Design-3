package sree;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> st;
    NestedInteger nextEl;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.st = new Stack<>();
        st.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextEl.getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()){
            if(!st.peek().hasNext()){
                st.pop();
                nextEl = null;
            }else{
                nextEl = st.peek().next();
                if(nextEl.isInteger()){
                    return true;
                }else{
                    st.push(nextEl.getList().iterator());
                }
            }
        }
        return false;
    }
}