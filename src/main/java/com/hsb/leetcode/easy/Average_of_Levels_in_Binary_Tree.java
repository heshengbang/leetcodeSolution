package com.hsb.leetcode.easy;

import com.hsb.leetcode.ToolUtils;
import com.hsb.leetcode.entity.TreeNode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Average_of_Levels_in_Binary_Tree {
    Map<Integer, List<Integer>> map;
    public List<Double> averageOfLevels(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 1);

        List<List<Integer>> list = new ArrayList<>(map.values());
        List<Double> result = new ArrayList<>();
        for (List<Integer> it: list) {
            BigDecimal res = new BigDecimal(0);
            for (Integer num: it) {
                res = res.add(new BigDecimal(num));
            }
            result.add(res.divide(BigDecimal.valueOf(it.size()), 5, RoundingMode.CEILING).doubleValue());
        }
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        dfs(root.left, level + 1);
        if (map.containsKey(level)) {
            map.get(level).add(root.val);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = ToolUtils.createTree(nums);

        Average_of_Levels_in_Binary_Tree it = new Average_of_Levels_in_Binary_Tree();
        System.out.println(it.averageOfLevels(root));
    }
}
