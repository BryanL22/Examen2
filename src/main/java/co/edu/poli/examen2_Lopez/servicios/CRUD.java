package co.edu.poli.examen2_Lopez.servicios;

import java.util.List;

public interface CRUD<T, K> {
	
    String create(T t);
    T readOne(K id);
    List<T> readAll();
}