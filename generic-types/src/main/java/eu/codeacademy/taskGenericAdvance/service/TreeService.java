package eu.codeacademy.taskGenericAdvance.service;

import eu.codeacademy.taskGenericAdvance.tree.Tree;
import eu.codeacademy.taskGenericAdvance.tree.conifers.Conifer;
import eu.codeacademy.taskGenericAdvance.tree.leaf.OakTree;


import java.util.List;

public class TreeService {

    public void anyTreeForest(List<? extends Tree> treeList){
        System.out.println("This is MIX tree <-<-<-<-<");
        for (int i = 0; i < treeList.size(); i++) {
            treeList.get(i).have();
        }
    }

    public void conifersTreeForest(List<? extends Conifer> conifers){
        System.out.println("This is Conifers tree forest <-<-<-<-<");
        for (int i = 0; i < conifers.size(); i++) {
            conifers.get(i).have();
        }
    }

    public void oakTreeForest(List<OakTree> oakTrees){
        System.out.println("This is Oak Tree forest <-<-<-<-<");
        for (int i = 0; i < oakTrees.size(); i++) {
            oakTrees.get(i).have();
        }
    }
}
