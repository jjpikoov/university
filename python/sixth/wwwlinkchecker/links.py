import urlparse
import httplib2
from HTMLParser import HTMLParser


class RemoteLinkHandler():
    def is_active(self, url):
        h = httplib2.Http()
        try:
            resp = h.request(url, 'HEAD')
            if int(resp[0]['status']) == 200:
                return True
            else:
                return False
        except:
            return False


class LinkParser(HTMLParser):
    def __init__(self, html_main):
        global links
        links = []
        HTMLParser.__init__(self)
        self.html_main = html_main

    def is_absolute_ulr(self, url):
        return bool(urlparse.urlparse(url).netloc)

    def handle_starttag(self, tag, attrs):
        if tag == "a":
            for (atr, val) in attrs:
                if atr == 'href':
                    if "mailto" not in val:
                        if self.is_absolute_ulr(val):
                            links.append(val)
                        else:
                            joined = urlparse.urljoin(self.html_main, val)
                            links.append(joined)

    def getLinks(self):
        with open(self.html_main) as data:
            self.feed(data.read())
        return links 






class ImageParser(HTMLParser):
    def __init__(self, html_main):
        global links
        links = []
        HTMLParser.__init__(self)
        self.html_main = html_main

    def is_absolute_ulr(self, url):
        return bool(urlparse.urlparse(url).netloc)

    def handle_starttag(self, tag, attrs):
        if tag == "img":
            for (atr, val) in attrs:
                if atr == 'src':
                    if self.is_absolute_ulr(val):
                        links.append(val)
                    else:
                        joined = urlparse.urljoin(self.html_main, val)
                        links.append(joined)

    def getLinks(self):
        with open(self.html_main) as data:
            self.feed(data.read())
        return links 

