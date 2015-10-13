import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cameronoakley on 10/12/15.
 */
public class ToDo {
    public static void main(String[] args) {
        ArrayList<ToDoItem> todos = new ArrayList<>();//creating arraylist, sequential and dynamic
        Scanner scanner = new Scanner(System.in);

        while (true) {//creating loop,
            int todoNum = 1;
            for (ToDoItem todo : todos) {
                String checkbox = "[ ]";
                if (todo.isDone){
                    checkbox = "[X]";
                }
                String line = String.format("%d. %s %s", todoNum, checkbox, todo.text);
                System.out.println(line );
                todoNum++;
            }
            System.out.println("Options:");
            System.out.println("[1] Create todo");
            System.out.println("[2] Mark todo as done or not done");

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1) {
                System.out.println("Type a todo and hit enter");
                String todo = scanner.nextLine();
                ToDoItem item = new ToDoItem(todo);
                todos.add(item);
            }
            else if (optionNum == 2) {
                System.out.println("Type the number of the todo you want to toggle");
                String select = scanner.nextLine();
                try {
                    int selectNum = Integer.valueOf(select);
                    ToDoItem item = todos.get(selectNum - 1);//
                    item.isDone = !item.isDone;
                } catch (Exception e ){
                    System.out.println("An error occurred.");
                }
            }
            else {
                System.out.println("Invalid number");
            }
        }
    }
}

