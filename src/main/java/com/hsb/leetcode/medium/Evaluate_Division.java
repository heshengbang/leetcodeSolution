package com.hsb.leetcode.medium;

import java.util.*;

public class Evaluate_Division {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int lenOfQueries = queries.size();
        double[] res = new double[lenOfQueries];
        Arrays.fill(res, -1);
        double def = 0.56239;
        int ct = 0, len = equations.size();
        for (List<String> it : equations) {
            for (String str : it) {
                if (!map.containsKey(str))
                    map.put(str, ct++);
            }
        }
        double[][] record = new double[ct][ct];
        for (double[] it : record)
            Arrays.fill(it, def);
        for (int i = 0; i < len; i++) {
            int a = map.get(equations.get(i).get(0)), b = map.get(equations.get(i).get(1));
            record[a][b] = values[i];
        }
        for (int k = 0; k < ct; k++) {
            for (int i = 0; i < ct; i++) {
                for (int j = 0; j < ct; j++) {
                    if (record[i][j] != def)
                        continue;
                    if (i == j) {
                        record[i][j] = 1;
                        continue;
                    }
                    if (record[j][i] != def) {
                        record[i][j] = 1 / record[j][i];
                        continue;
                    }
                    if (record[i][k] != def && record[j][k] != def) {
                        record[i][j] = record[i][k] / record[j][k];
                        continue;
                    }
                    if (record[i][k] != def && record[k][j] != def) {
                        record[i][j] = record[i][k] * record[k][j];
                        continue;
                    }
                }
            }
        }
        for (int i = 0; i < lenOfQueries; i++) {
            List<String> it = queries.get(i);
            int a, b;
            if (map.containsKey(it.get(0)))
                a = map.get(it.get(0));
            else
                continue;
            if (map.containsKey(it.get(1)))
                b = map.get(it.get(1));
            else
                continue;
            if (record[a][b] != def)
                res[i] = record[a][b];
        }
        return res;
    }

    private Map<String, Map<String, Double>> graph;

    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        int length = queries.size();
        double[] result = new double[length];

        for (int i = 0; i < length; i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1);
        }
        return result;
    }

    private double dfs(String src, String dest, HashSet<Object> hasVisited, double stepValue) {
        if (!graph.containsKey(src)) {
            return -1.0d;
        }
        if (src.equals(dest)) {
            return stepValue * 1.0d;
        }
        hasVisited.add(src);
        Map<String, Double> stepToDest = graph.get(src);
        for (Map.Entry<String, Double> entry : stepToDest.entrySet()) {
            if (hasVisited.contains(entry.getKey())) {
                continue;
            }
            if (dest.equals(entry.getKey())) {
                return stepValue * entry.getValue();
            }
            double ans = dfs(entry.getKey(), dest, hasVisited, stepValue * entry.getValue());
            if (ans != -1.0d) {
                return ans;
            }
        }
        hasVisited.remove(src);
        return -1.0d;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        graph = new HashMap<>();
        int length = equations.size();

        for (int i = 0; i < length; i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            graph.putIfAbsent(x, new HashMap<>());
            graph.putIfAbsent(y, new HashMap<>());

            graph.get(x).put(y, values[i]);
            graph.get(y).put(x, 1 / values[i]);
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(new String[]{"a","b"}));
        equations.add(Arrays.asList(new String[]{"b","c"}));
        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[]{"a","c"}));
        queries.add(Arrays.asList(new String[]{"b","a"}));
        queries.add(Arrays.asList(new String[]{"a","e"}));
        queries.add(Arrays.asList(new String[]{"a","a"}));
        queries.add(Arrays.asList(new String[]{"x","x"}));

        Evaluate_Division it = new Evaluate_Division();
        double[] result = it.calcEquation1(equations, values, queries);

        for (double d: result) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

}
