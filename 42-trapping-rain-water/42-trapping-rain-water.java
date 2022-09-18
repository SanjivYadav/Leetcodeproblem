class Solution {
    public int trap(int[] height) {
         if (height.length < 3) return 0;
    
    int ans = 0;
    int l = 0, r = height.length - 1;
    
    // find the left and right edge which can hold water
    while (l < r && height[l] <= height[l + 1]) l++;
    while (l < r && height[r] <= height[r - 1]) r--;
    
    while (l < r) {
        int left = height[l];
        int right = height[r];
        if (left <= right) {
            // add volum until an edge larger than the left edge
            while (l < r && left >= height[++l]) {
                ans += left - height[l];
            }
        } else {
            // add volum until an edge larger than the right volum
            while (l < r && height[--r] <= right) {
                ans += right - height[r];
            }
        }
    }
    return ans;
    }
}