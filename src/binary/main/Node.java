package binary.main;

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
}
