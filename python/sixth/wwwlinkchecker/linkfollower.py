from sixth.wwwlinkchecker.directories import dirHandler
from sixth.wwwlinkchecker.links import ImageParser
from sixth.wwwlinkchecker.links import LinkParser
from sixth.wwwlinkchecker.links import RemoteLinkHandler
from multiprocessing import Pool, Process, Queue
import itertools


class LinkFollower():
    def __init__(self, main_directory):
        self.dh = dirHandler(main_directory)
        self.rlh = RemoteLinkHandler()
        self.main_directory = main_directory
        
    def check_links(self):
        for d in self.dh.list_all_directories():
            for w in self.dh.all_html_files(d):
                container = self.link_receiver(w) 

                is_link_alive_locally = IsLinkAliveLocally(self.main_directory)
                is_link_alive_remote = IsLinkAliveRemote()

                locally = Pool().map(is_link_alive_locally, container)
                remote = Pool().map(is_link_alive_remote, container)

                for l in container:
                    index = container.index(l)
                    if locally[index] or remote[index]:
                        print("[OK] " + l)
                    else:
                        print("[FAIL] " + l)

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


class IsLinkAliveLocally():
    def __init__(self, main_directory):
        self.dh = dirHandler(main_directory)

    def __call__(self, link):
        if self.dh.is_file_or_dir(link):
            return True
        else:
            return False


class IsLinkAliveRemote():
    def __init__(self):
        self.rlh = RemoteLinkHandler()

    def __call__(self, link):
        if self.rlh.is_active(link):
            return True
        else:
            return False
