package com.company;

import com.company.entity.Plant;

import java.util.Iterator;

public class PlantList implements IPlantList<Plant>, Iterable<Plant> {
    private Node<Plant> Head;
    private Node<Plant> Tail;
    private int size;
    public PlantList()
    {
        Head=Tail=null;
        size=0;
    }
    @Override
    public void add(Plant plant)
    {
        Node node = new Node(plant);
        if(Head==null){
            Head=node;
        } else {
            Tail.setNext(node);
            node.setPrevious(Tail);
        }
        Tail=node;
        size++;
    }
    @Override
    public void clear()
    {
        for(var plant:this){
            remove(plant);
        }
    }
    @Override
    public boolean remove(Plant plant){
        Node node = Head;
        while(node!=null)
        {
            if(node.getData().equals(plant)){
                break;
            }
            node = node.getNext();
        }
        if(node!=null){
            if (node.getNext()!=null)
            {
                node.getNext().setPrevious(node.getPrevious());
            } else {
                Tail=node.getPrevious();
            }
            if(node.getPrevious()!=null)
            {
                node.getPrevious().setNext(node.getNext());
            }
            else{
                Head=node.getNext();
            }
            size--;
            return true;
        }
        return false;
    }
    @Override
    public Plant[] toArray(){
        Plant[] plants = new Plant[size];
        int i=0;
        for (Plant plant : this){
            plants[i]=plant;
            i++;
        }
        return plants;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean contains (Plant plant){
        for(Plant a :this) {
            if(a.equals(plant)) return true;
        }
        return false;
    }
    @Override
    public String toString() {
        String result="{";
        for(Plant plant: this){
            result+="\n["+plant.toString()+"],";
        }
        if(size>0)
            result=result.substring(0,result.length()-2);
        return result+"]}";
    }
    @Override
    public Iterator<Plant> iterator() {
        return new PlantIterator();
    }
    private class PlantIterator implements Iterator<Plant>{
        private Node<Plant> current;
        private Node<Plant> previous;
        private boolean isNextCalled;
        public PlantIterator(){
            current=Head;
            previous=null;
            isNextCalled=false;
        }
        @Override
        public boolean hasNext(){
            return current != null;
        }
        @Override
        public Plant next(){
            Node<Plant> node = current;
            previous = current;
            current = current.getNext();
            isNextCalled=true;
            return node.getData();
        }
        @Override
        public void remove(){
            if(previous==null||!isNextCalled){
                throw new IllegalStateException();
            }
            if(previous.getPrevious()==null)
            {
                Head=current;
            } else {
                previous.getPrevious().setNext(current);
            }
            isNextCalled=false;
            size--;
        }
    }
}
