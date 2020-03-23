package belousov.task2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stack {

    public void stackOwerFlow() throws StackOverflowError {
        try {
            stackOwerFlow();
        } catch (StackOverflowError e) {
            log.error("Ошибка " + e.toString());
            System.exit(-1);
        }
    }
}
