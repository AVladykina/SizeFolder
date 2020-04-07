import java.io.File;


public class Main {

    final static int constForSize = 1024;
    final static int constForSize2 = (int)Math.pow(constForSize,2);
    final static int constForSize3 = (int)Math.pow(constForSize,3);
    final static long constForSize4 = (long) Math.pow(constForSize,4);
    final static long constForSize5 = (long)Math.pow(constForSize,5);

    public static void main(String[] args) {

        File path = new File("/Users/nasenka/Downloads");
        if (path.exists()) {
            File[] files = path.listFiles();
            long size = getSize(files);
            System.out.println(print(size));
        }
        else
            System.out.println("Папка не найдена");
    }

    static long getSize(File[] files) {
        long size = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                size += files[i].length();
            }
            if (files[i].isDirectory()) {
                File[] filesDir = files[i].listFiles();
                size += getSize(filesDir);
            }
        }
        return size;
    }

    static String print(long size) {
        if (size < constForSize) {
            return size + " байт";
        }
        if (size < constForSize2) {
            return size / constForSize + " килобайт";
        }
        if (size < constForSize3) {
            return size / constForSize2 + " мегабайт";
        }
        if (size < constForSize4) {
            return size / constForSize3 + " гигабайт";
        }
        if (size < constForSize5) {
            return size / constForSize4 + " терабайт";
        }
        else{
                return size / constForSize4 + " петабайт";
        }
    }


}
