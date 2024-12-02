package yandexalgo6.week4.D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/yandexalgo6/week4/D/input.txt"));
        String line;

        BinarySearchTree bst = new BinarySearchTree();

        while ((line = reader.readLine()) != null) {
            String[] split = line.split(" ");
            switch (split[0]) {
                case "ADD":
                    int addValue = Integer.parseInt(split[1]);
                    System.out.println(bst.add(addValue));
                    break;
                case "SEARCH":
                    int searchValue = Integer.parseInt(split[1]);
                    System.out.println(bst.search(searchValue));
                    break;
                case "PRINTTREE":
                    bst.print();
                    break;
            }
        }
        reader.close();
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public String add(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return "DONE";
        }
        return addRecursive(root, value);
    }

    public String search(int value) {
        return searchRecursive(root, value) ? "YES" : "NO";
    }

    public void print() {
        printTree(root, 0);
    }

    private String addRecursive(TreeNode curr, int value) {
        if (value == curr.value) {
            return "ALREADY";
        }
        if (value < curr.value) {
            if (curr.left == null) {
                curr.left = new TreeNode(value);
                return "DONE";
            }
            return addRecursive(curr.left, value);
        } else {
            if (curr.right == null) {
                curr.right = new TreeNode(value);
                return "DONE";
            }
            return addRecursive(curr.right, value);
        }
    }

    private boolean searchRecursive(TreeNode curr, int value) {
        if (curr == null) {
            return false;
        }
        if (value == curr.value) {
            return true;
        }
        return value < curr.value ? searchRecursive(curr.left, value) : searchRecursive(curr.right, value);
    }

    private void printTree(TreeNode node, int depth) {
        if (node != null) {
            printTree(node.left, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print(".");
            }
            System.out.println(node.value);
            printTree(node.right, depth + 1);
        }
    }
}