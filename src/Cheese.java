public class Cheese extends Food {
    public Cheese() {
        super();
    }
    public Cheese(int calories){
        this.calories = calories;
    }
    public void consume() {
        super.consume();
    }

    @Override
    public void CalculateCalories() {
        ((Food)this).CalculateCalories();
    }

// Переопределять метод equals() в данном классе не нужно, т.к. он
// не добавляет новых полей данных, а сравнение по внутреннему полю name
// уже реализовано в базовом классе
// Переопределять метод toString() в данном классе не нужно, т.к. он
// не добавляет внутренних полей данных, а возврат поля name уже
// реализован в версии toString() базового класса
}
