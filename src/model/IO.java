package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.ArrayMapper;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import controller.Main;
import model.validation.FixedLength;
import model.validation.GreaterThan;
import model.validation.LessThan;
import model.validation.NotEmpty;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import view.MainPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Scott Kuehl-Shelby
 */
public class IO {

    public static Optional<List<Restaurant>> loadFromFile(String file) {

        XStream xstream = getConfiguredXMLStream();
        List<Restaurant> restaurants = new ArrayList<>();

        try (ObjectInputStream inputStream = xstream.createObjectInputStream(new FileInputStream(file))) {
            while(true) {
                restaurants.add((Restaurant) inputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(restaurants.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(restaurants);
        }
    }

    public static void writeToFile(String file, List<Restaurant> restaurants)
    {
        XStream xstream = getConfiguredXMLStream();

        try (ObjectOutputStream objectOutputStream = xstream.createObjectOutputStream(new FileOutputStream(file))) {
            for (Restaurant restaurant : restaurants) {
                objectOutputStream.writeObject(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static XStream getConfiguredXMLStream() {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        xstream.allowTypeHierarchy(Collection.class);
        xstream.allowTypes(getAllowedClassesForSerialization());
        xstream.allowTypesByWildcard( new String[] {
                Main.class.getPackage().getName() + ".*",
                IO.class.getPackage().getName() + ".*",
                MainPanel.class.getPackage().getName() + ".*",
                Restaurant.class.getPackage().getName() + ".*"
        });

        return xstream;
    }

    private static Class[] getAllowedClassesForSerialization() {
        return new Class[] {
                java.util.ArrayList.class,
                java.util.List.class,
                Restaurant.class,
                NotEmpty.class,
                FixedLength.class,
                GreaterThan.class,
                LessThan.class,
                Address.class
        };
    }

    public static Optional<File> promptUserForFileLocation(Component parent) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("XML files", "xml");
        fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
        fileChooser.setFileFilter(fileNameExtensionFilter);
        fileChooser.setDialogTitle("What Should I Eat?");

        if(fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            return Optional.of(fileChooser.getSelectedFile());
        }
        else {
            return Optional.empty();
        }
    }

    public static Optional<String> getUserPreferredRestaurantDataLocation() {
        return getUserPreferences().getRestaurantDataLocation();
    }

    public static void setUserPreferredRestaurantDataLocation(String location) {
        getUserPreferences().setRestaurantDataLocation(location);

        getUserPreferences().store();
    }

    private static UserPrefs getUserPreferences()
    {
        UserPrefs prefs = new UserPrefs();
        prefs.load();
        return prefs;
    }
}
