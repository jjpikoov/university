import unittest
from fifth.wwwlinkchecker.linkfollower import LinkFollower


class Tests(unittest.TestCase):
    """Only run LinkFollower"""
    def test_check_links(self):
        main_dir = "/home/jjpikoov/coding/python/" \
                   "RozszPython/fifth/website/"
        lf = LinkFollower(main_dir)
        lf.check_links()

if __name__ == '__main__':
    unittest.main()
