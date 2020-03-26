package belousov;

import belousov.exeption.CommandExeption;
import belousov.filter.Filter;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class Main {

    /**
     * This method realise main logic. In this method accept input command and call method execute
     *
     * @param args entry argument
     */
    public static void main(String[] args) {
        System.out.println("Для выхода введите \"exit\"");
        Scanner scanner = new Scanner(System.in);
        String command;
        Filter filter = new Filter();

        while (true) {
            System.out.println("Введите команду\n");

            try {
                command = scanner.nextLine();
                filter.execute(command);
            } catch (CommandExeption e) {
                log.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
