import unittest
from fifth.wwwlinkchecker.linkfollower import LinkFollower


class Tests(unittest.TestCase):
    def test_check_links(self):
        lf = LinkFollower('/home/jjpikoov/coding/python/RozszPython/fifth/website/')
        lf.check_links()

if __name__ == '__main__':
    unittest.main()
