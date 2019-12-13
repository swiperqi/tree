package binary.main;

import java.util.Random;

/**
 * @author qiqi
 * @date 2019/12/13 0013
 */

public class Node {
    private Node left;

    private Node right;

    private Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
    }
}
