from functools import reduce
import itertools
import timeit
def perfect_list_comp(n):
    return [x for x in range(1, n) if sum([y for y in range(1, x) if x % y == 0]) == x]


def is_perfect(n):
    return reduce(lambda x, y: x + y, filter(lambda k: n % k == 0, range(1, n)), 0) == n


def perfect_func(n):
    return list(filter(is_perfect, range(1, n)))


def perfect_itarator(number):
    result = []
    for i in PerfectCollection():
        if i <= number:
            result.append(i)
        else:
            return result


class PerfectIterator(object):
    def __init__(self):
        self.start = 1

    def __next__(self):
        for candidate in itertools.count(self.start, 1):
            sum_of_factors = 0
            for b in range(1, candidate):
                if candidate % b == 0:
                    sum_of_factors += b
            if sum_of_factors == candidate:
                self.start = candidate + 1
                return candidate


class PerfectCollection():
    def __iter__(self):
        return PerfectIterator()


comp10 = timeit.timeit('perfect_list_comp(10)', "from __main__ import perfect_list_comp", number = 1)
func10 = timeit.timeit('perfect_func(10)', "from __main__ import perfect_func", number = 1)
it10 = timeit.timeit('perfect_itarator(10)', "from __main__ import perfect_itarator", number = 1)

comp100 = timeit.timeit('perfect_list_comp(100)', "from __main__ import perfect_list_comp", number = 1)
func100 = timeit.timeit('perfect_func(100)', "from __main__ import perfect_func", number = 1)
it100 = timeit.timeit('perfect_itarator(100)', "from __main__ import perfect_itarator", number = 1)

comp1000 = timeit.timeit('perfect_list_comp(1000)', "from __main__ import perfect_list_comp", number = 1)
func1000 = timeit.timeit('perfect_func(1000)', "from __main__ import perfect_func", number = 1)
it1000 = timeit.timeit('perfect_itarator(1000)', "from __main__ import perfect_itarator", number = 1)

rows = [[" ", "|", "skladana", "|", "funkcyjna", "|", "iteracyjna"]
        , ["10", "|", str(comp10), "|", str(func10), "|", str(it10)]
        , ["100", "|", str(comp100), "|", str(func100), "|", str(it100)]
        , ["1000", "|", str(comp1000), "|", str(func1000), "|", str(it1000)]]

widths = [max(map(len, col)) for col in zip(*rows)]
for row in rows:
    print("  ".join((val.ljust(width) for val, width in zip(row, widths))))
