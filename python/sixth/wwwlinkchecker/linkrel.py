from sixth.wwwlinkchecker.directories import dirHandler
from sixth.wwwlinkchecker.links import ImageParser
from sixth.wwwlinkchecker.links import LinkParser
from multiprocessing import Queue, Process
import itertools


class LinkRel():
    def __init__(self, main_directory):
        self.main_directory = main_directory
        self.dh = dirHandler(main_directory)

    def run(self):
        dic = {}
        for d in self.dh.list_all_directories():
            for f in self.dh.all_files_with_extension(d, ".html", ".png", ".jpg", ".gif"):
                dic[f] = []

        for d in self.dh.list_all_directories():
            for w in self.dh.all_html_files(d):
                container = self.link_receiver(w)
                for l in container:
                    if self.dh.is_file(l):
                        dic[l].append(w)
        return dic

    def get_links(self, q, website):
        lp = LinkParser(website)
        q.put(lp.getLinks())

    def get_images(self, q, website):
        ip = ImageParser(website)
        q.put(ip.getLinks())

    def link_receiver(self, website):
        q = Queue()
        p1 = Process(target=self.get_links, args=(q, website))
        p2 = Process(target=self.get_images, args=(q, website))
        p1.start()
        p2.start()
        p1.join()
        p2.join()
        result = []
        while not q.empty():
            result.append(q.get())
        return list(itertools.chain.from_iterable(result))

