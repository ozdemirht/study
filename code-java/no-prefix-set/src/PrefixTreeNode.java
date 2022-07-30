public class PrefixTreeNode {
    private int numberOfWords = 0;
    private PrefixTreeNode[] childs = new PrefixTreeNode[10];

    PrefixTreeNode(){}

    public int getNumberOfWords() {
        return numberOfWords;
    }
    public void incrementNumberOfWords() {
       numberOfWords++;
    }
    public PrefixTreeNode getChild(int i){
        if (i>=0 && i<childs.length) return childs[i];
        else return null;
    }
    public void setChild(int i, PrefixTreeNode aChild){
        if (i>=0 && i<childs.length) childs[i]=aChild;
    }
    public boolean hasChild(){
        boolean answer = false;
        for(int i=0;!answer && i<childs.length;i++)
            answer=(childs[i]!=null);
        return answer;
    }
}
