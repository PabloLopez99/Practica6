/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pabloantoniolopezmartin
 */
public class Stack {
   private static List<Integer> lista;
   int counter=0;
   
   public Stack(){
       lista= new LinkedList<Integer>();
   }
   public void add(int n){
       counter++;
       lista.add(n);
       
   }
   public int undo(){
       counter--;
       return lista.get(counter);
       
   }
   public int redo(){
      counter++;
      return lista.get(counter);
   }
   public int getCounter(){
       return counter;
   }
   public int getSize(){
       return lista.size();
   }
   
}
