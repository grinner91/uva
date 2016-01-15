import java.util.*;

/**
 * Created by zaman on 14/01/16.
 *
 * 101 - The Blocks Problem solution
 *
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=37
 *
 */


class Main_101_Block {

    class BlockInfo{
        public int blockStackIndex = -1;
        public int blockPosition = -1;
    }

    private ArrayList<ArrayList<Integer>> blocks = new ArrayList<ArrayList<Integer>>();
    private int  blockCount = 0;


    private  BlockInfo getBlockInfo(int block)
    {
        BlockInfo blockInfo = new BlockInfo();

        for(int i = 0; i < blockCount; i++)
        {
            if(blocks.get(i).contains(block))
            {
                blockInfo.blockPosition = i;
                blockInfo.blockStackIndex = blocks.get(i).indexOf(block);
                break;
            }
        }
        return blockInfo;
    }

    private  void returnBlocksToInitPositionFrom(int block)
    {
        int  tempBlock, tempSize;

        BlockInfo binfo = getBlockInfo(block);

        int len = blocks.get(binfo.blockPosition).size();

        List<Integer> blockStack = blocks.get(binfo.blockPosition);

        List<Integer> removeList = new ArrayList<Integer>();

        for(int i = len - 1; i > binfo.blockStackIndex; i-- ) {

            tempBlock =  blockStack.get(i);

            blocks.get(tempBlock).add(tempBlock);

            removeList.add(tempBlock);
        }

        blockStack.removeAll(removeList);
    }

    private  void stackBlockToNewPosition( int blockA, int blockB)
    {

        BlockInfo bA = getBlockInfo(blockA);
        BlockInfo bB = getBlockInfo(blockB);

        blocks.get(bA.blockPosition).remove(bA.blockStackIndex);

        blocks.get(bB.blockPosition).add(blockA);

    }

    private   void pileBlocksNewPosition(int blockA, int blockB)
    {

        BlockInfo bA = getBlockInfo(blockA);
        BlockInfo bB = getBlockInfo(blockB);

        List<Integer> list = blocks.get(bA.blockPosition);

        List<Integer> removeList = new ArrayList<Integer>();

        int len = blocks.get(bA.blockPosition).size();

        for(int i = bA.blockStackIndex; i <  len; i++)
        {
            removeList.add(list.get(i).intValue());
        }

        blocks.get(bB.blockPosition).addAll(removeList);

        blocks.get(bA.blockPosition).removeAll(removeList);
    }


    private  void moveOnto(int blockA, int blockB)
    {
        returnBlocksToInitPositionFrom(blockA);

        returnBlocksToInitPositionFrom(blockB);

        stackBlockToNewPosition(blockA,blockB);
    }

    private  void moveOver(int blockA, int blockB)
    {
        returnBlocksToInitPositionFrom(blockA);

        stackBlockToNewPosition(blockA,blockB);
    }

    private void pileOnto(int blockA, int blockB)
    {
        returnBlocksToInitPositionFrom(blockB);

        pileBlocksNewPosition(blockA, blockB);
    }

    private void pileOver(int blockA, int blockB)
    {
        pileBlocksNewPosition( blockA, blockB);
    }

    public void solve()
    {
        Scanner scanner = new Scanner(System.in);

        blockCount = scanner.nextInt();
        scanner.nextLine(); // empty line


        //initial block positions
        for(int pos = 0; pos < blockCount; pos++)
        {
            blocks.add(new ArrayList<Integer>());
            blocks.get(pos).add(pos);
        }

        int blockA, blockB, tempBlock, tempSize;
        String command, instructOne, instructTwo;
        StringTokenizer tokenizer;

        while (true) {

            command = scanner.nextLine();
            if(command.equals("quit")) break;

            tokenizer = new StringTokenizer(command);

            instructOne = tokenizer.nextToken();
            blockA = Integer.parseInt(tokenizer.nextToken());

            instructTwo = tokenizer.nextToken();
            blockB = Integer.parseInt(tokenizer.nextToken());

            BlockInfo bA = getBlockInfo(blockA);
            BlockInfo bB = getBlockInfo(blockB);

            if(blockA == blockB || bA.blockPosition == bB.blockPosition) continue;

            if("move".equals(instructOne) && "onto".equals(instructTwo) )
                moveOnto(blockA,blockB);
            else if("move".equals(instructOne) && "over".equals(instructTwo))
                moveOver(blockA,blockB);
            else if("pile".equals(instructOne) && "onto".equals(instructTwo))
                pileOnto(blockA,blockB);
            else if("pile".equals(instructOne) && "over".equals(instructTwo))
                pileOver(blockA,blockB);

        }

        StringBuilder strbuilder;

        for(int i = 0; i < blockCount; i++)
        {
            strbuilder = new StringBuilder();
            strbuilder.append(""+i+":");

            int len = blocks.get(i).size();

            for(int j = 0 ; j < len; j++) {

                strbuilder.append(" "+blocks.get(i).get(j));
            }

            System.out.println(strbuilder.toString());
        }
    }

    public  static  void main(String[] args) {

        new Main_101_Block().solve();

    }

}


/*

 Sample Input

10
move 9 onto 1
move 8 over 1
move 7 over 1
move 6 over 1
pile 8 over 6
pile 8 over 5
move 2 over 1
move 4 over 9
quit

Sample Output

 0: 0
 1: 1 9 2 4
 2:
 3: 3
 4:
 5: 5 8 7 6
 6:
 7:
 8:
 9:



 */
