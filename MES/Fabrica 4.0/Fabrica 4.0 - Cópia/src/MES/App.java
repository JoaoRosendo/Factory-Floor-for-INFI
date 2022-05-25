package MES;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
//opc.tcp://Vasco-Laptop:4840

public class App {
	
	static String[] ids=new String[] {"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"11",
			"12"};
	
	static String tools_time_ant=null;
	static String pieces_time_ant=null;
    public static int send_pieces(ArrayList<piece> day_pieces) throws UaException, InterruptedException, ExecutionException { 
    	//returns the nr of pieces not correctly sent
    	
    	
    	OpcUaClient client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
    	int errors=0;
        
        for (int i=0;i<12;i++) {
       
        NodeId nodeId = new NodeId(4,ids[i]);
        String variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(30, 49);
        System.out.println(variable);
        
        short[] machines= day_pieces.get(i).machines;
        String machines_s="";
        for(int j=0;i<day_pieces.get(i).machines.length;i++) {machines_s.concat(String.valueOf(day_pieces.get(i).machines[i])+", ");}
        Variant v = new Variant( machines);
        
        DataValue dv = new DataValue(v, null, null);
        variable = client.writeValue(nodeId, dv).get().toString();
        System.out.println(variable);
        
        
        variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(30, 49);
        
        if(variable!=machines_s) {
        	errors++;
        }
        
        System.out.println(variable);
        
//        NodeId nodeId = new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C1");
//
//        String Variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString();
//
//        System.out.println(Variable);
    	}
                
        return errors;
    }
    
    public static int check_ToD() {
    	int result=0;
    	
		OpcUaClient client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
        NodeId nodeId = new NodeId(4,"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String tools_time = client.readValue(0, TimestampsToReturn.Both, nodeId).toString().substring(29, 31);
        if(tools_time=="1"&& tools_time_ant=="0") {
        	
        }
		
        NodeId nodeId = new NodeId(4,"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String pieces_time = client.readValue(0, TimestampsToReturn.Both, nodeId).toString().substring(29, 31);;
        if(pieces_time=="1"&& pieces_time_ant=="0") {
        	
        }
        
        tools_time_ant=tools_time;
        pieces_time_ant=pieces_time;
       return 0;
		
	}
    
    
}