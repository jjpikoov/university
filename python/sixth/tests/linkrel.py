from sixth.wwwlinkchecker.linkrel import LinkRel

lr = LinkRel('/home/jjpikoov/coding/python/RozszPython/sixth/website/')
for k, v in lr.run().items():
    print("====================")
    print(k)
    print("====================")
    for i in v:
        print(i)
    print("")
    print("")
    print("")
    print("")
