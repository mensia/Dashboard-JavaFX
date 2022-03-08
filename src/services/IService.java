/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

public interface IService<Object> {
    public void add(Object u);

    public Object getById(int id);

    public List<Object> getAll();

    public boolean update(Object u);

    public boolean delete(Object u);

}
