package belousov.handlers;

import belousov.exeption.CommandExeption;
import belousov.logics.MyPrintToCommandLine;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandPrint implements CommandHandler {

    Pattern pattern;

    @Override
    public void handler(String command) throws CommandExeption {

        pattern = Pattern.compile("^(print)( +[\\d])? +([\\w]+[\\w.]*)$");

        if (!pattern.matcher(command).matches()) throw new CommandExeption("Команда print написана не верно");
        Scanner scanner = new Scanner(command);
        scanner.next();

        int lineNumber = 0;
        boolean hasLineNumber;
        hasLineNumber = scanner.hasNextInt();

        if (hasLineNumber == true){
            lineNumber = scanner.nextInt();
        }

        if(hasLineNumber && lineNumber == 0) throw new CommandExeption("Нулевой строки нет");
        String fileName = scanner.next();

        if (hasLineNumber == true) MyPrintToCommandLine.printToCommandlineToLine(fileName, lineNumber);
        else MyPrintToCommandLine.printToCommandline(fileName);
    }
}
