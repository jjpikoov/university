class HtmlObject(object):
    def html(self):
        result = ""
        for prop, value in vars(self).iteritems():
            result += "<br><u>Property: </u>{0}, <u>type: </u>{1}, <u>value: </u> {2}".format(prop, type(value).__name__, value) + "\n"
        result += "<br><br>"

        return result

    def html_page(self):
        result = ""
        v = vars(self)
        result += "<b>Properties:</b><br><br>"
        for prop in v:
            result += "<i>[{0}]:</i><br>".format(prop)
            if hasattr(v[prop], 'html'):
                result += v[prop].html()
            else:
                result += "<br>Value: {0}<br>".format(v[prop])
            print "\n"
        return result


class NormalClass(object):
    def __init__(self):
        self.x = 5
        self.y = 10


class Foo2html(HtmlObject):
    def __init__(self):
        self.w = 17
        self.q = NormalClass()
    pass


class Foo3(HtmlObject):
    def __init__(self):
        self.g = 1
        self.z = Foo2html()

html = Foo3()
x = open('first.html', 'w')
x.write(html.html_page())
x.close()
