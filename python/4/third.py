import io


class CollectionIterator(object):
    def __init__(self, _bufferr):
        self.bufferr = _bufferr
        self.pointer = 0

    def __next__(self):
        _bufferr = self.bufferr.getvalue()
        _bufferr = _bufferr.split('\n')
        if self.pointer < len(_bufferr) - 1:
            self.pointer += 1
            return _bufferr[self.pointer - 1]
        else:
            raise StopIteration


class Collection(object):
    def __init__(self, _bufferr):
        self.bufferr = _bufferr

    def __iter__(self):
        return CollectionIterator(self.bufferr)


def correction(sentence):
    if (sentence[0].isupper() and sentence[-1] == "."):
        return sentence
    else:
        right_sentence = list(sentence)
        while (right_sentence[-1] in [" ", "\n", "\t"]):
            right_sentence.pop()
        right_sentence[0] = right_sentence[0].upper()
        if right_sentence[-1] != ".":
            right_sentence.append(".")
        return "".join(right_sentence)


bufferr = io.StringIO()
bufferr.write("Test bez kropki i z dużej litery\n")
bufferr.write("bez kropki i z małej litery \n")
bufferr.write("Z dużej litery i z kropką.\n")
bufferr.write("Z białymi znakami. 	     \n")
bufferr.write("same błedy z małej i bez kropki     \n")
collection = Collection(bufferr)
print(list(map(correction, collection)))
