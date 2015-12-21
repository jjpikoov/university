import os


class dirHandler():

    def __init__(self, main_directory):
       self.main_directory = main_directory 

    def list_all_directories(self):
        self.result = []
        for root, dirs, files in os.walk(self.main_directory):
            self.result.append(root)
        return self.result

    def all_html_files(self, in_directory):
        self.result = []
        for f in os.listdir(in_directory):
            if f.endswith(".html"):
                self.result.append(in_directory + "/" + f)
        return self.result

    def all_files_with_extension(self, in_directory, *extensions):
        self.result = []
        for f in os.listdir(in_directory):
            for ext in extensions:
                if f.endswith(ext):
                    self.result.append(in_directory + "/" + f)
        return self.result

    def is_file_or_dir(self, file_or_dir):
        return os.path.exists(file_or_dir)

    def is_file(self, item):
        return os.path.isfile(item)
