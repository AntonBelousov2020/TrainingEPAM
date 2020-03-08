package epamTraining.gitHubAndString;

public class Tasks {
    private String string1, string2;
    public Tasks(){

    }

    public Tasks(String str1){
        this.string1 = str1;
    }

    public Tasks(String str1, String str2){
        this.string1 = str1;
        this.string2 = str2;
    }

    public String getString1() {
        return string1;
    }

    public String getString2(){
        return string2;
    }

    public int getLengthString(String str1){//Получаем длину строки. 1 задание
        int length = 0;
        length = str1.length();
        return length;
    }

    public void compareSrtingExcludingRegister(String str1, String str2){//Сравниваем две строки без учета регистра. 2 задание
        int check;
        check = str1.compareToIgnoreCase(str2);
        //System.out.println(check);
        if (check == 0) System.out.println("Строки одинаковые без учета регистра");
        else if (check > 0) System.out.println("Строки не равны. Строка1 больше строки2");
        else System.out.println("Строки не равны. Строка1 меньше строки2");
    }

    public char[] getArrChar(String str1){//Получение из строки массива символов. 4 задание
        char[] arrCh;
        arrCh = str1.toCharArray();
        for (int i = 0; i < arrCh.length; i++){
            System.out.print(arrCh[i]);
        }
        System.out.println();
        return arrCh;
    }

    public byte[] getByte(String str1){//Получение из строки массива байтов. 5 задание
        byte[] arrB;
        arrB = str1.getBytes();
        return arrB;
    }

    public String upperCaseStr(String str1){//Приведение строки к верхнему регистру. 6 задание
        String upperStr;
        upperStr = str1.toUpperCase();
        return upperStr;
    }

    public void findFirstPositionSymbolInSrt(String srt1, char symbol){//Находим первое вхождение символа в строку. 7 задание
        int index = srt1.indexOf(symbol);
        if (index == -1) System.out.println("Символ не найден");
        else System.out.println("Первая позиция символа " + "'" + symbol + "'" + " в строке: " + (index + 1));
    }

    public void findLastPositionSymbolInStr(String str1, char symbol){//Нахождение последнией позиции символа в строке. 8 задание
        int index = str1.lastIndexOf(symbol);
        if (index == -1) System.out.println("Симовл не найден");
        else System.out.println("Последняя позиция символа " + "'" + symbol + "'" + " в строке: " + (index + 1));
    }

    public void findSubStr(String str1, String str2){//Проверим содержит ли строка слово. 9 задание
        int index = str1.indexOf(str2);
        if (index == -1) System.out.println("Нет такого слова в стоке");
        else System.out.println("Строка содержит слово " + str2);
    }

    public void checkEndStr(String str1,String str2){//Проверим заканчивается ли строка на заданное слово. 10 задание
        boolean end;
        end = str1.endsWith(str2);
        if (end == false) System.out.println("Строка не заканчивается на слово " + str2);
        else System.out.println("Строка заканчивается на слово " + str2);
    }

    public void checkStartStr(String str1,String str2){//Проверим начинается ли строка на заданное слово. 11 задание
        boolean start;
        start = str1.startsWith(str2);
        if (start == false) System.out.println("Строка не начинается со слова " + str2);
        else System.out.println("Строка начинается со слова " + str2);
    }

    public void replace(String str1, char replaceableSymbol, char newSymbol){//Заменим все символы "а" в строке на символ "о". 12 задание
        System.out.println(str1.replace(replaceableSymbol, newSymbol));
    }

    public void subString(String str1, int start, int end){//Получим подстроку с start символа по end символ. 13 задание
        System.out.println(str1.substring(start,end+1));
    }

    public void splitStr(String str1){//Разобъем строку по символу пробел (т.е. чтобы каждое слово было отдельным элементом массива). 14 задание
        String[] arrS = new String[str1.length()];
        for (int i = 0; i < str1.length(); i ++){
            arrS = str1.split(" ");
        }
        for (int i =  0; i < arrS.length; i++)
        System.out.println(arrS[i]);
    }

    public String reverseSequence(String str1){//Поменяем последовательность символов в строке на обратную. 15 задание
        String reverse = new StringBuilder(str1).reverse().toString();
        return reverse;
    }
}
