package eu.codeacademy.taskGenericAdvance;

import eu.codeacademy.taskGenericAdvance.service.TreeService;
import eu.codeacademy.taskGenericAdvance.tree.Tree;
import eu.codeacademy.taskGenericAdvance.tree.conifers.ChristmasTree;
import eu.codeacademy.taskGenericAdvance.tree.conifers.Conifer;
import eu.codeacademy.taskGenericAdvance.tree.conifers.JuniperTree;
import eu.codeacademy.taskGenericAdvance.tree.conifers.PineTree;
import eu.codeacademy.taskGenericAdvance.tree.leaf.Birch;
import eu.codeacademy.taskGenericAdvance.tree.leaf.OakTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTreeApp {
    public static void main(String[] args) {
        TreeService treeService = new TreeService();

        List<Tree> treeList = new ArrayList<>(Arrays.asList(
                new OakTree(),
                new Conifer(),
                new ChristmasTree(),
                new Birch()
        ));

        List<Conifer> coniferList = new ArrayList<>(Arrays.asList(
                new JuniperTree(),
                new PineTree(),
                new ChristmasTree()
        ));

        List<OakTree> oakTreeList = new ArrayList<>(Arrays.asList(
                new OakTree(),
                new OakTree()
        ));

        treeService.anyTreeForest(treeList);

        treeService.conifersTreeForest(coniferList);

        treeService.oakTreeForest(oakTreeList);


    }
}
