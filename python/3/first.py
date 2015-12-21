import math


def primes_list_comp(number):
    up_to_number = [x for x in range(2, number + 1)]
    l_to_sqrt = [x for x in range(2, int(math.sqrt(number)) + 1)]
    composite = [x for x in up_to_number for y in l_to_sqrt if x % y == 0 and x / y != 1]
    primes = [x for x in up_to_number if x not in composite]
    return primes


def is_composite(number):
    for i in range(2, int(math.sqrt(number) + 1)):
        if number % i == 0:
            return True
    return False


def is_not_composite(number):
    return not is_composite(number)


def primes_func(number):
    up_to_number = range(2, number + 1)
    return filter(is_not_composite, up_to_number)


print("List comprehension:")
# print(primes_list_comp(20))
print("")
print("Functional")
print(primes_func(20))
