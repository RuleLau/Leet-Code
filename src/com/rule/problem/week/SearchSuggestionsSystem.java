package com.rule.problem.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * week 164
 * @description: 1268. Search Suggestions System
 * @author: rule
 * @date: 2019-11-24 17:50
 **/
public class SearchSuggestionsSystem {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(searchWord.substring(0, i + 1)) && list.size() < 3) {
                    list.add(products[j]);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        String[] products1 = new String[]{"havana"};
        String[] products2 = new String[]{"bags","baggage","banner","box","cloths"};
        String[] products3 = new String[]{"havana"};
        String seachWord = "mouse";
        String seachWord1 = "havana";
        String seachWord2 = "bags";
        String seachWord3 = "tatiana";
        System.out.println(suggestedProducts(products, seachWord));
        System.out.println(suggestedProducts(products1, seachWord1));
        System.out.println(suggestedProducts(products2, seachWord2));
        System.out.println(suggestedProducts(products3, seachWord3));
    }

}
