package belousov.handlers;

import belousov.exeption.CommandExeption;

public class CommandExit implements CommandHandler{

    @Override
    public void handler(String command) throws CommandExeption {
        System.exit(0);
    }
}
