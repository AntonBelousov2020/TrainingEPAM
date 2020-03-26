package belousov.handlers;

import belousov.exeption.CommandExeption;

public class CommandExit implements CommandHandler {

    /**
     * This method realise handle for exit command
     *
     * @param command - input exit command
     * @throws CommandExeption - in case exit command write with some mistakes
     */
    @Override
    public void handler(String command) throws CommandExeption {
        System.exit(0);
    }
}
