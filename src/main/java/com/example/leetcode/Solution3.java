package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: MrDi
 * @Date: 2020/7/14 15:45
 */
public class Solution3 {

    /*执行用时：1 ms, 在所有 Java 提交中击败了99.86%的用户
    内存消耗：39.8 MB, 在所有 Java 提交中击败了8.70%的用户*/
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> resultList  = triangle.get(triangle.size()-1);//最后一行集合
        for (int i = triangle.size()-2; i >=0 ; --i) {
            resultList =  getNextList(triangle.get(i),resultList);
        }
        return resultList.get(0);
    }
    public static List<Integer> getNextList(List<Integer> list1,List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(Math.min(list1.get(i)+list2.get(i),list1.get(i)+list2.get(i+1)));
        }
        return result;
    }

}
