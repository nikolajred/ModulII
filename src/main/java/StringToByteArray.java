import java.util.Arrays;

public class StringToByteArray {

    public byte[] stringToByteArray(String inputString) {
        byte[] byteArray = inputString.getBytes();
        System.out.println("String to byte[] array " + Arrays.toString(byteArray));
        return byteArray;
    }

}
