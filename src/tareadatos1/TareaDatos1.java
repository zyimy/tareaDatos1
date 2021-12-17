/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadatos1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author zepeda
 */
public class TareaDatos1 {

    static Cafe cafe;
    static PersistenceStrategy strategy;
    static XmlArrayList lista;
    static Controlador c = new Controlador();
    static ObjectOutputStream out;

    public static void main(String[] args) throws IOException {
        XStream xstream = new XStream(new DomDriver());
        ArrayList<Cafe> lista;
        String xml = "";

        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("  MENU\nEJERCICIO 1\nEJERCICIO 2 PERSISTENCIA\n"
                    + "EJERCICIO 3 OUPUT INPUT \n"
                    + "EJERCICIO 4\nINGRESE UNA OPCION "));

            switch (opcion) {

                //Ejercicio 1
                case 1:

                    lista = listaCafe();
                    xml = devolverXml(xstream, lista);

                    try {
                        JOptionPane.showMessageDialog(null, xml);
                        JOptionPane.showMessageDialog(null, XmlToFromXml(xml, xstream).toString());
                    } catch (XStreamException e) {
                        System.out.println(e);

                    }

                    break;

                case 2:
                    try {

                        strategy = objectoPersistente(xstream);
                        listaCafePersistent(strategy);

                    } catch (XStreamException e) {
                        System.out.println(e);

                    }

                    break;

                case 3:

                    crearObjetoOuput(xstream, "xml.txt");

                    break;

                case 4:

                    lista = listaCafe();

                    xml = aliasPackage(xstream, lista);
                    JOptionPane.showMessageDialog(null, xml);

                    break;

            }
        } while (opcion != 0);
    }

    //Metodo que nos devuelve un objecto  cafe
    public static ArrayList<Cafe> listaCafe() {

        String nombre;
        float precio;
        int ventas, proveedorId, total, cantidad = 0;

        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cuantos objectos va ingresar: "));

        for (int i = 0; i < cantidad; i++) {
            nombre = JOptionPane.showInputDialog("Ingrese nombre cafe");
            ventas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor de las ventas: "));
            proveedorId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id de proveedor: "));
            total = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total: "));
            precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese precio: "));

            cafe = new Cafe(nombre, proveedorId, precio, ventas, total);
            c.addLista(cafe);

        }
        return c.mostrarLista();
    }

    //Metodo que nos devuelve un xml
    public static String devolverXml(XStream xstream, ArrayList<Cafe> lista) {

        xstream.alias("cafe", Cafe.class);
        xstream.aliasField("IdProveedor", Cafe.class, "proveedorId");
        xstream.addPermission(AnyTypePermission.ANY);

        String xml = xstream.toXML(lista);

        return xml;

    }

    //Metodo para convertir de xml a objecto
    public static Object XmlToFromXml(String xml, XStream xstream) {

        Object cafe = (Object) xstream.fromXML(xml);

        return cafe;
    }

    public static PersistenceStrategy objectoPersistente(XStream xstream) {

        strategy = new FilePersistenceStrategy(new File("."), xstream);
        xstream.alias("cafe", Cafe.class);
        xstream.aliasField("IdProveedor", Cafe.class, "proveedorId");

        return strategy;
    }

    public static XmlArrayList listaCafePersistent(PersistenceStrategy strategy) {
        ArrayList<Cafe> miLista = listaCafe();
        lista = new XmlArrayList(strategy);
        lista.add(miLista);

        return lista;
    }

    public static void crearObjetoOuput(XStream xstreams, String directorio) throws IOException {

        ObjectOutputStream write = xstreams.createObjectOutputStream(new FileOutputStream(directorio));
        write.writeObject(listaCafe());
        write.close();

    }

    public static String aliasPackage(XStream xstream, ArrayList<Cafe> lista) {

        xstream.alias("cafe", Cafe.class);
        xstream.aliasPackage("miCafe", "tareadatos1");
        xstream.aliasField("IdProveedor", Cafe.class, "proveedorId");
        xstream.addPermission(AnyTypePermission.ANY);

        String xml = xstream.toXML(lista);

        return xml;

    }

}
