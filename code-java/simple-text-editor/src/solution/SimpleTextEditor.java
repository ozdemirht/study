package solution;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayDeque;

import java.util.Deque;
import java.util.LinkedList;


public class SimpleTextEditor {
    String buffer = "";
    static final boolean DEBUG = false;
    Deque<SimpleTextEditorOp> stack = new LinkedList<>(); //Tre ArrayDeque<>();
    public void
    append(String val){
        if(val==null||val.length()<1) return;
        //if(DEBUG) System.out.print("append("+val+") ["+buffer+"] ");
        buffer = buffer.concat(val);
        //if(DEBUG) System.out.println(" => ["+buffer+"]");
        stack.push(new SimpleTextEditorOp(2,val.length()));
    }

    public void
    delete(int k){
        if(k<1) return;
        //if(DEBUG) System.out.print("delete("+k+") ["+buffer+"] ");
        int d = Math.min(k,buffer.length());
        stack.push( new SimpleTextEditorOp(1,buffer.substring(buffer.length()-d)));
        buffer = buffer.substring(0,buffer.length()-d);
        //if(DEBUG) System.out.println(" => ["+buffer+"] ");
    }

    public void
    print(int k, BufferedWriter bufferedWriter) throws IOException {
        if( k<1 && k>buffer.length() ) return;
        System.out.println( buffer.charAt(k-1) );
        bufferedWriter.write( buffer.charAt(k-1) );
    }

    public void
    undo() {
        //if(DEBUG) System.out.print("undo("+buffer+") ");

        if( stack.peek()!=null ) {
            //if(DEBUG) System.err.print(buffer);
            execute((SimpleTextEditorOp)stack.pop());
            //if(DEBUG) System.err.println("=>"+buffer);
        } //else if(DEBUG)
          //  System.err.println("no-op");
        //if(DEBUG) System.out.println("undo("+buffer+") ");
    }

    private void
    execute(SimpleTextEditorOp op){
        if(op==null) return;
        if(DEBUG) System.out.print("execute("+op.getOpcode()+") ["+buffer+"] ");
        if(op.getOpcode()==1) { // undo delete
            buffer = buffer.concat(op.getStringData());
        } else if(op.getOpcode()==2) { // undo append
            int d = Math.min(op.getIntData(),buffer.length());
            buffer = buffer.substring(0,buffer.length()-d);
        }
        if(DEBUG) System.out.println(" => ["+buffer+"] ");
    }
}
