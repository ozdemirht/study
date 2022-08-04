package solution;

public class SimpleTextEditorOp {
    int opcode;
    int intData;
    String stringData;

    SimpleTextEditorOp(int opcode){
        this.opcode = opcode;
    }
    SimpleTextEditorOp(int opcode, int intData){
        this(opcode);
        this.intData = intData;
    }
    SimpleTextEditorOp(int opcode, String stringData){
        this(opcode);
        this.stringData = stringData;
    }
    public int getOpcode() { return opcode; }
    public int getIntData() { return intData; }
    public String getStringData() { return stringData; }

}
