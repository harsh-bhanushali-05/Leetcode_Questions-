class Solution:
    def maxFrequency(self, nums, k):
        nums.sort()

        left, right = 0, 0
        total, ans = 0, 0

        for right in range(len(nums)):
            total += nums[right]

            while nums[right] * (right - left + 1) > total + k:
                total -= nums[left]
                left += 1

            ans = max(ans, right - left + 1)

        return ans