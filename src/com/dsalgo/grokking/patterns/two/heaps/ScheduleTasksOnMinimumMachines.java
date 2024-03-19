package com.dsalgo.grokking.patterns.two.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://or.stackexchange.com/questions/9964/identifying-the-minimum-number-of-required-machines-to-schedule-jobs
public class ScheduleTasksOnMinimumMachines {
    public static void main(String[] args) {
        List<List<Integer>> tasks = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(5, 5),
                Arrays.asList(8, 8),
                Arrays.asList(4, 4),
                Arrays.asList(6, 6),
                Arrays.asList(10, 10),
                Arrays.asList(7, 7)
        );

        System.out.println(tasks(tasks));
    }

    public static int tasks(List<List<Integer>> tasksList) {
        // to count the total number of machines for "optimalMachines" tasks
        int optimalMachines = 0;

        PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));


        for (List<Integer> task : tasksList){
            tasksQueue.offer(new int[] {task.get(0), task.get(1)});
        }

        // looping through the tasks list
        while (!tasksQueue.isEmpty()) {
            // remove from "tasksQueue" the task i with earliest start time
            int[] task = tasksQueue.poll();
            int[] machineInUse;

            if(!machinesAvailable.isEmpty() && task[0] >= machinesAvailable.peek()[0]) {
                // top element is deleted from "machinesAvailable
                machineInUse = machinesAvailable.poll();
                // schedule task on the current machine
                machineInUse = new int[] {task[1], machineInUse[1]};
            } else {
                // if there's a conflicting task, increment the counter for the machines and
                // store the task's end time on heap "machinesAvailable"
                optimalMachines += 1;
                machineInUse = new int[] {task[1], optimalMachines};
            }
            machinesAvailable.offer(machineInUse);
        }
        return optimalMachines;
    }
}
