#include <gtk/gtk.h>
////////////////////////////////// ELEMENT //////////////////////////////
typedef struct element
{
    gboolean is_num;
    gint num;

    gboolean is_subscript;
    gchar subscript;
    gint subscript_number;

    gboolean is_operator;
    gint operator;

    gboolean is_parantheses;

    struct element *left;
    struct element *right;


    gdouble lenght;
    gdouble width;
    gdouble olenght;
    gdouble owidth;

    gdouble x;
    gdouble y;
    gdouble ox;
    gdouble oy;



} ELEMENT;



//////////////////////////////////////////// WINDOW_AND_SEARCH_ENTRY //////////////////////////
typedef struct window_and_search_entry
{
    GtkWidget *window;
    GtkWidget *search_entry;
    GtkWidget *scrolled; //stack
    GtkWidget *d_area; //WILLSEE

} WINDOW_AND_SEARCH_ENTRY;



//////////////// MAIN GTK FUNCTIONS ////////////////////
void show_error(gchar *message);
ELEMENT *operate(const gchar *text, GtkWidget *window);
ELEMENT *analyse(GtkWidget *widget, WINDOW_AND_SEARCH_ENTRY *data);



/////////////STACK FUNCTIONS ///////////////
ELEMENT *new_malloc_element(void);
ELEMENT *add_operation(gint operation, ELEMENT *f, ELEMENT *s);
ELEMENT *add_num(gint num);
ELEMENT *add_chr(gchar chr);
ELEMENT *add_chr_with_subscript(gchar subscript, gint subscript_number);
ELEMENT *add_parantheses(ELEMENT *e);



/////////////////////////////// FUNCTIONS FROM LECTURE /////////////
void turn_back_chr(gint z);
gdouble read_number(void);
gint read_chr(void);
gint read_chr_extended(void);
ELEMENT *expression(void);
ELEMENT *term(void);
ELEMENT *factor(void);
ELEMENT *power(void);



/////////////////////////// PRINT FUNCTIONS //////////////
void print_on_console(ELEMENT *p);
void print_on_console_with_new_line(ELEMENT *p);
void debug(gchar *message);

gboolean expose_event_callback (GtkWidget *widget, GdkEventExpose *event, gpointer data);
void do_drawing(cairo_t *cr, ELEMENT *p);



//////////////////////////// UTILITIES ////////////////////
gint max(int a, int b);
gint how_many_digits(gint x);
void do_xy(ELEMENT *p);
GdkPixbuf *create_pixbuf(const gchar * filename);

