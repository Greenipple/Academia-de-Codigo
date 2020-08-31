public class TodoItem implements Comparable <TodoItem> {


    private int priority;
    private Importance importance;
    private String item;
    public TodoItem(Importance importance, int priority, String item ){
        this.importance = importance;
        this.priority = priority;
        this.item = item;
    }

    @Override
    public int compareTo(TodoItem item){
        return 1;
    }
    public enum Importance{
        HIGH,
        MEDIUM,
        LOW
    }
}
