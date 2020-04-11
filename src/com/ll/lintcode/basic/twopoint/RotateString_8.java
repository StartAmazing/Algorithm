package com.ll.lintcode.basic.twopoint;

public class RotateString_8 {
    public void rotateString(char[] str, int offset) {
        if(str==null || str.length==1|| str.length==0 || offset<=0){
            return;
        }

        offset%=str.length;

        for(int i = 0; i < offset; i++){
            char temp = str[str.length - 1];
            for(int j = str.length-1; j > 0; j--){
                str[j] = str[j - 1];
            }
            str[0] = temp;
        }
    }

    public static void main(String[] args) {
        RotateString_8 dto = new RotateString_8();
        String s = "abcdefg";
        char[] chars = s.toCharArray();
        dto.rotateString(chars,3);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

}
