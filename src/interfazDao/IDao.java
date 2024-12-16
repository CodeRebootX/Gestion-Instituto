/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfazDao;

import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IDao <T, V> {
    
    public boolean createRecord ( T model);
    
    public T readRecord(V idModel);
    
    public boolean updateRecord ( T model, V idModel);
    
    public boolean deleteRecord (V idModel);
    
    public List<T> readRecords();
}
