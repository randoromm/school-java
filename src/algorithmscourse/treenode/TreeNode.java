import java.util.*;

/**
 * Algorithm to convert left parenthetic representation of a Tree into right parenthetic representation.
 */
public class TreeNode {

    private String name;
    private TreeNode firstChild;
    private TreeNode nextSibling;

    TreeNode(String n, TreeNode d, TreeNode r) {
        this.name = n;
        this.firstChild = d;
        this.nextSibling = r;
    }

    /**
     * Natuke abi sain siit: https://stackoverflow.com/questions/19330731/tree-implementation-in-java-root-parents-and-children
     */
    public static TreeNode parsePrefix(String s) {
        if (s.contains("\t")) throw new RuntimeException("Input " + s + " contains tab char.");
        if (s.contains("()")) throw new RuntimeException("Input " + s + " contains an empty subtree.");
        if (s.contains(",,")) throw new RuntimeException("Input " + s + " contains double commas.");
        if (s.contains("((")) throw new RuntimeException("Input " + s + " contains double brackets.");
        if (s.contains(" ")) throw new RuntimeException("Input " + s + " contains a space.");
        if (s.length() == 0) throw new RuntimeException("Input " + s + " is empty.");
        else if (s.contains(")(")) throw new RuntimeException("Input " + s + " must contain a node between brackets");
        if (s.contains(",") && !(s.contains("(") && s.contains(")")))
            throw new RuntimeException("Input " + s + " contains more than 1 root");

        String arr[] = s.split("");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = new TreeNode(null, null, null);
        boolean multipleRoots = false;

        for(int i = 0; i < arr.length; i++) {
            String str = arr[i].trim();
            switch (arr[i]) {
                case "(":
                    if (multipleRoots) throw new RuntimeException("Input " + s + " contains multiple roots.");
                    stack.push(currentNode);
                    currentNode.firstChild = new TreeNode(null, null, null);
                    currentNode = currentNode.firstChild;
                    if (arr[i+1].trim().equals(","))
                        throw new RuntimeException("Input " + s + " contains comma after bracket.");
                    break;
                case ")":
                    if (stack.isEmpty()) throw new RuntimeException("String is faulty: " + s + " Fault is: " + arr[i]);
                    currentNode = stack.pop();
                    if (stack.size() == 0) multipleRoots = true;
                    break;
                case ",":
                    if (multipleRoots) throw new RuntimeException("Input " + s + " contains multiple roots.");
                    currentNode.nextSibling = new TreeNode(null, null, null);
                    currentNode = currentNode.nextSibling;
                    break;
                default:
                    if (currentNode.name == null) {
                        currentNode.name = str;
                    } else {
                        if (arr[i -1 ].trim().equals(")")) throw new RuntimeException("Siblings must be separated with comma in string: " + s);
                        currentNode.name += str;
                    }
                    break;
            }
        }
        return currentNode;  // TODO!!! return the root
    }

    public String rightParentheticRepresentation() {
        StringBuffer b = new StringBuffer();
        if (firstChild != null) {
            b.append("(");
            b.append(firstChild.rightParentheticRepresentation());
            b.append(")");
        }
        if (nextSibling != null) {
            b.append(name);
            b.append(",");
            b.append(nextSibling.rightParentheticRepresentation());
        } else {
            b.append(name);
        }
        return b.toString();
    }

    public static void main(String[] param) {
        //String s = "A(B1,v(uuu)k,D)";
        //String s = "A(B1,v(uu)(gg,D)";
        String s = "A(B1,C,D)";
        TreeNode t = TreeNode.parsePrefix(s);
        String v = t.rightParentheticRepresentation();
        System.out.println (s + " ==> " + v); // A(B1,C,D) ==> (B1,C,D)A
    }
}