package test;

import org.junit.jupiter.api.Test;
import solution.IQueue;
import solution.QueueBySinglyList;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestBase {
    void testEnqueue(IQueue<Integer> myQue){
        myQue.enqueue(1);
        assertEquals(1,myQue.peek());
    }
    void testDequeue(IQueue<Integer> myQue){
        myQue.enqueue(1);
        myQue.dequeue();
        assertEquals(0,myQue.size());
    }
    void testPeek(IQueue<Integer> myQue){
        myQue.enqueue(1);
        myQue.enqueue(2);
        myQue.enqueue(3);
        assertEquals(1,myQue.peek());
    }
    void testCmdsOnQue(IQueue<Integer> myQue, List<QueueCommands> cmds, int expectedFinalSize, PrintStream out)  {
        for(QueueCommands acmd: cmds) {
            if(acmd.getCmd()==1) myQue.enqueue(acmd.getValue());
            else if(acmd.getCmd()==2) myQue.dequeue();
            else out.println(myQue.peek());
        }
        assertEquals(expectedFinalSize,myQue.size());
    }
    void testInputFile(IQueue<Integer> myQue, String fileName, int expectedFinalSize) throws IOException {
        List<QueueCommands> cmds = TestHelper.readFromFile(fileName);
        testCmdsOnQue(myQue,cmds,expectedFinalSize,System.out);
    }
}
