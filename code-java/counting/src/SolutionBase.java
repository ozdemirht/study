public abstract class SolutionBase implements ISolution {
    String name = "SolutionBase";

    @Override
    public final String getName() {
        return name;
    }

    final void setName(String name){
        this.name = name;
    }
}
