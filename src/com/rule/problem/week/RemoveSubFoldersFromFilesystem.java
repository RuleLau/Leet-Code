package com.rule.problem.week;

import java.util.*;

/**
 * @description: 1233
 * @author: rule
 * @date: 2019-10-20 16:50
 **/
public class RemoveSubFoldersFromFilesystem {

    /**
     * mine timeout
     */
    public static List<String> removeSubfolders(String[] folder) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < folder.length; i++) {
            folder[i] = new StringBuilder().append(folder[i]).append("/").toString();
            set.add(folder[i]);
        }
        Collections.sort(set, Collections.reverseOrder());
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            boolean isExist = true;
            String value = iterator.next();
            for (int i = 0; i < folder.length; i++) {
                if (!folder[i].equals(value) && value.contains(folder[i])) {
                    iterator.remove();
                    isExist = false;
                    break;
                }
            }
            if (isExist) {
                result.add(value.substring(0, value.length() - 1));
            }
        }
        System.out.println(Arrays.asList(result));
        return result;
    }

    public static List<String> removeSubfolders1(String[] folder) {
        List<String> result = new ArrayList<>();
        Set<String> dir = new HashSet<>();
        // 排序
        Arrays.sort(folder);
        for (int i = 0; i < folder.length; i++) {
            String[] sp = folder[i].split("/");
            StringBuilder sb = new StringBuilder();
            boolean isSubFolder = true;
            for (int j = 1; j < sp.length; j++) {
                sb.append("/").append(sp[j]);
                if (dir.contains(sb.toString())) {
                    isSubFolder = false;
                    break;
                }
            }
            if (isSubFolder) {
                dir.add(sb.toString());
                result.add(sb.toString());
            }
        }
        System.out.println(Arrays.asList(result));
        return result;
    }

    public static void main(String[] args) {
        String[] folder = {"/aa/ab/ac/ae","/aa/ab/af/ag","/ap/aq/ar/as","/ap/aq/ar","/ap/ax/ay/az","/ap","/ap/aq/ar/at","/aa/ab/af/ah","/aa/ai/aj/ak","/aa/ai/am/ao"};
        removeSubfolders(folder);
        removeSubfolders1(folder);
    }
}
