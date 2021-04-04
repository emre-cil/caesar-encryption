import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputSentence;
        char[] list = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        boolean check;
        do {
            check = true;
            System.out.println("Enter Sentence:");
            inputSentence = input.nextLine().toUpperCase();
            check = checkInput(inputSentence);
            if (!check)
                System.out.println("!!!The message is invalid, please enter invalid message:");

        }
        while (!check);


        cryptedCodeToCrypted(codeToCryptedCode(convertToCode(inputSentence, list)), list);


    }

    static boolean checkInput(String sentence) {
        String temp = sentence.replace(" ", "");
        for (int i = 0; i < temp.length(); i++) {
            char chars = temp.charAt(i);
            if (!(chars >= 'A' && chars <= 'Z')) {
                return false;
            }
        }
        return true;
    }

    static String[] convertToCode(String input, char[] wordList) {
        String[] result = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < wordList.length; j++) {
                if (input.charAt(i) == ' ') {
                    result[i] = null;
                    break;
                }
                if (input.charAt(i) == wordList[j]) {
                    result[i] = String.valueOf(j);

                }
            }
        }
        return result;
    }

    static String[] codeToCryptedCode(String[] list) {
        String[] result = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                result[i] = String.valueOf((Integer.parseInt(list[i]) + 3) % 26);
            } else
                result[i] = null;
        }
        return result;
    }

    static void cryptedCodeToCrypted(String[] list, char[] wordList) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null)
                System.out.print(" ");
            else
                System.out.print(wordList[Integer.parseInt(list[i])]);
        }
    }



}
