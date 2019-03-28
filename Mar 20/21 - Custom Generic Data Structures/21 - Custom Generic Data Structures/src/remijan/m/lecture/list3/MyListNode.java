package remijan.m.lecture.list3;

public class MyListNode<T> {

    T data;
    MyListNode<T> next;
    MyListNode<T> previous;

    MyListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public MyListNode<T> getNext() {
        return next;
    }

    public MyListNode<T> getPrevious() {
        return previous;
    }
}
