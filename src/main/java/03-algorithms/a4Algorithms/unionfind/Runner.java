package a4Algorithms.unionfind;

public class Runner {
    public static void main(String[] args) {
        runQuickFind(new AQuickFind(10));
        //runQuickUnion(new QuickUnion(10));
    }

    private static void runQuickUnion(BQuickUnion unionFind) {
         /*
                1     4     3
               / \         / \
             2    5       8   9
            / \
           6   7
       */
         GraphUtility.graph1(unionFind);

        //1-2-5-6-7  3-8-9  4
        //GraphUtility.graph2(unionFind);

        // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 -- 9 -- 10
        //GraphUtility.worstCaseQuickUnion(unionFind);

        //GraphUtility.disconnectedComponents(unionFind);
        //GraphUtility.bestCase(unionFind);
        //GraphUtility.selfUnion(unionFind);
        //GraphUtility.singleElement(unionFind);
    }

    private static void runQuickFind(AQuickFind unionFind) {
        /*
                1     4     3    0
               / \         / \
             2    5       8   9
            / \
           6   7
       */
         GraphUtility.graph1(unionFind);

        //1-2-5-6-7  3-8-9  4
        //GraphUtility.graph2(unionFind);

        // 1 -- 2 -- 3 -- 4 -- 5 -- 6 -- 7 -- 8 -- 9 -- 10
        //GraphUtility.worstCase(unionFind);

        //GraphUtility.disconnectedComponents(unionFind);
        //GraphUtility.bestCase(unionFind);
        //GraphUtility.selfUnion(unionFind);
        //GraphUtility.singleElement(unionFind);
    }
}
