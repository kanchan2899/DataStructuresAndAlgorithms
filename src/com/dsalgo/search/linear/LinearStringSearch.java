package com.dsalgo.search.linear;

public class LinearStringSearch {
    public static void main(String[] args) {
        String name = "Kanchan";
        char element = 'h';
        System.out.println(search(name, element));
        System.out.println(search1(name, element));
    }

    private static boolean search1(String str, char element) {
        if(str.length() <= 0){
            return false;
        }
        for( char c : str.toCharArray()){
            if( element == c){
                return true;
            }
        }
        return false;
    }

    private static boolean search(String str, char ele) {
        if(str.length() <= 0){
            return false;
        }
        for ( int i = 0; i < str.length(); i++){
            if(ele == str.charAt(i)){
                return true;
            }
        }
        return false;
    }


}
