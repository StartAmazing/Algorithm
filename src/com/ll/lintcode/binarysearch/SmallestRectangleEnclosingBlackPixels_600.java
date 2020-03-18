package com.ll.lintcode.binarysearch;

/**
 * 一个由二进制矩阵表示的图，0 表示白色像素点，1 表示黑色像素点。黑色像素点是联通的，即只有一块黑色区域。像素是水平和竖直连接的，给一个黑色像素点的坐标 (x, y) ，返回囊括所有黑色像素点的矩阵的最小面积。
 *
 * 样例
 * 样例 1:
 *
 * 输入：["0010","0110","0100"]，x=0，y=2
 * 输出：6
 * 解释：
 * 矩阵左上角坐标是(0, 1), 右下角的坐标是(2, 2)
 * 样例 2:
 *
 * 输入：["1110","1100","0000","0000"], x = 0, y = 1
 * 输出：6
 * 解释：
 * 矩阵左上角坐标是(0,  0), 右下角坐标是(1, 3)
 */
public class SmallestRectangleEnclosingBlackPixels_600 {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length < 1 || image[0].length < 1){
            return 0;
        }

        int startRow = findTop(image, 0, x);
        int endRow = findBottom(image, x, image.length - 1);
        int endCol = findRight(image, y, image[0].length - 1);
        int startCol = findLeft(image, 0, y);


        return (endRow - startRow + 1) * (endCol - startCol + 1);
    }

    private int findTop(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (rowEmpty(image, mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if (!rowEmpty(image, start)){
            return start;
        }
        return end;
    }

    private int findBottom(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (rowEmpty(image, mid)){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        if (!rowEmpty(image, end)){
            return end;
        }
        return start;
    }

    private int findLeft(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (colEmpty(image, mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if (!colEmpty(image, start)){
            return start;
        }
        return end;
    }

    private int findRight(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (colEmpty(image, mid)){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        if (!colEmpty(image, end)){
            return end;
        }
        return start;
    }

    private boolean rowEmpty(char[][] image, int x){
        for (int i = 0; i < image[x].length; i++){
            if (image[x][i] == '1'){
                return false;
            }
        }
        return true;
    }

    private boolean colEmpty(char[][] image, int y){
        for (char[] chars : image) {
            if (chars[y] == '1') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SmallestRectangleEnclosingBlackPixels_600 dto = new SmallestRectangleEnclosingBlackPixels_600();
        char[][] image = new char[][]{{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};

        dto.minArea(image, 0, 2);
    }

}
