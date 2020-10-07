public abstract class Food implements Consumable, Nutritious{
    protected String name;
    protected int calories;
    public Food() {
        this.name = this.getClass().getName();
        this.calories=0;
    }
    public Food(String name){
        this.name = name;
    }
    public Food(int calories){
        this.calories = calories;
    }
    public Food(String name, int calories){
        this.calories = calories;
        this.name = name;
    }
    public void consume(){
        System.out.println("An object "+this.getName()+" was consumed");
        this.name = null;
        this.calories = 0;
    }
    public void CalculateCalories(){
        System.out.println("The amount of calories in "+this.name+" is "+this.calories);
    }
    public int GetCalories(){
        return calories;
    }
    public String GetName(){
        return name;
    }
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name==null || ((Food)arg0).name==null) return false; // Шаг 2
        return name.equals(((Food)arg0).name); // Шаг 3
    }
    public String toString() {
        return name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
// Реализация метода consume() удалена из базового класса Food
// Это можно сделать, потому что сам Food - абстрактный
}
