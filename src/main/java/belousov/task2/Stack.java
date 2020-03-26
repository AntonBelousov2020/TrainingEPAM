package belousov.task2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stack {

    /**
     * This method try to get StackOverflowError with recursive
     *
     * @throws StackOverflowError in case of stack be overflow
     */
    public void stackOwerFlow() throws StackOverflowError {
        try {
            stackOwerFlow();
        } catch (StackOverflowError e) {
            log.error("Ошибка " + e.toString());
            System.exit(-1);
        }
    }
}
