import java.util.*;

public class Main {
    public static void main(String[] args) {

        BinNode<Integer> t15 = new BinNode<>(15);
        BinNode<Integer> t14 = new BinNode<>(14);
        BinNode<Integer> t9 = new BinNode<>(9);
        BinNode<Integer> t3 = new BinNode<>(3);
        t14.setLeft(t9);
        t14.setRight(t3);

        BinNode<Integer> t2 = new BinNode<>(2);
        BinNode<Integer> t1 = new BinNode<>(1);
        t1.setLeft(t3);
        t1.setRight(t2);

        BinNode<Integer> tree = new BinNode<>(t15, 3, t14);

        t1.display();
        tree.display();

        System.out.println(treeHeight(tree));
        System.out.println(isBalanced(tree));
        System.out.println(leafCount(tree));
        System.out.println(allIsIn(tree, t14));
        System.out.println(sequentialTreeN(t1, 3));
    }

    public static <T> int treeHeight(BinNode<T> t) {
        if (t == null)
            return -1;
        return 1 + Math.max(treeHeight(t.getLeft()), treeHeight(t.getRight()));
    }

    public static boolean isBalanced(BinNode<Integer> t) {
        if (t == null)
            return true;
        if (Math.abs(treeHeight(t.getLeft()) - treeHeight(t.getRight())) > 1)
            return false;
        return isBalanced(t.getLeft()) && isBalanced(t.getRight());
    }

    public static int leafCount(BinNode<Integer> t) {
        if (t == null)
            return 0;
        if (!t.hasLeft() && !t.hasRight())
            return 1;
        return leafCount(t.getLeft()) + leafCount(t.getRight());
    }

    public static boolean isIn(BinNode<Integer> t, int a) {
        if (t == null)
            return false;
        if (t.getValue() == a)
            return true;
        return isIn(t.getLeft(), a) || isIn(t.getRight(), a);
    }

    public static boolean allIsIn(BinNode<Integer> t1, BinNode<Integer> t2) {
        if (t2 == null)
            return true;
        if (!isIn(t1, t2.getValue()))
            return false;
        return allIsIn(t1, t2.getLeft()) && allIsIn(t1, t2.getRight());
    }

    public static int nodeCount(BinNode<Integer> t) {
        if (t == null)
            return 0;
        return 1 + nodeCount(t.getLeft()) + nodeCount(t.getRight());
    }

    public static int isInCount(BinNode<Integer> t, int a) {
        if (t == null)
            return 0;
        int count = (t.getValue() == a) ? 1 : 0;
        return count + isInCount(t.getLeft(), a) + isInCount(t.getRight(), a);
    }

    public static boolean sequentialTreeN(BinNode<Integer> t, int n) {
        if (nodeCount(t) != n)
            return false;

        for (int i = 1; i <= n; i++) {
            if (isInCount(t, i) != 1)
                return false;
        }
        return true;
    }
}
