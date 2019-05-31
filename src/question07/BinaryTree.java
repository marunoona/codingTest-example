package question07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree {
    class Node{
        Node(int id, int x, int y){
            this.id = id;
            this.x = x;
            this.y = y;
        }
        int id;
        int x,y;
        Node left;
        Node right;
    };

    private int idx;
    private List<Node> Nodes = new ArrayList<Node>();

    Comparator<Node> Comp = new Comparator<Node>(){
        public int compare(Node a, Node b){
            if(a.y == b.y)
                return a.x - b.x;
            return b.y - a.y;
        }
    };

    private void addNode(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null)
                parent.left = child;
            else
                addNode(parent.left, child);
        }else{
            if(parent.right == null)
                parent.right = child;
            else
                addNode(parent.right, child);
        }
    }

    private void preorder(int[][] answer, Node node){
        if(node == null) return;

        answer[0][idx++] = node.id;
        preorder(answer, node.left);
        preorder(answer, node.right);
    }

    private void postorder(int[][] answer, Node node){
        if(node == null) return;

        postorder(answer, node.left);
        postorder(answer, node.right);
        answer[1][idx++] = node.id;
    }

    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length; //전체 노드 개수
        //노드 수 만큼 순회하면서 List에 노드 정보 저장
        for(int i = 0; i < size; i ++){
            Nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        //정렬 - y값이 제일 큰 순서대로 정렬, y값이 같으면 x값이 작은 순으로 정렬
        Nodes.sort(Comp);

        Node root = Nodes.get(0);
        for(int i = 1; i < size; i ++){
            addNode(root, Nodes.get(i));
        }

        int[][] answer = new int[2][size];
        //전위
        preorder(answer, root);
        idx = 0;
        //후위
        postorder(answer, root);
        return answer;
    }
}
