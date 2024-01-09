import java.util.ArrayList;
import java.util.List;

public class RoundRobinLoadBalancer {

    private int currentIndex;
    private List<String> servers;

    public RoundRobinLoadBalancer(List<String> servers){
        this.currentIndex = 0;
        this.servers = servers;
    }

    public String getNextServer(){
        String server = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % servers.size();
        return server;
    }


    public static void main(String[] args) {
       List<String> servers = new ArrayList<>();
       servers.add("Server 1");
       servers.add("Server 2");
       servers.add("Server 3");
       servers.add("Server 4");

       RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer(servers);

       for(int i=0; i<10 ; i++){
           String server = loadBalancer.getNextServer();
           System.out.println("Request "+(i+1) + " gets " + server);
       }

    }
}