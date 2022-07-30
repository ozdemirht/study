package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHelper {

    public static List<QueueCommands> readFromStdio() throws IOException {
        List<QueueCommands> answer = new ArrayList<>();
        Scanner getInput = new Scanner(System.in);
        //System.out.println("Number of queries:"+);
        int numberOfQueries = getInput.nextInt();
        //System.out.println(numberOfQueries);
        for (int i = 0; i < numberOfQueries; i++) {
            int cmd = getInput.nextInt();
            if (cmd == 1) {
                answer.add(QueueCommands.buildEnqueue(getInput.nextInt()));
            } else if (cmd == 2)
                answer.add(QueueCommands.buildDequeue());
            else if (cmd == 3)
                answer.add(QueueCommands.buildPrintFront());
        }
        return answer;
    }
    public static List<QueueCommands> readFromFile(String fileName) throws IOException {
        List<QueueCommands> answer = new ArrayList<>();
        Scanner getInput = new Scanner(new FileReader(fileName));
        int numberOfQueries = getInput.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int cmd = getInput.nextInt();
            switch(cmd){
                case 1:
                    answer.add(QueueCommands.buildEnqueue(getInput.nextInt()));
                    break;
                case 2:
                    answer.add(QueueCommands.buildDequeue());
                    break;
                case 3:
                    answer.add(QueueCommands.buildPrintFront());
                    break;
                default:
            }
        }
        getInput.close();
        return answer;
    }


}
