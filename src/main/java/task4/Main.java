package task4;

import task4.Tree.Tree;
import task4.Tree.TreeImplBuilder;
import task4.Tree.TreeType;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Tree> trees = new LinkedList<>();
    TreeImplBuilder treeImplBuilder = new TreeImplBuilder();

    // creating new object
    trees.add(treeImplBuilder.build());

    // adding reference of already created object
    trees.add(treeImplBuilder.build());

    // creating new pine tree
    trees.add(treeImplBuilder.setType(TreeType.PINE).build());

    // adding reference of already created object
    trees.add(treeImplBuilder.build());

    // checking if setting width to default won't create new object
    trees.add(treeImplBuilder.setWidth(100).build());

    System.out.println(trees);
    System.out.println("Number of objects created: " + TreeImplBuilder.getTreeCreatedCounter());
    System.out.println("Number of references in list: " + trees.size());
  }
}
