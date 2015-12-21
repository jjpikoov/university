# import unittes
from sixth.wwwlinkchecker.directories import dirHandler

dh = dirHandler('/home/jjpikoov/coding/python/RozszPython/sixth/website/')

directories = dh.list_all_directories()


for d in directories:
    print("DIRECTORY: " + str(d))
    # ahf = dh.all_html_files(d)
    # print(ahf)
    print("===============================")
    alll = dh.all_files_with_extension(d, ".html", ".png", ".jpg", ".gif")
    print(alll)
    print("===============================")
    print("")

# print("+++++++++++++++++")
# print(d)
# print(ahf)
# print(dh.is_file_or_dir(d + "/" +  ahf[0]))
# print(dh.is_file_or_dir(d))
# print(dh.is_file_or_dir('dksljfskldfjklfjd'))
