package belousov.handlers;

import belousov.exeption.CommandExeption;

public interface CommandHandler {

    void handler(String command) throws CommandExeption;
}
