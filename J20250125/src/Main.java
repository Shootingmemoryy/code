import java.util.ArrayList;

import static java.lang.Character.isLetter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {

        }
    }
}
class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int left = 0, right = n - 1;
        while (true) {
            while (left < right && !Character.isLetter(s.charAt(left))) { // 判断左边是否扫描到字母
                left++;
            }
            while (right > left && !Character.isLetter(s.charAt(right))) { // 判断右边是否扫描到字母
                right--;
            }
            if (left >= right) {
                break;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }
    public String minWindow(String s, String t) {
        int ns = s.length(), nt = t.length();
        if(ns < nt) return "";
        int[] hash = new int[58]; // A~Z: 65~90, a~z: 97~122
        int diff = 0;
        for(int i = 0; i < nt; i++){
            hash[t.charAt(i) - 'A']++;
            hash[s.charAt(i) - 'A']--;
        }
        for(int val : hash){ // 只关心未抵消的字符
            if(val > 0) diff++;
        }
        if(diff == 0) return s.substring(0, nt); // 第一个窗为最小覆盖子串时
        int l = 0, r = nt, lmin = 0, rmin = ns;
        for(; r < ns; r++){ // 只要当前窗还未覆盖，向右侧扩窗
            int in = s.charAt(r) - 'A';
            hash[in]--;
            if(hash[in] == 0) diff--; // in入窗后使得窗内该字符个数与t中相同
            if(diff != 0) continue; // diff不为0则继续扩窗
            for(; diff == 0; l++){ // 从左侧缩窗
                int out = s.charAt(l) - 'A';
                hash[out]++;
                if(hash[out] == 1) diff++;
            }
            if(r - l + 1 < rmin - lmin){ // 缩窗后得到一个合格窗，若窗宽更小，更新窗界
                lmin = l - 1;
                rmin = r;
            }
        }
        return rmin == ns ? "" : s.substring(lmin, rmin + 1);
    }