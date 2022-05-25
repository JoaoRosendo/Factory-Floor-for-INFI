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
	
	static String[] ids=new String[] {
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C1",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C2",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C3",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C4",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C5",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C6",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C7",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C8",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C9",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C10",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C11",
			"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C12"};
	
	static String tools_time_ant=null;
	static String pieces_time_ant=null;
    public static int send_pieces(ArrayList<piece> day_pieces) throws UaException, InterruptedException, ExecutionException { 
    	//returns the nr of pieces not correctly sent
    	//TRY CATCH ROUTINE NEEDED
    	
    	OpcUaClient client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
    	int errors=0;
        
        for (int i=0;i<12;i++) {
       
        NodeId nodeId = new NodeId(4,ids[i]);
        String variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(30, 47).replace(", ", "");
        
        short[] machines= day_pieces.get(i).machines;
        String machines_s="";
        for(int j=0;i<day_pieces.get(i).machines.length;i++) {machines_s.concat(String.valueOf(day_pieces.get(i).machines[j]));}
        System.out.println("machines_s"+":");
        System.out.print(machines_s);

        Variant v = new Variant( machines);
        
        DataValue dv = new DataValue(v, null, null);
        variable = client.writeValue(nodeId, dv).get().toString();        
        
        variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(31, 44).replace(", ", "");
        
        if(variable!=machines_s) {
        	errors++;
        }
        
        System.out.println(variable);
        System.out.println(i);
        System.out.println();


        
        
//        NodeId nodeId = new NodeId(4,"|var|CODESYS Control Win V3 x64.Application.Lista_Vars.C1");
//
//        String Variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString();
//
//        System.out.println(Variable);
    	}
        System.out.println(errors);

        return errors;
    }
    
    /////////////////POSSIVELMENTE FAZER EVENT SUBSCRIPTION//////////////////
    public static int check_ToD() {
    	//TRY CATCH ROUTINE NEEDED
    	int result=0;
    	
		OpcUaClient client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
        NodeId nodeId_midday = new NodeId(4,"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String tools_time = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);
        if(tools_time=="1"&& tools_time_ant=="0") {
        	
        }
		
        NodeId nodeId_startday = new NodeId(4,"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String pieces_time = client.readValue(0, TimestampsToReturn.Both, nodeId_startday).toString().substring(29, 31);;
        if(pieces_time=="1"&& pieces_time_ant=="0") {
        	
        }
        
        tools_time_ant=tools_time;
        pieces_time_ant=pieces_time;
       return 0;
		
	}
    
    
}