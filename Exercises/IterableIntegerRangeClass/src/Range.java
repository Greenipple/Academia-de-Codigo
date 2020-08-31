import java.util.Iterator;

public class Range implements Iterable <Integer> {


    private int range;

    public Range(int range){
        this.range = range;
    }

    @Override
    public Iterator iterator(){
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator <Integer>{

        private int start = 5;

        @Override
        public boolean hasNext(){
            return start < range;
        }

        @Override
        public Integer next() {
            start++;
            return new Integer(start);
        }
    }

}
