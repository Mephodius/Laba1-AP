import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception
    {
        Comparator compare = new Comparator() {
            @Override
            public int compare(Object o, Object o2) {
                if(o==null) {
                    return 1;
                }else if (o2==null){
                    return -1;
                } else {
                   if(((Food)o).getName().length()>((Food)o2).getName().length()){
                       return 1;
                   } else if(((Food)o).getName().length()<((Food)o2).getName().length()){
                       return -1;
                   } else{
                       return 0;
                   }
                }

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
                } else if (parts[0].equals("Sandwich")) {
                    if (parts.length == 1) {
                        breakfast[itemsSoFar] = new Sandwich();
                    } else if (parts.length == 5) {
                        breakfast[itemsSoFar] = new Sandwich(new Components(parts[1], Integer.valueOf(parts[2])), new Components(parts[3], Integer.valueOf(parts[4])));
                    } else {
                        System.out.println("Length "+parts.length);
                        throw new IllegalArgumentException();
                    }
                } else if (parts[0].charAt(0) == '-') {
                    if (parts[0].equals("-calories")) {
                        int calories = 0;
                        for (Food food: breakfast) {
                            if (food != null)
                                calories += food.GetCalories();
                            else
                                break;
                        }
                        System.out.println("There is "+calories+" calories in your breakfast");

                    }
                    else if(parts[0].equals("-sort")) {
                           Arrays.sort(breakfast, compare);
                        System.out.println("Food was sorted");
                    } else if(parts[0].equals("-show")) {
                        for(Food food:breakfast){
                            if (food != null)
                            System.out.println(food.getName());
                        }
                    }
                    else{
                    throw new NoSuchMethodException();
                    }
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
            if (item!=null) {
                item.consume();
            }
// Если элемент не null – употребить продукт
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        System.out.println("Всего хорошего!");
    }
}
