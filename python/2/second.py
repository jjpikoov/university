from sets import Set


class ObiektyDodawalne():
    def merge_attributes(self, another_class):
        result = EmptyObject()
        if not issubclass(another_class.__class__, ObiektyDodawalne):
            print "I CAN'T DO THAT"
            return result
        this_class_vars = vars(self)
        another_class_vars = vars(another_class)
        this_class_vars_keys = Set(this_class_vars.keys())
        another_class_vars_keys = Set(another_class_vars.keys())
        union = this_class_vars_keys.union(another_class_vars_keys)
        intersection = this_class_vars_keys.intersection(another_class_vars_keys)
        for proprty in union:
            try:
                if (proprty in intersection):
                    print "WATCH OUT, ELEMENT IN INTERSECTION\n"
                setattr(result, proprty, this_class_vars[proprty])
                # result.__setattr__(proprty, this_class_vars[proprty])
            except KeyError:
                setattr(result, proprty, another_class_vars[proprty])
                # result.__setattr__(proprty, another_class_vars[proprty])
        return result

    def __radd__(self, obj):
        return self.merge_attributes(obj)


class EmptyObject(ObiektyDodawalne):
    pass


class First(ObiektyDodawalne):
    def __init__(self):
        self.a = 1
        self.c = 2


class Second(ObiektyDodawalne):
    def __init__(self):
        self.a = 0
        self.b = 1


class Third():
    def __init__(self):
        self.y = 5
        self.z = 6

f = First()
s = Second()

print vars(f + s)
print ""
print vars(s + f)
print ""

t = Third()
t + f 
