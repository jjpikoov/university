import functools


def perfect_functional(num):
    is_perfect = lambda num: num == functools.reduce(lambda x, y: x+y, list(filter(lambda k: num % k == 0, range(1, num))), 0)
    return filter(is_perfect, range(1, num + 1))


def perfect_comp(num):
    result = [x for x in range(1, num + 1) if sum([y for y in range(1, x) if x % y == 0]) == x]
    return result


# print(perfect_num_l_comp(10))
print("List comprehension")
print(perfect_comp(10000))
print("Functional:")
print(perfect_functional(10000))
# print(perfect_num_funcional(10000))
