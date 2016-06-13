//clase lista prendas

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author jaume
 */
public class ListaPrendas implements Serializable {

    private ObservableList<Prendas> lista;

    public ListaPrendas() {
        lista=ObservableCollections.observableList(new ArrayList<Prendas>());
    }

    public static final String PROP_LISTA = "lista";

    public ObservableList<Prendas> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Prendas> lista) {
        ObservableList<Prendas> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void altaPrenda(Prendas p) {
        lista.add(p);
    }

    public void bajaPrenda(Prendas p){
        lista.remove(p);
    }    
}