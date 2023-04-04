package eu.codeacademy.taskGenericAdvance.tree.leaf;

import eu.codeacademy.taskGenericAdvance.tree.Tree;

public class LeafThrough implements Tree {
    @Override
    public void have() {
        System.out.println("we are LEAF TREE");
    }
}
