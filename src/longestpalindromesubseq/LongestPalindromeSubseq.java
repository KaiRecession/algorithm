package longestpalindromesubseq;
// 求最长的回文子序列（字符串中可以有间隔，去掉这些间隔能成为一个回文字符串）
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        int count = longestPalindromeSubseq.longestPalindromeSubseq("abbbbb12abba");
        System.out.println(count);

    }
    int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        // 倒着遍历方便状态的转移，正着遍历直接就没法搞了，上来i和j的距离最直接拉到最大化了
        // i为起点，j为终点，其实i完全可以从n-2开始
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    // 这句话就很牛皮，保证dp[i][j]永远是周围最大的情况,这也是二维倒叙保持最大值的方法
                    // 多联想一下二维dp数组
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        //倒着循环，看一下上面的注释，注定dp[0][n]就是最大的dp值！！
        return dp[0][n-1];
    }
}
