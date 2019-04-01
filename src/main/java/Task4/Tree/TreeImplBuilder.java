package Task4.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeImplBuilder {
    private static final int DEFAULT_WIDTH = 100;
    private static final TreeType DEFAULT_TYPE = TreeType.SPRUCE;

    private static final Map<TreeType, Map<Integer, Tree>> treeCache = new HashMap<>();
    private static final AtomicInteger treeCreatedCounter = new AtomicInteger(0);

    private int width = DEFAULT_WIDTH;
    private TreeType type = DEFAULT_TYPE;

    public TreeImplBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public TreeImplBuilder setType(TreeType type) {
        this.type = type;
        return this;
    }

    public Tree build() {
        Map<Integer, Tree> nestedCachedMap = treeCache.get(type);
        if (nestedCachedMap != null) {
            Tree tree = nestedCachedMap.get(width);
            if (tree != null) {
                return tree;
            }
        }

        System.out.println("Creating new tree");
        treeCreatedCounter.addAndGet(1);
        return treeCache
                .computeIfAbsent(type, v -> new HashMap<>())
                .computeIfAbsent(width, v -> new TreeImpl(width, type));
    }

    public static AtomicInteger getTreeCreatedCounter() {
        return treeCreatedCounter;
    }
}