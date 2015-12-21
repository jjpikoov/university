from gi.repository import Gtk
import math


class Handler():
    def show_dialog(self, dialog):
        dialog.show()

    def gtk_widget_hide(self, *args):
        args[0].hide()

    def gtk_quit(self, *args):
        Gtk.main_quit()

    def init_drawing_area(self, drawing_area, *args):
        Drawer.draw_all(drawing_area)

    def forward_entry(self, text_entry_window):
        text_entry_window.set_position(Gtk.WindowPosition.CENTER)
        text_entry_window.set_title("Forward")
        text_entry_window.show()

    def turn_window(self, t_window):
        t_window.set_position(Gtk.WindowPosition.CENTER)
        t_window.set_title("Turn")
        t_window.resize(200, 200)
        t_window.show()

    def text_entry_ok(self, entry):
        value = int(entry.get_text())
        Drawer.forward(value)

    def turn4(*args):
        Drawer.turn90()
        

    def turn3(*args):
        Drawer.turn90()
        Drawer.turn90()

    def turn2(*args):
        Drawer.turn90()
        Drawer.turn90()
        Drawer.turn90()

    def updown_main(*args):
        Drawer.raised_brush = not Drawer.raised_brush
 
    def main_to_middle(self, drawing_area):
        Drawer.x, Drawer.y = Drawer.middle
        Drawer.turn = 1
        Drawer.draw_all(drawing_area)

class Drawer():
    raised_brush = False
    steps = []
    turn = 1
    x = None
    y = None
    middle = None

    @staticmethod
    def lower_brush():
        Drawer.raised_brush = False

    @staticmethod
    def raise_brush():
        Drawer.raised_brush = True

    @staticmethod
    def forward(length):
        tupl = (Drawer.x, Drawer.y, length, Drawer.turn)
        if Drawer.turn == 1:
            Drawer.y -= length
        elif Drawer.turn == 2:
            Drawer.x -= length
        elif Drawer.turn == 3:
            Drawer.y += length
        else:
            Drawer.x += length

        if (not Drawer.raised_brush):
            Drawer.steps.append(tupl)

    @staticmethod
    def turn90():
        Drawer.turn = Drawer.turn + 3
        if (Drawer.turn >= 5):
            Drawer.turn = Drawer.turn % 4

    @staticmethod
    def draw_all(widget):
        window = widget.get_property('window')
        cr = window.cairo_create()
        if Drawer.x is None and Drawer.y is None:
            Drawer.x, Drawer.y = window.get_geometry()[2]/2, window.get_geometry()[3]/2
            Drawer.middle = Drawer.x, Drawer.y

        cr.set_source_rgb(255, 255, 255)
        cr.arc(250, 250, 99999, 0, 2*math.pi)
        cr.stroke_preserve()
        cr.fill()

        for x, y, l, t in Drawer.steps:

            cr.set_source_rgb(0, 0, 0)
            cr.set_line_width(2)
            cr.move_to(x, y)

            if t == 1:
                cr.line_to(x, y - l)
            elif t == 2:
                cr.line_to(x-l, y)
            elif t == 3:
                cr.line_to(x, y + l)
            else:
                cr.line_to(x + l, y)

            cr.stroke()

        cr.set_source_rgb(0.7, 0.2, 0.0)
        cr.arc(Drawer.x, Drawer.y, 3, 0, 2*math.pi)
        cr.stroke_preserve()
        cr.fill()


builder = Gtk.Builder()
builder.add_from_file("turrtl.glade")
builder.connect_signals(Handler())

window = builder.get_object("main_window")
window.set_title("Turrtl")
window.set_position(Gtk.WindowPosition.CENTER)
window.resize(500, 500)


drawing_area = builder.get_object("main_board")



window.show_all()
Gtk.main()
