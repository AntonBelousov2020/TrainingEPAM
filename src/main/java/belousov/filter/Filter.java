package belousov.filter;

import belousov.exeption.CommandExeption;
import belousov.handlers.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

@Slf4j
public class Filter {

    HashMap<String, Commands> stringCommandsHashMap;
    HashMap<Commands, CommandHandler> commandsCommandHandlerHashMap;
    Pattern pattern;

    public Filter() {

        pattern = Pattern.compile("(\\b(add|print|delete)\\b *[\\d]* *([\\w]+[\\w.]*) *(\"[\\w ]*\")?)|(exit)");

        stringCommandsHashMap = new HashMap<>();
        stringCommandsHashMap.put("add", Commands.ADD);
        stringCommandsHashMap.put("print", Commands.PRINT);
        stringCommandsHashMap.put("delete", Commands.DELETE);
        stringCommandsHashMap.put("exit", Commands.EXIT);

        commandsCommandHandlerHashMap = new HashMap<>();
        commandsCommandHandlerHashMap.put(Commands.ADD, new CommandAdd());
        commandsCommandHandlerHashMap.put(Commands.PRINT, new CommandPrint());
        commandsCommandHandlerHashMap.put(Commands.DELETE, new CommandDelete());
        commandsCommandHandlerHashMap.put(Commands.EXIT, new CommandExit());
    }

    /**
     * This method call handler with special command
     *
     * @param command - input some command
     * @throws CommandExeption - in case some command write with some mistakes
     */
    public void execute(String command) throws CommandExeption {

        if (pattern.matcher(command).matches()) {

            System.out.println("Команда распознана");
            Scanner scanner = new Scanner(command);
            scanner.useDelimiter(" ");
            Commands commands = stringCommandsHashMap.get(scanner.next());
            commandsCommandHandlerHashMap.get(commands).handler(command);
        } else {
            throw new CommandExeption("Команда не распознана");
        }
    }
}
