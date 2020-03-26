package belousov.handlers;

import belousov.exeption.CommandExeption;

public interface CommandHandler {
    /**
     * This template for some realise handler in some classes
     *
     * @param command - input some command
     * @throws CommandExeption - in case some command write with wrong
     */
    void handler(String command) throws CommandExeption;
}
