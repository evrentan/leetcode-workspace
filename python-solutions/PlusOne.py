def plusOne(digits):
    number = int(''.join(map(str, digits)))
    return [int(digit) for digit in str(number+1)]
