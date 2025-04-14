
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root, sb);
        return sb.toString();
    }

    public void sHelper(TreeNode curr, StringBuilder sb) {
        //if its null we add N, as a marker
        if(curr == null) {
            sb.append("N,");
        } else {
            //otherwise we add the value + a ,
            sb.append(Integer.toString(curr.val));
            sb.append(",");
            //recursively do same on subtress
            sHelper(curr.left, sb);
            sHelper(curr.right, sb);
        }
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //tokenize and call helper func
        return dHelper(data.split(","));
    }
    int i = 0;
    public TreeNode dHelper(String [] toks) {

        if(i >= toks.length || toks[i].equals("N")) {
            //if we are at an N its null
            i++;
            return null;
        } else {
            //if we are at a value we parse it
            TreeNode curr = new TreeNode(Integer.parseInt(toks[i]));
            //move up one on the token list
            i++;
            //recursively do the same on subtrees
            curr.left = dHelper(toks);
            curr.right = dHelper(toks);
            
            //store solution
            return curr;
        }

    }
}
