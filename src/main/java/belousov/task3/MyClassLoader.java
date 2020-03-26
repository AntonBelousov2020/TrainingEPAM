package belousov.task3;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader(String path) {
        super();
        classPath = path;
    }

    /**
     * This method find necessary file with byte code
     *
     * @param className - name file with byte code
     * @return string with class name
     * @throws ClassNotFoundException in case of not found file with byte code
     */
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] bytes = fetchClassFromFS(classPath + className + ".class");
            return defineClass(className, bytes, 0, bytes.length);
        } catch (IOException e) {
            log.error(e.getMessage());
            return super.findClass(className);
        }
    }

    /**
     * This method get size class from file system
     *
     * @param path - input path to byte code file
     * @return array of bytes into file
     * @throws IOException - in case file value so big
     */
    private byte[] fetchClassFromFS(String path) throws IOException {
        InputStream inputStream = new FileInputStream(new File(path));
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            throw new IOException("Слишком большой файл");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead = inputStream.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Файл не может быть полностью прочитан " + path);
        }
        inputStream.close();
        return bytes;
    }
}
