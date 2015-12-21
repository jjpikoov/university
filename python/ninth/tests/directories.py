import unittest
from ninth.wwwlinkchecker.directories import dirHandler
import os


class Tests(unittest.TestCase):
    """Unit tests for dirHandler class"""
    test_dir = '/home/jjpikoov/coding/python/RozszPython/fifth/website/'
    dh = dirHandler(test_dir)

    def test_list_all_directories(self):
        """Test for list_all_directories method"""
        dirs = self.dh.list_all_directories()
        for d in dirs:
            self.assertEqual(os.path.isdir(d), True)

    def test_all_html_files(self):
        """Test for all_html_files method"""
        for h in self.dh.all_html_files(self.test_dir):
            self.assertEqual(h.endswith('.html'), True)

if __name__ == "__main__":
    unittest.main()
