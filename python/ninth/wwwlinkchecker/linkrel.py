from ninth.wwwlinkchecker.directories import dirHandler
from ninth.wwwlinkchecker.links import ImageParser
from ninth.wwwlinkchecker.links import LinkParser


class LinkRel():
    def __init__(self, main_directory):
        self.main_directory = main_directory
        self.dh = dirHandler(main_directory)

    def run(self):
        """Main function of LinkRel"""
        dic = {}
        for d in self.dh.list_all_directories():
            for f in self.dh.all_files_with_extension(
                    d, ".html", ".png", ".jpg", ".gif"):
                dic[f] = []

        for d in self.dh.list_all_directories():
            for w in self.dh.all_html_files(d):
                container = []
                lp = LinkParser(w)
                container += lp.getLinks()
                ip = ImageParser(w)
                container += ip.getLinks()
                for l in container:
                    if self.dh.is_file(l):
                        dic[l].append(w)
        return dic
