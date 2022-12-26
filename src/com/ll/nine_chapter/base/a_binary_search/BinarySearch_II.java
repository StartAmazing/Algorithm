package com.ll.nine_chapter.base.a_binary_search;

import java.util.Arrays;

/**
 * XXXXOOO型
 */
public class BinarySearch_II {

    /*
     * 1. Find first bad version
     *
     * 2. Search in a big sorted array
     *
     * 3. Find Minimum in rotated sorted array(first number <= last number)
     */
    public static int findMinimumInRotatedSortedArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return nums[end] < nums[start] ? end : start;
    }

    /**
     * @link https://www.lintcode.com/problem/74/
     * @param n
     * @return
     */
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return isBadVersion(start) ? start : end;
    }

    private static boolean isBadVersion(int x) {
        return Math.random() < 0.5;
    }


    /**
     * @link https://www.lintcode.com/problem/28/
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        while(x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

    /**
     * @link https://www.lintcode.com/problem/38/
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: an int, the times of target appearance
     * [
     *  1, 2, 4, 5,  8,  9,
     *  2, 4, 5, 7,  11, 13,
     *  5, 7, 8, 10, 13, 17,
     *  6, 8, 10,12, 14, 20,
     * ]
     */
    public int searchMatrixII(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        int times = 0;
        while (y >= 0 && x < matrix.length) {
            if (matrix[x][y] == target) {
                times++;
                y--;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }

        return times;
    }

    /**
     * @link https://www.lintcode.com/problem/61/
     * @param a: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public static int[] searchRange(int[] a, int target) {
        if (a == null || a.length < 1) {
            return new int[]{-1, -1};
        }
        int start = 0, end = a.length - 1;
        int left, right;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (a[start] != target && a[end] != target) {
            return new int[]{-1, -1};
        }

        left = a[start] == target ? start : end;

        start = 0;
        end = a.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        right = a[end] == target ? end : start;

        return new int[]{left, right};
    }

    /**
     * @link https://www.lintcode.com/problem/585/
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }

    /**
     * @link: https://www.lintcode.com/problem/600/
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     *
     *     0 0 1 0
     *     0 1 1 0
     *     0 1 0 0
     */
    public static int minArea(char[][] image, int x, int y) {
        if (image == null || image.length < 1 || image[0].length < 1) {
            return 0;
        }

        int height = image.length - 1, width = image[0].length - 1;
        // 二分法找到基于给出x, y的四个顶点
        int left, right, top, bottom;
        // 左
        int start = 0, end = y;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (image[x][mid] == '0') {
                start = mid;
            } else {
                end = mid;
            }
        }
        left = image[x][start] == '1' ? start : end;

        // 右
        start = y;
        end = width;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (image[x][mid] == '0') {
                end = mid;
            } else {
                start = mid;
            }
        }
        right = image[x][end] == '1' ? end : start;


        // 上
        start = 0;
        end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(image[mid][y] == '0') {
                start = mid;
            } else {
                end = mid;
            }
        }
        top = image[start][y] == '1' ? start : end;

        // 下
        start = x;
        end = height;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (image[mid][y] == '0') {
                end = mid;
            } else {
                start = mid;
            }
        }
        bottom = image[end][y] == '1' ? end : start;

        int[] lt = new int[]{left, top}, rb = new int[]{right, bottom};
        for (int i = left - 1; i >= 0; i--) {
            boolean flag = false;
            for(int j = 0; j <= height; j++) {
                if(image[j][i] == '1') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                lt[0] = i + 1;
                break;
            } else {
                lt[0] = i;
            }
        }

        for (int i = right + 1; i <= width; i++) {
            boolean flag = false;
            for(int j = 0; j <= height; j++) {
                if(image[j][i] == '1') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                rb[0] = i - 1;
                break;
            } else {
                rb[0] = i;
            }
        }

        for (int i = top - 1; i >= 0; i--) {
            boolean flag = false;
            for(int j = 0; j <= width; j++) {
                if (image[i][j] == '1') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                lt[1] = i + 1;
                break;
            } else {
                lt[1] = i;
            }
        }

        for (int i = bottom + 1; i <= height; i++) {
            boolean flag = false;
            for(int j = 0; j <= width; j++) {
                if (image[i][j] == '1') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                rb[1] = i - 1;
                break;
            } else {
                rb[1] = i;
            }
        }


        return (rb[0] - lt[0] + 1) * (rb[1] - lt[1] + 1);
    }



    public static void main(String[] args) {
        char[][] data = new char[][]{
                {'0','0','0','0','0','0','0','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','0','0','0','0','1'},
                {'0','0','0','0','0','0','0','0','0','0','0','1'},
                {'0','0','0','0','0','0','0','0','0','0','0','1'}
        };

        data = new char[][]{
                {'0','0','1','0'},
                {'0','1','1','0'},
                {'0','1','0','0'}};

        int area = minArea(data, 0, 2);
        System.out.println(area);
    }
}
