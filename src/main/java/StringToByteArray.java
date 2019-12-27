import java.util.Arrays;

public class StringToByteArray {

    public byte[] stringToByteArray(String inputString) {
        byte[] byteArray = inputString.getBytes();
        System.out.println("Строка в массиве байт : " + Arrays.toString(byteArray));
        return byteArray;
    }

}
