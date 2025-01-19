class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        i = 0
        j = 0 
        curr = 0
        ans = 0 
        while j < len(nums):
            if nums[j] == 0:
                curr+=1
            while curr > 1:
                if nums[i] == 0:
                    curr-=1
                i+=1
            ans = max(ans , j-i)
            j+=1
        # ans = max(ans , j-i)    
        if ans == len(nums):
            return ans-1
        return ans