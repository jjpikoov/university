#include <cairo.h>
#include <gtk/gtk.h>
#include "functions.h"

#define NUMBER '0' 
#define VARIABLE '$'

///////////////////// GLOBAL VARIABLES ///////////////////////
const gchar *inptr;

GtkWidget *main_window;
GtkWidget *formula_scrolled_window;
GtkWidget *d_area;

gchar buffer[30];
gdouble LL = 30;
gdouble WW = 50;

gboolean DIV = FALSE;
gboolean IN_POWER = FALSE;

gdouble BIG = 30;
gdouble SMALL = 10;


cairo_t *cr;
ELEMENT *foo;


///////////////// ANALYSE ////////////////////////
ELEMENT *analyse(GtkWidget *widget, WINDOW_AND_SEARCH_ENTRY *data)
{
    const gchar *text = gtk_entry_get_text(GTK_ENTRY(data->search_entry));
    main_window = data->window;
    formula_scrolled_window = data->scrolled;
    d_area = data->d_area;


    foo = operate(text, GTK_WIDGET(data->window));
    do_xy(foo);
    print_on_console_with_new_line(foo);

    gtk_widget_queue_draw(formula_scrolled_window);

    if (LL > 400 || WW > 200)
    {
        gtk_widget_set_size_request(d_area, LL + 100, WW + 100);
    }


    LL = 30;
    WW = 50;
}




///////////////////////////////////// SHOW_ERROR /////////////////////////////////////
void show_error(gchar *message)
{
    GtkWidget *dialog;
    dialog = gtk_message_dialog_new(GTK_WINDOW(main_window),
            GTK_DIALOG_DESTROY_WITH_PARENT,
            GTK_MESSAGE_ERROR,
            GTK_BUTTONS_OK,
            "%s",message);
    gtk_window_set_title(GTK_WINDOW(dialog), "Error");
    gtk_dialog_run(GTK_DIALOG(dialog));
    gtk_widget_destroy(dialog);
}



/////////////////////////// OPERATION //////////////////////////////////
ELEMENT *operate(const gchar *text, GtkWidget *window)
{

    gint z;
    ELEMENT *new;

    inptr = text;

    while ((z = read_chr_extended()) != EOF)
    {
        turn_back_chr(z);
        new = expression();

        return new;
    }

}



/////////////////// ADD_OPERATION /////////////////////////
ELEMENT *add_operation(gint operation, ELEMENT *f, ELEMENT *s)
{
    ELEMENT *new = new_malloc_element();

    new->is_num = FALSE;
    new->is_subscript = FALSE;
    new->is_operator = TRUE;
    new->operator = operation;
    new->left = f;
    new->right = s;
    new->is_parantheses = FALSE;


    if (operation != '/' && operation != '^')
    {
        new->olenght = BIG;
        new->owidth = BIG;
        new->lenght = f->lenght + new->olenght + s->lenght;
        new->width = max(f->width, s->width);

        new->x = 0;
        new->y = 0;
        new->ox = 0;
        new->oy = 0;
    }
    else if (operation == '^')
    {
        new->lenght = f->lenght + s->lenght;
        new->width = f->width + (s->lenght)/2;
        new->olenght= f->lenght;
        new->owidth = f->width/2;

        new->x = 0;
        new->y = 0;
        new->ox = 0;
        new->oy = 0;
    }
    else 
    {
        new->olenght = max(f->lenght, s->lenght);
        new->owidth = f->width;
        new->lenght = new->olenght;
        new->width = f->width + new->owidth + s->width;

        new->x = 0;
        new->y = 0;
        new->ox = 0;
        new->oy = 0;
    }

    return new;

}



////////////////////////// ADD_NUM /////////////////////
ELEMENT *add_num(gint num)
{
    ELEMENT* new;
    new = new_malloc_element();

    new->is_num = TRUE;
    new->num = num;
    new->is_subscript = FALSE;
    new->is_operator = FALSE;
    new->is_parantheses = FALSE;

    new->left = NULL;
    new->right = NULL;



    new->lenght = BIG * how_many_digits(num);

    new->width = BIG;
    new->olenght = 0;
    new->owidth = 0;

    new->x = 0;
    new->y = 0;
    new->ox = 0;
    new->oy = 0;



    return new;
}



//////////////////////// ADD_CHR_WITH_SUBSCRIPT ///////////////////
ELEMENT *add_chr_with_subscript(gchar subscript, gint subscript_number)
{
    ELEMENT *new = new_malloc_element();

    new->is_num = FALSE;
    new->is_subscript = TRUE;
    new->subscript= subscript;
    new->subscript_number = subscript_number;
    new->is_operator = FALSE;
    new->is_parantheses = FALSE;


    new->lenght = BIG + BIG / 5;
    new->width = BIG + BIG / 5;
    new->olenght = BIG / 2;
    new->owidth = BIG / 5;

    new->x = 0;
    new->y = 0;
    new->ox = 0;
    new->oy = 0;



    return new;
}



////////////////// ADD_PARANTHESES /////////////////
ELEMENT *add_parantheses(ELEMENT *e)
{
    ELEMENT *new = new_malloc_element();

    new->is_num = FALSE;
    new->is_subscript = FALSE;
    new->is_operator = FALSE;
    new->is_parantheses = TRUE;
    new->left = e;
    new->right = NULL;

    new->lenght = BIG + e->lenght + BIG;
    new->width = e->width;
    new->olenght = e->lenght/10;
    new->owidth = 0;

    new->x = 0;
    new->y = 0;
    new->ox = 0;
    new->oy = 0;



    return new;
}



////////////////////////////////////////////////////////
//////////////////// FROM LECTURE///////////////////////
////////////////////////////////////////////////////////



//////////////////////// TURN_BACK_CHR /////////////////
void turn_back_chr(gint z)
{
    if (z != EOF && z != NUMBER && z != VARIABLE)
        --inptr;
} 



////// READ_NUMBER ////////////////
gdouble read_number(void)
{
    gint z;
    gdouble n=0.0;
    gdouble exp10=1.0;

    while((z = *inptr++) != '\0' && g_ascii_isdigit(z))
    {
        n = 10.0 * n + (z-'0');
    }


    turn_back_chr(z == 0 ? EOF : z);

    return n/exp10;
}




///////////////////////// READ_CHR_EXTENDED ////////////////
gint read_chr_extended(void)
{
    gint z;

    if (*inptr=='\0') 
    {
        return EOF;
    }

    while ((z = *inptr++) != '\0' && g_ascii_isspace(z));

    if (g_ascii_isdigit(z))
    {
        turn_back_chr(z);
        return NUMBER;
    }
    else if (z == '[')
    {
        turn_back_chr(z);
        return VARIABLE;

    }

    return z == 0 ? EOF : z;
}           



///////////////////////// EXPRESSION //////////////////////
ELEMENT *expression(void)
{
    gint z;

    ELEMENT *new;
    ELEMENT *new2;

    if ((z = read_chr_extended()) != '-' && z != '+')
    {
        turn_back_chr(z);
    }

    new = term();

    while ((z = read_chr_extended()) == '+' || z == '-')
    {
        new2 = term();
        new = add_operation(z, new, new2); 
    }


    turn_back_chr(z);
    return new;
}



//////////////////  TERM //////////////////////
ELEMENT *term(void)
{
    gint z;

    ELEMENT *new;
    ELEMENT *new2;

    new = power();

    while ((z = read_chr_extended()) == '*' || z == '/')
    {
        new2 = power();
        new = add_operation(z, new, new2);

    }

    turn_back_chr(z);

    return new;
}


//////////////////  POWER //////////////////////
ELEMENT *power(void)
{
    gint z;

    ELEMENT *new;
    ELEMENT *new2;

    new = factor();

    while ((z = read_chr_extended()) == '^')
    {
        new2 = factor();
        new = add_operation(z, new, new2);

    }

    turn_back_chr(z);

    return new;
}



/////////////////////// FACTOR //////////////////////
ELEMENT *factor(void)
{
    gint z;
    gchar subscript;
    gint subscript_number;

    ELEMENT *new;

    z = read_chr_extended();
    if (z == NUMBER)
    {
        return add_num((gint)read_number());
    }
    else if (z == VARIABLE)
    {

        if (*inptr++ == '[')
        {

            subscript = *inptr++; 

            if (*inptr++ == ']')
            {
            }
            else show_error("Lack of closing ']' bracket!\n");

            if (*inptr++ == '_')
            {
            }
            else show_error("Lack of the floor!\n");

            subscript_number = read_number();

            return add_chr_with_subscript(subscript, subscript_number);

        }
    }
    else if (z == '(')
    {

        new = expression();
        z = read_chr_extended();
        if (z == ')')
            return add_parantheses(new);
        else
        {
            g_print("\nERROR1 - with parantheses\n");
            show_error("Parantheses are not matching!\n");
        }
    }
    else
    {
        g_print("ERROR2 - with number\n");
        show_error("You have not typed a number!\n");
    }
}



/////////////////////////// NEW_MALLOC_ELEMENT /////////////////
ELEMENT *new_malloc_element(void)
{
    ELEMENT *new;

    new = (ELEMENT*)g_malloc(sizeof(ELEMENT));

    return new;
}




//////////////////////////// PRINT_ON_CONSOLE_WITH_NEW_LINE ///////////////
void print_on_console_with_new_line(ELEMENT *p)
{
    print_on_console(p);
    g_print("\n");
}



///////////////////////////////// PRINT_ON_CONSOLE //////////////////////
void print_on_console(ELEMENT *p)
{
    if ((p != NULL) && (p->is_num))
    {
        g_print("%d", p->num);
    }
    else if ((p != NULL) && (p->is_subscript))
    {
        g_print("[%c]_%d", p->subscript, p->subscript_number);
    }
    else if ((p != NULL) && (p->is_parantheses))
    {
        g_print("(");
        print_on_console(p->left);
        g_print(")");
    }
    else if ((p != NULL) && (p->operator))
    {
        print_on_console(p->left);
        printf(" %c ", (gchar)p->operator); 
        print_on_console(p->right);

    }


}



/////////////////////////// DEBUG ////////////////////////
void debug(gchar *message)
{
    g_print("%s\n", message);
}



//////////////////// EXPOSE_EVENT_CALLBACK //////////////////
gboolean expose_event_callback (GtkWidget *widget, GdkEventExpose *event, gpointer data)
{

    cr = gdk_cairo_create (gtk_widget_get_window (widget)); 
    do_drawing(cr, foo);

    return FALSE;

}



///////////////////////////////////// DO_DRAWING ////////////////////////
void do_drawing(cairo_t *cr, ELEMENT *p) 
{   


    gchar znak[2];
    cairo_set_source_rgb(cr, 0, 0, 0); 
    cairo_select_font_face(cr, "Sans", CAIRO_FONT_SLANT_NORMAL, CAIRO_FONT_WEIGHT_NORMAL);

    if (IN_POWER == FALSE)
        cairo_set_font_size(cr, BIG);



    if ((p != NULL) && (p->is_num))
    {
        if (IN_POWER == FALSE)
            cairo_set_font_size(cr, BIG);
        else
            cairo_set_font_size(cr, SMALL);

        cairo_move_to(cr, p->x, p->y);
        cairo_show_text(cr, g_ascii_dtostr(buffer, 30, (gdouble)p->num));
    }
    else if ((p != NULL) && (p->is_subscript))
    {
        if (IN_POWER == FALSE)
            cairo_set_font_size(cr, BIG);
        else
            cairo_set_font_size(cr, SMALL);

        cairo_move_to(cr, p->x, p->y);
        znak[0] = p->subscript;
        znak[1] = '\0';
        cairo_show_text(cr, znak);

        cairo_move_to(cr, p->ox, p->oy);
        cairo_set_font_size(cr, SMALL);
        cairo_show_text(cr, g_ascii_dtostr(buffer, 30, (gdouble)p->subscript_number));
        cairo_set_font_size(cr, BIG);
    }
    else if ((p != NULL ) && (p->is_parantheses))
    {
        if (IN_POWER == FALSE)
            cairo_set_font_size(cr, BIG);
        else
            cairo_set_font_size(cr, SMALL);

        cairo_move_to(cr, p->x, p->y);
        cairo_show_text(cr, "(");
        do_drawing(cr, p->left);
        cairo_show_text(cr, ")");
    }
    else if ((p != NULL) && (p->operator))
    {

        if (p->operator == '/')
        {

            if (IN_POWER == FALSE)
                cairo_set_font_size(cr, BIG);
            else
                cairo_set_font_size(cr, SMALL);

            do_drawing(cr, p->left);

            cairo_move_to (cr, p->x, p->oy);
            cairo_line_to (cr, p->ox, p->oy);
            cairo_set_line_width (cr, 1.5);
            cairo_stroke (cr);

            do_drawing(cr, p->right);
        }
        else if (p->operator == '^')
        {
            do_drawing(cr, p->left);

            cairo_move_to(cr, p->ox, p->oy);

            IN_POWER = TRUE;
            cairo_set_font_size(cr, SMALL);
            do_drawing(cr, p->right);
            cairo_set_font_size(cr, BIG); //@ change
            IN_POWER = FALSE;
        }
        else 
        {
            if (IN_POWER == FALSE)
                cairo_set_font_size(cr, BIG);
            else
                cairo_set_font_size(cr, SMALL);

            do_drawing(cr, p->left);
            cairo_move_to(cr, p->ox, p->oy);
            znak[0] = (gchar) p->operator;
            znak[1] = '\0';
            cairo_show_text(cr, znak);

            do_drawing(cr, p->right);
        }

    }

}



///////////////////////////////////// MAX ////////////////////////////////
gint max(int a, int b)
{
    if (a > b)
        return a;

    return b;
}



/////////////////////////// DO_XY //////////////////////////////////////////
void do_xy(ELEMENT *p)
{


    if ((p != NULL) && (p->is_num))
    {
        if (IN_POWER == TRUE)
        {
            p->lenght /= 3;
            p->width /= 3;
            p->owidth/= 3;
            p->olenght /= 3;
        }

        p->x = LL;
        p->y = WW;

        if (DIV == FALSE)
            LL += p->lenght;


    }
    else if ((p != NULL) && (p->is_subscript))
    {
        if (IN_POWER == TRUE)
        {
            p->lenght /= 3;
            p->width /= 3;
            p->owidth/= 3;
            p->olenght /= 3;
        }

        p->x = LL;
        p->y = WW;

        p->ox = LL + p->olenght;
        p->oy = WW + p->owidth;

        if (DIV == FALSE)
            LL += p->lenght;

    }
    else if ((p != NULL) && (p->is_parantheses))
    {
        if (IN_POWER == TRUE)
        {
            p->lenght /= 3;
            p->width /= 3;
            p->owidth/= 3;
            p->olenght /= 3;
        }

        p->x = LL;
        LL += p->olenght;
        p->y = WW;
        do_xy(p->left);

    }
    else if ((p != NULL) && (p->operator))
    {

        if (p->operator != '/' && p->operator != '^')
        {

            if (IN_POWER == TRUE)
            {
                p->lenght /= 3;
                p->width /= 3;
                p->owidth/= 3;
                p->olenght /= 3;
            }

            DIV = FALSE;
            p->x = LL;
            p->y = WW;

            do_xy(p->left);

            p->ox = LL ;
            LL += p->olenght;
            p->oy =  WW;

            do_xy(p->right);

        }
        else if (p->operator == '^')
        {
            DIV = FALSE;
            p->x = LL;
            p->y = WW;


            do_xy(p->left);

            p->ox = LL;
            
            WW -= p->owidth;   
            p->oy = WW;

            IN_POWER = TRUE;
            do_xy(p->right);
            IN_POWER = FALSE;

            WW += p->owidth;


        }
        else
        {
            DIV = TRUE;

            if (IN_POWER == TRUE)
            {
                p->lenght /= 3;
                p->width /= 3;
                p->operator /= 3;
                p->olenght /= 3;
            }

            WW -= p->width / 6;

            p->x = LL;
            p->y = WW;

           p->ox = LL + p->olenght;
            p->oy = WW + p->owidth;
             do_xy(p->left);

            


            //WW += p->width/2;
            LL -= p->lenght/5;


            do_xy(p->right);


            WW -= p->owidth;
            LL += BIG;


            DIV = FALSE;
        }


    }

}



///////////////////////////// HOW_MANY_DIGITS ////////////////////////
gint how_many_digits(gint x)
{
    gint hm = 0;

    while (x != 0)
    {
        x = x / 10;
        hm++;
    }

    return hm;
}



//////////////////////// CREATE_PIXBUF ////////////////////
GdkPixbuf *create_pixbuf(const gchar * filename)
{
   GdkPixbuf *pixbuf;
   GError *error = NULL;
   pixbuf = gdk_pixbuf_new_from_file(filename, &error);
   if(!pixbuf) 
   {
      fprintf(stderr, "%s\n", error->message);
      g_error_free(error);
   }

   return pixbuf;
}
