package mmf.piskunou.lab2J;

import java.util.Arrays;
import java.util.Scanner;


/** n is in range from 5000 to 10000*/

public class Input {
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    private String input;

    public Input(String input) {
        this.input= input;
    }

    private String[] words;
    private String word;

    String text = "Бурого медведя считают хозяином смешанных лесов. " +
            "Он очень любит малину и мёд. Косолапый часто совершает набеги на жилища диких пчёл. " +
            "Забредает порой на пасеки. Пчёлы мстят медведю. Они жалят его в кончик носа, язык. " +
            "Зверю приходится спасаться бегством.";
    public Input() {
        words = text.replaceAll("\\p{Punct}", "").toLowerCase().split(" ");
        System.out.println("Words array not sorted: " + Arrays.toString(words));
        Arrays.sort(words);
        System.out.println("Sorted words array: " + Arrays.toString(words)); // for best and worst cases
        System.out.print("Enter word to find: ");
        Scanner scan = new Scanner(System.in);
        word = scan.nextLine();
    }

    public int findWord(){
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word)) return i;
        }
        return -1;
    }
}
