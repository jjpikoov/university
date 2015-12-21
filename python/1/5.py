#!/usr/bin/env python
def table(x1, x2, y1, y2):
    print "{0:1}".format(""),
    for i in range(x1, x2 + 1):
        print "{0:>2}".format(i),

    print ""

    for j in range(y1, y2 + 1):
        print "{0}".format(j),
        for yy in range(x1, x2 + 1):
            print "{0:2}".format(yy * j),
        print ""
