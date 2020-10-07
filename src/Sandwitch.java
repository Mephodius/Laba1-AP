public class Sandwitch extends Food{
    private Object component1;
    private Object component2;

    public Sandwitch() {
        super();
        this.component1=null;
        this.component2=null;
    }
    public Sandwitch(Components component1, Components component2){
        super();
        this.component1 = new Components(component1);
        this.component2 = new Components(component2);
        this.calories = component1.calories+component2.calories;
    }
    @Override
    public void consume() {
        ((Food)this).consume();
        this.component1 = null;
        this.component2 = null;
    }
    public String GetName(){
        return new String(name+" with "+((Food)component1).getName()+" and "+((Food)component2).getName());
    }
    @Override
    public void CalculateCalories() {
        ((Food)this).CalculateCalories();
    }
    public boolean equals(Object obj){
        if(obj instanceof Sandwitch){
            if(((Sandwitch) obj).component1!=null&&((Sandwitch) obj).component2!=null&&((Sandwitch) obj).component1.equals(this.component1)&&((Sandwitch) obj).component2.equals(this.component2)){
                return true;
            }
        }
        return false;
    }
}
