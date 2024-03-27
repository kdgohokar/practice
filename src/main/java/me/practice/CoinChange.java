package me.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public int coinChangeModified(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        Map<Integer, Integer> dpMap = new HashMap<>(amount+1);
        dpMap.put(0, 0);
        for (int i = 1; i <= amount; i++) {
            dpMap.put(i, amount + 1);
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dpMap.put(i, Math.min(dpMap.get(i), 1 + dpMap.get(i - coin)));
                }
            }
        }

        return dpMap.get(amount) != amount + 1 ? dpMap.get(amount) : -1;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = new int[]{1, 3, 4, 5};
        int amount = 7;
        System.out.println(cc.coinChangeModified(coins, amount));
    }

}
