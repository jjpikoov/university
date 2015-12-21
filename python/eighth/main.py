from gi.repository import Gtk, GObject
import sqlite3
import os 


class GtkHandler():
    def __init__(self, controller):
        self.controller = controller

    def gtk_quit(*args):
        Gtk.main_quit()

    def create_button_clicked(self, new_window):
        new_window.set_title("Create record")
        new_window.set_position(Gtk.WindowPosition.CENTER)
        new_window.resize(300, 300)
        new_window.show()

    def oku_button_clicked(self, mod_window):
        self.controller.delete_record()
        self.ok_button_clicked(mod_window)


    def update_button_clicked(self, mod_window):
        mod_window.set_title("Update")
        mod_window.set_position(Gtk.WindowPosition.CENTER)
        mod_window.resize(300, 300)
        mod_window.show()
        grid = mod_window.get_children()[0]
        cd_id_entry = grid.get_child_at(1, 0)
        songs_entry = grid.get_child_at(1, 1)
        authors_entry = grid.get_child_at(1, 2)
        borrowed_box = grid.get_child_at(1, 3)

        cd_id_entry.set_text(str(self.controller.get_selected_item()[0]))
        songs_entry.set_text(self.controller.get_selected_item()[1])
        authors_entry.set_text(self.controller.get_selected_item()[2])
        borrowed_box.set_active(bool(self.controller.get_selected_item()[3]))


    def delete_button_clicked(self, foo):
        self.controller.delete_record()


    def ok_button_clicked(self, new_window):
        grid = new_window.get_children()[0]
        cd_id_entry = grid.get_child_at(1, 0)
        songs_entry = grid.get_child_at(1, 1)
        authors_entry = grid.get_child_at(1, 2)
        borrowed_box = grid.get_child_at(1, 3)

        cd_id = int(cd_id_entry.get_text())
        songs = str(songs_entry.get_text())
        authors = str(authors_entry.get_text())
        borrowed = int(borrowed_box.get_active())
        
        self.controller.add_record(cd_id, songs, authors, borrowed)

    def row_selected(self, view_tree):
        tree_selection = tree_view.get_selection()
        model, pathlist = tree_selection.get_selected_rows()
        for path in pathlist:
            tree_iter = model.get_iter(path)
            cd_id = model.get_value(tree_iter, 0)
            songs = model.get_value(tree_iter, 1)
            authors = model.get_value(tree_iter, 2)
            borrowed = model.get_value(tree_iter, 3)
            self.controller.set_selected_item(cd_id, songs, authors, borrowed)

    def filter_activated(self, entry):
        text = entry.get_text()
        if len(text) != 0:
            self.controller.id_filter = True
            cd_id = int(text)
            self.controller.d = self.controller.data.get_data_by_id(cd_id)
        else:
            self.controller.id_filter = False
        self.controller.view_all()

        
    def hide_widget(self, widget):
        widget.hide()

    def destroy_widget(self, widget):
        widget.destroy()


class Cd():
    cd_id = None
    songs = ""
    authors = ""
    borrowed = False


class Data():
    def __init__(self):
        self.db = sqlite3.connect("/home/jjpikoov/cdz.db")
        self.cursor = self.db.cursor()

        if  os.path.isfile("/home/jjpikoov'cdz.db") is True:
            self.cursor.execute("CREATE TABLE Cdz (Cd_id INT PRIMARY KEY, Songs TEXT, Authors TEXT, Borrowed INT)")
            self.db.commit()
            self.sample_data_init()
            self.db.commit()


    def sample_data_init(self):
        self.cursor.execute('INSERT INTO Cdz VALUES(0, "Piano Man, Honesty", "Billy Joel", 1)')
        self.cursor.execute('INSERT INTO Cdz VALUES(1, "Help, Yesterday", "The Beatles", 0)')

    def get_data(self):
        result = []
        self.cursor.execute("SELECT * FROM Cdz")
        for row in self.cursor:
            result.append(row)
        return result

    def get_data_by_id(self, cd_id):
        result = []
        self.cursor.execute("SELECT * FROM Cdz WHERE Cd_id = {0}".format(cd_id))
        for row in self.cursor:
            result.append(row)
        return result

    def add_record(self, cd_id, songs, authors, borrowed):
        self.cursor.execute('INSERT INTO Cdz VALUES({0}, "{1}", "{2}", {3})'.format(cd_id, songs, authors, borrowed))
        self.db.commit()

    def delete_record(self, cd_id):
        self.cursor.execute('DELETE FROM Cdz WHERE Cd_id = {0}'.format(cd_id))
        self.db.commit()


class Controller():

    def __init__(self, tree_view, data):
        self.tree_view = tree_view
        self.data = data
        self.id_filter = False
        self.tree_view.set_rules_hint(True)
        self.create_columns(tree_view)
        self.view_all()

    def create_model(self):
        store = Gtk.ListStore(
                GObject.TYPE_INT,
                GObject.TYPE_STRING,
                GObject.TYPE_STRING,
                GObject.TYPE_INT)

        if self.id_filter is False:
            self.d = self.data.get_data()

        for idd, songs, authors, borrowed in self.d:
            store.append([idd, songs, authors, borrowed])
        return store

    def view_all(self):
        store = self.create_model()
        self.tree_view.set_model(store)

    def create_columns(self, tree_view):
        renderText = Gtk.CellRendererText()
        column0 = Gtk.TreeViewColumn("Cd ID", renderText, text=0)
        column0.set_sort_column_id(0)
        self.tree_view.append_column(column0)

        renderText = Gtk.CellRendererText()
        column1 = Gtk.TreeViewColumn("Songs", renderText, text=1)
        column1.set_sort_column_id(1)
        self.tree_view.append_column(column1)

        renderText = Gtk.CellRendererText()
        column2 = Gtk.TreeViewColumn("Authors", renderText, text=2)
        column2.set_sort_column_id(2)
        self.tree_view.append_column(column2)

        renderText = Gtk.CellRendererText()
        column3 = Gtk.TreeViewColumn("Is borrowed", renderText, text=3)
        column3.set_sort_column_id(3)
        self.tree_view.append_column(column3)

    def add_record(self, cd_id, songs, authors, borrowed):
        self.data.add_record(cd_id, songs, authors, borrowed)
        self.view_all()

    def set_selected_item(self, cd_id, songs, authors, borrowed):
        self.selected_item_id = cd_id
        self.selected_item_songs = songs
        self.selected_item_authors = authors
        self.selected_item_borrowed = borrowed

    def get_selected_item(self):
        return (
                self.selected_item_id,
                self.selected_item_songs,
                self.selected_item_authors,
                self.selected_item_borrowed)



    def delete_record(self):
        self.data.delete_record(self.selected_item_id)
        self.view_all()



builder = Gtk.Builder()
builder.add_from_file("cdz.glade")

window = builder.get_object("window")
window.set_title("Cdz")
window.resize(500, 400)
window.set_position(Gtk.WindowPosition.CENTER)


tree_view = builder.get_object("tree_view")
d = Data()
c = Controller(tree_view, d)
builder.connect_signals(GtkHandler(c))

window.show_all()
Gtk.main()
