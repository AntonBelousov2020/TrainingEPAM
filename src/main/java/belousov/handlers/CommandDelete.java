package belousov.handlers;

import belousov.exeption.CommandExeption;
import belousov.logics.MyReadFromFile;
import belousov.logics.MyWriteToFile;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandDelete implements CommandHandler {

    Pattern pattern;

    /**
     * This realise handle with regular expression and logic for delete command
     *
     * @param command - input delete command
     * @throws CommandExeption - in case command delete write with some mistakes
     *                         or in case if number line for delete not exist
     */
    @Override
    public void handler(String command) throws CommandExeption {

        pattern = Pattern.compile("^(delete)( +[\\d]*)? +([\\w]+[\\w.]*)$");

        if (!pattern.matcher(command).matches()) {
            throw new CommandExeption("Команда delete введена не верно");
        }

        Scanner scanner = new Scanner(command);
        scanner.next();

        int numberLineToDelete = 1;
        boolean hasNumberLine = scanner.hasNextInt();

        if (hasNumberLine == true) {
            numberLineToDelete = scanner.nextInt();
        }

        String fileName = scanner.next();
        List<String> lines = MyReadFromFile.parseFile(fileName);

        if (hasNumberLine == true) {
            if (numberLineToDelete > lines.size())
                throw new CommandExeption("Строка не может быть удалена, нет такого номера строки");
            lines.remove(numberLineToDelete - 1);
        } else {
            lines.remove(lines.size() - 1);
        }
        MyWriteToFile.myWriteToFile(fileName, lines);
    }
}
