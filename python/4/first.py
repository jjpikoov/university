import math


def primes_list_comp(number):
    up_to_number = [x for x in range(2, number + 1)]
    l_to_sqrt = [x for x in range(2, int(math.sqrt(number)) + 1)]
    composite = [x for x in up_to_number for y in l_to_sqrt if x % y == 0 and x / y != 1]
    primes = [x for x in up_to_number if x not in composite]
    return primes


def is_prime(number):
    return len(list(filter(lambda k: number % k == 0, range(2, int(math.sqrt(number) + 1))))) == 0


def primes_func(number):
    return filter(is_prime, range(2, number + 1))


print("List comprehension:")
print(primes_list_comp(20))
print("")
print("Functional")
print(primes_func(20))
