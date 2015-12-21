import unittest
from ninth.wwwlinkchecker.links import RemoteLinkHandler
from ninth.wwwlinkchecker.links import LinkParser
from ninth.wwwlinkchecker.links import ImageParser

rlh = RemoteLinkHandler()


class Test(unittest.TestCase):
    """Test for is_active mehtod"""

    def test_is_active(self):
        self.assertEqual(
            rlh.is_active('http://stackoverflow.com/questions/'
                          '16778435/python-check-if-website-exists'),
            True)
        self.assertEqual(rlh.is_active(
            'https://sdklfjsdklfjkdsljsdklfj.com'), False)
        self.assertEqual(rlh.is_active("http://google.com"), True)

# IMAGES

        self.assertEqual(rlh.is_active(
            'https://openclipart.org/image/90px/svg_to_png/231812/'
            'Seamless-Doodle.png'), True)
        self.assertEqual(rlh.is_active(
            'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/'
            'Image_created_with_a_mobile_phone.png/'
            '800px-Image_created_with_a_mobile_phone.png'), True)
        self.assertEqual(rlh.is_active(
            'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/'
            'Image_created_with_a_mobile_phone.png/'
            '800px-Image_created_with_a_mobile_phonee.png'), False)
        self.assertEqual(rlh.is_active(
            'mailto:thomas.hirsch@statkart.no'), False)

    def test_for_relative_links(self):
            """Tests which check whether link is relative or absolute"""
            lpp = LinkParser(
                '/home/jjpikoov/coding/python/RozszPython/fifth/website/'
                'relet.github.io/kivyMaps/configuration.html')
            ip = ImageParser(
                '/home/jjpikoov/coding/python/RozszPython/fifth/website/'
                'relet.github.io/kivyMaps/index.html')

            self.assertFalse(lpp.is_absolute_ulr('index.html'))
            self.assertFalse(ip.is_absolute_ulr('index.html'))

            self.assertTrue(lpp.is_absolute_ulr('http://www.mysite.com'))
            self.assertTrue(ip.is_absolute_ulr('http://www.mysite.com'))

            self.assertFalse(lpp.is_absolute_ulr(
                '/help/articles/how-do-i-set-up-a-webpage.html'))
            self.assertFalse(ip.is_absolute_ulr(
                '/help/articles/how-do-i-set-up-a-webpage.html'))

            self.assertTrue(lpp.is_absolute_ulr(
                'http://www.mysite.com/help/articles/'
                'how-do-i-set-up-a-webpage.html'))
            self.assertTrue(ip.is_absolute_ulr(
                'http://www.mysite.com/help/articles/'
                'how-do-i-set-up-a-webpage.html'))

    def test_linkparser(self):
        """Tests LinkParser"""
        lpp = LinkParser(
            '/home/jjpikoov/coding/python/RozszPython/fifth/website/'
            'relet.github.io/kivyMaps/configuration.html')
        for link2 in lpp.getLinks():
            self.assertEqual(
                link2.endswith('.html')
                or link2.endswith('/'), True, link2)

    def test_imageparser(self):
        """Tests for imageparser"""
        print("imageparser")
        ip = ImageParser(
            '/home/jjpikoov/coding/python/RozszPython/fifth/website/'
            'relet.github.io/kivyMaps/index.html')
        for link in ip.getLinks():
            self.assertEqual((
                link.endswith('.png') or link.endswith('.jpg')
                or link.endswith('.gif')), True)

if __name__ == '__main__':
    unittest.main()
