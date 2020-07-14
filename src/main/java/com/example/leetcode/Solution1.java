package com.example.leetcode;

/**
 * @Desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: MrDi
 * @Date: 2020/7/14 9:30
 */
public class Solution1 {


    //字符串的滑动窗口 快
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int lk = 0;//左指针
        int rk = 0;//右指针
        String childStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (childStr.contains(String.valueOf(s.charAt(rk)))) {
                lk++;
                i--;//当左指针前进时  保持右指针位置不变
            }
            rk=i+1;
            childStr = s.substring(lk, rk);
            if (childStr.length() > maxLength) {
                maxLength = childStr.length();
            }
        }
        return maxLength;
    }
    //map 滑动存到map里 中
    //    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        } else if (s.length() == 1) {
//            return 1;
//        }
//        Map<Integer,Character> map = new HashMap<>();
//        int maxLength = 0;
//        int lk = 0;
//        int rk = 0;//右指针
//        for (int i = 0; i < s.length(); i++) {
//            rk=i;
//            while (map.containsValue(s.charAt(rk))){
//                map.remove(lk);
//                lk++;
//            }
//            map.put(rk,s.charAt(rk));
//            if (map.size() > maxLength) {
//                maxLength = map.size();
//            }
//        }
//        return maxLength;
//    }


    //两次for循环 最慢
//    public static int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        String childStr ="";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j < s.length()+1; j++) {
//                if (childStr.contains(String.valueOf(s.charAt(j-1)))){
//                    break;
//                }
//                childStr = s.substring(i,j);
//                if (childStr.length()>maxLength){
//                    maxLength = childStr.length();
//                }
//            }
//            childStr = "";
//        }
//        return maxLength;
//    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
    }
}
