二分法----二分答案
Binary Search on Result

往往没有给你一个数组让你二分，同样是找到满足某个条件的最大值或者最小值

通过猜值判断是否满足题意不对去搜索可能解
1. 找到可行解范围
2. 猜答案
3. 检验条件
4. 调整搜索范围

int start = 1, end = max; //1. 找到可行解范围
while( start + 1 < end) {
    int mid = start + (end - start)  //2. 猜答案
    if(check(mid)) {      // 3. 检验答案
        start = mid;    // 4. 调整搜索范围
    } else {
        end = mis;      // 4. 调整搜索范围
    }
}

按值二分，需要怎么二分性