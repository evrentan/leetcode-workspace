def removeElement(nums,val):

    if nums==[]:
        return 0
    
    while nums.count(val)!=0:
        nums.remove(val)
    return len(nums)
