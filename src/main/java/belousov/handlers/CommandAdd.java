package belousov.handlers;

import belousov.exeption.CommandExeption;
import belousov.logics.MyReadFromFile;
import belousov.logics.MyWriteToFile;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandAdd implements CommandHandler {

    Pattern pattern;

    /**
     * This method realise handle with regular expression and logic for add command
     *
     * @param command - input add command
     * @throws CommandExeption - in case command add write with some mistakes
     */
    @Override
    public void handler(String command) throws CommandExeption {

        pattern = Pattern.compile("^(add)( +[\\d]*)? ([\\w]+[\\w.]*) +(\"[\\w ]*\")?$");

        if (!pattern.matcher(command).matches()) {
            throw new CommandExeption("Команда add написана не верно");
        }

        Scanner scanner = new Scanner(command);
        scanner.next();

        int numberLine = 0;
        boolean hasNumberLine = scanner.hasNextInt();

        if (hasNumberLine == true) {
            numberLine = scanner.nextInt();
        }

        String fileName = scanner.next();
        String txt = scanner.findInLine("\"[\\w ]*\"");
        txt = txt.replace("\"", "");
        List<String> lines = MyReadFromFile.parseFile(fileName);

        if (hasNumberLine == true) {
            for (int i = lines.size(); i < numberLine - 1; i++) {
                lines.add("");
            }

            lines.add(numberLine - 1, txt);
        } else {
            lines.add(txt);
        }

        MyWriteToFile.myWriteToFile(fileName, lines);
    }
}
