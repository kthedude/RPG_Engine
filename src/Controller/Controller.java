package Controller;

import Model.Model;
import View.View;

public abstract class Controller {
    Model model;
    View view;

    public Controller(Model m, View v){
        model = m;
        view = v;

    }

    

}
