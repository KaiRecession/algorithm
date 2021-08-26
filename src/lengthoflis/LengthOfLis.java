/**
 * 最长递增序列
 */
package lengthoflis;

import java.util.Arrays;

public class LengthOfLis {

    public static void main(String[] args) {
        LengthOfLis lengthOfLis = new LengthOfLis();
        int[] test = {1, 3, 2, 2, 1, 5, 6, 9, 10};
        System.out.println(lengthOfLis.lengthOfLis(test));
    }

    int lengthOfLis(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 新加入的i比较大，在求递增序列的情况下，该变量引起了更新
                if (nums[j] < nums[i]) {
                    // 更新条件就是动态规划的核心，新变量的引入是否会引起结果的更新（结果是否跟新，在记录中找到最靠近的一项子结果），这就是动态规划
                    // 动态规划背包问题，比的总是背包里面的价值！！！
                    // 遍历最大值的高大上语句
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
