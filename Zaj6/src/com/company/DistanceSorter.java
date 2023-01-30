package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface DistanceSorter extends Remote {
    List<Map.Entry<Integer, String>> sortByDistance(List<Map.Entry<Integer, String>> entries) throws RemoteException;
}
