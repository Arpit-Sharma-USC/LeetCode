/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec{
    public String serialize(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        my_serialize(sb,root);
        return sb.toString();
    }
    private void my_serialize(StringBuilder sb, TreeNode root)
    {
        if(root==null)
            sb.append("null,");
        else
        {
            sb.append(root.val).append(",");
            my_serialize(sb,root.left);
            my_serialize(sb,root.right);
        }
        
    }
    
    public TreeNode deserialize(String data){
        Queue<String> myQ = new LinkedList<>();
        myQ.addAll(Arrays.asList(data.split(",")));
        return my_deserialize(myQ);
        
    }
    private TreeNode my_deserialize(Queue<String> myQ)
    {
        String val = myQ.remove();
        if(val.equals("null"))
            return null;
       else
       {   
           TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left=my_deserialize(myQ);
            root.right=my_deserialize(myQ);
            return root;
        }
    }
    
    
}

