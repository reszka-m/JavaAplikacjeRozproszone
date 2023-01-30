package com.company;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class Main extends UnicastRemoteObject implements DistanceSorter {
    public Main() throws RemoteException, MalformedURLException, NotBoundException {
        super();
    }

    @Override
    public List<Map.Entry<Integer, String>> sortByDistance(List<Map.Entry<Integer, String>> entries) throws RemoteException {
        Collections.sort(entries, (entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));
        return entries;
    }

    DistanceSorter sorter = (DistanceSorter) Naming.lookup("rmi://localhost/DistanceSorter");
    private List<Map.Entry<Integer, String>> entries;
    List<Map.Entry<Integer, String>> sortedEntries = sorter.sortByDistance(entries);
}

