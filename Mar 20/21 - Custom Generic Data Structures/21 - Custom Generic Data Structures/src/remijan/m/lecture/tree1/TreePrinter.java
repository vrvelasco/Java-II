package remijan.m.lecture.tree1;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreePrinter {

    public void print(DefaultTreeModel model) {
        DefaultMutableTreeNode root = 
            (DefaultMutableTreeNode)model.getRoot();
        
        print(0, root);
        System.out.printf("%n");
    }
    
    private void print(int level, DefaultMutableTreeNode node) {
        String indent = new String(new char[level]).replace('\0', ' ');
        System.out.printf("%s* %s%n", indent, node.toString());
        
        if (!node.isLeaf()) {
            Enumeration children = node.children();
            while (children.hasMoreElements()) {
                DefaultMutableTreeNode child = 
                    (DefaultMutableTreeNode) children.nextElement();
                print(level + 4, child);
            }
        }
    } 
    
    
}
