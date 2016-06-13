//clase prendas

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaume
 */
public class Prendas implements Serializable, Cloneable{
    
    private String codigo;
    private String descripcion;
    private String color;
    private String talla;
    private double precioCoste;
    private double precioVenta;
    private int stock;
    
public Prendas() {
        codigo="";
        descripcion="";
        color="";
        talla="";
    }

    public Prendas(String codigo) {
        this.codigo = codigo;
    }

    public static final String PROP_STOCK = "stock";

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        int oldStock = this.stock;
        this.stock = stock;
        propertyChangeSupport.firePropertyChange(PROP_STOCK, oldStock, stock);
    }

    public static final String PROP_PRECIOVENTA = "precioVenta";

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        double oldPrecioVenta = this.precioVenta;
        this.precioVenta = precioVenta;
        propertyChangeSupport.firePropertyChange(PROP_PRECIOVENTA, oldPrecioVenta, precioVenta);
    }

    public static final String PROP_PRECIOCOSTE = "precioCoste";

    public double getPrecioCoste() {
        return precioCoste;
    }

    public void setPrecioCoste(double precioCoste) {
        double oldPrecioCoste = this.precioCoste;
        this.precioCoste = precioCoste;
        propertyChangeSupport.firePropertyChange(PROP_PRECIOCOSTE, oldPrecioCoste, precioCoste);
    }

    public static final String PROP_TALLA = "talla";

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        String oldTalla = this.talla;
        this.talla = talla;
        propertyChangeSupport.firePropertyChange(PROP_TALLA, oldTalla, talla);
    }

    public static final String PROP_COLOR = "color";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        propertyChangeSupport.firePropertyChange(PROP_COLOR, oldColor, color);
    }

    public static final String PROP_DESCRIPCION = "descripcion";

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        propertyChangeSupport.firePropertyChange(PROP_DESCRIPCION, oldDescripcion, descripcion);
    }

    public static final String PROP_CODIGO = "codigo";

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "codigo:   " + codigo + "\ndescripcion:   " + descripcion + 
                "\ncolor:   " + color + "\ntalla:   " + talla + "\nstock:   " + stock;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Prendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prendas other = (Prendas) obj;
        return other.getCodigo().equalsIgnoreCase(codigo);
    }
}
