from fifth.wwwlinkchecker.directories import dirHandler
from fifth.wwwlinkchecker.links import ImageParser
from fifth.wwwlinkchecker.links import LinkParser
from fifth.wwwlinkchecker.links import RemoteLinkHandler

class LinkFollower():
    def __init__(self, main_directory):
        self.dh = dirHandler(main_directory)
        self.rlh = RemoteLinkHandler()
        self.main_directory = main_directory
        
    def check_links(self):
        for d in self.dh.list_all_directories():
            for w in self.dh.all_html_files(d):
                container = []
                lp = LinkParser(w)
                container += lp.getLinks()
                ip = ImageParser(w)
                container += ip.getLinks()
                for l in container:
                    if self.dh.is_file_or_dir(l) or self.rlh.is_active(l):
                        print("[OK] "),
                    else:
                        print("[NOT OK !!!] "),
                    print(l)


