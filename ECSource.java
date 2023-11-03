class Node<T> {
  T val;
  Node<T> next;

  public Node(T val) {
    this.val = val;
    this.next = null;
  }
}

class ECSource {
  public static <T> T getNodeValue(Node<T> head, int index) {
    // todo - note the return type, but don't overthink it

    for (int i = 0; i < index; i++) {
      if (head.next == null) {
        // must check b/c in following iteration
        // null.next does not exist, throws exception
        head = head.next;
        break;
      }
      head = head.next;
    }

    T value = head == null ? null : head.val;

    // if (head == null) {
    // value = null;
    // } else {
    // value = head.val;
    // }

    return value;
  }

  public static void main(String[] args) {
    Node<String> node1 = new Node<>("banana");
    Node<String> node2 = new Node<>("mango");
    Node<String> node3 = new Node<>("kiwi");

    node1.next = node2;
    node2.next = node3;

    // banana -> mango -> kiwi

    System.out.println(ECSource.getNodeValue(node1, 1));
    System.out.println(ECSource.getNodeValue(node1, 2));
    System.out.println(ECSource.getNodeValue(node1, 3));
    System.out.println(ECSource.getNodeValue(node1, 21));
    System.out.println(ECSource.getNodeValue(node1, 100));

    System.out.println("_________________________");

    Node<String> a = new Node<>("a");
    Node<String> b = new Node<>("b");
    Node<String> c = new Node<>("c");
    Node<String> d = new Node<>("d");

    a.next = b;
    b.next = c;
    c.next = d;

    // a -> b -> c -> d

    System.out.println(ECSource.getNodeValue(a, 7)); // null
  }
}