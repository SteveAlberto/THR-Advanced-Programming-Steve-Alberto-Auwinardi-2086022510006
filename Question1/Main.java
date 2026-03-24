package Question1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "holly may interesting MARCH corey November junior january paul december";

        String[] words = input.split(" ");
        
        Stack<String> inputStack = new Stack<>();
        for (String word : words) {
            inputStack.push(word);
        }
        
        TrailPiece[] pieces = new TrailPiece[5];
        int index = 0;
        
        while (!inputStack.isEmpty()) {
            String month = inputStack.pop();
            String secretWord = inputStack.pop();
            
            pieces[index] = new TrailPiece(secretWord, month);
            index++;
        }
        
        Arrays.sort(pieces);
        
        Stack<String> finalStack = new Stack<>();
        for (int i = 0; i < pieces.length; i++) {
            finalStack.push(pieces[i].word);
            finalStack.push(pieces[i].month);
        }
        String[] outputArray = finalStack.toArray(new String[0]);
        System.out.println(Arrays.toString(outputArray));
    }
}

class TrailPiece implements Comparable<TrailPiece> {
    String word;
    String month;
    int monthNumber; 

    public TrailPiece(String word, String month) {
        this.word = word;
        this.month = month;
        this.monthNumber = convertMonthToNumber(month);
    }

    private int convertMonthToNumber(String m) {
        switch (m.toLowerCase()) {
            case "january": return 1;
            case "february": return 2;
            case "march": return 3;
            case "april": return 4;
            case "may": return 5;
            case "june": return 6;
            case "july": return 7;
            case "august": return 8;
            case "september": return 9;
            case "october": return 10;
            case "november": return 11;
            case "december": return 12;
            default: return 99;
        }
    }

    @Override
    public int compareTo(TrailPiece other) {
        return Integer.compare(this.monthNumber, other.monthNumber);
    }
}