package com.ityj.advance.io;

import com.ityj.advance.io.entity.Person;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectStream {

    // Exception in thread "main" java.lang.RuntimeException: j
    // ava.io.NotSerializableException: com.ityj.advance.io.entity.Person

    @Test
    public void writeObject() {
        Person person = new Person();
        person.setName("颗颗");
        try (ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream("person.data"))) {
            oos.writeObject(person);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("complete....");
    }

    @Test
    public void readObject() {
        try (ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("person.data"))) {
            Object o = ois.readObject();
            if (o instanceof Person) {
                Person p = (Person) o;
                System.out.println("p = " + p);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("complete....");
    }

}
