package stacks_and_queues;

import java.util.Stack;

public class QueueUsingTwoStacksSolution {

    static class Queue {

        /*
        6 (Num of queries)
        1 22 (enqueue 22)
        1 23 (enqueue 23)
        2 (dequeue)
        3 (print front of queue) = 23
        1 24 (enqueue 24)
        2 (dequeue)

        Push 22
        Tail stack =
        |22|

        Push 23
        Tail stack =
        |23|
        |22|

        Dequeue
        Pop tail stack onto head stack =

        Tail stack =
        | |

        Head stack =
        |22|
        |23|

        Pop head stack = |22|

        Head stack =
        |23|

        Print head stack = |23|

        Pop head stack back onto tail stack =

        Head stack =
        | |

        Tail stack =
        |23|

        Push 24
        Tail stack =
        |24|
        |23|

        Dequeue
        Pop tail stack onto head stack =

        Tail stack =
        | |

        Head stack =
        |23|
        |24|
         */

        public Queue() {
        }

        public Integer frontOfQueue = null;

        public Stack<Integer> tail = new Stack<>();
        public Stack<Integer> head = new Stack<>();

        public void enqueue(int data) {
            if(frontOfQueue == null) {
                frontOfQueue = data;
            }
            tail.push(data);
        }

        // O(N + N) time complexity
        public int dequeue() {
            // O(N)
            while (!tail.empty()) {
                head.push(tail.pop());
            }
            int front = head.pop();

            if(!head.empty()) {
                frontOfQueue = head.peek();
            } else {
                frontOfQueue = null;
            }

            // O(N)
            while (!head.empty()) {
                tail.push(head.pop());
            }

            return front;
        }

        // O(1) time complexity
        public int print() {
            return frontOfQueue;
        }

    }

    private static Queue queue = new Queue();

    public static void main(String[] args) {
        queue.enqueue(22);
        queue.enqueue(23);
        System.out.println(queue.dequeue());
        System.out.println(queue.print());
        queue.enqueue(24);
        System.out.println(queue.dequeue());
        System.out.println(queue.print());
        System.out.println(queue.dequeue());
    }

}
