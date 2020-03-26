package belousov.exeption;

public class CommandExeption extends RuntimeException {

    /**
     * Construct a CommandExeption with exeption message
     *
     * @param message that could be logged and analysed
     */
    public CommandExeption(String message) {
        super(message);
    }
}
