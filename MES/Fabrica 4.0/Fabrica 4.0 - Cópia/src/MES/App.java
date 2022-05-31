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
	
	static String[] array_ids=new String[] {
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
	
	static String[] maq_ids= {
			"",
			"",
			"",
			"",
			"",
			"",
			};
	
	static String[] maq_tools= {
			"",
			"",
			"",
			"",
			"",
			"",
			};
	
	static String[] dock_ids= {
			"",
			"",
			"",
			};
	
	
	static OpcUaClient client;
	
	static String tools_time_ant=null;
	static String pieces_time_ant=null;
    public static int send_pieces(ArrayList<piece> day_pieces) throws UaException, InterruptedException, ExecutionException { 
    	//returns the nr of pieces not correctly sent
    	//TRY CATCH ROUTINE NEEDED
    	
    	client = OpcUaClient.create("opc.tcp://Vasco-Laptop:4840");
        client.connect().get();
    	int errors=0;
        
        for (int i=0;i<12;i++) {
        	//Always searcehs all pieces, even the ones with 000000
        NodeId nodeId = new NodeId(4,array_ids[i]);
        //reads the array
        String variable = client.readValue(0, TimestampsToReturn.Both, nodeId).get().toString().substring(30, 47).replace(", ", "");
        
        //Creates a array of shorts and inserts there the values to send adn transforms them to string to be able to compare
        short[] machines= day_pieces.get(i).machines;
        String machines_s="";
        for(int j=0;i<day_pieces.get(i).machines.length;i++) {machines_s.concat(String.valueOf(day_pieces.get(i).machines[j]));}
        System.out.println("machines_s"+":");
        System.out.print(machines_s);

        //Sending Values
        Variant v = new Variant( machines);
        DataValue dv = new DataValue(v, null, null);
        variable = client.writeValue(nodeId, dv).get().toString();        
        
        
        //Check if the sent array and the one we have here are equal
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
    public static int check_ToD() throws UaException, InterruptedException, ExecutionException {
    	//TRY CATCH ROUTINE NEEDED
    	int result=0;
    	
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
    
    public ArrayList<machine> mach_stats(ArrayList<machine> machines) throws InterruptedException, ExecutionException{

    	//Gets machine counts
		client.connect().get();
		short total=0;
		for(int i=0;i<7;i++) {
		
			NodeId nodeId_midday = new NodeId(4,maq_ids[i]);
			
			//Read array of nr of pieces of each type and save
			String type_count = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);//!!!!!!!!!!CUT RIGHT WAY
			for(int j=0;i<machines.get(i).op_pieces.length;j++) {machines.get(i).op_pieces[j]=Short.parseShort(type_count[j]);}
			for(int j=0;i<machines.get(i).op_pieces.length;j++) {total+=machines.get(i).op_pieces[j];}
			machines.get(i).pieces_total=total;
			total=0;
			
			
			//Read tool in use
			type_count = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);//!!!!!!!!!!CUT RIGHT WAY
			machines.get(i).tool=toString().valueOf(type_count);
			
		}
		
				
		return machines;
	}
    
    public ArrayList<dock> dock_stats(ArrayList<dock> docks) throws InterruptedException, ExecutionException{

    	//Gets machine counts
		client.connect().get();
		short total=0;
		for(int i=0;i<3;i++) {
			
			NodeId nodeId_midday = new NodeId(4,dock_ids[i]);
			
			//Read array of nr of pieces of each type and save
			String type_count = client.readValue(0, TimestampsToReturn.Both, nodeId_midday).toString().substring(29, 31);//!!!!!!!!!!CUT RIGHT WAY
			for(int j=0;i<docks.get(i).nr_types.length;j++) {docks.get(i).nr_types[j]=Short.parseShort(type_count[j]);}
			for(int j=0;i<docks.get(i).nr_types.length;j++) {total+=docks.get(i).nr_types[j];}
			docks.get(i).total=total;
			total=0;
			
		}
		
				
		return docks;
	}
    
    
    
   
    
}