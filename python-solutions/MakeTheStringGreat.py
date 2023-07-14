def makeGood(s):
    stack=[]
    for char in s:
        if stack:
            if (char.isupper() and stack[-1].islower() and stack[-1].upper() == char )or (char.islower() and stack[-1].isupper() and stack[-1].lower() == char):
                stack.pop()
                continue
            else:
                stack.append(char)
        
        else:
            stack.append(char)

        
    return "".join(stack)
