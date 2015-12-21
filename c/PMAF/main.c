#include <gtk/gtk.h>
#include "functions.h"

int main( int argc, char *argv[])
{
    //types
    GtkWidget *main_space_h_30_box;
    GtkWidget *window;
    GtkWidget *main_v_box;
    GtkWidget *search_and_do_it_h_box;
    GtkWidget *search_and_do_it_h_format_box; 
    GtkWidget *do_it_button;
    GtkWidget *search_entry;
    GtkWidget *enter_text_v_box;
    GtkWidget *enter_text_label;
    GtkWidget *formula_h_box;
    GtkWidget *formula_scrolled_window;
    WINDOW_AND_SEARCH_ENTRY window_and_search_entry;
    GtkWidget *d_area;



    /////////////////////  WINDOW  //////////
    gtk_init(&argc, &argv);
    window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "PMAF - Simple math expression printer");
    gtk_window_set_default_size(GTK_WINDOW(window), 500, 300);
    gtk_window_set_position(GTK_WINDOW(window), GTK_WIN_POS_CENTER);
    gtk_window_set_icon(GTK_WINDOW(window), create_pixbuf("logo.png"));
    window_and_search_entry.window = window;
    g_signal_connect(G_OBJECT(window), "destroy", G_CALLBACK(gtk_main_quit), NULL);



    ///////////////////  MAIN  ///////////////////////////////////////////////
    //main_space_h_box
    main_space_h_30_box = gtk_hbox_new(TRUE, 0);
    gtk_container_add(GTK_CONTAINER(window), main_space_h_30_box);

    //main_v_box
    main_v_box = gtk_vbox_new(FALSE, 0);
    gtk_box_pack_start(GTK_BOX(main_space_h_30_box), main_v_box, FALSE, FALSE, 0);



    //////////////////////////////// ENETER TEXT LABEL ///////////////////////////////  
    //enter_text_v_box
    enter_text_v_box = gtk_vbox_new(FALSE, 0);
    gtk_box_pack_start(GTK_BOX(main_v_box), enter_text_v_box, FALSE, FALSE, 10);

    //enter_text_label
    enter_text_label = gtk_label_new("Enter something: ");
    gtk_box_pack_start(GTK_BOX(enter_text_v_box), enter_text_label, FALSE, FALSE, 0);



    ////////////////////////  SEARCH AND DO  ////////////////////////////////////////////
    //search_and_do_it_h_box
    search_and_do_it_h_box = gtk_hbox_new(FALSE, 0);
    search_and_do_it_h_format_box = gtk_vbox_new(TRUE, 1000000);
    gtk_box_pack_start(GTK_BOX(search_and_do_it_h_format_box), search_and_do_it_h_box, FALSE, FALSE, 0); 
    gtk_box_pack_start(GTK_BOX(main_v_box), search_and_do_it_h_format_box, FALSE, FALSE, 0); 

    //search_entry 
    search_entry = gtk_entry_new();
    window_and_search_entry.search_entry = search_entry;
    g_signal_connect(G_OBJECT(search_entry), "activate", G_CALLBACK(analyse), &window_and_search_entry);

    gtk_box_pack_start(GTK_BOX(search_and_do_it_h_box), search_entry, FALSE, FALSE, 0);

    //do_it_button
    do_it_button = gtk_button_new_with_label("Do it!");
    gtk_box_pack_start(GTK_BOX(search_and_do_it_h_box), do_it_button, FALSE, FALSE, 0);
    g_signal_connect(G_OBJECT(do_it_button), "clicked", G_CALLBACK(analyse), &window_and_search_entry);



    ////////////////////////  FROMULA  ////////////////////////////
    //d_area
    d_area = gtk_drawing_area_new();
    window_and_search_entry.d_area = d_area;

    //formula_h_box
    formula_h_box = gtk_hbox_new(FALSE, 0);
    gtk_box_pack_start(GTK_BOX(main_v_box), formula_h_box, FALSE, FALSE, 10);

    //formula_hscrollbar
    formula_scrolled_window = gtk_scrolled_window_new(NULL, NULL);
    window_and_search_entry.scrolled = formula_scrolled_window;
    gtk_scrolled_window_set_policy(GTK_SCROLLED_WINDOW(formula_scrolled_window), GTK_POLICY_ALWAYS, GTK_POLICY_ALWAYS);

    gtk_widget_set_size_request(formula_scrolled_window, 400, 200);
    gtk_scrolled_window_add_with_viewport(GTK_SCROLLED_WINDOW(formula_scrolled_window), d_area);
    gtk_box_pack_start(GTK_BOX(formula_h_box), formula_scrolled_window, FALSE, FALSE, 0);

    gtk_widget_set_size_request(d_area, 500, 500);
    g_signal_connect(G_OBJECT(d_area), "expose_event", G_CALLBACK(expose_event_callback), NULL);



    /////////////////// END //////////////////////////
    gtk_widget_show_all(window);
    gtk_main();

    return 0;
}
