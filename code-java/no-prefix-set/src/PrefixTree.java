public class PrefixTree {
    PrefixTreeNode root=new PrefixTreeNode();
    public PrefixTree() {}

    public boolean insertAndCheck(String word){
        PrefixTreeNode currentNode = root;
        PrefixTreeNode child = null;
        //
        //System.out.println("insertAndCheck("+word+")");
        for(Character aChar: word.toCharArray()){
            //System.out.println("current char="+aChar);
            child = currentNode.getChild(aChar-'a');
            if(child==null) { // create if not exist
                child = new PrefixTreeNode();
                currentNode.setChild(aChar-'a',child);
            }
            // return fast,
            if(child.getNumberOfWords()>0) return true;
            currentNode=child;
        }
        // end of word
        if(child!=null) {
            child.incrementNumberOfWords();
            if(child.hasChild()) return true;
        }
        return false;
    }
}
