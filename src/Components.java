public class Components extends Food{
    public Components(Components component){
        this.name = component.name;
        this.calories = component.calories;
    }
    public Components(String name, int calories){
        super(name, calories);
    }
    public Components(){
        super();
    }
    @Override
    public void consume() {
        System.out.println("An object "+this.name+" was consumed");
        this.name = null;
        this.calories = 0;
    }
    @Override
    public void CalculateCalories() {
        ((Food)this).CalculateCalories();
    }
    public boolean equals(Object obj){
        if(obj instanceof Components){
            if(((Components) obj).name!=null&&((Components) obj).name.equals(this.name)&&this.calories==((Components) obj).calories){
                return true;
            }
        }
        return false;
    }
}
