package test;

import org.junit.jupiter.api.Test;
import solution.IQueue;
import solution.QueueByDeque;


import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testQueueByDeque extends TestBase {
    @Test
    public void testConstructor(){
        IQueue<Integer> myQue = new QueueByDeque<>();
        assertEquals(true,myQue!=null);
    }
    @Test
    public void testEnqueue(){
        testEnqueue(new QueueByDeque<Integer>());
    }
    @Test
    public void testDequeue(){
        testDequeue(new QueueByDeque<Integer>());
    }

    @Test
    public void testInputFile() throws IOException {
        testInputFile(new QueueByDeque<Integer>(),"./test-input/testdata01.txt",2);
    }
}
