package binary.main;

import java.util.Random;
import java.util.Scanner;

/**
 * @author qiqi
 * @date 2019/12/13 0013
 */

public class Tree {
    private static Node root = new Node(45);
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int value = random.nextInt(100);
            System.out.print(value + " ");
            add(root, new Node(value));
        }
        System.out.println();
        while (true) {
            System.out.println("1:add | 2:delete | 3:print | other:exit：");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1 :
                    System.out.println("value:");
                    int addValue = sc.nextInt();
                    Node node = new Node(addValue);
                    add(root, node);
                    break;
                case 2:
                    System.out.println("value:");
                    int deleteValue = sc.nextInt();
                    delete(deleteValue);
                    break;
                case 3 :
                    System.out.print("pre: ");
                    prePrint(root);
                    System.out.println();
                    System.out.print("in:  ");
                    inPrint(root);
                    System.out.println();
                    break;
                default :
                    System.exit(0);
            }
        }
    }

    private static void add(Node parent, Node node) {
        if (node.getValue() < parent.getValue()) {
            if (parent.getLeft() == null) {
                parent.setLeft(node);
            } else {
                add(parent.getLeft(), node);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(node);
            } else {
                add(parent.getRight(), node);
            }
        }
    }

    private static void prePrint(Node node) {
        if (node.getLeft() != null) {
            prePrint(node.getLeft());
        }
        System.out.print(node.getValue() + " ");
        if (node.getRight() != null) {
            prePrint(node.getRight());
        }
    }

    private static void inPrint(Node node) {
        System.out.print(node.getValue() + " ");
        if (node.getLeft() != null) {
            inPrint(node.getLeft());
        }
        if (node.getRight() != null) {
            inPrint(node.getRight());
        }
    }

    private static void delete(Integer value) {
        boolean isLeft = true;
        Node parent = root;
        Node p = root;
        if (root.getValue().equals(value)) {
            Node right = root.getRight();
            root = root.getLeft();
            p = root;
            while (p.getRight() != null) {
                p = p.getRight();
            }
            p.setRight(right);
            prePrint(root);
            System.out.println();
            return;
        }
        while (!p.getValue().equals(value)) {
            parent = p;
            if (p.getValue() > value) {
                p = p.getLeft();
                isLeft = true;
            } else {
                p = p.getRight();
                isLeft = false;
            }
            if (p == null) {
                System.out.println("there is no value : " + value);
                return;
            }
        }
        if (p.getLeft() == null && p.getRight() == null) {
            if (isLeft) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (p.getLeft() != null && p.getRight() == null) {
            if (isLeft) {
                parent.setLeft(p.getLeft());
            } else {
                parent.setRight(p.getLeft());
            }
        } else if (p.getLeft() == null && p.getRight() != null) {
            if (isLeft) {
                parent.setLeft(p.getRight());
            } else {
                parent.setRight(p.getRight());
            }
        } else {
            Node right = p.getRight();
            Node left = p.getLeft();
            if (isLeft) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            p = left;
            while (p.getRight() != null) {
                p = p.getRight();
            }
            p.setRight(right);
        }
        prePrint(root);
        System.out.println();
    }
}
