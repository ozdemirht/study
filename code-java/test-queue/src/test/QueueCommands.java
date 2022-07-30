package test;

import jdk.nashorn.internal.objects.annotations.Getter;


public class QueueCommands {
    private int cmd=0;
    private int value = -1;

    protected QueueCommands(int cmd){
        this.cmd=cmd;
    }
    protected QueueCommands(int cmd, int value){
        this.cmd=cmd;
        this.value=value;
    }
    public int getCmd(){
        return this.cmd;
    }

    public int getValue() {
        return value;
    }

    public static QueueCommands buildEnqueue(int value){
        return new QueueCommands(1,value);
    }
    public static QueueCommands buildDequeue(){
        return new QueueCommands(2);
    }
    public static QueueCommands buildPrintFront(){
        return new QueueCommands(3);
    }
}
