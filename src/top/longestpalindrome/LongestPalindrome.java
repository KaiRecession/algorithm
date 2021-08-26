/**
 * 寻找最长回文字串
 */
package top.longestpalindrome;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("123abba222"));
    }

    /**
     * 双指针妙用
     * @param s
     * @param l
     * @param r
     * @return
     */
    String palindrome(String s, int l, int r) {
        while (l >= 0 && r<s.toCharArray().length && s.toCharArray()[l] == s.toCharArray()[r]) {

            l--; r++;
        }

        // 循环中多减了一次，补回来
        l += 1;

        // sub函数左闭右开，所以r不用动
        return s.substring(l, r);
    }

    /**
     * 复杂度：O(N^2)
     * @param s
     * @return
     */
    String longestPalindrome(String s) {

        String res = s.substring(0,1);
//        System.out.println(res);
        for (int i = 0; i < s.length(); i++) {
            // 奇偶都写一次，我觉得不如加if判断长度，fine
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }
}
