package com.dsalgo.grokking.patterns.custom.data.structures;

// https://leetcode.com/problems/snapshot-array/

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
    public static HashMap<Integer, Map<Integer, Integer>> nodeValue;
    public static int nCount;
    private int snapID;

    public SnapshotArray(int length) {
        nodeValue = new HashMap<>();
        nCount = length;
        snapID = 0;
        nodeValue.put(0, new HashMap<Integer, Integer>());
    }

    // function setValue sets the value at a given index ids to val
    public void setValue(int idx, int val) {
        if(idx < nCount) {
            nodeValue.get(snapID).put(idx, val);
        }
    }

    // this function takes no parameters and returns the snapid
    // snapid is the number of times that the snapshot() function was called minus 1
    public int snapshot() {
        // create a deep copy of the map nodeState[snap_id - 1]
        nodeValue.put(snapID + 1, new HashMap<>(nodeValue.get(snapID)));
        snapID++;
        return snapID - 1;
    }

    // function getValue returns the value at the index idx with the given snapid
    public int getValue(int idx, int snapshotId1) {
        if(snapshotId1 < snapID && snapshotId1 >= 0) {
            if(nodeValue.get(snapshotId1).containsKey(idx)) {
                return nodeValue.get(snapshotId1).get(idx);
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {

    }
}
