package com.hsb.leetcode.medium;

import java.util.*;

public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<>();
        Set<Integer> allPrerequisites = new HashSet<>();
        for (int[] tmp : prerequisites) {
            if (prerequisitesMap.containsKey(tmp[1])) {
                prerequisitesMap.get(tmp[1]).add(tmp[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(tmp[0]);
                prerequisitesMap.put(tmp[1], set);
            }
            // 存在环
            if (prerequisitesMap.containsKey(tmp[0]) && prerequisitesMap.get(tmp[0]).contains(tmp[1])) {
                return new int[0];
            }
            allPrerequisites.add(tmp[0]);
            allPrerequisites.add(tmp[1]);
        }
        int[] result = new int[numCourses];
        boolean[] hasVisited = new boolean[numCourses];
        int index;
        if (allPrerequisites.isEmpty()) {
            index = 0;
        } else {
            index = allPrerequisites.size() - 1;
            int noPrerequisites = allPrerequisites.size();
            while (allPrerequisites.size() != 0) {
                Iterator<Integer> iterator = allPrerequisites.iterator();
                Set<Integer> tmp = new HashSet<>();
                while (iterator.hasNext()) {
                    Integer course = iterator.next();
                    // 当前没有依赖关系的课程
                    if (!prerequisitesMap.containsKey(course)) {
                        tmp.add(course);
                        result[index--] = course;
                        hasVisited[course] = true;
                        iterator.remove();
                    }
                }
                // 没有不存在依赖关系的课程，同时又有课程存在依赖关系，这自相矛盾，存在环，所以返回空数组
                if (tmp.isEmpty() && !prerequisitesMap.isEmpty()) {
                    return new int[0];
                }

                // 移除没有依赖关系的课程的存在
                Set<Integer> emptyKey = new HashSet<>();
                for (Map.Entry<Integer, Set<Integer>> entry : prerequisitesMap.entrySet()) {
                    entry.getValue().removeAll(tmp);
                    if (entry.getValue().isEmpty()) {
                        emptyKey.add(entry.getKey());
                    }
                }
                if (!emptyKey.isEmpty()) {
                    for (Integer course: emptyKey) {
                        prerequisitesMap.remove(course);
                    }
                }
            }
            index = noPrerequisites;
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasVisited[i]) {
                continue;
            }
            result[index++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
//        int numCourses = 2;
//        int[][] prerequisites = {{1,0}};

//        int numCourses = 4;
//        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

//        int numCourses = 1;
//        int[][] prerequisites = {};

//        int numCourses = 2;
//        int[][] prerequisites = {{0,1},{1,0}};

//        int numCourses = 3;
//        int[][] prerequisites = {{0,1},{0,2},{1,2}};

//        int numCourses = 3;
//        int[][] prerequisites = {{0,2},{1,2},{2,0}};

//        int numCourses = 3;
//        int[][] prerequisites = {{1, 0}};

        int numCourses = 3;
        int[][] prerequisites = {{1,0},{0,2},{2,1}};


        Course_Schedule_II it = new Course_Schedule_II();
        int[] result = it.findOrder(numCourses, prerequisites);
        for (int i: result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
