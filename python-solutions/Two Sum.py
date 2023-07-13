def twoSum(nums,target):
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in nums and nums.index(complement) != i:
            complement_index = nums.index(complement)
            return [i,complement_index]
