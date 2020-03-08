package epamTraining.gitHubAndString;

public class GitHubAndStringWork {
    public void gitHubAndStringWork(){
        String str1 = "Какова длина этой строки?";
        String str2 = "какова длина этой Строки?";
        String str3 = "какова длина строки";
        String str4 = "Какова длина этой строчки?";
        String str6 = "Как найти символ а в строке?";
        String str7 = "Today is Sunday";
        String str8 = "Inc. Oracle";
        String str9 = "Java Developing";
        String str10 = "1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859606162636465666768697071727374757677787980818283848586878889909192";

        Tasks tasks = new Tasks();
        int lenth;//Переменная для записи длины строки
        lenth = tasks.getLengthString(str1);
        System.out.println("Получим длину строки. Задание 1");
        System.out.println("Длина строки= " + lenth);

        System.out.println("Сравним две строки без учета регистра. Задание 2");
        tasks.compareSrtingExcludingRegister(str1,str2);

        //Создадим новую строку с помощью конструктора и занесем ее в пул летиралов. 3 задание
        System.out.println("Создадим новую строку с помощью конструктора и занесем ее в пул летиралов. Задание 3");
        String str5 = new String("Строка, созданная с помощью конструктора").intern();//Проверяем есть ли такая строка
        // в пуле литералов. Если нет, то создаем строку и заносим строку в пул литералов, если есть, то новый объект создан не будет
        //и будет возвращена ссылка на строку из пула строк
        System.out.println(str5.intern());

        System.out.println("Массив символов, полученный из строки. Задание 4");
        tasks.getArrChar(str3);

        System.out.println("Массив байтов, полученный из строки. Задание 5");
        byte[] arrB;
        arrB = tasks.getByte(str4);
        for (int i = 0 ; i < arrB.length; i ++){
            System.out.print(arrB[i]);
        }
        System.out.println("\nПриведем строку к верхнему регистру. Задание 6");
        System.out.println(tasks.upperCaseStr(str3));

        System.out.println("Нахождение первой позиции символа в стоке. Задание 7\nИсходная строка\n" + str1);
        tasks.findFirstPositionSymbolInSrt(str1, 'а');

        System.out.println("Нахождение последней позиции символа в строке. Задание 8\nИсходная стока\n" + str6);
        tasks.findLastPositionSymbolInStr(str6, 'а');

        System.out.println("Проверка вхождения слова в строку. Задание 9\nИсходная стока\n" + str7);
        tasks.findSubStr(str7, "Sun");

        System.out.println("Проверка окончания строки на заданное слово. Задание 10\nИсходная строка\n" + str8);
        tasks.checkEndStr(str8, "Oracle");

        System.out.println("Начинается ли строка с заданного слова? Задание 11\nИсходная строка\n" + str9);
        tasks.checkStartStr(str9, "Java");

        System.out.println("Заменим все символы 'a' в строке на символ 'о'. Задание 12\nИсходная строка\n" + str6);
        System.out.println("Результирующая строка");
        tasks.replace(str6, 'а', 'о');

        System.out.println("Получим подстроку с 44 симовла по 90 символ. Задание 13");
        tasks.subString(str10,44,90);

        System.out.println("Разобъем строку по символу пробел (т.е. чтобы каждое слово было отдельным элементом массива). Задание 14\nИсходная строка\n" + str1);
        tasks.splitStr(str1);

        System.out.println("Поменяем последовательность символов в строке на обратуню. Задание 15\nИсходная строка\n" + str1);
        System.out.println("Полученная строка");
        System.out.println(tasks.reverseSequence(str1));
    }
}
