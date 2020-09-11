class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        tempMax = 0
        tempMin = 0
        if(len(nums) == 1):
            return nums[0]
        maxP = 0
        
        for val in nums:
            temp = tempMax
            tempMax = max(val,max(val*tempMax,val*tempMin))
            tempMin = min(val,min(val*temp,val*tempMin))
            maxP = max(tempMax,maxP)
            
        return maxP
