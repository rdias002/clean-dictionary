package com.example.cleandictionary;

import java.util.HashMap;

public class Testing {

    public void main(){
        HashMap<Character, Integer> pairs = new HashMap<>();
        String line = "asdfasdf";
        for(int i = 0; i<line.length(); i++){
            pairs.putIfAbsent(line.charAt(i),1);
        }
    }
}
