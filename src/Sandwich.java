public class Sandwich extends Food{
    private Object component1;
    private Object component2;

    public Sandwich() {
        super();
        this.component1=null;
        this.component2=null;
    }
    public Sandwich(Components component1, Components component2){
        super();
        this.component1 = new Components(component1);
        this.component2 = new Components(component2);
        this.calories = component1.calories+component2.calories;
        this.name = "Sandwich with "+((Food)component1).getName()+" and "+((Food)component2).getName();
    }
    @Override
    public void consume() {
        super.consume();
        ((Food)component1).consume();
        ((Food)component2).consume();
    }
    public String GetName(){
        return new String(name+" with "+((Food)component1).getName()+" and "+((Food)component2).getName());
    }
    @Override
    public void CalculateCalories() {
        ((Food)this).CalculateCalories();
    }
    public boolean equals(Object obj){
        if(obj instanceof Sandwich){
            if(((Sandwich) obj).component1!=null&&((Sandwich) obj).component2!=null&&((Sandwich) obj).component1.equals(this.component1)&&((Sandwich) obj).component2.equals(this.component2)){
                return true;
            }
        }
        return false;
    }
}
