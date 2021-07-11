package stackexercise;

public class Solutions {
    public String reverseWords(String s) {
        String[] sArray = s.split(" ");
        int size = sArray.length;
        String[] newsArray = new String[size];
        for(int j = 0; j < size - 1; j++ ){
            char[] charArray = sArray[j].toCharArray();
            int sizeChar = charArray.length;
            for(int i = 0; i < sizeChar - 1 / 2; i++){
                char temp = charArray[i];
                charArray[i] = charArray[sizeChar - 1 - i];
                charArray[sizeChar - 1 - i] = temp;
            }
            newsArray[j] = new String(charArray);
        }
        String ans = "";
        for(String i : newsArray){
            ans = ans + i + " ";
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = " lets take a shaowe";
        Solutions rev = new Solutions();
        String ans = rev.reverseWords(s);
        System.out.println(ans);
    }
}
