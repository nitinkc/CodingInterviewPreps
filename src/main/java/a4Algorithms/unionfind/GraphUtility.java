package a4Algorithms.unionfind;

public class GraphUtility {

    public static void graph1(IUnionFind unionFind) {
        //        1     4     3
        //       / \         / \
        //     2    5       8   9
        //    / \
        //   6   7
        unionFind.union(1, 2);
        unionFind.union(1, 5);
        unionFind.union(2, 6);
        unionFind.union(2, 7);
        unionFind.union(3, 8);
        unionFind.union(3, 9);

        System.out.println("isConnected(1, 7) :: " + unionFind.isConnected(1, 7));//true
        System.out.println("isConnected(1, 9) :: " + unionFind.isConnected(1, 9));//false

        System.out.println("union(1, 3)");
        unionFind.union(1, 3);
        System.out.println("find(8) :: " + unionFind.find(8));

    }

    public static void graph2(IUnionFind unionFind) {
        //1-2-5-6-7  3-8-9  4
        unionFind.union(1, 2);
        unionFind.union(2, 5);
        unionFind.union(5, 6);
        unionFind.union(6, 7);
        unionFind.union(3, 8);
        unionFind.union(8, 9);

        System.out.println("isConnected(1, 5) :: "+ unionFind.isConnected(1, 5));//true
        System.out.println("isConnected(5, 8) :: " + unionFind.isConnected(5, 8));//false

        //1-2-5-6-7 3-8-9-4
        unionFind.union(9, 4);
        System.out.println("Finding root of 4 :: " + unionFind.find(4));
    }

    // Example demonstrating a sequence of union operations leading to a tall tree structure.
    public static void worstCase(IUnionFind unionFind) {
        // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 -- 9 -- 10
        connectGraph(unionFind);

        System.out.println("isConnected(1, 9) :: " + unionFind.isConnected(1, 9)); // true
        System.out.println("find(9) :: " + unionFind.find(9)); // should return the root of the set containing 1
    }

    public static void worstCaseQuickUnion(BQuickUnion unionFind) {
        // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 -- 9
        connectGraph(unionFind);

        System.out.println("isConnected(1, 9) :: " + unionFind.isConnected(1, 9)); // true
        System.out.println("find(9) :: " + unionFind.findWithPrint(9)); // should return the root of the set containing 1
    }

    private static void connectGraph(IUnionFind unionFind) {
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(3, 4);
        unionFind.union(4, 5);
        unionFind.union(5, 6);
        unionFind.union(6, 7);
        unionFind.union(7, 8);
        unionFind.union(8, 9);
    }

    // Example demonstrating union-find operations on a single element.
    // Example demonstrating union-find operations on a single element:
    public static void singleElement(IUnionFind unionFind) {
        // Initially: 1
        System.out.println("isConnected(1, 2) :: " + unionFind.isConnected(1, 2)); // false
        unionFind.union(1, 2); // Union(1, 2): Connects node 1 to node 2.
        System.out.println("isConnected(1, 2) :: " + unionFind.isConnected(1, 2)); // true
        System.out.println("find(2) :: " + unionFind.find(2)); // should return the root of the set containing 1
    }


    // Example demonstrating union-find operations on initially disconnected components.
    // Example demonstrating union-find operations on initially disconnected components:
    public static void disconnectedComponents(IUnionFind unionFind) {
        // Initially:
        // 1 -- 2      3 -- 4
        unionFind.union(1, 2); // Union(1, 2): Connects node 1 to node 2.
        unionFind.union(3, 4); // Union(3, 4): Connects node 3 to node 4.

        // Queries to check connectivity
        System.out.println("isConnected(1, 3) :: " + unionFind.isConnected(1, 3)); // false
        unionFind.union(1, 3); // Union(1, 3): Merges the sets containing nodes 1 and 2 with the set containing nodes 3 and 4.
        System.out.println("isConnected(1, 3) :: " + unionFind.isConnected(1, 3)); // true
        System.out.println("find(4) :: " + unionFind.find(4)); // should return the root of the set containing 3
    }

    // Example demonstrating a sequence of union operations resulting in a well-balanced tree structure:
    public static void bestCase(IUnionFind unionFind) {
        // 1 -- 2 -- 3 -- 4
        unionFind.union(1, 2);
        unionFind.union(3, 4);
        unionFind.union(1, 3);
        unionFind.union(2, 4);

        // Queries to check connectivity
        System.out.println("isConnected(1, 4) :: " + unionFind.isConnected(1, 4)); // true
        System.out.println("isConnected(2, 3) :: " + unionFind.isConnected(2, 3)); // true
        System.out.println("find(4) :: " + unionFind.find(4)); // should return the root of the set containing 1 or 3
    }

    // Example demonstrating a union operation on the same element:
    public static void selfUnion(IUnionFind unionFind) {
        // Initially: 1
        unionFind.union(1, 1); // Union(1, 1): No effect, since it's a self-union.
        System.out.println("isConnected(1, 1) :: " + unionFind.isConnected(1, 1)); // true
    }
}
