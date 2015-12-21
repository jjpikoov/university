import unittest
from sixth.wwwlinkchecker.links import RemoteLinkHandler
from sixth.wwwlinkchecker.links import LinkParser
from sixth.wwwlinkchecker.links import ImageParser

rlh = RemoteLinkHandler()


class Test(unittest.TestCase):
    def test_is_active(self):
        self.assertEqual(rlh.is_active('http://stackoverflow.com/questions/16778435/python-check-if-website-exists'), True)
        self.assertEqual(rlh.is_active('https://sdklfjsdklfjkdsljsdklfj.com'), False)
        self.assertEqual(rlh.is_active("http://google.com"), True)
# IMAGES

        self.assertEqual(rlh.is_active('https://openclipart.org/image/90px/svg_to_png/231812/Seamless-Doodle.png'), True)
        self.assertEqual(rlh.is_active('https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/800px-Image_created_with_a_mobile_phone.png'), True)
        self.assertEqual(rlh.is_active('https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/800px-Image_created_with_a_mobile_phonee.png'), False)
        self.assertEqual(rlh.is_active('mailto:thomas.hirsch@statkart.no'), False)

    def test_linkparser(self):
        print("linkparser")
        lpp = LinkParser('/home/jjpikoov/coding/python/RozszPython/sixth/website/relet.github.io/kivyMaps/configuration.html')
        # with open('/home/jjpikoov/coding/python/RozszPython/fifth/website/relet.github.io/kivyMaps/configuration.html') as data2:
         #    lpp.feed(data2.read())
        for link2 in lpp.getLinks():
            print link2

    def test_imageparser(self):
        print("imageparser")
        ip = ImageParser('/home/jjpikoov/coding/python/RozszPython/sixth/website/relet.github.io/kivyMaps/index.html')
        for link in ip.getLinks():
            print link
        print("")
       




if __name__ == '__main__':
    unittest.main()
