package remijan.m.lecture.list1;

public class MyListNode<T> {

    T data;
    MyListNode<T> next;

    MyListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public MyListNode<T> getNext() {
        return next;
    }
}
