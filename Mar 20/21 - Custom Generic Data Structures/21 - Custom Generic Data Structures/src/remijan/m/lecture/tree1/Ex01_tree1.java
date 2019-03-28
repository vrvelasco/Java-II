package remijan.m.lecture.tree1;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Ex01_tree1 {
    public static void main(String[] args) {
        
        DefaultMutableTreeNode root
            = new DefaultMutableTreeNode("root");
        
        DefaultTreeModel tree
            = new DefaultTreeModel(root);
        
        TreePrinter printer = new TreePrinter();
        System.out.printf("-- tree with just a root --%n");
        printer.print(tree);
        
        // let's add some children to the root    
        root.add(new DefaultMutableTreeNode("Rita Red"));
        root.add(new DefaultMutableTreeNode("Oscar Orange"));
        root.add(new DefaultMutableTreeNode("Yet Yellow"));
        System.out.printf("-- tree with children --%n");
        printer.print(tree);
        
        
        // let's add some grand children to the root  
        DefaultMutableTreeNode oscar
            = (DefaultMutableTreeNode)root.getChildAt(1);
        oscar.add(new DefaultMutableTreeNode("Gary Green"));
        oscar.add(new DefaultMutableTreeNode("Betty Blue"));
        oscar.add(new DefaultMutableTreeNode("Ivan Indigo"));
        oscar.add(new DefaultMutableTreeNode("Vivian Violet"));
        System.out.printf("-- tree with grand-children --%n");
        printer.print(tree);
    }
}
