package Exam.August2018;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Agency1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //stack
        ArrayDeque<String> id = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(id::push);
        //queue
        ArrayDeque<String> agent = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));

        String input = scanner.nextLine();

        while (!input.equals("stop")){
            String [] tokens = input.split("-");
            String command = tokens[0];
            //•	"add-ID {ID Number}"-
            //•	"add-agent {Agent Name}"
            //•	"remove-ID"
            //remove-agent"-
            //sort-ID

            if (command.equals("add")){
                String[] commandOrId = tokens[1].split("\\s+");
                if (commandOrId[0].equals("ID")){
                    String addId = commandOrId[1];
                    id.push(addId);
                }else if (commandOrId[0].equals("agent")){
                    String agentName = commandOrId[1];
                    agent.offer(agentName);
                }
            }else if (command.equals("remove")){
                String[] commandOrId = tokens[1].split("\\s+");
                if (commandOrId[0].equals("ID")){
                    System.out.println(id.poll() + " " + "has been removed.");
                }else if (commandOrId[0].equals("agent")){
                    System.out.println(agent.pollLast() + " has left the queue.");
                }
            }else if (command.equals("sort")){
               id =  id.stream().sorted((e1, e2)-> e2.compareTo(e1)).collect(Collectors.toCollection(ArrayDeque::new));
            }
            input = scanner.nextLine();
        }
      while (!id.isEmpty() && !agent.isEmpty()){
          System.out.println(agent.poll() + " takes ID number: " + id.pop());
      }

      if (id.isEmpty() && !agent.isEmpty()){
          while (!agent.isEmpty()) {
              System.out.println(agent.poll() + " does not have an ID.");
          }
      }else if (!id.isEmpty() && agent.isEmpty()){
          System.out.println("No more agents left.");
          while (!id.isEmpty()){
              System.out.println("ID number: " + id.pop());
          }
      }
    }
}
