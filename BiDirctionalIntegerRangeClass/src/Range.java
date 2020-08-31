import java.util.Iterator;

public class Range implements Iterable <Integer> {

    private int start =5;
    private int range;
    private boolean growing = true;

    public Range(int range){
        this.range = range;
    }

    @Override
    public Iterator iterator(){
        if(growing){
            return new Iterator() {
                // private int start = 5;

                @Override
                public boolean hasNext() {
                    return start < range;
                }

                @Override
                public Integer next() {
                    start++;
                    System.out.println("going up");
                    return new Integer(start);
                }
            };

        }
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return start<range;
            }

            @Override
            public Integer next() {
                range--;
                System.out.println("going down");
                return range;
            }
        };
    }


    public void setGrowing(boolean growing) {
        this.growing = growing;
    }
}
