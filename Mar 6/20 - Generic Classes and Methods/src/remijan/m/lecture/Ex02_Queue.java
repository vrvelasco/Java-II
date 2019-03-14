package remijan.m.lecture;

public class Ex02_Queue {

    public static void main(String[] args) {
        {
            Queue<Integer> queue
                = new Queue<>();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            System.out.printf("Size: %d%n", queue.size());

            Integer peek = queue.peek();
            System.out.printf("Peek: %d%n", peek);
            System.out.printf("Size: %d%n", queue.size());

            Integer pop = queue.dequeue();
            System.out.printf("Pop: %d%n", pop);
            System.out.printf("Size: %d%n", queue.size());
        }

        System.out.printf("%n");
        {
            Queue<Name> queue
                = new Queue<>();
            queue.enqueue(new Name("Rita Red"));
            queue.enqueue(new Name("Oscar Orange"));
            queue.enqueue(new Name("Yet Yellow"));

            System.out.printf("Size: %d%n", queue.size());

            Name peek = queue.peek();
            System.out.printf("Peek: %s%n", String.valueOf(peek));
            System.out.printf("Size: %d%n", queue.size());

            Name pop = queue.dequeue();
            System.out.printf("Pop: %s%n", String.valueOf(pop));
            System.out.printf("Size: %d%n", queue.size());
        }
    }
}
