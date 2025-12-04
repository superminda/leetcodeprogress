// Last updated: 12/4/2025, 12:46:55 AM
1class Bank {
2
3    private long[] accounts;
4    public Bank(long[] balance) {
5        this.accounts = balance;
6    }
7    
8    public boolean transfer(int account1, int account2, long money) {
9        int index1 = account1 - 1;
10        if (index1 < 0 || index1 >= this.accounts.length) {
11            return false;
12        }
13        if (money > this.accounts[index1]) {
14            return false;
15        }
16        int index2 = account2 - 1;
17        if (index2 < 0 || index2 >= this.accounts.length) {
18            return false;
19        }
20        this.accounts[index1] -= money;
21        this.accounts[index2] += money;
22        return true;
23    }
24    
25    public boolean deposit(int account, long money) {
26        int index = account - 1;
27        if (index < 0 || index >= this.accounts.length) {
28            return false;
29        }
30        this.accounts[index] += money;
31        return true;
32    }
33    
34    public boolean withdraw(int account, long money) {
35        int index = account - 1;
36        if (index < 0 || index >= this.accounts.length) {
37            return false;
38        }
39        if (money > this.accounts[index]) {
40            return false;
41        }
42        this.accounts[index] -= money;
43        return true;
44    }
45}
46
47/**
48 * Your Bank object will be instantiated and called as such:
49 * Bank obj = new Bank(balance);
50 * boolean param_1 = obj.transfer(account1,account2,money);
51 * boolean param_2 = obj.deposit(account,money);
52 * boolean param_3 = obj.withdraw(account,money);
53 */