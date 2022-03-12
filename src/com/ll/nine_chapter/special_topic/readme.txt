
===== RabinKarp ====

"abcde"    ==hash==>     ('a' * 31^4 + 'b' * 31 ^3 + 'c' * 31 ^ 2 + 'd' * 31^ 1 + 'e' * 31 ^ 0) % 10 ^ 6
31 -> magic number
10^6 -> base number

for (int i = 0; i < m; i++) {
    targetCode = (targetCode * 31 + target.charAt(i)) % HASH_BASE_NUMBER;
}

(((((0 * 31 + 'a') * 31 + 'b') * 31 + 'c') * 31 + 'd') * 31 + 'e')
= ('a' * 31^4 + 'b' * 31 ^3 + 'c' * 31 ^ 2 + 'd' * 31^ 1 + 'e' * 31 ^ 0) % 10 ^ 6



===== SubSet With Oup ====

1. 生成所有可能的子集全部找出来，再去重？
   [1, 1, 1, 1, 1] ?
2. sort -> dfs