
public class Main {

    public static void main(String[] args) throws Exception {
        Comparator compare = new Comparator(){
            public boolean Compare(Food f1, Food f2){
                return f1.getName().length()>f2.getName().length();
            }
        };
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;

        for (String arg: args) {
            try {
                String[] parts = arg.split("/");
                if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                    if (parts.length == 1) {
                        System.out.println("Missing calories information");
                        breakfast[itemsSoFar] = new Cheese();
                    } else if (parts.length == 2) {
                        breakfast[itemsSoFar] = new Cheese(Integer.valueOf(parts[1]));
                    } else {
                       throw new IllegalArgumentException();
                    }
                } else if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                    if (parts.length == 1) {
                        System.out.println("Missing arguments");
                        breakfast[itemsSoFar] = new Apple();
                    } else if (parts.length == 2) {
                        System.out.println("Missing calories information");
                        breakfast[itemsSoFar] = new Apple(parts[1]);
                    } else if (parts.length == 3) {
                        breakfast[itemsSoFar] = new Apple(parts[1], Integer.valueOf(parts[2]));
                    } else {
                       throw new IllegalArgumentException();
                    }
                } else if (parts[0].equals("Sandwitch")) {
                    if (parts.length == 1) {
                        breakfast[itemsSoFar] = new Sandwitch();
                    } else if (parts.length == 4) {
                        breakfast[itemsSoFar] = new Sandwitch(new Components(parts[1], Integer.valueOf(parts[2])), new Components(parts[3], Integer.valueOf(parts[4])));
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (parts[0].charAt(0) == '-') {
                    if (parts[0].equals("-calories")) {
                        int calories = 0;
                        for (Food food: breakfast) {
                            if (food != null)
                                calories += food.GetCalories();
                            else break;

                        }
                    }
                    else if(parts[0].equals("-sort")) {
                    for(int i = 0; i<itemsSoFar; i++){
                       for(int j = 0; j<itemsSoFar-1; j++){
                           if(compare.Compare(breakfast[j], breakfast[j+1])){
                               Class tempfood = Class.forName(breakfast[j].getClass().getTypeName());
                               breakfast[j] =  Class.forName(breakfast[j+1].getClass().getTypeName());
                               breakfast[j] = breakfast[j+1]; //написать конструктор копирования
                               breakfast[j+1] = Class.forName(tempfood.getClass().getTypeName());
                               breakfast[j+1] = tempfood;
                           }
                       }
                    }
                    } else {
                    throw new NoSuchMethodException();
                    }
                    break;
                } else {
                    throw new ClassNotFoundException();
                }
// ... Продолжается анализ других продуктов для завтрака
                itemsSoFar++;
            }
            catch(ClassNotFoundException e){
                System.out.println("Class not found, the line was skipped");
                continue;
            }
            catch(NoSuchMethodException e){
                System.out.println("Method not found, please, check case of letters and names of admissible commands, the line was skipped");
                continue;
            }
            catch(IllegalArgumentException e){
                System.out.println("Unacceptable amount of arguments, the line was skipped");
                continue;
            }
        }
// Перебор всех элементов массива
        for (Food item: breakfast)
            if (item!=null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        System.out.println("Всего хорошего!");
    }
}
