class Solution {
  //Question 1
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res[] = new int[2];
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            if(map.containsKey(target-nums[i])){
                if(map.get(target-nums[i])==i){
                    continue;
                }
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
  //Question 2
    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while( first <= last){
            int mid = first + ((last - first) / 2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                first = mid + 1;
            }else{
                last = mid - 1;
            }
        }
        return first;
        
    }
  //Question 3
  public int maxArea(int[] height) {
        int first = 0;
        int last = height.length-1;
        int res = 0;
        while(first<last){
            int vol = (last - first) * (( height[first] >= height[last] ? height[last]: height[first]));
            if(vol > res){
                res = vol;
            }
            if(height[first]>=height[last]){
                last = last - 1;
            }
            else{
                first = first + 1;
            }
        }
        return res;
        
    }
  //Question 4
  public boolean isValidRow(char[][] board,int row){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            if(board[row][i]!='.' && set.contains(board[row][i])){
                return false;
            }
            set.add(board[row][i]);
        }
        return true;
    }
    public boolean isValidCol(char[][] board,int col){
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            if(board[i][col]!='.' && set.contains(board[i][col])){
                return false;
            }
            set.add(board[i][col]);
        }
        return true;
    }
    public boolean isValidBox(char[][] board,int row,int col){
        HashSet<Character> set = new HashSet<>();
        for(int i = row;i<row+3;i++){
            for(int j = col;j<col+3;j++){
                if(board[i][j]!='.' && set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int[][] box = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for(int i=0;i<9;i++){
            if(!isValidRow(board,i) || !isValidCol(board,i) || !isValidBox(board,box[i][0],box[i][1])){
                return false;
            }
        }
        return true;
    }
  //Question 5
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length,n=nums2.length;
        int first = 0;
        int last = m;
        int total_mid = (m + n + 1) / 2;

        while (first <= last) {
            int mid = (first + last) / 2;
            int left1Size = mid;
            int left2Size = total_mid - mid;
            int left1 = (left1Size > 0) ? nums1[left1Size - 1] : Integer.MIN_VALUE;
            int left2 = (left2Size > 0) ? nums2[left2Size - 1] : Integer.MIN_VALUE;
            int right1 = (left1Size < m) ? nums1[left1Size] : Integer.MAX_VALUE;
            int right2 = (left2Size < n) ? nums2[left2Size] : Integer.MAX_VALUE;
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                return Math.max(left1, left2);
            }
            else if (left1 > right2) {
                last = mid - 1;
            }
            else
                first = mid + 1;
        }
        return 0.0;
    }
  //Question 6
  public int trap(int[] height) {
        int[] left_DP = new int[height.length];
        int[] right_DP = new int[height.length];
        left_DP[0] = height[0];
        right_DP[height.length-1] = height[height.length-1];
        for(int i=1,j=height.length-2;i<height.length&&j>=0;i++,j--){
            if(height[i]>left_DP[i-1]){
                left_DP[i]=height[i];
            }
            else{
                left_DP[i] = left_DP[i-1];
            };
            if(height[j]>right_DP[j+1]){
                right_DP[j]=height[j];
            }
            else{
                right_DP[j] = right_DP[j+1];
            }
        }
        int res = 0;
        for(int i =0;i<height.length;i++){
            res += (((left_DP[i]<right_DP[i])?left_DP[i]:right_DP[i]) - height[i]);
        }
        return res;
        
    }
}
