package question07;

import java.util.Arrays;

public class BinaryTreeMain {
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        BinaryTree binaryTree = new BinaryTree();
        int[][] result = binaryTree.solution(nodeinfo);
        System.out.println(Arrays.deepToString(result));
    }
}
